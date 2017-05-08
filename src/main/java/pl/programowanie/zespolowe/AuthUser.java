/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.programowanie.zespolowe;

import pl.programowanie.zespolowe.model.User;

public class AuthUser {

    private User user = null;

    private static AuthUser instance = null;

    protected AuthUser() {

    }

    public static AuthUser getInstance() {
        if (instance == null) {
            instance = new AuthUser();
        }
        return instance;
    }

    public void setLoggedUser(User user) {
        this.user = user;
    }

    public User getLoggedUser() {
        return this.user;
    }

}
