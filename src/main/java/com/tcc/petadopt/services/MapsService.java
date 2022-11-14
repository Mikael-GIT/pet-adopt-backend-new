package com.tcc.petadopt.services;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcc.petadopt.domain.dtos.RowsDTO;

@Service
public class MapsService {
    
    private String apiKey = "AIzaSyCNQ6Mg5vuZutG_88ys3ipMyQV1Q5GTzwk";

    public RowsDTO getDistanceBetweenCeps(String cepOrigin, String cepDestination){
        final String baseUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?destinations=26031481&origins=26031481&key=AIzaSyCNQ6Mg5vuZutG_88ys3ipMyQV1Q5GTzwk";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RowsDTO> zoomRoom= restTemplate.getForEntity(baseUrl, RowsDTO.class);
        return zoomRoom.getBody();
    }
}