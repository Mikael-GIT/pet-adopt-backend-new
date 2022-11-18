package com.tcc.petadopt.domain.dtos;

import java.util.List;

import lombok.Data;

@Data
public class RowDTO {
    private List<ElementsDTO> elements;
}