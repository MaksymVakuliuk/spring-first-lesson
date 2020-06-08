package org.spring.first.controllers;

import java.util.ArrayList;
import java.util.List;
import org.spring.first.dto.UserResponseDto;
import org.spring.first.model.User;
import org.spring.first.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public void inject() {
        var user1 = new User();
        user1.setLogin("login1");
        user1.setPassword("pass1");
        userService.add(user1);

        var user2 = new User();
        user2.setLogin("login2");
        user2.setPassword("pass2");
        userService.add(user2);

        var user3 = new User();
        user3.setLogin("login3");
        user3.setPassword("pass3");
        userService.add(user3);

        var user4 = new User();
        user4.setLogin("login4");
        user4.setPassword("pass4");
        userService.add(user4);
    }

    @GetMapping("/get/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        var user = userService.getUserById(userId);
        var userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        var users = userService.listUsers();
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for (User user : users) {
            var userResponseDto = new UserResponseDto();
            userResponseDto.setId(user.getId());
            userResponseDto.setLogin(user.getLogin());
            userResponseDto.setPassword(user.getPassword());
            userResponseDtoList.add(userResponseDto);
        }
        return userResponseDtoList;
    }
}
