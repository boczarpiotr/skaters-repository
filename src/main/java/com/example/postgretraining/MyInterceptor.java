package com.example.postgretraining;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("Bearer mixon69".equals(request.getHeader(HttpHeaders.AUTHORIZATION))){
            return true;
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
}
