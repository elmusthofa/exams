package com.online.exams.config;

import com.online.exams.filter.JwtFilter;
import com.online.exams.filter.LocalIpFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author muhamad.fariz
 * email : farizcb@gmail.com
 * on 26/03/2022
 */
@RequiredArgsConstructor
@Configuration
public class FilterConfig {

    private final JwtFilter jwtFilter;
    private final LocalIpFilter localIpFilter;

    @Bean
    public FilterRegistrationBean<OncePerRequestFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<OncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jwtFilter);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> filterCors() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>(new CorsFilter(source));
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<OncePerRequestFilter> filterLocalIp() {
        FilterRegistrationBean<OncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(localIpFilter);
        registrationBean.addUrlPatterns("/actuator/prometheus");
        return registrationBean;
    }

}
