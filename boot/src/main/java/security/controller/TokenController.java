package security.controller;


import com.agenda.model.entity.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import jdk.nashorn.internal.objects.NativeJSON;
import org.springframework.web.bind.annotation.*;
import security.model.TokenResponse;
import security.securityServer.JwtGenerator;

@CrossOrigin
@RestController
@RequestMapping("/token")
public class TokenController {

    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;

    }

    @PostMapping
    public TokenResponse generate(@RequestBody final Account account){
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(jwtGenerator.generate(account));
        return tokenResponse;
    }
}