package security.securityServer;

import com.agenda.model.entity.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    public String generate(Account account) {

        Claims claims = Jwts.claims()
                .setSubject(account.getUsername());
        claims.put("id",String.valueOf(account.getId()));
        claims.put("Role", account.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,"youtube")
                .compact();
    }
}
