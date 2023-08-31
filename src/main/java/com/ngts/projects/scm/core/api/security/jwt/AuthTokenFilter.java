package com.ngts.projects.scm.core.api.security.jwt;

import java.io.IOException;
import com.ngts.projects.scm.core.api.security.redis.RedisCacheUtils;
import com.ngts.projects.scm.core.api.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthTokenFilter extends OncePerRequestFilter {

  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private RedisCacheUtils redisCacheUtils;

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      String jwt = parseJwt(request);
      logger.debug("Jwt token from client " + jwt);
      if ( jwt != null && jwtUtils.validateJwtToken(jwt)) {
        String jwtTokenFrmRedis = redisCacheUtils.hGet(jwt, "auth_cookie") != null ?  redisCacheUtils.hGet(jwt, "auth_cookie").toString() : null;
        if(jwtTokenFrmRedis != null ){
          String username = jwtUtils.getUserNameFromJwtToken(jwt);
          UserDetails userDetails = userDetailsService.loadUserByUsername(username);
          UsernamePasswordAuthenticationToken authentication =
                  new UsernamePasswordAuthenticationToken(userDetails,
                          null,
                          userDetails.getAuthorities());

          authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

          SecurityContextHolder.getContext().setAuthentication(authentication);
        }else {
          logger.debug("Key expired in Redis cache ");
          throw new Exception("Key expired");
        }

      }else {
       logger.error("No jwt token in cookie for this request ");
       throw new Exception("No Jwt token ");
      }
    } catch (Exception e) {
      logger.error("Cannot set user authentication: {}", e);
    }

    filterChain.doFilter(request, response);
  }

  private String parseJwt(HttpServletRequest request) {
    String jwt = jwtUtils.getJwtFromCookies(request);
    return jwt;
  }
}
