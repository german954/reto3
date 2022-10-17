package com.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import com.reto3.reto3.model.Message;
import com.reto3.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessageAll() {
        return messageRepository.getMessageAll();
    }

    public Optional<Message> getMessageId(int messageId) {
        return messageRepository.getMessageId(messageId);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> messageAuxiliar = messageRepository.getMessageId(message.getIdMessage());
            if (messageAuxiliar.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }

    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> messageAuxiliar = messageRepository.getMessageId(message.getIdMessage());
            if (!messageAuxiliar.isEmpty()) {
                if (message.getMessageText() != null) {
                    messageAuxiliar.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(messageAuxiliar.get());
                return messageAuxiliar.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean delete(Integer messageId) {
        boolean flag = false;
        Optional<Message> messageAuxiliar = messageRepository.getMessageId(messageId);
        if (messageAuxiliar.isPresent()) {
            messageRepository.delete(messageAuxiliar.get());
            flag = true;
        }
        return flag;
    }
}

