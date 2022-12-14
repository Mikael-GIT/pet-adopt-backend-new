package com.tcc.petadopt.domain.dtos;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDto {

    @NotBlank
    private String ownerRef;

    @NotBlank
    @Email
    private String emailFrom;

    @NotBlank
    @Email
    private String emailTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;
}