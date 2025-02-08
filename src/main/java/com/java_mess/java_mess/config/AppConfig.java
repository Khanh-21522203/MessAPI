package com.java_mess.java_mess.config;

// import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.java_mess.java_mess.common.AuthenticationFilter;
import com.java_mess.java_mess.common.LatencyInterceptor;
import com.java_mess.java_mess.common.RateLimiterFilter;
import com.java_mess.java_mess.service.AppService;

@Configuration
public class AppConfig implements WebMvcConfigurer{
    // @Bean
    // ObjectMapper objectMapper() {
    //   ObjectMapper mapper = new ObjectMapper();
    //   return mapper;
    // }
    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        registry.addInterceptor(new LatencyInterceptor());
    }

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authenticationFilter(AppService appService) {
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AuthenticationFilter(appService));
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(1);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<RateLimiterFilter> rateLimiterFilter(RedisTemplate<String, String> redisTemplate) {
        FilterRegistrationBean<RateLimiterFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RateLimiterFilter(redisTemplate));
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }
}
