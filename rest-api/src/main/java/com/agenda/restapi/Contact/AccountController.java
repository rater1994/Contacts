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
    AccountDto addAccount(@RequestBody AccountDto accountDto);

    @PutMapping("/edit/{id}")
    AccountDto editAccount(@RequestBody AccountDto accountDto, @PathVariable Integer id);

    @GetMapping("/find/{id}")
    AccountDto findAccount(@PathVariable Integer id);

    @DeleteMapping("/delete/{id}")
    AccountDto deleteAccount(@PathVariable Integer id);




}


