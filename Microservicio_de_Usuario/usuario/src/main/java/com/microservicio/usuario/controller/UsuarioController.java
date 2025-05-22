package com.microservicio.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.usuario.model.Usuario;
import com.microservicio.usuario.model.UsuarioDto;
import com.microservicio.usuario.service.UsuarioService;



@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    ResponseEntity<String> obtenerUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.agregarUsuario(usuario));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDto> obtenerUsuario(@PathVariable int idUsuario){ 
        return ResponseEntity.ok(usuarioService.traerUsuario(idUsuario));
    }

    
    
}
