package com.webservice.config.auth;

import com.webservice.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
// Spring Security 설정들을 활성화 시켜준다
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                        .antMatchers("/", "/css/**", "/image/**", "/js/**", "/h2-console/**").permitAll() // 모든 접근자 허용
                        .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //USER 계정 접근 허용
                        .anyRequest().authenticated() // 인증된 사용자(로그인한 사용자)만 가능
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                        .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속조치를 진행할 UserService 인터페이스 구현체를 등록


    }
}
