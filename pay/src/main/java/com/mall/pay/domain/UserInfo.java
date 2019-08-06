package com.mall.pay.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/8/5 16:59
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private String name;
    private String age;
}
