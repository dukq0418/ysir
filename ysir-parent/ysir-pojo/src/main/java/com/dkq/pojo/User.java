package com.dkq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private Integer id;
    private String email;
    private String phoneNum;
    private String password;
    private String code;
    private String nickName;
    private String sex;
    private String birthday;
    private String address;
    private String imgUrl;
    private Date createTime;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String phoneNum, String password, String code, String nickName, String sex, String birthday, String address, String imgUrl, Date createTime) {
        this.email = email;
        this.phoneNum = phoneNum;
        this.password = password;
        this.code = code;
        this.nickName = nickName;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
    }
}
