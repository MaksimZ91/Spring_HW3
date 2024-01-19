package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;

    /**
     * Метод предоставляющий список команд.
     * @return список команд.
     */
    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Сортировка пользователей по возрасту (ASC).
     * @return список пользователей.
     */
    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge();
    }

    /**
     * Фильтр пользователей по возрасту.
     * @param age параметр для фильтрации.
     * @return возвращает список пользователей > age.
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return service.filterUsersByAge(age);
    }

    /**
     * Метод определения среднего возраста всех пользователей.
     * @return double
     * */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        return service.calculateAverageAge();
    }

}
