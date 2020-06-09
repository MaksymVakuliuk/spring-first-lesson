package org.spring.first.service.impl;

import java.util.List;
import org.spring.first.dao.UserDao;
import org.spring.first.model.User;
import org.spring.first.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
