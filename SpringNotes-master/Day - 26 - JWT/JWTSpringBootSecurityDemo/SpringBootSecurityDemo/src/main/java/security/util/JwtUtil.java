package security.util;
import java.util.Date;

import java.util.HashMap;

import java.util.Map;

import java.util.stream.Collectors;
 
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Component;
 
import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.security.Keys;
 
@Component

public class JwtUtil {
 
//private final String secret = "mySuperSecretKey1234567890123456"; // 32 chars = 256 bits

private final String secret = "a-string-secret-at-least-256-bits-long";

    private final long expiration = 1000 * 60 * 60; // 1 hour

    public String generateToken(UserDetails userDetails) {

        Map<String, Object> claims = new HashMap();

        claims.put("roles", userDetails.getAuthorities().stream()

            .map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

        return Jwts.builder()

            .setClaims(claims)

            .setSubject(userDetails.getUsername())

            .setIssuedAt(new Date())

            .setExpiration(new Date(System.currentTimeMillis() + expiration))

            .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)

            .compact();

    }
 
    public String extractUsername(String token) {

        return extractClaims(token).getSubject();

    }
 
    public boolean validateToken(String token, UserDetails userDetails) {

        String username = extractUsername(token);

        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);

    }
 
    private boolean isTokenExpired(String token) {

        return extractClaims(token).getExpiration().before(new Date());

    }
 
    private Claims extractClaims(String token) {

        return Jwts.parserBuilder()

            .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))

            .build()

            .parseClaimsJws(token)

            .getBody();

    }

}
