package com.ms.user.producer;

import com.ms.user.dtos.EmailDto;
import com.ms.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    private final RabbitTemplate template;

    public UserProducer(RabbitTemplate template) {
        this.template = template;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel model) {
        var emailDto = new EmailDto();
        emailDto.setUserId(model.getId());
        emailDto.setEmailTo(model.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(model.getName() + ", seja bem vindo(a)! \nAgradecemos seu cadstro, aproveite agora todos recursos da nossa plataforma!");

        template.convertAndSend("", routingKey, emailDto);
    }
}
