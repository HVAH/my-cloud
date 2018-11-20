package com.mall.pay.test;

import com.mall.pay.confgurer.MyWxpayConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/9/10 12:16
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PayTest {

	private @Resource MyWxpayConfig myWxpayConfig;

	/**
	 * 测试
	 * @throws Exception
	 */
	@Test
	public void Test() throws Exception {

		System.out.println(myWxpayConfig.getAppID());

	}
}
