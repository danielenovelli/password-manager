package com.daniele.passwordmanager.services.impl;

import com.daniele.passwordmanager.dto.DataDto;
import com.daniele.passwordmanager.entities.Data;
import com.daniele.passwordmanager.exception.custom.DataNotFoundException;
import com.daniele.passwordmanager.repositories.DataRepository;
import com.daniele.passwordmanager.services.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DataServiceImpl implements IDataService {
    @Autowired
    private DataRepository dataRepository;
    @Transactional
    @Override
    public DataDto createData(DataDto dataDto) {
        Data data=DataDto.toDataEntity(dataDto);
        dataRepository.save(data);
        return DataDto.toDataDto(data);
    }
    @Override
    public List<DataDto> getAllData() {
        List<Data> dataList=dataRepository.findAll();
        return DataDto.toDataDtoList(dataList);
    }
    @Override
    public DataDto getDataById(Long id) {
        Data data=dataRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found with this id: "+id));
        return DataDto.toDataDto(data);
    }
    @Transactional
    @Override
    public DataDto updateData(DataDto dataDto) {
        Optional<Data> optionalData=dataRepository.findById(dataDto.getId());
        Data finalData=new Data();
        if(optionalData.isPresent()){
            Data temp=DataDto.toDataEntity(dataDto);
            finalData= Data.builder()
                    .id(optionalData.get().getId())
                    .name(temp.getName())
                    .email(temp.getEmail())
                    .username(temp.getUsername())
                    .password(temp.getPassword())
                    .url(temp.getUrl())
                    .notes(temp.getNotes())
                    .build();
            dataRepository.save(finalData);
        } else {
            throw new DataNotFoundException("Data not found with this id: "+dataDto.getId());
        }
        return DataDto.toDataDto(finalData);
    }
    @Transactional
    @Override
    public DataDto deleteDataById(Long id) {
        Data data=dataRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found with this id: "+id));
        dataRepository.deleteById(id);
        return DataDto.toDataDto(data);
    }
    @Transactional
    @Override
    public List<DataDto> deleteAllData() {
        List<Data> dataList=dataRepository.findAll();
        dataRepository.deleteAll();
        return DataDto.toDataDtoList(dataList);
    }
}