package com.microservicio.usuario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data

@Entity
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Id
    private int idUsuario;

    private String nombre;
    private String correo;
    private String contrasena;

}
