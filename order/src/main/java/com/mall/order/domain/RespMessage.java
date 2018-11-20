package com.mall.order.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by Ken on 2018/4/13.
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class RespMessage implements Serializable {

    private static final long serialVersionUID = 5617984065928474342L;

    @JsonProperty
    private String code;

    @JsonProperty
    private String message;
}
