package com.example.notificationservice.Controller;

import com.example.notificationservice.Entity.NotificationEntity;
import com.example.notificationservice.Services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noti")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/getAllNoti")
    public ResponseEntity<?> getNotification() {
        List<NotificationEntity> noti = notificationService.getNotifications();
        return ResponseEntity.ok(noti);
    }

    @GetMapping("/getAllNotiByType/{type}")
    public ResponseEntity<?> getNotificationByType(@PathVariable("type") String type) {
        NotificationEntity noti = notificationService.getNotificationByType(type);
        return ResponseEntity.ok(noti);
    }

    @PostMapping("/createNoti")
    public ResponseEntity<?> createNotification(@RequestBody NotificationEntity notificationEntity) {
        NotificationEntity noti = notificationService.createNotification(new NotificationEntity(null,notificationEntity.getTitle(),notificationEntity.getType(),notificationEntity.getNoti_send_hour(),notificationEntity.getNoti_send_min(),notificationEntity.getNoti_date()));
        return ResponseEntity.ok(noti);
    }

    @PutMapping("/updateNoti")
    public ResponseEntity<?> updateNotification(@RequestBody NotificationEntity notificationEntity, @RequestParam("oldTitle") String oldTitle) {

        NotificationEntity old_noti = notificationService.getNotificationByTitle(oldTitle);
        if (old_noti != null) {
            notificationService.updateNotification(new NotificationEntity(old_noti.get_id(), notificationEntity.getTitle(),notificationEntity.getType(),notificationEntity.getNoti_send_hour(),notificationEntity.getNoti_send_min(),notificationEntity.getNoti_date()));
            return ResponseEntity.ok(old_noti);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notification not found");
        }
    }

}