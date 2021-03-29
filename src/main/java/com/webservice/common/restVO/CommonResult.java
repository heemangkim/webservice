package com.webservice.common.restVO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResult {
    @JsonIgnore
    HttpStatus httpStatus;

    @JsonIgnore
    ResultCode resultCode;
    Map<String, Object> result = null;

    public CommonResult(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public CommonResult(HttpStatus httpStatus, ResultCode resultCode) {
        this.httpStatus = httpStatus;
        this.resultCode = resultCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public static CommonResult getDefResult() {
        return new CommonResult(HttpStatus.OK, ResultCode.SUCCESS);
    }

    public static CommonResult getResult(ResultCode result_code) {
        return new CommonResult(result_code);
    }

    public ResponseEntity<?> getResponse() {
        if (result == null){
            return new ResponseEntity<Object>(httpStatus);
        }else{
            return new ResponseEntity<Object>(result, httpStatus);
        }
    }

    public void setHttpStatus(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }
}
