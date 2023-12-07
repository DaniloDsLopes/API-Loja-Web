package com.fatec.backend.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.backend.Entitys.PedidoEntity;
import com.fatec.backend.Repository.PedidoRepository;

@RestController
@CrossOrigin("origins = *")
public class PedidoController {
    @Autowired
    PedidoRepository repository;

    @PostMapping("/api/pedido")
    public ResponseEntity<String> 
        inserir(@RequestBody PedidoEntity obj){
                repository.save(obj); 
                String mensagem = "pedido efetuado com sucesso";
                return ResponseEntity.ok(mensagem);        
    }
    @PutMapping("/api/pedido")
    public ResponseEntity<String> 
        alterar(@RequestBody PedidoEntity obj){
            repository.save(obj);   
            String mensagem = "pedido atualizado";
            return ResponseEntity.ok(mensagem);        
    }    
    @GetMapping("/api/pedido/{codigo}")
    public ResponseEntity<PedidoEntity> 
        carregar(@PathVariable int codigo){
            Optional<PedidoEntity> obj = repository.findById(codigo);
            if(obj.isPresent())    
                return ResponseEntity.ok(obj.get());
            else
                return ResponseEntity.ok(new PedidoEntity());
    }
    @GetMapping("/api/pedido/lista")
    public ResponseEntity<List<PedidoEntity>> 
        lista(){
            List<PedidoEntity> lista = repository.findAll();
            return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/api/pedido/{codigo}")
    public ResponseEntity<String> 
        remover(@PathVariable int codigo){
            repository.deleteById(codigo);
            String mensagem = "pedido removido!";
            return ResponseEntity.ok(mensagem);    
    }
}
