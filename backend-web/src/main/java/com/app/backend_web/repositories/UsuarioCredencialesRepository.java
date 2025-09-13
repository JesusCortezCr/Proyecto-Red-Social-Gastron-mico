package com.app.backend_web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.backend_web.entities.UsuarioCredenciales;

public interface UsuarioCredencialesRepository extends JpaRepository<UsuarioCredenciales,Long> {

    
}
