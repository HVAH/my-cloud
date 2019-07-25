package com.mall.base.utils;

import com.mall.base.dto.response.RespBatch;
import com.mall.base.dto.response.RespJson;
import com.mall.base.dto.response.RespMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;

/**
 * @Description API返回结果工厂
 * @Author HuangJiang
 * @Date 2018/10/15 16:58
 * @Version 1.0
 */
public class RespFactory {

    /**
     * 单个查询结果
     * @param type 查询类型
     * @param data 数据
     * @return
     */
    public static ResponseEntity singleQuery(String type, Object data) {
        return RespJson.newResult(type, data);
    }

    /**
     * 列表查询结果
     * @param page 当前页
     * @param size 分页大小
     * @param total 总条数
     * @param type 类型
     * @param data 数据
     * @return
     */
    public static ResponseEntity listQuery(Integer page, Integer size, Long total, String type, Object data) {
        return RespJson.newResult(page, size, total,type, data);
    }

    /**
     * 添加结果
     * @param type 类型
     * @param value 值
     * @return
     */
    public static ResponseEntity addResult(String type, Object value) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new HashMap<String, Object>() {
            {
                put(type, value);
            }
        });
    }

    /**
     * 删除结果
     * @param type 类型
     * @param value 值
     * @return
     */
    public static ResponseEntity deleteResult(String type, Object value) {
        return ResponseEntity.ok().body(new HashMap<String, Object>() {
            {
                put(type, value);
            }
        });
    }

    /**
     * 更新结果
     * @return
     */
    public static ResponseEntity updateResult() {
        return ResponseEntity.ok().body(new RespMessage(null, "修改成功"));
    }

    /**
     * 无返回体结果
     * @param httpStatus 状态
     * @return
     */
    public static ResponseEntity noContent(HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).body(null);
    }

    /**
     * 参数校验不通过信息-自动校验
     * @param bindingResult
     * @return
     */
    public static ResponseEntity message(BindingResult bindingResult) {
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

    /**
     * 其他业务异常
     * @param httpStatus
     * @param code
     * @param message
     * @return
     */
    public static ResponseEntity message(HttpStatus httpStatus, String code, String message) {
        return ResponseEntity.status(httpStatus).body(new RespMessage(code, message));
    }

    /**
     * 其他业务异常
     * @return
     */
    public static ResponseEntity message(OperationResult.FailureMessage failureMessage) {
        return ResponseEntity.status(failureMessage.getHttpStatus()).body(new RespMessage(failureMessage.getCode(), failureMessage.getMessage()));
    }

    /**
     * 批量操作
     * @param ids
     * @return
     */
    public static ResponseEntity batch(List<Long> ids) {
        return ResponseEntity.ok().body(new RespBatch(ids));
    }
}
