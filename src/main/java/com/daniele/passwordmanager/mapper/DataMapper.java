package com.daniele.passwordmanager.mapper;

import com.daniele.passwordmanager.dto.DataDto;
import com.daniele.passwordmanager.entities.Data;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DataMapper {
    Data toDataEntity(DataDto dataDto);
    DataDto toDataDto(Data data);
    List<DataDto> toDataDtoList(List<Data> dataList);
    List<Data> toDataEntityList(List<DataDto> dataDtoList);
}
