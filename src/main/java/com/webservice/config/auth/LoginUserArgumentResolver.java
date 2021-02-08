package com.webservice.config.auth;

import com.webservice.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

// 컴파일시 조건에 맞는 메소드가 있으면 해당값을 메소드로 넘기는 역할
// @LoginUser 어노테이션이 붙은 메서드에 세션값을 넘기는 역할

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;

    //특정 컨트롤러의 메서드를 지원하는지 판단
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
         boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
         boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());

        return isLoginUserAnnotation && isUserClass;
    }

    // 파라미터에 전달할 객체를 생성한다.
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return httpSession.getAttribute("user");
    }
}
