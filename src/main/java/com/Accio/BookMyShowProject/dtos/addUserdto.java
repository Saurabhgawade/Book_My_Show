package com.Accio.BookMyShowProject.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class addUserdto {
    private String userName;


    private String emailId;
    private int age;

    private String mobNo;
}
