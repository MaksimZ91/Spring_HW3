package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private NotificationService notificationService;
    @Autowired
    private UserRepository userRepository;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Создание ползователя и запись его в бд.
     * @param name имя пользователя.
     * @param age возраст пользователя.
     * @param email почта пользователя
     * @return объект нового пользователя.
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        userRepository.saveUser(user);
        notificationService.notifyUser(user);
        return user;
    }
}
