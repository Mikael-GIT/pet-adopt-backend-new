package com.tcc.petadopt.domain.dtos;

import lombok.Data;

@Data
public class SettingsDTO {

    private Boolean host_video;
    private Boolean participant_video;
    private Boolean cn_meeting;
    private Boolean in_meeting;
    private Boolean join_before_host;
    private Integer jbh_time;
    private Boolean mute_upon_entry;
    
}