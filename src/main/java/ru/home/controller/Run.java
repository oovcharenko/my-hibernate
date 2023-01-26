package ru.home.controller;
import ru.home.entity.Type;
import ru.home.entity.User;
import ru.home.service.Service;

public class Run {
    public static void main(String[] args) {
        User user = new Service().createUser("Вася", Type.ADMIN);
    }
}
