package com.tcc.petadopt.domain.dtos;

import com.tcc.petadopt.domain.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioPostDTO {

    private String nome;

    private String login;

    private String email;

    private String senha;

    private String telefone;

    public Usuario toModel(UsuarioPostDTO dto){
        Usuario usuario = new Usuario();
        usuario.setLogin(dto.getLogin());
        usuario.setEmail(dto.getEmail());
        usuario.setNome(dto.getNome());
        usuario.setSenha(dto.getSenha());
        usuario.setTelefone(dto.getTelefone());
        return usuario;
        
    }
}