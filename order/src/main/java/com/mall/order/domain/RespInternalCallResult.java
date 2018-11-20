package com.mall.order.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by Ken on 7/13/2018.
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class RespInternalCallResult<T> implements Serializable {

    private static final long serialVersionUID = -7402703565584312827L;

    @JsonProperty
    private Boolean logicResult;

    @JsonProperty
    private String contentResult;

    @JsonProperty
    private T objectResult;
}
