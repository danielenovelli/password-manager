package com.daniele.passwordmanager.dto;

import com.daniele.passwordmanager.entities.Data;
import com.daniele.passwordmanager.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
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

    public static User toUserEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDto.getId() );
        user.firstName( userDto.getFirstName() );
        user.lastName( userDto.getLastName() );
        user.username( userDto.getUsername() );
        user.email( userDto.getEmail() );
        user.password( userDto.getPassword() );
        if ( userDto.getDateOfBirth() != null ) {
            user.dateOfBirth( LocalDateTime.ofInstant( userDto.getDateOfBirth().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        user.role( userDto.getRole() );

        return user.build();
    }
    public static UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setUsername( user.getUsername() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        if ( user.getDateOfBirth() != null ) {
            userDto.setDateOfBirth( Date.from( user.getDateOfBirth().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }
        userDto.setRole( user.getRole() );

        return userDto;
    }
    public static List<UserDto> toUserDtoList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( userList.size() );
        for ( User user : userList ) {
            list.add( toUserDto( user ) );
        }

        return list;
    }
}
