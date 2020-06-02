package org.spring.first;

import org.spring.first.config.AppConfig;
import org.spring.first.model.User;
import org.spring.first.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setLogin("login1");
        user.setPassword("pass1");
        userService.add(user);

        User anotherUser = new User();
        anotherUser.setLogin("anotherLogin");
        anotherUser.setPassword("anotherPassword");
        userService.add(anotherUser);

        userService.listUsers()
                .stream()
                .forEach(u -> {
                    System.out.println("id: " + u.getId());
                    System.out.println("Login: " + u.getLogin());
                    System.out.println("Password: " + u.getPassword());
                    System.out.println();
                });

        System.out.println("End.");
    }
}
