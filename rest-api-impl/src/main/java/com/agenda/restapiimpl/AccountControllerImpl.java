package com.agenda.restapiimpl;

import com.agenda.model.dto.AccountDto;
import com.agenda.restapi.Contact.AccountController;
import com.agenda.serviceapi.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AccountControllerImpl  implements AccountController {

    @Autowired
    private AccountService accountService;

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountService.getAllAccountsDto();
    }

    @Override
    public ResponseEntity<String> addAccount(@RequestBody AccountDto accountDto){
        return accountService.addAccountDTO(accountDto);
    }

    @Override
    public ResponseEntity<String> editAccount(@RequestBody AccountDto accountDto,@PathVariable Integer id) {
        return accountService.editAccountDTO(accountDto,id);
    }

    @Override
    public AccountDto findAccount(@PathVariable Integer id){
        return accountService.findAccountDTO(id);
    }

    @Override
    public ResponseEntity<String> deleteAccount(@PathVariable Integer id) {
     return accountService.deleteAccountDTO(id);
    }

    @Override
    public ResponseEntity<String> login(@PathVariable String username, @PathVariable String password) {
        return accountService.loginDto(username,password);
    }
}
