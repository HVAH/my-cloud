package com.mall.admain.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description
 * @Author HuangJiang
 * @Date 2018/8/24 11:53
 * @Version 1.0
 */
@RestController
public class RabbitmqController {

	private @Autowired AmqpTemplate rabbitTemplate;
	private @Value("${mq.quene}") String queneName;

	@PostMapping("/send-message")
	@ApiOperation(value = "", code = 200, produces = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "查询成功", response = Map.class) })
	public ResponseEntity method(
	        @ApiParam(name = "message", value = "消息", required = true) @RequestParam(name = "message", required = true) String message
	        )throws Exception {

		rabbitTemplate.convertAndSend(queneName, message);
	    return ResponseEntity.ok().body("发送成功");
	}
}
