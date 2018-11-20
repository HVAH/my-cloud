package com.mall.base.util;

import com.mall.base.constant.ReturnCode;
import com.mall.base.dto.response.RespMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Created by Ken on 2018/4/13.
 */
public final class RespMessageFactory {
    private RespMessageFactory() {
    }

    public static ResponseEntity createByBindingResult(BindingResult bindingResult) {
        RespMessage respMessage = new RespMessage();
        respMessage.setCode(ReturnCode.PARAMETERS_INCORRECT);
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            stringBuilder.append(fieldError.getField());
            stringBuilder.append(": ");
            stringBuilder.append(fieldError.getDefaultMessage());
            stringBuilder.append("; ");
        }
        respMessage.setMessage(stringBuilder.toString());
        return new ResponseEntity<>(respMessage, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity create(HttpStatus httpStatus, String code, String message) {
        return new ResponseEntity(new RespMessage(code, message), httpStatus);
    }
}
