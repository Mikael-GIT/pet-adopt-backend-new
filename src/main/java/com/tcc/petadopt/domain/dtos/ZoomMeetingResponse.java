package com.tcc.petadopt.domain.dtos;

import lombok.Data;

@Data
public class ZoomMeetingResponse {
    
    private String uuid; 
    private String id;
    private String host_id;
    private String host_email;
    private String topic;
    private Integer type;
    private String status;
    private String start_time;  
    private Integer duration;
    private String timezone; 
    private String agenda;
    private String created_at; 
    private String start_url;
    private String join_url;
    private String password;
    private String h323_password;
    private String pstn_password;
    private String encrypted_password;
    private SettingsDTO settings;
    private boolean pre_schedule;
}