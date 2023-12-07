package com.fatec.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fatec.backend.Entitys.PedidoEntity;

public interface PedidoRepository 
extends JpaRepository<PedidoEntity, Integer>, 
JpaSpecificationExecutor<PedidoEntity> {
    
}
