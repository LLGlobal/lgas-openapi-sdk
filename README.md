# lianlian-global-ew-openapi-sdk for Java
Java libraries for using lianlian global eWallet's apis. Supports Accounts Service and Acceptance Service.

Includes the following artifacts:
- `api` : request/response POJOs for the lianlian Global eWallet APIs.
- `client` : A basic retrofit client for the lianlian Global eWallet endpoints, includes the `api` module
- `service` : A basic service class that creates and calls the client. This is the easiest way to get started.

as well as an example project using the service.


## Supported APIs
- Account Service (For Accounts API)
    + [Core Accounts](https://docs.lianlianglobal.com/api-reference#tag/Core-Accounts)
    + [Balance](https://docs.lianlianglobal.com/api-reference#tag/Balances)
    + [Receiving Accounts](https://docs.lianlianglobal.com/api-reference#tag/Receiving-Accounts)
    + [Bank Accounts](https://docs.lianlianglobal.com/api-reference#tag/Bank-Accounts)
    + [Network Accounts](https://docs.lianlianglobal.com/api-reference#tag/Network-Accounts)
    + [Payer](https://docs.lianlianglobal.com/api-reference#tag/Payer)
    + [Payouts](https://docs.lianlianglobal.com/api-reference#tag/Payouts)
    + [Request Payments](https://docs.lianlianglobal.com/api-reference#tag/Request-Payments)
    + [Withdraw](https://docs.lianlianglobal.com/api-reference#tag/Withdraw)
    + [Refunds](https://docs.lianlianglobal.com/api-reference#tag/Refunds)
    + [Mandate](https://docs.lianlianglobal.com/api-reference#tag/Mandate)
    + [Splits](https://docs.lianlianglobal.com/api-reference#tag/Splits)
    + [Cards](https://docs.lianlianglobal.com/api-reference#tag/Cards)
    + [Remittance](https://docs.lianlianglobal.com/api-reference#tag/Remittance)
    + [Exchanges](https://docs.lianlianglobal.com/api-reference#tag/Exchanges)
    + [Transactions](https://docs.lianlianglobal.com/api-reference#tag/Transactions)
- Acceptance Service (For Acceptance API)
  + [Settlement report](https://docs.lianlianglobal.com/acquire-api-reference#tag/Settlement-report)
  + [Payment](https://docs.lianlianglobal.com/acquire-api-reference#tag/Payment)
  + [Refund](https://docs.lianlianglobal.com/acquire-api-reference#tag/Refund)
  + [Consent](https://docs.lianlianglobal.com/acquire-api-reference#tag/Consent)
- Supporting Service (For Common Supporting API)
  + [Files](https://docs.lianlianglobal.com/api-reference#tag/Files)
  + [Transaction Document](https://docs.lianlianglobal.com/api-reference#tag/Transaction-Document)
  + [Bank Account Verification](https://docs.lianlianglobal.com/api-reference#tag/Bank-Account-Verification)
## Importing

### Gradle
`implementation 'com.lianlianpay.global:lianlian-global-ew-openapi-service:${latest.version}'`

### Maven
```xml
   <dependency>
    <groupId>com.lianlianpay.global</groupId>
    <artifactId>lianlian-global-ew-openapi-service</artifactId>
    <version>${latest.version}</version>       
   </dependency>
```

## Usage
### Authorization
The authorization header is required for all requests.  
There are two modes of authorization: ```Basic``` and ```OAuth```.  
+ for ```Basic``` Authorization
```http request
Authorization: Basic [Base64(devloper_id:token)]
```
+ for ```OAuth``` Authorization
```http request
Authorization: Bearer [access_token]
```
if you are using ```Basic``` mode, you could use the BasicAuthClient which could be used to generate the authorization header by Basic mode:
```java
import com.lianlianpay.global.ew.openapi.client.ClientBuilder;
import com.lianlianpay.global.ew.openapi.client.Client;

public class MyLianlianServiceFacade {
    
    private final AccountService accountService;
    
    public MyLianlianServiceFacade() {
        // create a client with basic authorization
        Client client = ClientBuilder.defaultBasicAuthClient(
                "[lianlian gateway endpoint]", "[your private key]",
                "[lianlian public key]", "[your developer token]",
                "[your developer id]");
        // create a service with the client
        accountService = new AccountService(client);
    }

}

```
if you are using ```OAuth``` mode, you could use the OAuthClient which could be used to generate the authorization header by OAuth mode:
```java
import com.lianlianpay.global.ew.openapi.client.ClientBuilder;
import com.lianlianpay.global.ew.openapi.client.OAuthClient;

public class MyLianlianServiceFacade {

  private final AccountService accountService;

  public MyLianlianServiceFacade() {
    // create a client with OAuth authorization
    OAuthClient client = ClientBuilder.defaultOAuthClient(
            "[lianlian gateway endpoint]", "[your private key]",
            "[lianlian public key]", "[access token]");
    // create a service with the client
    accountService = new AccountService(client);
  }

}
```
in ```OAuth```mode, you could use the following code to refresh the access token:
```java
import com.lianlianpay.global.ew.openapi.client.ClientBuilder;
import com.lianlianpay.global.ew.openapi.client.OAuthClient;

public class MyLianlianServiceFacade {

  private final AccountService accountService;
  
  private final OAuthClient client;

  // if you are holding the client outside, you could refresh access token directly
  // refresh access token through by client and do request
  public void refreshAccessTokenAndDoRequest() {
      client.setAccessToken("[new access token]");
      Result<AccountDetailRes> result = accountService.retrieveAccount();
      if (result.isHttpOk()) {
          System.out.println(result.getData());
      }
  }
  
  // all service methods support to refresh access token quickly
  public void fastRefreshAccessTokenAndDoRequest() {
    Result<AccountDetailRes> result = accountService.newAccessToken("[new access token]").retrieveAccount();
    if (result.isHttpOk()) {
      System.out.println(result.getData());
    }
  }

}
```

### Signature

The signature is required for all requests. The signature is generated by the following steps:
1. Concatenate the request method, request path, timestamp, request body, and query stings (if exists) into a single string.
2. Use the developer private key to sign the concatenated string using the `SHA256withRSA` algorithm.
3. Base64 encode the signature.
4. The timestamp is in seconds， and must be within 10 minutes of the current time.
5. The signature is included in the request header as:

```http request
LLPAY-Signature: t=SENCONDS_TIMESTAMP,v=Base64(SHA256withRSA( HTTP_METHOD&URI&REQUEST_EPOCH&REQUEST_PAYLOAD[&QUERY_STRING] )))
```


### Client Configuration
#### Configuration Properties
Properties:```endpoint```|```privateKey```|```lianlianPublicKey```|```authMode```|```token```|```developerId```|```accessToken```|```connectTimeout```|```readTimeout```|```withSign```|```checkSign```|```proxy```
+ ```endpoint```: the endpoint of lianlian gateway.
+ ```privateKey```: the merchant developer's private key for generating signature.
+ ```lianlianPublicKey```: the lianlian public key for merchant to verify signature.
+ ```authMode```: the authorization mode of lianlian gateway. It can be ```Basic``` or ```OAuth```(Bound by ClientBuilder).
+ ```token```: the token for ```Basic``` authorization. It's the developer's master token.
+ ```developerId```: the developer id for ```Basic``` authorization.
+ ```accessToken```: the access token for ```OAuth``` authorization. 
+ ```connectTimeout```: the connection timeout in milliseconds. Default is 10000. (10 seconds)
+ ```readTimeout```: the read timeout in milliseconds. Default is 30000. (30 seconds)
+ ```withSign```: whether to sign the request. Default is true.
+ ```checkSign```: whether to check the signature of response. Default is true.
+ ```proxy```: the proxy configuration for the request. Default is null.

### Client Builder
The SDK provides a builder which named `ClientBuilder` to build a client with the configuration properties. The builder allows setting each property
individually. The builder can be created by calling the static method `newBasicAuthClientBuilder()`
or `newOAuthClientBuilder()` to create a builder. 
+ BasicAuthClient: the client with ```Basic``` authorization. It could be used to generate the authorization header by Basic mode.
+ OAuthClient: the client with ```OAuth``` authorization. It could be used to generate the authorization header by OAuth mode.

### Default Client
To Simplicity, The ClientBuilder provides some static methods to create a default client with the simple configuration properties.

**The default configuration** (can not be changed in default client):
  + ```connectTimeout```: 10000 ms
  + ```readTimeout```: 30000 ms
  + ```withSign```: true
  + ```checkSign```: true
  + ```authMode```: ```Basic``` for `BasicAuthClient`, ```OAuth``` for `OAuthClient` and  ```None```
    for `SimpleClient`.
  
<br/>

 **Methods**:
<br/>
`defaultBasicAuthClient`: the client with ```Basic``` authorization. It could be used to generate the authorization header by Basic mode.
<br/>
  + **Method Parameters**:
    + ```endpoint```: the endpoint of lianlian gateway.
    + ```privateKey```: the merchant developer's private key for generating signature.
    + ```lianlianPublicKey```: the lianlian public key for merchant to verify signature.
    + ```token```: the token for ```Basic``` authorization. It's the developer's master token.
    + ```developerId```: the developer id for ```Basic``` authorization.

`defaultOAuthClient`: the client with ```OAuth``` authorization. It could be used to generate the authorization header by OAuth mode.
<br/>
+ **Method Parameters**:
  + ```endpoint```: the endpoint of lianlian gateway.
  + ```privateKey```: the merchant developer's private key for generating signature.
  + ```lianlianPublicKey```: the lianlian public key for merchant to verify signature.
  + ```accessToken```: the access token for ```OAuth``` authorization.(Optional for initialization, but required for request calls)