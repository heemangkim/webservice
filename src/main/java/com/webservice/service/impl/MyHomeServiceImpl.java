package com.webservice.service.impl;

import com.webservice.common.restVO.CommonResult;
import com.webservice.model.req.RequestLogin;
import com.webservice.service.MyHomeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@Slf4j
public class MyHomeServiceImpl implements MyHomeService {
    private static final Logger logger = LoggerFactory.getLogger(MyHomeService.class);

    @Override
    public CommonResult loginAction(HttpServletRequest request, HttpServletResponse response, RequestLogin body) {
        CommonResult result = CommonResult.getDefResult();

        try{

        }catch (Exception e) {
            logger.error("",e);
            result.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return result;
        }

        return result;
    }
}
