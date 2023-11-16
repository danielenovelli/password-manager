package com.daniele.passwordmanager.mapper;

import com.daniele.passwordmanager.dto.UserDto;
import com.daniele.passwordmanager.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUserEntity(UserDto userDto);
    UserDto toUserDto(User user);
    List<UserDto> toUserDtoList(List<User> userList);
}
