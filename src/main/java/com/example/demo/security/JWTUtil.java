package com.example.demo.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*
    Our simple static class that demonstrates how to create and decode JWTs.
 */
public class JWTUtil {

    // The secret key. This should be in a property file NOT under source
    // control and not hard coded in real life. We're putting it here for
    // simplicity.
    private static final String SECRET_KEY = "dermo_key";

    //Sample method to construct a JWT
    public static String createJWT(String id, String issuer, String email, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        Claims claims = Jwts.claims().setSubject(email);
        claims.put("email", email);
        claims.put("role", "ADMIN");
        

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(now)
                .setHeaderParam("typ","JWT")
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY);

        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public static Claims decodeJWT(String jwt) {

        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    public static boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);            
            if (claims.getBody().getExpiration().before(new Date())) {
                return false;
            }           
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            
        }
        return false;
    }

}