package com.daniel.estudos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.daniel.estudos.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
