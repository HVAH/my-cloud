package com.mall.pay.controller;

import com.mall.pay.domain.AjaxReturn;
import com.mall.pay.service.PayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 支付 controller
 * @Author HuangJiang
 * @Date 2018/8/29 18:04
 * @Version 1.0
 */
/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG
*/
@RestController
@RequestMapping("/pay")
public class PayController {

	private @Resource PayService payService;

	/**
	 * 统一获取支付信息接口
	 * @param orderNo 订单号
	 * @param orderType 订单类型
	 * @param payComp   支付公司 1 支付宝 2 微信
	 * @param payment   支付方式 1 app 2 二维码支付
	 * @return
	 * @throws Exception
	 */
	@PostMapping()
	public AjaxReturn pay(
	        @RequestParam(name = "orderNo", required = true) Long orderNo,
	        @RequestParam(name = "orderType", required = true, defaultValue = "1") Integer orderType,
	        @RequestParam(name = "payment", required = true) Integer payment,
	        @RequestParam(name = "payComp", required = true) Integer payComp
	        )throws Exception {

		String payInfo = payService.pay(orderNo, orderType, payment, payComp);
	    return new AjaxReturn(200, "", payInfo);
	}

	/**
	 * 主动查询支付结果
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/query")
	public AjaxReturn query(
	        @RequestParam(name = "orderNo", required = true) String orderNo,
	        @RequestParam(name = "payComp", required = true) Integer payComp
	        )throws Exception {

		String result = payService.query(orderNo, payComp);
	    return new AjaxReturn(200, "");
	}

	/**
	 * 申请退款
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/refund")
	public AjaxReturn refund(
			@RequestParam(name = "orderNo", required = true) Long orderNo
	        )throws Exception {

		String result = payService.refund(orderNo);
	    return new AjaxReturn();
	}

	/**
	 * 主动查询退款结果
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/refund/query")
	public AjaxReturn method(
			@RequestParam(name = "orderNo", required = true) String orderNo
	        )throws Exception {

		String result = payService.refundQuery(orderNo);
		return new AjaxReturn();
	}
}
