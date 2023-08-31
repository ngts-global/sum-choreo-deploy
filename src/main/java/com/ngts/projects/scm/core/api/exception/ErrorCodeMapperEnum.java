package com.ngts.projects.scm.core.api.exception;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCodeMapperEnum {

    UNAUTHORIZED_ERROR("Unauthorized access","AE0001"),
    AUTHENTICATION_ERROR("Authentication details wrong", "AE002"),
    NOT_FOUND("Record not found", "FE001");

    private String errorCode;
    private String errorText;

    private static Map<String, ErrorCodeMapperEnum> codeToLevelMapping;

    private static void initMapping(){
        codeToLevelMapping = new HashMap<String , ErrorCodeMapperEnum>();
        for(ErrorCodeMapperEnum s: values()){
            codeToLevelMapping.put(s.errorCode, s);
        }
    }

    private static String getErrorText(String responseCode){
        if(codeToLevelMapping == null){
            initMapping();
        }
        return  codeToLevelMapping.get(responseCode).errorText;
    }
    ErrorCodeMapperEnum(String code, String text){
        this.errorCode = code;
        this.errorText = text;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorText() {
        return errorText;
    }
}
