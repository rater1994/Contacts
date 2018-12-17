package com.agenda.restapi.Contact;

import com.agenda.model.dto.AccountDto;
import com.agenda.model.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
    @RequestMapping("/account")
public interface AccountController {

    @GetMapping ("/list")
    List<AccountDto> getAllAccounts();

    @PostMapping("/add")
    ResponseEntity<String> addAccount(@RequestBody AccountDto accountDto);

    @PutMapping("/edit/{id}")
    AccountDto editAccount(@RequestBody AccountDto accountDto, @PathVariable Integer id);

    @GetMapping("/find/{id}")
    AccountDto findAccount(@PathVariable Integer id);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteAccount(@PathVariable Integer id);

    @GetMapping("/login/{username}/{password}")
    ResponseEntity <String> login(@PathVariable  String username, @PathVariable String password);

}


