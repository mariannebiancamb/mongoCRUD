package com.mongo.crud.service;

import com.mongo.crud.DTO.UpdateDTO;
import com.mongo.crud.documents.User;
import com.mongo.crud.repository.AddressRepository;
import com.mongo.crud.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public User addUser(User user){
        addressRepository.save(user.getAddress());
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
