package com.daniele.passwordmanager.services;

import com.daniele.passwordmanager.dto.DataDto;

import java.util.List;

public interface IDataService {
    public DataDto createData(DataDto dataDto);
    public List<DataDto> getAllData();
    public DataDto getDataById(Long id);
    public DataDto updateData(DataDto dataDto);
    public DataDto deleteDataById(Long id);
    public List<DataDto> deleteAllData();
}
