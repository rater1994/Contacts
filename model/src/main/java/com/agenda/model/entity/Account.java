package com.agenda.model.entity;


import com.agenda.model.dto.AccountDto;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import java.util.logging.Logger;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Entity
@SQLDelete(sql = "UPDATE users SET delete_flag = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "delete_flag <> 'DELETED'")
@Table(name="users")
public class Account {

    @Transient
    Logger log = Logger.getLogger(this.getClass().getName());


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private String Role;

    @Column(name = "DeleteFlag")
    private String deleteFlag;

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

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
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
        accountDto.setRole(this.Role);
        accountDto.setDeleteFlag(this.deleteFlag);
        return accountDto;
    }

    public void updateAccountDto(AccountDto accountDto){
        this.id = accountDto.getId();
        this.username = accountDto.getUsername();
        this.password = accountDto.getPassword();
        this.Role  = accountDto.getRole();
        this.deleteFlag = accountDto.getDeleteFlag();
    }
}
