package com.tcc.petadopt.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.petadopt.domain.Adocao;
import com.tcc.petadopt.domain.Email;
import com.tcc.petadopt.domain.dtos.AdocaoPostDTO;
import com.tcc.petadopt.repositories.AdocaoRepository;
import com.tcc.petadopt.repositories.AnimalRepository;
import com.tcc.petadopt.repositories.UsuarioRepository;
import com.tcc.petadopt.services.EmailService;

@RestController
@RequestMapping("/adocao")
@CrossOrigin
public class AdocaoController {
    
    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private EmailService emailService;


    @GetMapping
    public List<Adocao> getAll(){
        return adocaoRepository.findAll();
    }

    @GetMapping("{id}")
    public Adocao getById(@PathVariable Integer id) throws Exception{
        return adocaoRepository.findById(id).orElseThrow(() -> new Exception("Não foi possível recuperar dados"));
    }

    @GetMapping("{id}/adoptions")
    public List<Adocao> getAdoptionsByUser(@PathVariable Integer id) throws Exception{
        return adocaoRepository.findAllAdoptionsByUserId(id);
    }

    @PostMapping
    public Adocao save(@RequestBody AdocaoPostDTO dto) throws Exception{
        Adocao adocao = dto.toModel(dto, animalRepository, usuarioRepository);
        Email email = new Email();
        email.setEmailFrom("mikael.tavares@unigranrio.br");
        email.setEmailTo("raphael.mathias@unigranrio.br");
        email.setOwnerRef("Raphael");
        email.setSubject("Solicitação de adoção - PET ADOPT APP");
        email.setText("Olá " + adocao.getUsuario() + " recebemos seu pedido de adoção do nosso amado " + adocao.getAnimal() + " ficamos muito felizes com seu pedido."
        + " A próxima etapa, é verificarmos se o seu perfil confiz com as necessidades do pet, em até 48h, entraremos em contato por whatsapp com um a devolutiva e caso seja positiva, marcaremos uma entrevista e o link da sala será enviado por email. Muito obrigado e até já!");
        emailService.sendEmail(email);
        return adocaoRepository.save(adocao);
    }

}