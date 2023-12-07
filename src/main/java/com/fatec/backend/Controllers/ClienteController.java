package com.fatec.backend.Controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.fatec.backend.Entitys.ClienteEntity;
import com.fatec.backend.Repository.ClienteRepository;

@RestController
@CrossOrigin("*")
public class ClienteController {
    @Autowired
    ClienteRepository repository;

    // @Autowired 
    // JavaMailSender mailSender;

    @PostMapping("/api/cliente")
    public ResponseEntity<String> 
            inserir(@RequestBody ClienteEntity obj){
        repository.save(obj);
        String mensagem = "cadastro efetuado com sucesso";
        return ResponseEntity.ok(mensagem);        
    }
    @PutMapping("/api/cliente")
    public ResponseEntity<String> 
        alterar(@RequestBody ClienteEntity obj){
        repository.save(obj);
        String mensagem = "cadastro atualizado";
        return ResponseEntity.ok(mensagem);        
    }    
    @GetMapping("/api/cliente/{codigo}")
    public ResponseEntity<ClienteEntity> 
        carregar(@PathVariable int codigo){
        Optional<ClienteEntity> obj = repository.findById(codigo);
        if(obj.isPresent())    
            return ResponseEntity.ok(obj.get());
        else
            return ResponseEntity.ok(new ClienteEntity());    
    }

    @GetMapping("/api/cliente/lista")
    public ResponseEntity<List<ClienteEntity>> 
        lista(){
        List<ClienteEntity> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/api/cliente/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        repository.deleteById(codigo);
        String mensagem = "cliente removido !";
        return ResponseEntity.ok(mensagem);    
    }

    @PostMapping("/api/cliente/login")
    public ResponseEntity<ClienteEntity> 
            fazerLogin(@RequestBody ClienteEntity obj){
        Optional<ClienteEntity> retorno = 
            repository.fazerLogin(obj.getEmail(),obj.getSenha());                
        if(retorno.isPresent()){
            return ResponseEntity.ok(retorno.get());
        } else {
            return ResponseEntity.ok(new ClienteEntity());
        }         
    }

    // @PostMapping("/api/cliente/faleConosco")
    // public ResponseEntity<String> 
    //     faleConosco(@RequestBody ModeloEmail obj){
        
    //     String retorno = "";
    //     SimpleMailMessage novoEmail = new SimpleMailMessage();
        
    //     novoEmail.setSubject(obj.getAssunto());
    //     novoEmail.setText(obj.getMensagem());
    //     novoEmail.setFrom("fatecipiranga2023@outlook.com");
    //     novoEmail.setTo(obj.getPara());
    //     novoEmail.setCc("fatecipiranga2023@outlook.com");
    //     try{
    //         mailSender.send(novoEmail);
    //         retorno = "email enviado com sucesso";
    //     }
    //     catch(Exception err){
    //         retorno = "Ocorreu um erro no envio do email "+err.getMessage();
    //     } finally{}
    //         return ResponseEntity.ok(retorno);
            

    // } 
}

