package com.app.backend_web.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.backend_web.entities.Publicacion;
import com.app.backend_web.services.PublicacionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/publicaciones")
@RequiredArgsConstructor
public class PublicacionController {
   
    private final PublicacionService publicacionService;

   @GetMapping()
   public List<Publicacion> list() {
        return publicacionService.getAllPublicaciones();
   }

   @GetMapping("{id}")
   public Publicacion getById(@PathVariable Long id) {
       try {
           return publicacionService.getPublicacionById(id);
       } catch (Exception e) {
           return new Publicacion();
       }
   }

   @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
   public Publicacion insertPublicacion(@RequestBody Publicacion publicacion) {
       try {
           return publicacionService.addPublicacion(publicacion);
       } catch (Exception e) {
           return new Publicacion();
       }
   }

   @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
   public Publicacion updatePublicacion(@RequestBody Publicacion publicacion) {
       try {
           return publicacionService.updatePublicacion(publicacion);
       } catch (Exception e) {
           return new Publicacion();
       }
   }

   @DeleteMapping("{id}")
   public String deleteById(@PathVariable Long id) {
       try {
           return publicacionService.deletePublicacionById(id);
       } catch (Exception e) {
           return e.getMessage();
       }
   }
}