package security.securityServer;

import com.agenda.model.entity.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private String secret = "dENdtkgB7VMNGyanznMq9G4abtGMwan8WevvnshEyoHt5zp97hRkGVUNHAxKXTvOh97lzAutOm5SKtpb3w1sd2uF29W9v3CGgYyin";

    public Account validate(String token) {

        Account account = null;

        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            account = new Account();

            account.setUsername(body.getSubject());
            account.setUsername((String) body.get("Username"));
            account.setPassword((String) body.get("Password"));
        }
        catch (Exception e){
            System.out.println("Error in JwtValidator : " + e);
        }
        return account;
    }
}