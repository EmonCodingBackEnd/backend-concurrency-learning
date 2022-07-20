package com.coding.concurrency;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.coding.concurrency.example.threadlocal.RequestHolder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response,
        @Nullable Object handler) throws Exception {
        log.info("preHandle");
        return true;
    }

    @Override
    public void afterCompletion(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response,
        @Nullable Object handler, @Nullable Exception ex) throws Exception {
        RequestHolder.remove();
        log.info("afterCompletion");
    }

    @Override
    public void afterConcurrentHandlingStarted(@Nullable HttpServletRequest request,
        @Nullable HttpServletResponse response, @Nullable Object handler) throws Exception {
        log.info("afterConcurrentHandlingStarted");
    }
}
