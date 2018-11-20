package com.mall.order.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by Ken on 7/15/2018.
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class RespStorageId implements Serializable {

    private static final long serialVersionUID = -7482569559819001473L;

    @JsonProperty("storage_id")
    private String storageId;
}
