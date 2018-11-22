package com.agenda.serviceapiimpl;

import com.agenda.model.dto.AccountDto;
import com.agenda.model.dto.ContactDto;
import com.agenda.model.entity.Account;
import com.agenda.model.repository.AccountRepository;
import com.agenda.serviceapi.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public List<AccountDto> getAllAccountsDto() {
        List<AccountDto> list = new ArrayList<>();

        accountRepository.findAll().forEach(account -> {
            list.add(account.toAccountDto());
        });
        return list;
    }

    @Override
    public AccountDto addAccountDTO(AccountDto accountDto) {
        Account account = new Account();

        if(account.getRole() == "" ){
            account.setRole("USER");
            account.updateAccountDto(accountDto);
            return accountRepository.save(account).toAccountDto();
        }

    return null;
    }

    @Override
    public AccountDto editAccountDTO(AccountDto accountDto, Long id) {
        Optional<Account> dbAccount = accountRepository.findById(id);

        if(dbAccount.isPresent()){
            Account account = dbAccount.get();

            System.out.println("Edit.........");

            account.setUsername(accountDto.getUsername());
            account.setPassword(accountDto.getPassword());
            account.setRole(accountDto.getRole());
            account.setDeleteFlag(accountDto.isDeleteFlag());
            return accountRepository.save(account).toAccountDto();
        }
        return null;
    }



    @Override
    public AccountDto findAccountDTO(Long id) {
        Optional<Account> byId = accountRepository.findById(id);

        if (byId.isPresent()){
            return accountRepository.findById(id).get().toAccountDto();
        }else {
            return null;
        }

    }

    @Override
    public AccountDto deleteAccountDTO(AccountDto accountDto, Long id) {
        Optional<Account> editDbAccount = accountRepository.findById(id);

        if(editDbAccount.isPresent()){
            Account account = editDbAccount.get();
            account.setDeleteFlag(true);
            return accountRepository.save(account).toAccountDto();
        }
            return null;
    }


}
