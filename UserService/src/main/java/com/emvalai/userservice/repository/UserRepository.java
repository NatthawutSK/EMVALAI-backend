package com.emvalai.userservice.repository;

import com.emvalai.userservice.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
    @Query(value="{email:'?0'}")
    public UserEntity findByEmail(String email);

    @Query(value="{_id:'?0'}")
    public UserEntity findByUserId(String _id);

    @Query(value="{role:?0}")
    public List<UserEntity> findByRole(String role);

}
