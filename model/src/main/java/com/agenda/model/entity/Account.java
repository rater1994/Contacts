package com.agenda.model.entity;


import com.agenda.model.dto.AccountDto;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Entity
@Table(name="users")
@SQLDelete(sql = "UPDATE users SET delete_flag = 'DELETED' WHERE id = ?",check = ResultCheckStyle.COUNT)
@Where(clause = "delete_flag <> 'DELETED'")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private String role;

    @Column(name = "DeleteFlag")
    private String deleteFlag;

    @OneToMany(mappedBy = "account")
    private List<Contact> contacts = new ArrayList<>();

    private String token;

    public Account(){}

    public Account(Account account) {
        this.id = account.getId();
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.role = account.getRole();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //    @Column
//    @Enumerated(EnumType.STRING)
//    private AccountState state;



//    @PreRemove
//    public void deleteUser(){
//        log.info("Set state to DELETED");
//        this.state = AccountState.DELETED;
//    }


//
//    public AccountState getState() {
//        return state;
//    }
//
//    public void setState(AccountState state) {
//        this.state = state;
//    }

    public AccountDto toAccountDto(){
        AccountDto accountDto = new AccountDto();

        accountDto.setId(this.id);
        accountDto.setUsername(this.username);
        accountDto.setPassword(this.password);
        accountDto.setRole(this.role);
        accountDto.setDeleteFlag(this.deleteFlag);
        return accountDto;
    }

    public void updateAccountDto(AccountDto accountDto){
        this.id = accountDto.getId();
        this.username = accountDto.getUsername();
        this.password = accountDto.getPassword();
        this.role  = accountDto.getRole();
        this.deleteFlag = accountDto.getDeleteFlag();
    }
}
