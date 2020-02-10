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
public class Admin implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String roles;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
