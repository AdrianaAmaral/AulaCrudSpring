package com.curso.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curso.crud.model.Usuario;
import com.curso.crud.repository.UsuarioRepository;

@RestController
public class GreetingsController {
   	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	   
    @RequestMapping(value = "/usuario/{nome}/idade/{idade}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String salvarUsuario(@PathVariable String nome, @PathVariable int idade) {
    	
    	Usuario usuario = new Usuario();
    	    	   	
    	usuario.setNome(nome);
    	
    	usuario.setIdade(idade);
    	
    	usuarioRepository.save(usuario);
    	
    	   	    	
    	return  "Salvo o usuario " + nome;
    	
    }
    
    @GetMapping(value = "listatodos")
    @ResponseBody 
    public ResponseEntity<List<Usuario>> listaUsuario(){
    	
    	List<Usuario> usuario = usuarioRepository.findAll();
    	
    	return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
    	
    	
    }
    
    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@ResquestParam Long iduser) {
    	
    	usuarioRepository.deleteById(iduser);
    	
    	return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);
    	
    }
    
    
}
