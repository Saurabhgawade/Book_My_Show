package com.Accio.BookMyShowProject.Controller;

import com.Accio.BookMyShowProject.Services.UserService;
import com.Accio.BookMyShowProject.dtos.addUserdto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity adduser(@RequestBody addUserdto addUserdto){
        String response=userService.adduser(addUserdto);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
