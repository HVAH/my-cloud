package com.mall.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.InputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Ken on 7/15/2018.
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Storage implements Serializable {

    private static final long serialVersionUID = -4021896968549612321L;

    private String id;

    private String name;

    private String type;

    private BigInteger length;

    private String md5;

    private InputStream inputStream = null;

    private Date createdAt;
}
