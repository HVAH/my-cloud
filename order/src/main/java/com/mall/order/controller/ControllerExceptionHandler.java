package com.mall.order.controller;

import com.mall.order.common.ReturnCode;
import com.mall.order.domain.RespMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ken on 5/23/2018.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity handlerIncorrectRequestException(IllegalArgumentException ex) {
        RespMessage respMessage = new RespMessage()
                .setCode(ReturnCode.PARAMETERS_INCORRECT)
                .setMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(respMessage);
    }
}
