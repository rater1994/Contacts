package com.agenda.serviceapiimpl;

import com.agenda.model.dto.AccountDto;
import com.agenda.model.entity.Account;
import com.agenda.model.repository.AccountRepository;
import com.agenda.serviceapi.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        account.updateAccountDto(accountDto);

        System.out.println(accountDto.getRole());

        return accountRepository.save(account).toAccountDto();

    }


    @Override
    public AccountDto editAccountDTO(AccountDto accountDto, Integer id) {
        Optional<Account> dbAccount = accountRepository.findById(id);

        if (dbAccount.isPresent()) {
            Account account = dbAccount.get();

            System.out.println("Edit.........");

            account.setUsername(accountDto.getUsername());
            account.setPassword(accountDto.getPassword());
            account.setRole(accountDto.getRole());
            account.setDeleteFlag(accountDto.getDeleteFlag());
            return accountRepository.save(account).toAccountDto();
        }
        return null;
    }


    @Override
    public AccountDto findAccountDTO(Integer id) {
        Optional<Account> byId = accountRepository.findById(id);

        if (byId.isPresent()) {
            return accountRepository.findById(id).get().toAccountDto();
        } else {
            return null;
        }
    }

    @Override
    public AccountDto deleteAccountDTO(Integer id)  {
        accountRepository.deleteById(id);
        return null;
    }

}
