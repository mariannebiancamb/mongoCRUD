package com.mongo.crud.repository;

import com.mongo.crud.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findUserDTOByLogin(String login);
}
