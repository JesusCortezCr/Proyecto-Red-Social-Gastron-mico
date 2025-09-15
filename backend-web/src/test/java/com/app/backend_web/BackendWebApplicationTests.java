package com.app.backend_web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import com.app.backend_web.entities.Usuario;
import com.app.backend_web.repositories.UsuarioRepository;
import com.app.backend_web.services.UsuarioServiceImpl;

@SpringBootTest
class BackendWebApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Test
	void testCrearUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombre("jamon");
		usuario.setApellido("patricio");
		usuario.setCantidadSeguidores(1);

		Usuario guardado = usuarioService.guardarUsuario(usuario, 2L, 1L);

		assertThat(guardado.getId()).isNotNull();
		assertThat(guardado.getNombre()).isEqualTo("jamon");
	}

}
