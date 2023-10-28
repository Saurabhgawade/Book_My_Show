package com.Accio.BookMyShowProject.Transformer;

import com.Accio.BookMyShowProject.Models.User;
import com.Accio.BookMyShowProject.dtos.addUserdto;

public class UserTransformer {
    public static User adduserdtoTouser(addUserdto addUserdto){
        User user=User.builder()
                .userName(addUserdto.getUserName())
                .age(addUserdto.getAge())
                .emailId(addUserdto.getEmailId())
                .mobNo(addUserdto.getMobNo())
                .build();
        return user;
    }
}
