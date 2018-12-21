package com.agenda.serviceapi;

import com.agenda.model.dto.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface AccountService {

    List<AccountDto> getAllAccountsDto();

    ResponseEntity<String> addAccountDTO(@RequestBody AccountDto accountDto);

    ResponseEntity<String> editAccountDTO(@RequestBody  AccountDto accountDto, @PathVariable Integer id);

    AccountDto findAccountDTO(@PathVariable Integer id);

    ResponseEntity<String> deleteAccountDTO(@PathVariable Integer id);

    ResponseEntity<String> loginDto(@PathVariable String username, @PathVariable String password);
}
