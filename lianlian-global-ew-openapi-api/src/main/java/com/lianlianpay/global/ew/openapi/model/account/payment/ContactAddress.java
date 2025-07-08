/**
 * 
 */
package com.lianlianpay.global.ew.openapi.model.account.payment;

import lombok.Data;

import java.io.Serializable;

/**
 * 联系人地址
 * 
 * @doc https://developer.lianlianglobal.com/docs/llg-openapi/c2NoOjQ0NzMwNTEx-payee-response
 * 
 * @author xujs002
 *
 */
@Data
public class ContactAddress implements Serializable {

	private static final long serialVersionUID = 3536664159802937174L;

	/**
	 * Two-letter ISO 3166-2 country code.
	 */
	private String countryCode;

	/**
	 * City, district, suburb, town, or village.
	 */
	private String city;

	/**
	 * State, county, province, or region
	 */
	private String state;

	/**
	 * Address line1 (e.g. street, PO Box, or company name)
	 */
	private String line1;

	/**
	 * Address line2 (e.g. apartment, suite, unit, or building)
	 */
	private String line2;

	/**
	 * ZIP or postal code.
	 */
	private String postcode;
}
