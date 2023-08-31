package com.ngts.projects.scm.core.api.exception;

public class NgtsException extends Exception {

    private String errorCode;
    private String errorText;

    public NgtsException(ErrorCodeMapperEnum errorCodeMapperEnum){
        this.errorCode = errorCodeMapperEnum.getErrorCode();
        this.errorText = errorCodeMapperEnum.getErrorText();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}
