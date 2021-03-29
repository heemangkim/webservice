package com.webservice.web;

import com.webservice.model.req.RequestLogin;
import com.webservice.service.MyHomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class MyHomeController {

    private final MyHomeService myHomeService;

    @PostMapping("/loginAction")
    public Object login(HttpServletRequest request, HttpServletResponse response, @RequestBody RequestLogin body) {

        return myHomeService.loginAction(request, response, body).getResponse();
    }
}
