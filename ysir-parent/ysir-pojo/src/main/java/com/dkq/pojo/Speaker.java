package com.dkq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Speaker implements Serializable {
    private Integer id;
    private String speaker_name;
    private String speaker_desc;
    private String speaker_job;
    private String head_img_url;

}
