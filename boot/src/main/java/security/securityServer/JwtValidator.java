package security.securityServer;

import com.agenda.model.entity.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private String secret = "youtube";

    public Account validate(String token) {

        Account account = null;

        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            account = new Account();

            account.setUsername(body.getSubject());
            account.setId((Integer) Integer.parseInt((String) body.get("id")));
            account.setRole((String) body.get("Role"));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return account;
    }
}