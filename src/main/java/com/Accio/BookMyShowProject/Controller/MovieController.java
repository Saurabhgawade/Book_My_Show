package com.Accio.BookMyShowProject.Controller;

import com.Accio.BookMyShowProject.Services.MovieService;
import com.Accio.BookMyShowProject.dtos.addmoviedto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/addmovie")
    public ResponseEntity addMovie(@RequestBody addmoviedto addmoviedto){
        try {
            String response = movieService.addMovie(addmoviedto);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
