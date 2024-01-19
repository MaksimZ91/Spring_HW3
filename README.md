## Урок 3. Использование Spring для разработки серверного приложения
Задание: Используя Spring, создайте серверное REST приложение. Добавить функционал в приложение разработанное на семинаре:  
Базовое задание  
1) В класс RegistrationService добавить поля UserService, NotificationService(добавить в IOC контейнер аннотацией @Autowired или через конструктор класса)  
2) Разработать метод processRegistration в котором:  
- создается пользователь из параметров метода  
- созданный пользователь добавляется в репозиторий  
- через notificationService выводится сообщение в консоль  
3) В TaskController добавить обработчики filterUsersByAge()(Подсказка @GetMapping("/filter/{age}")) и calculateAverageAge (Подсказка @GetMapping("/calc"))  
4) В методе filterUsersByAge параметр age получать через аннотацию @PathVariable  
Задание со звездочкой  
1) В классе UserController добавить обработчик userAddFromParam извлекающий данные для создания пользователя из параметров HTTP запроса  
2) Перенести репозиторий проекта с List<User> на базу данных H2
=============================== Проверка работы ====================================  
Для теcтирования проекта использовать программу PostMan:
### Добавление пользователя - запрос :  
метод - POST  
адрес - http://localhost:8080/user/body  
тело ->
```json 
{  
"name":"Artur",  
"age":23,  
"email":"exam1@yandex.ru"
}
```
![body](https://github.com/MaksimZ91/Spring_HW3/assets/72209139/614fdc0d-8bd7-460a-8b4f-378b3cc53f89)
![log](https://github.com/MaksimZ91/Spring_HW3/assets/72209139/8588b7bd-d07f-4794-ab4d-6f2dda00fb1f)

### Получение списка пользователей на сервере - запрос:
метод - GET  
адрес - http://localhost:8080/user  
![users](https://github.com/MaksimZ91/Spring_HW3/assets/72209139/30526e15-7a00-417c-b3d9-0af62fd0ac8f)

### Проверка сортировки - запрос:
метод - GET  
адрес - http://localhost:8080/tasks/sort  
![sort](https://github.com/MaksimZ91/Spring_HW3/assets/72209139/f287f128-9634-41e6-9318-bf322cfe5fd6)

### Проверка фильтрации - запрос:
метод - GET  
адрес - http://localhost:8080/tasks/filter/23  
![filter](https://github.com/MaksimZ91/Spring_HW3/assets/72209139/e347644f-4bb6-47f8-9d61-9695b478f401)

### Проверка среднего арифметического - запрос:
метод - GET  
адрес - http://localhost:8080/tasks/calc  
![calc](https://github.com/MaksimZ91/Spring_HW3/assets/72209139/a1de56e6-a17e-44e3-a774-c7006d17af4e)





