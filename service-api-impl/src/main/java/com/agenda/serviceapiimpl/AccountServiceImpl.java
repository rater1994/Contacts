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

    String admin = "admin";

    @Override
    public List<AccountDto> getAllAccountsDto() {
        List<AccountDto> list = new ArrayList<>();

        accountRepository.findAll().forEach(account -> list.add(account.toAccountDto()));
        return list;
    }

    @Override
    public ResponseEntity<String> addAccountDTO(AccountDto accountDto) {
        Account account = new Account();

        String test = accountDto.getRole();



        if(test == "admin" ) {
//            accountDto.setRole( "USER" );
            System.out.println("1");
        } else {
            System.out.println("2");
        }


//        if (accountRepository.existsByUsername( accountDto.getUsername() )) {
//            return new ResponseEntity <> ( "Username already exist!", HttpStatus.BAD_REQUEST );
//        } else {
//            accountDto.setDeleteFlag( "ACTIVATED" );
//
//            System.out.println("The account role: " + accountDto.getRole());
//            account.updateAccountDto( accountDto );
//            accountRepository.save( account ).toAccountDto();
//
//            return new ResponseEntity <>( "Account was created", HttpStatus.OK );
//        }
        return new ResponseEntity <>( "Account was created", HttpStatus.OK );
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
            System.out.println("Search...." + id);
            return accountRepository.findById(id).get().toAccountDto();

        } else {
            return null;
        }
    }

    @Override
    public ResponseEntity<String> deleteAccountDTO(Integer id)  {
        Optional<Account> byId = accountRepository.findById(id);
        if(byId.isPresent()) {
            accountRepository.deleteById( id );
            return new ResponseEntity <> ( "Account was succesfull deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity <> ( "Account was not found", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> loginDto(String  username, String password) {
        boolean findByIdDb = accountRepository.existsByUsername( username );
        boolean findByPasswordDb  = accountRepository.existsByPassword( password );

        if (findByIdDb && findByPasswordDb) {
            return new ResponseEntity <>( "Successful login", HttpStatus.OK);
        } else {
            return new ResponseEntity <>( "Invalid credentials!", HttpStatus.BAD_REQUEST);
        }
    }
}
