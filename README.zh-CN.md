# lianlian-global-ew-openapi-sdk for Java 中文说明

这是用于调用连连全球电子钱包（lianlian Global eWallet）API 的 Java 开发工具包，支持 **账户服务** 和 **收单服务**。

## 模块说明

- **`api`**：包含连连 Global eWallet API 的请求和响应数据模型（POJO）。
- **[client](file:///Users/huyl/IdeaProjects/lianlian-global-ew-openapi-sdk/lianlian-global-ew-openapi-service/src/main/java/com/lianlianpay/global/ew/openapi/service/AccountService.java#L38-L38)**：基于 Retrofit 的基础客户端，用于调用连连 Global eWallet 接口，包含 `api` 模块。
- **`service`**：封装了客户端的服务类，简化调用流程，推荐快速接入方式。
- **示例项目**：演示如何使用 `service` 模块进行开发。

## 支持的 API

### 账户服务（Account Service）

- [核心账户](https://docs.lianlianglobal.com/api-reference#tag/Core-Accounts)
- [余额](https://docs.lianlianglobal.com/api-reference#tag/Balances)
- [收款账户](https://docs.lianlianglobal.com/api-reference#tag/Receiving-Accounts)
- [银行账户](https://docs.lianlianglobal.com/api-reference#tag/Bank-Accounts)
- [网络账户](https://docs.lianlianglobal.com/api-reference#tag/Network-Accounts)
- [付款人](https://docs.lianlianglobal.com/api-reference#tag/Payer)
- [付款](https://docs.lianlianglobal.com/api-reference#tag/Payouts)
- [请求付款](https://docs.lianlianglobal.com/api-reference#tag/Request-Payments)
- [提现](https://docs.lianlianglobal.com/api-reference#tag/Withdraw)
- [退款](https://docs.lianlianglobal.com/api-reference#tag/Refunds)
- [授权协议](https://docs.lianlianglobal.com/api-reference#tag/Mandate)
- [分账](https://docs.lianlianglobal.com/api-reference#tag/Splits)
- [卡](https://docs.lianlianglobal.com/api-reference#tag/Cards)
- [汇款](https://docs.lianlianglobal.com/api-reference#tag/Remittance)
- [兑换](https://docs.lianlianglobal.com/api-reference#tag/Exchanges)
- [交易记录](https://docs.lianlianglobal.com/api-reference#tag/Transactions)

### 收单服务（Acceptance Service）

- [结算报告](https://docs.lianlianglobal.com/acquire-api-reference#tag/Settlement-report)
- [支付](https://docs.lianlianglobal.com/acquire-api-reference#tag/Payment)
- [退款](https://docs.lianlianglobal.com/acquire-api-reference#tag/Refund)
- [授权](https://docs.lianlianglobal.com/acquire-api-reference#tag/Consent)

### 支持服务（Supporting Service）

- [文件](https://docs.lianlianglobal.com/api-reference#tag/Files)
- [交易文档](https://docs.lianlianglobal.com/api-reference#tag/Transaction-Document)
- [银行账户验证](https://docs.lianlianglobal.com/api-reference#tag/Bank-Account-Verification)

## 引入方式

### Gradle

```groovy
implementation 'com.lianlianpay.global:lianlian-global-ew-openapi-service:${latest.version}'
```


### Maven

```xml
<dependency>
  <groupId>com.lianlianpay.global</groupId>
  <artifactId>lianlian-global-ew-openapi-service</artifactId>
  <version>${latest.version}</version>
</dependency>
```


## 使用说明

### 授权方式

所有请求必须包含 `Authorization` 头，支持两种授权方式：

- **Basic**
  ```http
  Authorization: Basic [Base64(developer_id:token)]
  ```


- **OAuth**
  ```http
  Authorization: Bearer [access_token]
  ```


#### 使用 `Basic` 授权方式

```java
import com.lianlianpay.global.ew.openapi.client.ClientBuilder;
import com.lianlianpay.global.ew.openapi.client.Client;

public class MyLianlianServiceFacade {

    private final AccountService accountService;

    public MyLianlianServiceFacade() {
        // 创建 Basic 授权客户端
        Client client = ClientBuilder.defaultBasicAuthClient(
                "[lianlian gateway endpoint]", "[your private key]",
                "[lianlian public key]", "[your developer token]",
                "[your developer id]");
        // 创建服务
        accountService = new AccountService(client);
    }

}
```


#### 使用 `OAuth` 授权方式

```java
import com.lianlianpay.global.ew.openapi.client.ClientBuilder;
import com.lianlianpay.global.ew.openapi.client.OAuthClient;

public class MyLianlianServiceFacade {

    private final AccountService accountService;

    public MyLianlianServiceFacade() {
        // 创建 OAuth 授权客户端
        OAuthClient client = ClientBuilder.defaultOAuthClient(
                "[lianlian gateway endpoint]", "[your private key]",
                "[lianlian public key]", "[access token]");
        // 创建服务
        accountService = new AccountService(client);
    }

}
```


##### 刷新 Access Token

```java
public class MyLianlianServiceFacade {

    private final AccountService accountService;
    private final OAuthClient client;

    public void refreshAccessTokenAndDoRequest() {
        client.setAccessToken("[new access token]");
        Result<AccountDetailRes> result = accountService.retrieveAccount();
        if (result.isHttpOk()) {
            System.out.println(result.getData());
        }
    }

    public void fastRefreshAccessTokenAndDoRequest() {
        Result<AccountDetailRes> result = accountService.newAccessToken("[new access token]").retrieveAccount();
        if (result.isHttpOk()) {
            System.out.println(result.getData());
        }
    }

}
```


### 签名机制

所有请求必须包含签名，签名生成步骤如下：

1. 拼接请求方法、请求路径、时间戳、请求体和查询参数（如果存在）。
2. 使用开发者私钥通过 `SHA256withRSA` 算法签名。
3. 对签名结果进行 Base64 编码。
4. 时间戳单位为秒，且必须在当前时间的 10 分钟内。
5. 签名头格式如下：

```http
LLPAY-Signature: t=时间戳,v=Base64(SHA256withRSA( HTTP_METHOD&URI&REQUEST_EPOCH&REQUEST_PAYLOAD[&QUERY_STRING] )))
```


### 客户端配置

#### 配置参数

| 参数名 | 描述 |
| --- | --- |
| `endpoint` | 连连网关地址 |
| `privateKey` | 开发者私钥，用于生成签名 |
| `lianlianPublicKey` | 连连公钥，用于验证签名 |
| `authMode` | 授权方式（Basic / OAuth） |
| `token` | Basic 授权的 Token |
| `developerId` | Basic 授权的开发者 ID |
| `accessToken` | OAuth 授权的 Access Token |
| `connectTimeout` | 连接超时时间（毫秒） |
| `readTimeout` | 读取超时时间（毫秒） |
| `withSign` | 是否签名请求 |
| `checkSign` | 是否验证响应签名 |
| `proxy` | 代理配置（可选） |

### 客户端构建器

SDK 提供了 `ClientBuilder` 用于构建客户端，支持单独配置各项参数。

- `newBasicAuthClientBuilder()`：创建 Basic 授权的客户端构建器。
- `newOAuthClientBuilder()`：创建 OAuth 授权的客户端构建器。

### 默认客户端

默认客户端配置如下：

- `connectTimeout`: 10000 ms
- `readTimeout`: 30000 ms
- `withSign`: true
- `checkSign`: true
- `authMode`: 根据构建方式自动设置

#### `defaultBasicAuthClient` 方法参数

- `endpoint`
- `privateKey`
- `lianlianPublicKey`
- `token`
- `developerId`

#### `defaultOAuthClient` 方法参数

- `endpoint`
- `privateKey`
- `lianlianPublicKey`
- `accessToken`（可选，但调用时需设置）