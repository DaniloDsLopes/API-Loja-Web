package com.fatec.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fatec.backend.Entitys.CestaEntity;

public interface CestaRepository 
extends JpaRepository<CestaEntity, Integer>, 
JpaSpecificationExecutor<CestaEntity> {
    
}
