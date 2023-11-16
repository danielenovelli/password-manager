package com.daniele.passwordmanager.repositories;

import com.daniele.passwordmanager.dto.DataDto;
import com.daniele.passwordmanager.entities.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
}
