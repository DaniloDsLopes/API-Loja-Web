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

import com.fatec.backend.Entitys.CestaEntity;
import com.fatec.backend.Repository.CestaRepository;



@RestController
@CrossOrigin("origins = *")
public class CestaController {
    @Autowired
    CestaRepository repository;

    @PostMapping("/api/cesta")
    public ResponseEntity<String> 
            inserir(@RequestBody CestaEntity obj){
        repository.save(obj);
        String mensagem = "Item adicionado na cesta";
        return ResponseEntity.ok(mensagem);        
    }
    @PutMapping("/api/cesta")
    public ResponseEntity<String> 
            alterar(@RequestBody CestaEntity obj){
        repository.save(obj);
        String mensagem = "Item atualizado na cesta";
        return ResponseEntity.ok(mensagem);        
    }    
    @GetMapping("/api/cesta/{codigo}")
    public ResponseEntity<CestaEntity> 
        carregar(@PathVariable int codigo){
        Optional<CestaEntity> obj = repository.findById(codigo);
        if(obj.isPresent())    
            return ResponseEntity.ok(obj.get());
        else
            return ResponseEntity.ok(new CestaEntity());
    }
    @GetMapping("/api/cesta/lista")
    public ResponseEntity<List<CestaEntity>> 
        lista(@PathVariable int cliente){
            List<CestaEntity> lista = repository.findAll();
            return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/api/cesta/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        repository.deleteById(codigo);
        String mensagem = "item removido da cesta!";
        return ResponseEntity.ok(mensagem);    
    }

}
