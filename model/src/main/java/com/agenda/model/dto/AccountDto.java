package com.agenda.model.dto;

import java.util.ArrayList;
import java.util.List;

public class AccountDto {

    private Integer id;
    private String username;
    private String password;
    private String role;
    private String email;
    private String deleteFlag;

    private List <ContactDto> contactDtos = new ArrayList <>();

    public List <ContactDto> getContactDtos() {
        return contactDtos;
    }



    public void setContactDtos(List <ContactDto> contactDtos) {
        this.contactDtos = contactDtos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
