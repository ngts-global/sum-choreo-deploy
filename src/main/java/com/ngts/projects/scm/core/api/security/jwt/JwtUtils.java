package com.ngts.projects.scm.core.api.security.jwt;

import java.security.Key;
import java.util.Date;
import com.ngts.projects.scm.core.api.service.UserDetailsImpl;
import com.ngts.projects.scm.core.api.utils.TimerUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtils {

  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  @Value("${ngtsscm.app.jwtSecret}")
  private String jwtSecret;

  @Value("${ngtsscm.app.jwtExpirationMs}")
  private int jwtExpirationMs;

  @Value("${ngtsscm.app.jwtCookieName}")
  private String jwtCookie;

  public String getJwtFromCookies(HttpServletRequest request) {
    Cookie cookie = WebUtils.getCookie(request, jwtCookie);
    if (cookie != null) {
      return cookie.getValue();
    } else {
      return null;
    }
  }

  public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
    String jwt = generateTokenFromUsername(userPrincipal.getUsername());
    ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/").maxAge(24 * 60 * 60).httpOnly(true).build();
    return cookie;
  }

  public ResponseCookie getCleanJwtCookie() {
    System.out.println("Token while logout " + jwtCookie);
    ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/").build();
    return cookie;
  }

  public String getUserNameFromJwtToken(String token) {
    return Jwts.parserBuilder().setSigningKey(key()).build()
        .parseClaimsJws(token).getBody().getSubject();
  }
  
  private Key key() {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
      return true;
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }

  // JWT token generated at Sat Jul 01 10:09:50 IST 2023
  // JWT expired at 2023-07-01T04:40:50Z. Current time: 2023-07-01T04:40:51Z
  
  public String generateTokenFromUsername(String username) {
    logger.debug("JWT token generated at "+ new Date((new Date()).getTime()));
    return Jwts.builder()
              .setSubject(username)
              .setIssuedAt(new Date())
              .setExpiration(new TimerUtils().addMinutesToDate(jwtExpirationMs))
              .signWith(key(), SignatureAlgorithm.HS256)
              .compact();

  }
}
