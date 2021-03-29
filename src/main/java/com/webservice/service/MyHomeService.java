package com.webservice.service;

import com.webservice.common.restVO.CommonResult;
import com.webservice.model.req.RequestLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyHomeService {
    CommonResult loginAction(HttpServletRequest request, HttpServletResponse response, RequestLogin body);
}
