package com.tcc.petadopt.domain.dtos;

import java.util.ArrayList;

import lombok.Data;

@Data
public class RowsDTO {
    ArrayList <Object> destination_addresses = new ArrayList <Object> ();
    ArrayList <Object> origin_addresses = new ArrayList <Object> ();
    ArrayList <RowDTO> rows = new ArrayList <RowDTO> ();
    private String status;
}