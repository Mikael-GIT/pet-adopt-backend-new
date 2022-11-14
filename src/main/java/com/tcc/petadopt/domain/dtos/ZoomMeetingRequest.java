package com.tcc.petadopt.domain.dtos;

import lombok.Data;

@Data
public class ZoomMeetingRequest {
    
    private String agenda;
    private String start_time;
    private String topic;
    
}