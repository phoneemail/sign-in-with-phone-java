import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtDecoder {
    private static final String API_KEY = "API_KEY"; // Specify your API key

    public static void main(String[] args) {
        String phtoken = "your_jwt_token_here"; // Replace with the JWT token you want to decode

        int jwtResponse;
        String jwtPhone;

        try {
            Key key = Keys.hmacShaKeyFor(API_KEY.getBytes());
            Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(phtoken).getBody();

            jwtResponse = 1; // JWT decoded successfully
            jwtPhone = claims.get("country_code", String.class) + claims.get("phone_no", String.class);
        } catch (Exception e) {
            jwtResponse = 0; // Invalid JWT
            jwtPhone = "";
        }

        System.out.println("JWT Response: " + jwtResponse);
        System.out.println("JWT Phone: " + jwtPhone);
    }
}
