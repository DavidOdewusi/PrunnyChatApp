package com.prunny.chatapp.service;

import com.prunny.chatapp.model.Message;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    void saveMessage(Message message);

}
