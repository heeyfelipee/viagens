package com.empresa.viagens.security;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * JWT Authentication Filter.
 *
 * <p>Processes JWT tokens from HTTP requests and sets up authentication in the security context.
 */
@Component
@SuppressWarnings("java:S110") // OncePerRequestFilter is appropriate for JWT filtering
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @Autowired private JwtTokenProvider jwtTokenProvider;

  @Autowired private UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String token = extractTokenFromRequest(request);

    if (token != null && jwtTokenProvider.validateJwtToken(token)) {
      try {
        String username = jwtTokenProvider.getUsernameFromJwtToken(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
      } catch (JwtException | IllegalArgumentException e) {
        logger.error("Cannot set user authentication: {}", e);
      }
    }

    filterChain.doFilter(request, response);
  }

  /**
   * Extract JWT token from request.
   *
   * @param request HTTP request
   * @return JWT token or null if not found
   */
  private String extractTokenFromRequest(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");
    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7);
    }
    return null;
  }
}
