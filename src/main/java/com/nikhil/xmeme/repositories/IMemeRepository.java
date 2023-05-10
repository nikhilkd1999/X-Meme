package com.nikhil.xmeme.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nikhil.xmeme.entities.Meme;

@Repository
public interface IMemeRepository extends MongoRepository<Meme, String> {

}
