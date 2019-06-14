package com.mall.pay.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
 * @Description 支付信息父类
 * @Author HuangJiang
 * @Date 2018/9/12 16:35
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PayInfo implements Serializable {
	private static final long serialVersionUID = 1876447324102809245L;

	private String amount;
	private String orderNo;
}
