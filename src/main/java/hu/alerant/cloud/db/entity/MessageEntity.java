package hu.alerant.cloud.db.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
@Getter
public class MessageEntity {

    public MessageEntity() {
    }

    public MessageEntity(String message, LocalDateTime dateTime) {
        this.message = message;
        this.dateTime = dateTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_sequence")
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

}
