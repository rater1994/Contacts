package com.agenda.model.dto;

public class ContactDto {
    private Integer id;
    private String firstNameDto;
    private String lastNameDto;
    private String numberPhoneDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstNameDto() {
        return firstNameDto;
    }

    public void setFirstNameDto(String firstNameDto) {
        this.firstNameDto = firstNameDto;
    }

    public String getLastNameDto() {
        return lastNameDto;
    }

    public void setLastNameDto(String lastNameDto) {
        this.lastNameDto = lastNameDto;
    }

    public String getNumberPhoneDto() {
        return numberPhoneDto;
    }

    public void setNumberPhoneDto(String numberPhoneDto) {
        this.numberPhoneDto = numberPhoneDto;
    }


}
