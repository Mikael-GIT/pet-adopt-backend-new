package com.tcc.petadopt.domain.dtos;

import com.tcc.petadopt.domain.Endereco;
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

    private String profissao;

    private String linkFacebook;

    private String linkInstagram;

    private Boolean possuiOuPossuiuPets;

    private String motivoAdocao;

    private String numResidentesDomicilio;

    private Boolean residentesConcordamAdocao;

    private Boolean teraLivreAcessoAosComodos;
    
    private Boolean possuiBebeOuPretende;

    private Boolean residentesPossuiAlergia;

    private Boolean isCastrados;

    private Boolean concordaManterInformados;

    private Boolean aceitaVisitasPosAdocao;

    private Boolean adotouoOuDoouUmPet;

    private String tipoResidencia;

    private String ambientePropicioParaCriacao;

    private Endereco endereco;
    

    public Usuario toModel(UsuarioUpdateDTO dto, UsuarioRepository usuarioRepository) throws Exception{
        Usuario usuario = usuarioRepository.findById(dto.getId()).orElseThrow(() -> new Exception("Não foi possível obter dados do usuário."));
        usuario.setIdade(dto.getIdade());
        usuario.setCpf(dto.getCpf());
        usuario.setEndereco(dto.getEndereco());
        usuario.setLinkFacebook(dto.getLinkFacebook());
        usuario.setLinkInstagram(dto.getLinkInstagram());
        usuario.setMotivoAdocao(dto.getMotivoAdocao());
        usuario.setIsCastrados(dto.getIsCastrados());
        usuario.setAdotouoOuDoouUmPet(dto.getAdotouoOuDoouUmPet());
        usuario.setAceitaVisitasPosAdocao(dto.getAceitaVisitasPosAdocao());
        usuario.setAmbientePropicioParaCriacao(dto.getAmbientePropicioParaCriacao());
        usuario.setConcordaManterInformados(dto.getConcordaManterInformados());
        usuario.setNumResidentesDomicilio(dto.getNumResidentesDomicilio());
        usuario.setPossuiBebeOuPretende(dto.getPossuiBebeOuPretende());
        usuario.setPossuiOuPossuiuPets(dto.getPossuiOuPossuiuPets());
        usuario.setProfissao(dto.getProfissao());
        usuario.setResidentesConcordamAdocao(dto.getResidentesConcordamAdocao());
        usuario.setResidentesPossuiAlergia(dto.getResidentesPossuiAlergia());
        usuario.setTeraLivreAcessoAosComodos(dto.getTeraLivreAcessoAosComodos());
        usuario.setTipoResidencia(dto.getTipoResidencia());
        return usuarioRepository.save(usuario);
    }
}