package security.securityServer;

import com.agenda.model.entity.Account;
import com.google.gson.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import org.json.*;
import sun.reflect.generics.parser.SignatureParser;

import java.security.Signature;

@Component
public class JwtGenerator {
    Gson g = new Gson();
    public String generate(Account account) {

        Account fields = new Account();

        Claims claims = Jwts.claims()

                .setSubject(account.getUsername());
//        claims.put("id",String.valueOf(account.getId()));
        claims.put("username",String.valueOf(account.getUsername()));
        claims.put("passsword",String.valueOf(account.getPassword()));


//        System.out.println("Username: " + g.toJson(account.getUsername()));
//        System.out.println("Password: " + g.toJson( account.getPassword()));
//


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,"dENdtkgB7VMNGyanznMq9G4abtGMwan8WevvnshEyoHt5zp97hRkGVUNHAxKXTvOh97lzAutOm5SKtpb3w1sd2uF29W9v3CGgYyin")
                .compact();
    }


}
