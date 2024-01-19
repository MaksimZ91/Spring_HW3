package com.example.sem3HomeTask.domain;

import java.util.Objects;

public class User {

    private int id;
    private String name;
    private int age;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.getAge() && Objects.equals(name, user.getName()) && Objects.equals(email, user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email);
    }
}
