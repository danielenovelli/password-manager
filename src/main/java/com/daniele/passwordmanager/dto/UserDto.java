package com.daniele.passwordmanager.dto;

import com.daniele.passwordmanager.entities.Data;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    private String username;
    @Email(message = "Must be a valid email")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    private Date dateOfBirth;
    private String role;
}
