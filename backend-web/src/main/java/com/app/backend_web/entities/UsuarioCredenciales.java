package com.app.backend_web.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Usuario_Credenciales")
public class UsuarioCredenciales {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="usuario_credenciales_id")
    private Long id;

    private String correo;

    private String contraseña;

    @ManyToOne
    @JoinColumn(name="rol_id")
    private Rol rol;



}
