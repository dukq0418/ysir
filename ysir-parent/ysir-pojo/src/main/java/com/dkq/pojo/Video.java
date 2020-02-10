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
public class Video implements Serializable {
    private Integer id;
    private String title;
    private String detail;
    private Integer time;
    private Integer speaker_id;
    private Integer course_id;
    private String video_url;
    private String image_url;
    private Integer play_num;
    private Speaker speaker;
    private Course course;

    public Video(Integer id, String title, String detail, Integer time, Integer speaker_id, Integer course_id, String video_url, String image_url, Integer play_num) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.time = time;
        this.speaker_id = speaker_id;
        this.course_id = course_id;
        this.video_url = video_url;
        this.image_url = image_url;
        this.play_num = play_num;
    }
}
