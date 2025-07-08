/**
 *
 */
package com.lianlianpay.global.ew.openapi.model.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * anditionalInfo
 *
 *
 * @author xujs002
 *
 */
@Data
public class AdditionalInfo implements Serializable {

    private static final long serialVersionUID = 1245243564371273731L;


    public AdditionalInfo() {

    }

    public AdditionalInfo(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /** key */
    private String name;

    /** value */
    private String value;
}
