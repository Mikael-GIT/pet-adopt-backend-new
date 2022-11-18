package com.tcc.petadopt.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcc.petadopt.domain.dtos.RowsDTO;

@Service
public class MapsService {
    
    private String apiKey = "AIzaSyCNQ6Mg5vuZutG_88ys3ipMyQV1Q5GTzwk";

    public RowsDTO getDistanceBetweenCeps(String cepOrigin, List<String> ceps){
        StringBuilder url = new StringBuilder();
        
        final String baseUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?destinations=";
        url.append(baseUrl);
        ceps.forEach(cep -> url.append(cep + "|"));
        url.append("&origins=")
        .append(cepOrigin)
        .append("&key=")
        .append(apiKey)
        .toString();
        System.out.println(url.toString());
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RowsDTO> zoomRoom= restTemplate.getForEntity(url.toString(), RowsDTO.class);
        return zoomRoom.getBody();
    }
}