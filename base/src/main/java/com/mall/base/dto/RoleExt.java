package com.mall.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description 角色对应
 * @Author HuangJiang
 * @Date 2018/10/11 16:28
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class RoleExt {
    private String role;
    private Long branchId;
}
