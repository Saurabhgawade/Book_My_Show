package com.Accio.BookMyShowProject.Services;

import com.Accio.BookMyShowProject.Models.User;
import com.Accio.BookMyShowProject.Repositories.UserRepository;
import com.Accio.BookMyShowProject.Transformer.UserTransformer;
import com.Accio.BookMyShowProject.dtos.addUserdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String adduser(addUserdto addUserdto){
        User user= UserTransformer.adduserdtoTouser(addUserdto);

        userRepository.save(user);

        return "User added in userRepositorySuccessfully";
    }
}
