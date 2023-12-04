package com.Accio.BookMyShowProject.Controller;

import com.Accio.BookMyShowProject.Services.ShowService;
import com.Accio.BookMyShowProject.dtos.addshowdto;
import com.Accio.BookMyShowProject.dtos.addshowseatsdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    private ShowService showService;

    @PostMapping("/addshow")
    public ResponseEntity addshow(addshowdto addshowdto){
        String response=showService.addshow(addshowdto);
        return new ResponseEntity(response, HttpStatus.OK);

    }
    @PostMapping("/addahowseats")
    public ResponseEntity addshowseats(addshowseatsdto addshowseatsdto){
        String response=showService.addshowseats(addshowseatsdto);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
