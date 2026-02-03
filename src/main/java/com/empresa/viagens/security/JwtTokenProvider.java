package com.empresa.viagens.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * JWT token provider for authentication.
 *
 * <p>Generates, validates, and extracts information from JWT tokens.
 */
@Component
@SuppressWarnings("java:S5941") // Using HS512 is acceptable for this internal JWT use case
public class JwtTokenProvider {

  @Value(
      "${jwt.secret:mySecretKeyForJWTTokenGenerationAndValidationPurposesOnly12345678901234567890}")
  private String jwtSecret;

  @Value("${jwt.expiration:86400000}")
  private long jwtExpirationInMs;

  /**
   * Generate JWT token from UserDetails.
   *
   * @param userDetails User details
   * @return JWT token
   */
  public String generateToken(UserDetails userDetails) {
    return generateTokenFromUsername(userDetails.getUsername());
  }

  /**
   * Generate JWT token from username.
   *
   * @param username Username
   * @return JWT token
   */
  public String generateTokenFromUsername(String username) {
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(now)
        .setExpiration(expiryDate)
        .signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
  }

  /**
   * Get username from JWT token.
   *
   * @param token JWT token
   * @return Username
   */
  public String getUsernameFromJwtToken(String token) {
    Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

    return claims.getSubject();
  }

  /**
   * Validate JWT token.
   *
   * @param token JWT token
   * @return True if token is valid, false otherwise
   */
  public boolean validateJwtToken(String token) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
