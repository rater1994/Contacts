package com.agenda.model.entity;


import com.agenda.model.dto.AccountDto;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private String Role;

    @Column(name = "Deleted")
    private boolean deleteFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

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
        this.deleteFlag = accountDto.isDeleteFlag();
    }
}
