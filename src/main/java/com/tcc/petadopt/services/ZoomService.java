package com.tcc.petadopt.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcc.petadopt.domain.dtos.ZoomMeetingRequest;
import com.tcc.petadopt.domain.dtos.ZoomMeetingResponse;


@Service
public class ZoomService {

    private String tokenJwt = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOm51bGwsImlzcyI6InJLN2tBNjl4UlN5M0tkVVVEdF9zR3ciLCJleHAiOjE2Njg5ODIxOTEsImlhdCI6MTY2ODM3NzM4OH0.2YckVmqy732lxnpFDHAmMe2iD7swFn_ppjjkCQISWAI";

    private final String hostEmail = "mikael.tavares@unigranrio.br";


    public ZoomMeetingResponse createZoomMeeting(ZoomMeetingRequest zoomMeetingRequest) throws URISyntaxException{
        final String baseUrl = "https://api.zoom.us/v2/users/"+ this.hostEmail +"/meetings";
        URI uri = new URI(baseUrl);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization", "Bearer " + tokenJwt);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<ZoomMeetingRequest> httpEntity = new HttpEntity<>(zoomMeetingRequest, headers);
        ResponseEntity<ZoomMeetingResponse> zoomRoom= restTemplate.exchange(uri, HttpMethod.POST, httpEntity, ZoomMeetingResponse.class);
        return zoomRoom.getBody();
    }
}