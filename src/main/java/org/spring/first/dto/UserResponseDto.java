package org.spring.first.dto;

import org.spring.first.model.User;

public class UserResponseDto {
    private Long id;
    private String login;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
