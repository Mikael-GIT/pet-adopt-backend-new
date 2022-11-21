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
import com.tcc.petadopt.domain.dtos.ZoomMeetingRequest;
import com.tcc.petadopt.domain.dtos.ZoomMeetingResponse;
import com.tcc.petadopt.repositories.AdocaoRepository;
import com.tcc.petadopt.repositories.AnimalRepository;
import com.tcc.petadopt.repositories.UsuarioRepository;
import com.tcc.petadopt.services.EmailService;
import com.tcc.petadopt.services.ZoomService;

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

    @Autowired
    private ZoomService zoomService;


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
        email.setEmailTo(adocao.getUsuario().getEmail());
        email.setOwnerRef("PetAdopt APP");
        email.setSubject("Solicitação de adoção - PET ADOPT APP");
        email.setText("Olá " + adocao.getUsuario().getNome() + " recebemos seu pedido de adoção do nosso amado " + adocao.getAnimal().getNome() + " ficamos muito felizes com seu pedido."
        + " A próxima etapa, é a entrevista, sala no zoom foi criada, solicitamos que entre nesta sala no horário informado: ");
        emailService.sendEmail(email);
        return adocaoRepository.save(adocao);
    }

    @PostMapping("/agendarEntrevista")
    public Adocao agendarEntrevista(@RequestBody AdocaoPostDTO dto) throws Exception{

        Adocao adocao = adocaoRepository.findById(dto.getId()).orElseThrow(() -> new Exception("Pedido de adoção não encontrado!"));
        Email email = new Email();
        ZoomMeetingRequest zoomMeetingRequest = new ZoomMeetingRequest();
        zoomMeetingRequest.setAgenda("Entrevista agendada");
        zoomMeetingRequest.setStart_time(dto.getData_entrevista());
        zoomMeetingRequest.setTopic("Entrevista de adoção");

        ZoomMeetingResponse zoomResponse =  zoomService.createZoomMeeting(zoomMeetingRequest);

        email.setEmailFrom("mikael.tavares@unigranrio.br");
        email.setEmailTo(adocao.getUsuario().getEmail());
        email.setOwnerRef("PetAdopt APP");
        email.setSubject("Entrevista agendada - PET ADOPT APP");
        email.setText("Olá " + adocao.getUsuario().getNome() + " agendamos sua entrevista de adoção. Por favor, entre na sala do zoom na data " + dto.getData_entrevista() + ". Segue o link da sala: "+ zoomResponse.getStart_url());
        emailService.sendEmail(email);
        adocao.setStatus("agendado");
        return adocaoRepository.save(adocao);
    }


    @PostMapping("/aprovarSolicitacao")
    public Adocao aprovarSolicitacao(@RequestBody AdocaoPostDTO dto) throws Exception{

        Adocao adocao = adocaoRepository.findById(dto.getId()).orElseThrow(() -> new Exception("Pedido de adoção não encontrado!"));
        Email email = new Email();
        ZoomMeetingRequest zoomMeetingRequest = new ZoomMeetingRequest();
        zoomMeetingRequest.setAgenda("Entrevista agendada");
        zoomMeetingRequest.setStart_time(dto.getData_entrevista());
        zoomMeetingRequest.setTopic("Entrevista de adoção");

        ZoomMeetingResponse zoomResponse =  zoomService.createZoomMeeting(zoomMeetingRequest);

        email.setEmailFrom("mikael.tavares@unigranrio.br");
        email.setEmailTo(adocao.getUsuario().getEmail());
        email.setOwnerRef("PetAdopt APP");
        email.setSubject("Pedido de adoção aprovado - PET ADOPT APP");
        email.setText("Olá " + adocao.getUsuario().getNome() + " seu pedido de adoção do (a) " + adocao.getAnimal().getNome() + " foi aprovado. Em breve entraremos em contato pelo whatsapp para marcarmos a entrega do seu tão aguardado novo amiguinho (a). Falta pouco, logo mais estará em seus braços!");
        emailService.sendEmail(email);
        adocao.getAnimal().setStatus("adotado");
        adocao.setStatus("aprovado");
        return adocaoRepository.save(adocao);
    }

}