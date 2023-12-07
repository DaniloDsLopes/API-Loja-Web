package com.fatec.backend.Controllers;
import java.util.ArrayList;
import java.util.List;

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

import com.fatec.backend.Entitys.ProdutoEntity;

import com.fatec.backend.Repository.ProdutoRepository;

@RestController
@CrossOrigin("*")
public class ProdutoController {
    @Autowired
    ProdutoRepository repository;

        @PostMapping("/api/produto")
    public ResponseEntity<String> 
            inserir(@RequestBody ProdutoEntity obj){
        String mensagem = "produto cadastrado com sucesso";
        return ResponseEntity.ok(mensagem);        
    }
    @PutMapping("/api/produto")
    public ResponseEntity<String> 
        alterar(@RequestBody ProdutoEntity obj){
        String mensagem = "produto atualizado";
        return ResponseEntity.ok(mensagem);        
    }    
    @GetMapping("/api/produto/{codigo}")
    public ResponseEntity<ProdutoEntity> 
        carregar(@PathVariable int codigo){
        ProdutoEntity obj = new ProdutoEntity();    
        return ResponseEntity.ok(obj);
    }
    @GetMapping("/api/produto/lista")
    public ResponseEntity<List<ProdutoEntity>> 
        lista(){
        List<ProdutoEntity> lista = new ArrayList<ProdutoEntity>();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/api/produto/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        String mensagem = "produto removido!";
        return ResponseEntity.ok(mensagem);    
    }
}
