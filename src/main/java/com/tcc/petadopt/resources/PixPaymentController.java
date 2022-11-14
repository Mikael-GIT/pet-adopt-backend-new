package com.tcc.petadopt.resources;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.petadopt.domain.Usuario;
import com.tcc.petadopt.domain.dtos.pix.PixPaymentDTO;
import com.tcc.petadopt.domain.dtos.pix.PixPaymentResponseDTO;
import com.tcc.petadopt.repositories.UsuarioRepository;
import com.tcc.petadopt.services.PixPaymentService;

@RestController
@RequestMapping("/process_payment")
@CrossOrigin
public class PixPaymentController {
    
    @Autowired
    private PixPaymentService pixPaymentService;

    @Autowired
    private  UsuarioRepository usuarioRepository;


    @PostMapping("{id}")
    public ResponseEntity<PixPaymentResponseDTO> processPayment(@RequestBody @Valid PixPaymentDTO pixPaymentDTO, @PathVariable Integer id) throws Exception {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new Exception("Não foi possível obter usuário"));
        PixPaymentResponseDTO payment = pixPaymentService.processPayment(pixPaymentDTO, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}
