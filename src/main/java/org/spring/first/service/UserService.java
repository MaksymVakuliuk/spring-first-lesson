package org.spring.first.service;

import java.util.List;
import org.spring.first.model.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getUserById(Long id);
}
