package com.ntd.pratice.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import java.util.Date;

public class JwtUtil {
    private static long EXPIRE_TIME = 24*60*60*1000;
    private static String KEY = "NguyenTienDuy";

    public static String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(new Date(new Date().getTime() + EXPIRE_TIME))
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
    }

    public static boolean validateJwt(String jwt) {
        try {
            Jwts.parser().setSigningKey(KEY).parseClaimsJws(jwt);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public static String getUsernameFromJwt(String jwt) {
        try {
            return Jwts.parser().setSigningKey(KEY).parseClaimsJws(jwt).getBody().getSubject();
        } catch (Exception exception) {
            return null;
        }
    }
}
