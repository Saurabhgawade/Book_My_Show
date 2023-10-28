package com.Accio.BookMyShowProject.Services;

import com.Accio.BookMyShowProject.Enums.SeatType;
import com.Accio.BookMyShowProject.Models.Theatre;
import com.Accio.BookMyShowProject.Models.TheatreSeat;
import com.Accio.BookMyShowProject.Repositories.TheatreRepository;
import com.Accio.BookMyShowProject.dtos.addTheatredto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public String addtheatre(addTheatredto addTheatredto){
        Theatre theatre=Theatre.builder()
                .theatreName(addTheatredto.getTheatreName())
                .address(addTheatredto.getAddress())
                .city(addTheatredto.getCity())
                .build();
        addtheatreseats(theatre,addTheatredto);
        return "theatre and theatre seats added successfully";

    }
    public void addtheatreseats(Theatre theatre,addTheatredto addTheatredto){
        int premiumSeats=addTheatredto.getNoOfPremiumseats();
        int classicSeats=addTheatredto.getNoOfClassicseats();
        int noOfrows=addTheatredto.getNoOfrows();

        List<TheatreSeat>theatreSeatList=new ArrayList<>();

        int row=0;

        char ch='A';
        for(int i=1;i<=premiumSeats;i++){
            if(i%noOfrows==1){
                row++;
                ch='A';
            }

            String seatno=row+" "+ch;
            ch=(char)(ch+1);

            TheatreSeat theatreSeat=TheatreSeat.builder()
                    .seatNo(seatno)
                    .seatType(SeatType.Premium)
                    .theatre(theatre)
                    .build();

            theatreSeatList.add(theatreSeat);


        }
        ch='A';
        for(int i=1;i<=classicSeats;i++){
            if(i%noOfrows==1){
                row++;
                ch='A';
            }

            String seatno=row+" "+ch;
            ch=(char)(ch+1);

            TheatreSeat theatreSeat=TheatreSeat.builder()
                    .seatNo(seatno)
                    .seatType(SeatType.Classic)
                    .theatre(theatre)
                    .build();

            theatreSeatList.add(theatreSeat);


        }
        theatre.setTheatreSeatList(theatreSeatList);

        theatreRepository.save(theatre);



    }
}
