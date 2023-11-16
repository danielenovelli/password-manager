package com.daniele.passwordmanager.dto;

import com.daniele.passwordmanager.entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataDto {
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Email(message = "Email is not valid")
    private String email;
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    private String url;
    private String notes;
}
