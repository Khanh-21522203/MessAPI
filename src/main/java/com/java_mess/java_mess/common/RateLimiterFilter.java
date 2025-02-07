package com.java_mess.java_mess.common;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RateLimiterFilter implements Filter{
    private static int RATE_LIMIT = 1000;
    private RedisTemplate<String, String> redisTemplate;

    public RateLimiterFilter(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }

    private boolean exceedsLimit(String apiClientKey, int currentMinute) {
        String redisKey = String.format("rate_limiter:counter:%s:minute:%d", apiClientKey, currentMinute);
        long counter = redisTemplate.opsForValue().increment(redisKey);
        if (counter > RATE_LIMIT) {
            return true;
        }
        redisTemplate.expire(redisKey, Duration.ofMinutes(1));
        return false;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) 
        throws IOException, ServletException {

        log.info("Run rate limit filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String apiClientKey = request.getHeader("x-api-key");
        int currentMinute = LocalTime.now().getMinute();
        if (exceedsLimit(apiClientKey, currentMinute)) {
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code if needed
    }
}
