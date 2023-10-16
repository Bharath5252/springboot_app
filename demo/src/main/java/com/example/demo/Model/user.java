package com.example.demo.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class user {
    @Id
    public String Id;
    public String name;
    public String email;
    public String password;


    public String getname(){
        return name;
    } 

    public String getemail(){
        return email;
    }

    
}


