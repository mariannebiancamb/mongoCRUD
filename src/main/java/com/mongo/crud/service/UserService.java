package com.mongo.crud.service;

import com.mongo.crud.DTO.UpdateDTO;
import com.mongo.crud.DTO.UserDTO;
import com.mongo.crud.documents.Address;
import com.mongo.crud.documents.User;
import com.mongo.crud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User addUser(UserDTO userDTO){

        List<Address> addresses = new ArrayList<>();
        addresses.add(Address.builder().street(userDTO.getAddress().get(0).getStreet()).zipcode(userDTO.getAddress().get(0).getZipcode()).build());

        //problema para unir com address

        User user = User.builder().login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .build();

        return userRepository.save(user);
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
