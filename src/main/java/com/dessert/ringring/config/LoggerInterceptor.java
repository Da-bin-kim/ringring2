package com.dessert.ringring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {
    //컨트롤러 실행되기 전 수행
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        log.debug("======================START======================");
        log.debug("Request URI \t:"+request.getRequestURI());
        return true;
    }
    //컨트롤러 실행된 후 수행행
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView){
                               log.debug("=======================END==========================");
    }


}
