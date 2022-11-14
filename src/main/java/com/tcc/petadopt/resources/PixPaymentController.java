package com.tcc.petadopt.resources;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.petadopt.domain.dtos.pix.PixPaymentDTO;
import com.tcc.petadopt.domain.dtos.pix.PixPaymentResponseDTO;
import com.tcc.petadopt.services.PixPaymentService;

@RestController
@RequestMapping("/process_payment")
public class PixPaymentController {
    
    @Autowired
    private final PixPaymentService pixPaymentService;

    @Autowired
    public PixPaymentController(PixPaymentService pixPaymentService) {
        this.pixPaymentService = pixPaymentService;
    }

    @PostMapping
    public ResponseEntity<PixPaymentResponseDTO> processPayment(@RequestBody @Valid PixPaymentDTO pixPaymentDTO) {
        PixPaymentResponseDTO payment = pixPaymentService.processPayment(pixPaymentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}
