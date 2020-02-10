package com.dkq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course implements Serializable {
    private Integer id;
    private String course_title;
    private String course_desc;
    private Integer subject_id;
    private Subject subject;
    private Speaker speaker;
    private List<Video> videoList;
}
