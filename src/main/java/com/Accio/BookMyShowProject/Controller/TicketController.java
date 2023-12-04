package com.Accio.BookMyShowProject.Controller;

import com.Accio.BookMyShowProject.Services.TicketService;
import com.Accio.BookMyShowProject.dtos.BookTicketdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/addticket")
    public String addticket(@RequestBody BookTicketdto bookTicketdto){
        String response=ticketService.bookticket(bookTicketdto);
        return response;
    }
}
