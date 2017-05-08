package pl.programowanie.zespolowe.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.programowanie.zespolowe.MainStage;
import pl.programowanie.zespolowe.dao.UserDAO;
import pl.programowanie.zespolowe.model.User;

public class UserFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField loginNameField;

    @FXML
    private PasswordField passwordField;
    private UserDAO userDao;
    private Stage stage;

    
    public UserFormController() {
        this.stage = stage;
        userDao = new UserDAO();
    }

    @FXML
    void addUser(ActionEvent event) {
        User user = new User();
        user.setImie(firstNameField.getText());
        user.setNazwisko(lastNameField.getText());
        user.setPassword(passwordField.getText());
        user.setLogin(loginNameField.getText());
        user.setUserRole(User.ADMIN_ROLE);
        userDao.save(user);
        MainStage.getApplicationStage().loadAdminUsersPage();
    }

    @FXML
    void initialize() {

    }

    @FXML
    void init() {

    }
}
