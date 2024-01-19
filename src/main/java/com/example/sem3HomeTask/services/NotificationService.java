package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    /**
     * Уведомление о регистрации нового пользователя.
     * @param user объект нового пользователя.
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    /**
     * Уведомление в лог сервера.
     * @param s текс уведомления.
     */
    public void sendNotification(String s) {
        System.out.println(s);
    }
}
