package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private  UserService userService;

    @Autowired
    private  NotificationService notificationService;

    /**
     * Регистрация нового пользователя.
     * @param user объект нового пользователя.
     */

    public void processRegistration(User user){
        try {
            userService.createUser(user.getName(), user.getAge(), user.getEmail());
        } catch (Exception e){
            notificationService.sendNotification("Registration error");
            e.printStackTrace();

        }
    }

    //Поля UserService, NotificationService

    //Метод processRegistration
}
