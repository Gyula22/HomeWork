package com.example.homework.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class ClientDTO {


    @Size(min = 1, max = 100)

    private String name;
    @Email
    private String email;

    public ClientDTO() {
    }

    public ClientDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
