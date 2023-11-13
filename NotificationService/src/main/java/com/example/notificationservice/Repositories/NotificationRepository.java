package com.example.notificationservice.Repositories;

import com.example.notificationservice.Entity.NotificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationRepository extends MongoRepository<NotificationEntity, String> {

    @Query(value="{type: '?0'}")
    public NotificationEntity findByType(String type);

    @Query(value="{title: '?0'}")
    public NotificationEntity findByTitle(String title);

    @Query(value="{_id: '?0'}")
    public NotificationEntity findBy_id(String id);
}
