package com.tcc.petadopt.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.petadopt.domain.Usuario;
import com.tcc.petadopt.domain.dtos.UsuarioAccessDTO;
import com.tcc.petadopt.domain.dtos.UsuarioPostDTO;
import com.tcc.petadopt.domain.dtos.UsuarioUpdateDTO;
import com.tcc.petadopt.exceptions.ReturnError;
import com.tcc.petadopt.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping("{id}")
    public Usuario getById(@PathVariable Integer id) throws Exception{
        return usuarioRepository.findById(id).orElseThrow(() -> new Exception("Não foi possível obter usuário"));

	}

    @PostMapping
    public Usuario save(@RequestBody UsuarioPostDTO dto){
        Usuario usuario = dto.toModel(dto);
        return usuarioRepository.save(usuario);
    }

    @PutMapping
    public Usuario update(@RequestBody UsuarioUpdateDTO dto) throws Exception{
        Usuario usuario = dto.toModel(dto, usuarioRepository);
        return usuario;
    }


    @PostMapping
	@RequestMapping("access")
	public ResponseEntity<Object> access(@RequestBody UsuarioAccessDTO pUsuario) {
		Usuario usuario = new Usuario();
		try {
			usuario = usuarioRepository.access(pUsuario.getEmail(), pUsuario.getSenha());
			if (usuario != null) {
				return ResponseEntity.status(HttpStatus.OK).header("access", "true").body(usuario);
			} else {				
				return ResponseEntity.status(HttpStatus.NOT_FOUND).header("access", "false").body(new ReturnError(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase(), "Usuário ou senha inválida", "/api/usuario/create"));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("access", "false")
					.body(new ReturnError(HttpStatus.INTERNAL_SERVER_ERROR,
							HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage(),
							"/api/usuario/create"));
		}

	}

}