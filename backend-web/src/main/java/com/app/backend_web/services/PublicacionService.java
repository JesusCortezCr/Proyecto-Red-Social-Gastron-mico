package com.app.backend_web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.backend_web.entities.Publicacion;
import com.app.backend_web.repositories.PublicacionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;

    public List<Publicacion> getAllPublicaciones() {
        return publicacionRepository.findAll();
    }

    public Publicacion getPublicacionById(Long id) {
        return publicacionRepository.findById(id).orElseThrow(() -> new RuntimeException("Publicacion not found"));
    }

    public Publicacion addPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public Publicacion updatePublicacion(Publicacion publicacion) throws Exception {
        if (!publicacionRepository.existsById(publicacion.getId())) {
            throw new Exception("ID not found");
        }
        return publicacionRepository.save(publicacion);
    }

    public String deletePublicacionById(Long id) throws Exception {
        if (!publicacionRepository.existsById(id)) {
            throw new Exception("ID not found");
        }
        publicacionRepository.deleteById(id);
        return String.format("publicacion deleted with id: %d", id);
    }
}