package hu.alerant.cloud.service;

import hu.alerant.cloud.db.entity.MessageEntity;
import hu.alerant.cloud.db.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public void createNewMessage(String message) {
        log.info("Creating new message in database with message: {}", message);
        var newEntity = new MessageEntity(message, LocalDateTime.now());
        repository.save(newEntity);
    }

    public List<String> getRecentMessages() {
        log.info("Getting recent messages from database");
        return repository.findFirst5ByOrderByDateTimeDesc().stream().map(MessageEntity::getMessage).toList();
    }
}
