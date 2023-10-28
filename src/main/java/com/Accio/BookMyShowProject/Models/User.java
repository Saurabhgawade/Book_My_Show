package com.Accio.BookMyShowProject.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;

    @Column(name = "emailId",unique = true)
    private String emailId;

    private int age;

    private String mobNo;
}
