package com.daniele.passwordmanager.services.impl;

import com.daniele.passwordmanager.dto.DataDto;
import com.daniele.passwordmanager.entities.Data;
import com.daniele.passwordmanager.exception.custom.DataNotFoundException;
import com.daniele.passwordmanager.mapper.DataMapper;
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
    private DataMapper dataMapper;
    @Autowired
    private DataRepository dataRepository;
    @Transactional
    @Override
    public DataDto createData(DataDto dataDto) {
        Data data=dataMapper.toDataEntity(dataDto);
        dataRepository.save(data);
        return dataMapper.toDataDto(data);
    }
    @Override
    public List<DataDto> getAllData() {
        List<Data> dataList=dataRepository.findAll();
        return dataMapper.toDataDtoList(dataList);
    }
    @Override
    public DataDto getDataById(Long id) {
        Data data=dataRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found with this id: "+id));
        return dataMapper.toDataDto(data);
    }
    @Transactional
    @Override
    public DataDto updateData(DataDto dataDto) {
        Optional<Data> optionalData=dataRepository.findById(dataDto.getId());
        Data finalData=new Data();
        if(optionalData.isPresent()){
            Data temp=dataMapper.toDataEntity(dataDto);
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
        return dataMapper.toDataDto(finalData);
    }
    @Transactional
    @Override
    public DataDto deleteDataById(Long id) {
        Data data=dataRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found with this id: "+id));
        dataRepository.deleteById(id);
        return dataMapper.toDataDto(data);
    }
    @Transactional
    @Override
    public List<DataDto> deleteAllData() {
        List<Data> dataList=dataRepository.findAll();
        dataRepository.deleteAll();
        return dataMapper.toDataDtoList(dataList);
    }
}
