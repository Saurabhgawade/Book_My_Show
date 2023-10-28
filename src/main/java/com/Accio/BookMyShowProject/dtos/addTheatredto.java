package com.Accio.BookMyShowProject.dtos;

import com.Accio.BookMyShowProject.Enums.City;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class addTheatredto {
    private String theatreName;

    private String address;


    private City city;
    private int noOfPremiumseats;
    private int noOfClassicseats;
    private int noOfrows;
}
