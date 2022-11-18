package com.tcc.petadopt.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.petadopt.domain.dtos.RowsDTO;
import com.tcc.petadopt.services.MapsService;
@RestController
@RequestMapping("/distances")
@CrossOrigin
public class DistanceController {
    
    @Autowired
    private MapsService mapsService;

    @GetMapping
    public RowsDTO getDistance(){
        return null;
    }

}