package com.agenda.restapi.Contact;

import com.agenda.model.dto.AccountDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public interface AccountController {

    @GetMapping ("/list")
    List<AccountDto> getAllAccounts();

    @PostMapping("/add")
    AccountDto addAccount(@RequestBody AccountDto accountDto);

    @PutMapping("/edit/{id}")
    AccountDto editAccount(@RequestBody AccountDto accountDto, @PathVariable Long id);

    @GetMapping("/find/{id}")
    AccountDto findAccount(@PathVariable Long id);

    @PutMapping("/delete/{id}")
    AccountDto deleteAccount(@RequestBody AccountDto accountDto,@PathVariable Long id);

}
