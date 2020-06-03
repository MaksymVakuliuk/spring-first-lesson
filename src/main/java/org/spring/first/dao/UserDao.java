package org.spring.first.dao;

import java.util.List;
import org.spring.first.model.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
