package com.ms.email.consumer;

import com.ms.email.dtos.EmailRecordDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailConsumer {
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDto dto) {
        log.info(dto.emailTo());
    }
}
