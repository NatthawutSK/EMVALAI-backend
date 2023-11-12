package com.example.notificationservice.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.lang.annotation.Documented;

@Document("Notification")
@Data
public class NotificationEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -1913081408101653820L;

    @Id
    private String _id;

    private String title;
    private String type;
    private Integer noti_send_hour;
    private Integer noti_send_min;
    private String noti_date;

    public NotificationEntity() {}
    public NotificationEntity(String notiId, String title, String type, Integer noti_send_hour, Integer noti_send_min, String noti_date) {
        this._id = notiId;
        this.title = title;
        this.type = type;
        this.noti_send_hour = noti_send_hour;
        this.noti_send_min = noti_send_min;
        this.noti_date = noti_date;
    }
}
