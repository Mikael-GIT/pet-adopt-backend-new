package com.tcc.petadopt.domain.dtos;

import com.tcc.petadopt.domain.Usuario;
import com.tcc.petadopt.repositories.UsuarioRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUpdateDTO {

    private Integer id;

    private String idade;

    private String cpf;
    

    public Usuario toModel(UsuarioUpdateDTO dto, UsuarioRepository usuarioRepository) throws Exception{
        Usuario usuario = usuarioRepository.findById(dto.getId()).orElseThrow(() -> new Exception("Não foi possível obter dados do usuário."));
        usuario.setIdade(dto.getIdade());
        usuario.setCpf(dto.getCpf());
        return usuarioRepository.save(usuario);
    }
}