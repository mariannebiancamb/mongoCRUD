package com.mongo.crud.repository;

import com.mongo.crud.documents.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
