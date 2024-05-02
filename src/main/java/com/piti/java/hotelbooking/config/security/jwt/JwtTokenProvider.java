package com.piti.java.hotelbooking.config.security.jwt;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
	
	@Value("${app.jwt-secret}")
	private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpirationDate;
    
    // Generate JWT token
    public String generateToken(Authentication authentication){
        String username = authentication.getName();

        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        String token = Jwts.builder()
                .setSubject(username)
                .claim("authorities", authentication.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .setIssuer("hotels.booking.com")
                .signWith(key())
                .compact();
        
        return token;
    }
    
    private Key key(){
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret)
        );
    }
    
    
//    public Jws<Claims> getUsername(String token){
//        Jws<Claims> claims = Jwts.parser()
//                .setSigningKey(key())
//                .build()
//                .parseClaimsJws(token);
//               
//        return claims;
//    }
    
    // Get username from JWT token
    public String getUsername(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();

        String username = claims.getSubject();

        return username;
    }
    
    // Validate JWT Token
    public boolean validateToken(String token){
            Jwts.parser()
                    .setSigningKey(key())
                    .build()
                    .parse(token);
            return true;
    }

}
