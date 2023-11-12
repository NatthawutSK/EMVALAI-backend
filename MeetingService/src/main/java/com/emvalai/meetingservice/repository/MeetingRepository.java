package com.emvalai.meetingservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface MeetingRepository extends MongoRepository<MeetingEntity,String> {
    @Query("{ 'role': ?0}")
    public List<MeetingEntity> findByRole(String role);
}
