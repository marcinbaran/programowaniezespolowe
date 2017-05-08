/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.programowanie.zespolowe.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.programowanie.zespolowe.model.User;

public class UserDAO extends HibernateDAO<User, Integer> {

    public User findByLoginAndPassword(String login, String password) {
        openCurrentSession();
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        criteria.add(Restrictions.eq("password", password));
        User user = (User) criteria.uniqueResult();
        closeCurrentSession();
        return user;
    }

    public List<User> findAll() {
        openCurrentSession();
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        List<User> users = (List<User>) criteria.list();
        closeCurrentSession();
        return users;
    }
}
