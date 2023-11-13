package com.example.notificationservice.Services;

import com.example.notificationservice.Entity.NotificationEntity;
import com.example.notificationservice.Repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    public List<NotificationEntity> getNotifications() {
        return notificationRepository.findAll();
    }

    public NotificationEntity getNotificationByType(String type) {
        return notificationRepository.findByType(type);
    }

    public NotificationEntity getNotificationByTitle(String title) {
        return notificationRepository.findByTitle(title);
    }

    public NotificationEntity getNotificationById(String id) {
        return notificationRepository.findBy_id(id);
    }

    public NotificationEntity createNotification(NotificationEntity notificationEntity) {
        return notificationRepository.save(notificationEntity);
    }

    public NotificationEntity updateNotification(NotificationEntity notificationEntity) {
            return notificationRepository.save(notificationEntity);
        }
}
