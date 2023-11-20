package com.example.eezu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.eezu.entity.UserTable;


@Repository
public interface UserTableRepository extends MongoRepository<UserTable, String>{

}
