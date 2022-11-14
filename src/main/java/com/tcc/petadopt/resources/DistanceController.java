package com.tcc.petadopt.resources;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.petadopt.domain.Animal;
import com.tcc.petadopt.domain.dtos.AnimalPostDTO;
import com.tcc.petadopt.domain.dtos.RowsDTO;
import com.tcc.petadopt.repositories.AnimalRepository;
import com.tcc.petadopt.repositories.CategoriaRepository;
import com.tcc.petadopt.services.MapsService;
@RestController
@RequestMapping("/distances")
@CrossOrigin
public class DistanceController {
    
    @Autowired
    private MapsService mapsService;

    @GetMapping
    public RowsDTO getDistance(){
        return mapsService.getDistanceBetweenCeps("26031481", "26022181");
    }

}