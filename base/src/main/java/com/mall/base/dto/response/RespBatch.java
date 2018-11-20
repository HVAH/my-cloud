package com.mall.base.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 批量操作
 * @Author Jiang
 * @Date 2018/11/13 16:03
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class RespBatch {
    /** 失败数 */
    private Integer failures;

    /** id */
    @JsonProperty("target_ids")
    private List<Long> targetIds = new ArrayList<>();

    public RespBatch(List<Long> targetIds) {
        this.targetIds = targetIds;
        int count = 0;
        for (Long targetId : targetIds) {
            if (targetId == null) {
                count ++;
            }
        }
        this.failures = count;
    }
}
