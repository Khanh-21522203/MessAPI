package com.java_mess.java_mess.common;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LatencyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView)
        throws Exception {
        
        long startTime = (Long) request.getAttribute("startTime");
        long latency = System.currentTimeMillis() - startTime;

        log.info("Request URL: {}, Latency: {} ms", request.getRequestURL(), latency);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, 
        @Nullable Exception ex) throws Exception {
        // cleap up resource if needed
    }
}