/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.programowanie.zespolowe.service;

import java.util.Base64;
import java.util.List;
import pl.programowanie.zespolowe.AuthUser;
import pl.programowanie.zespolowe.model.User;
import pl.programowanie.zespolowe.dao.UserDAO;

/**
 *
 * @author Cinek
 */
public class UserService {

    private UserDAO userDao;

    public UserService() {
        this.userDao = new UserDAO();
    }

    public void addUser(User user) {
        userDao.openCurrentSessionwithTransaction();
        userDao.save(user);
        userDao.closeCurrentSessionwithTransaction();
    }

    public User findById(int id) {
        userDao.openCurrentSession();
        User user = (User) userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }

    public void login(String login, String password) {
        User user = userDao.findByLoginAndPassword(login, password);
        if (user != null) {
            AuthUser.getInstance().setLoggedUser(user);
        }
    }

    public List<User> listAllUsers() {
        return userDao.findAll();
    }

}
