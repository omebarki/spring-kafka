package omar.mebarki.springkafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(@Payload List<String> messages) throws IOException {
        logger.info("messages size : {}", messages.size());
        for (String message : messages) {
            logger.info(String.format("#### -> Consumed message -> %s", message));
        }
    }
}
