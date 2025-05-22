package com.microservicio.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.usuario.entity.UsuarioEntity;
import com.microservicio.usuario.model.Usuario;
import com.microservicio.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    UsuarioEntity ue = new UsuarioEntity();

    public String agregarUsuario(Usuario u){

        
        if(usuarioRepository.existsByIdUsuario(u.getIdUsuario())){
            try {
                ue.setIdUsuario(u.getIdUsuario());
                ue.setNombre(u.getNombre());
                ue.setCorreo(u.getCorreo());
                ue.setContrasena(u.getContrasena());
                usuarioRepository.save(ue);
                return "usuario guuardado correctamente"; 
            } catch (Exception e) {
                return "error al guardar el usuario"+ e.getMessage();
            }
            
        }else{
            return "el usuario ya existe";
        }
        


    }
    public Usuario traerUsuario(int id){

        try {
            UsuarioEntity usuarioDB = usuarioRepository.findByIdUsuario(id);
            if (usuarioDB != null) {
                Usuario u = new Usuario();
                u.setIdUsuario(u.getIdUsuario());
                u.setNombre(usuarioDB.getNombre());
                u.setCorreo(usuarioDB.getCorreo());
                u.setContrasena(usuarioDB.getContrasena());
                return u;
            } 


        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        return null;

    }

}
