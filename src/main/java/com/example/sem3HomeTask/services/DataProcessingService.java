package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    /**
     * Поправил сигнатуры методов, убрал из параметров List<User> users.
     */


    @Autowired
    private UserRepository repository;


    /**
     * Получение всех пользователей.
     * @return список всех пользователей.
     */
    public List<User> getUsers(){
        return repository.getUsers();
    }

    /**
     * Сортировка пользователей по возрасту (ASC).
     * @return список пользователей.
     */
    public List<User> sortUsersByAge() {
        List<User> users = getUsers();
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Фильтр пользователей по возрасту.
     * @param age параметр для фильтрации.
     * @return возвращает список пользователей > age.
     */
    public List<User> filterUsersByAge(int age) {
        List<User> users = getUsers();
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Метод определения среднего возраста всех пользователей.
     * @return double
     **/
    public double calculateAverageAge() {
        List<User> users = getUsers();
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }


}
