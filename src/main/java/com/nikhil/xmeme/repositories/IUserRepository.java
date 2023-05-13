package com.nikhil.xmeme.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nikhil.xmeme.entities.User;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {

}
