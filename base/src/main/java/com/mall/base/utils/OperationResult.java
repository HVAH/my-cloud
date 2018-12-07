package com.mall.base.utils;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

/**
 * @Description crud结果
 * @Author HuangJiang
 * @Date 2018/10/17 16:41
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class OperationResult<T> {
    /** 操作是否成功 */
    private Boolean success;
    /** 返回数据 */
    private T data;
    /** 失败提示 */
    private FailureMessage message;

    public static OperationResult success() {
        OperationResult operationResult = new OperationResult();
        operationResult.success = true;
        return operationResult;
    }
    public static OperationResult failure() {
        OperationResult operationResult = new OperationResult();
        operationResult.success = false;
        return operationResult;
    }

    public Boolean isSuccess() {
        return this.success;
    }

    public OperationResult data(T data) {
        this.data = data;
        return this;
    }

    public OperationResult message(HttpStatus httpStatus, String code, String message) {
        this.message = new FailureMessage(httpStatus, code, message);
        return this;
    }



    private OperationResult() {
    }
    @Data
    @Accessors(chain = true)
    class FailureMessage {

        private HttpStatus httpStatus;
        private String code;
        private String message;

        public FailureMessage(HttpStatus httpStatus, String code, String message) {
            this.httpStatus = httpStatus;
            this.code = code;
            this.message = message;
        }
    }
}
