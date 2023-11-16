package com.daniele.passwordmanager.resources.impl;

import com.daniele.passwordmanager.dto.DataDto;
import com.daniele.passwordmanager.resources.IDataController;
import com.daniele.passwordmanager.services.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController implements IDataController {
    @Autowired
    private IDataService dataService;

    @Override
    public ResponseEntity<DataDto> createData(DataDto dataDto) {
        return new ResponseEntity<>(dataService.createData(dataDto), HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<List<DataDto>> getAllData() {
        return new ResponseEntity<>(dataService.getAllData(), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<DataDto> getDataById(Long id) {
        return new ResponseEntity<>(dataService.getDataById(id), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<DataDto> updateData(DataDto dataDto) {
        return new ResponseEntity<>(dataService.updateData(dataDto), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<DataDto> deleteDataById(Long id) {
        return new ResponseEntity<>(dataService.deleteDataById(id), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<List<DataDto>> deleteAllData() {
        return new ResponseEntity<>(dataService.deleteAllData(), HttpStatus.OK);
    }
}