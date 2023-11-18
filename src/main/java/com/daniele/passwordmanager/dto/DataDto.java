package com.daniele.passwordmanager.dto;

import com.daniele.passwordmanager.entities.Data;
import com.daniele.passwordmanager.entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
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

    public static DataDto toDataDto(Data data) {
        if (data == null) {
            return null;
        }
        DataDto dataDto = new DataDto();
        dataDto.setId(data.getId());
        dataDto.setName(data.getName());
        dataDto.setEmail(data.getEmail());
        dataDto.setUsername(data.getUsername());
        dataDto.setPassword(data.getPassword());
        dataDto.setUrl(data.getUrl());
        dataDto.setNotes(data.getNotes());

        return dataDto;
    }

    public static List<DataDto> toDataDtoList(List<Data> dataList) {
        if (dataList == null) {
            return null;
        }
        List<DataDto> list = new ArrayList<DataDto>(dataList.size());
        for (Data data : dataList) {
            list.add(toDataDto(data));
        }

        return list;
    }

    public static Data toDataEntity(DataDto dataDto) {
        if (dataDto == null) {
            return null;
        }
        Data.DataBuilder data = Data.builder();
        data.id(dataDto.getId());
        data.name(dataDto.getName());
        data.email(dataDto.getEmail());
        data.username(dataDto.getUsername());
        data.password(dataDto.getPassword());
        data.url(dataDto.getUrl());
        data.notes(dataDto.getNotes());

        return data.build();
    }

    public static List<Data> toDataEntityList(List<DataDto> dataDtoList) {
        if (dataDtoList == null) {
            return null;
        }
        List<Data> list = new ArrayList<Data>(dataDtoList.size());
        for (DataDto dataDto : dataDtoList) {
            list.add(toDataEntity(dataDto));
        }
        return list;
    }
}