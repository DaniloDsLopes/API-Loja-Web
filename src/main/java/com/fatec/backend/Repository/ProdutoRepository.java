package com.fatec.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fatec.backend.Entitys.ProdutoEntity;

public interface ProdutoRepository 
extends JpaRepository<ProdutoEntity, Integer>, 
JpaSpecificationExecutor<ProdutoEntity> {
    
}
