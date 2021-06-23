package com.mongo.crud.service;

import com.mongo.crud.DTO.UpdateDTO;
import com.mongo.crud.documents.Address;
import com.mongo.crud.documents.User;
import com.mongo.crud.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User addUser(User userDTO){

        //Address adress = Address.builder().street(userDTO.getAddress().getStreet()).zipcode(userDTO.getAddress().getZipcode()).build();

        //problema para unir com address

        User user = User.builder().login(userDTO.getLogin())
                .password(userDTO.getPassword())

                .build();

        return userRepository.save(userDTO);
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }


    public User updatePassword(UpdateDTO updateDTO){
        User user = userRepository.findUserDTOByLogin(updateDTO.getLogin());
        user.setPassword(updateDTO.getPassword());
        return userRepository.save(user);
    }


    public User deleteUserBylogin(String login){
        User user = userRepository.findUserDTOByLogin(login);
        userRepository.delete(user);
        return user;
    }
}
