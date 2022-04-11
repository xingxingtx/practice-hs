package com.hs.exception;

/**
 * @author wei.peng
 * @date 2022/4/8
 * @describe
 */
public class UserBusinessException extends  RuntimeException{

    private String errorMessage;
    private String errorCode;

    public UserBusinessException(String errorMessage, String errorCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public UserBusinessException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = "";
    }
}
