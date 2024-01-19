package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.RegistrationService;
import com.example.sem3HomeTask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {

    @Autowired
    private RegistrationService service;

    /**
     * Получение всех пользователей.
     * @return список пользователей.
     */
    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getUsers(); }

    /**
     * Регистрация нового пользователя.
     * @param user объект пользователя состоит из:
     *             String name;
     *             int age;
     *             String email;
     * @return строку об успешной/не спешной регистрации.
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)    {
        service.processRegistration(user);
        return "User added from body!";
    }
}
