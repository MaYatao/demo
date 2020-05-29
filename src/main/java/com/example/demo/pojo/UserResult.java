package com.example.demo.pojo;

import com.example.demo.bean.User;
import lombok.Data;

@Data
public class UserResult  {



    private User user;
    private String username;
    private String password;
    private String name;
    private  Integer roleId;
    private Integer patientId;
    private Integer age;
    private String email;
    private String phone;
    private Boolean sex ;
    private String card;
    private String regDate;
    private Integer state ;

}
