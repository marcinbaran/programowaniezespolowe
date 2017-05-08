/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.programowanie.zespolowe.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pl.programowanie.zespolowe.AuthUser;
import pl.programowanie.zespolowe.MainStage;
import pl.programowanie.zespolowe.model.User;

/**
 *
 * @author Cinek
 */
public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label loginAsLabel;

    @FXML
    void initialize() {
        User user = AuthUser.getInstance().getLoggedUser();
        loginAsLabel.setText("Zalogowano jako: " + user.getNazwisko() + " " + user.getImie() + " (" + user.getLogin() + ")");
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void logout(ActionEvent event) {
        AuthUser.getInstance().setLoggedUser(null);
        MainStage.getApplicationStage().loadLoginPage();
    }
}
