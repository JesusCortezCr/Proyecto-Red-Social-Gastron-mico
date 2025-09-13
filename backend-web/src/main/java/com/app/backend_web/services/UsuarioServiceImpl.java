package com.app.backend_web.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.app.backend_web.entities.Usuario;
import com.app.backend_web.repositories.RolRepository;
import com.app.backend_web.repositories.UsuarioCredencialesRepository;
import com.app.backend_web.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioCredencialesRepository usuarioCredencialesRepository;  
   
    private final UsuarioRepository usuarioRepository;

    private final RolRepository rolRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,UsuarioCredencialesRepository usuarioCredencialesRepository,RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioCredencialesRepository = usuarioCredencialesRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Usuario> listadoTodosUsuarios() {
        return usuarioRepository.findAll();
    }
    
    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario, Long credencialesId, Long rolId) {
        var credenciales = usuarioCredencialesRepository.findById(credencialesId)
                .orElseThrow(() -> new RuntimeException("No se pudo encontrar por id: " + credencialesId));
        var rol = rolRepository.findById(rolId)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + rolId));

                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.setNombre(usuario.getNombre());
                nuevoUsuario.setApellido(usuario.getApellido());
                nuevoUsuario.setCantidadSeguidores(usuario.getCantidadSeguidores());
               
        nuevoUsuario.setUsuarioCredenciales(credenciales);
        nuevoUsuario.getUsuarioCredenciales().setRol(rol);
        return usuarioRepository.save(nuevoUsuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
    
    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario, Long credencialesId, Long rolId) {
        var usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        var credenciales = usuarioCredencialesRepository.findById(credencialesId)
                .orElseThrow(() -> new RuntimeException("No se pudo encontrar por id: " + credencialesId));
        var rol = rolRepository.findById(rolId)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + rolId));

        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellido(usuario.getApellido());
        usuarioExistente.setCantidadSeguidores(usuario.getCantidadSeguidores());
        usuarioExistente.setUsuarioCredenciales(credenciales);
        usuarioExistente.getUsuarioCredenciales().setRol(rol);

        return usuarioRepository.save(usuarioExistente);
    }


    


}
