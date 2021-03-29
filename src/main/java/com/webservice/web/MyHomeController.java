package com.webservice.web;

import com.webservice.model.req.RequestLogin;
import com.webservice.service.MyHomeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class MyHomeController {
    private static final Logger logger = LoggerFactory.getLogger(MyHomeController.class);

    private final MyHomeService myHomeService;

    @PostMapping("/v1/hm/login")
    public Object login(HttpServletRequest request, HttpServletResponse response, @RequestBody RequestLogin body) {
        logger.info("[CONTROLLER] -> login()");
        return myHomeService.loginAction(request, response, body).getResponse();
    }
}
