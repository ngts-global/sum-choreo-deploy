package com.ngts.projects.scm.core.api.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Slf4j
public class ResponseHandlerFilter extends OncePerRequestFilter {

    @Value("${ngtsscm.app.jwtCookieName}")
    private String jwtCookie;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.debug("<<< Response handler filter start.>>> ");
        logger.debug(" Jwt token in Response handler filter ---> "  + request.getAttribute("Current_user_jwt_token"));
        String jwt = (String)request.getAttribute("Current_user_jwt_token");
        filterChain.doFilter(request, response);
        Cookie ck=new Cookie("Set-Cookie",jwtCookie+"="+jwt);
        ck.setMaxAge(24 * 60 * 60);
        response.addCookie(ck);
        logger.debug("<<< Response handler filter end.>>> ");
    }
}
