package pl.programowanie.zespolowe.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.programowanie.zespolowe.AuthUser;
import pl.programowanie.zespolowe.MainStage;
import pl.programowanie.zespolowe.ValidationUtils;
import pl.programowanie.zespolowe.service.UserService;
import pl.programowanie.zespolowe.model.User;

public class LoginController implements Initializable {

    @FXML
    private Label loginValidationLabel;
    @FXML
    private Label passwordValidationLabel;

    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;
    private UserService userService;
    @FXML
    private Button loginButton;
    @FXML
    private ImageView loaderImage;

    public LoginController() {
        this.userService = new UserService();
    }

    @FXML
    public void login(ActionEvent event) {
        if (validateLoginForm()) {
            User user = AuthUser.getInstance().getLoggedUser();
            if (User.ADMIN_ROLE.equals(user.getUserRole())) {
                MainStage.getApplicationStage().loadAdminUsersPage();
            } else if (User.USER_ROLE.equals(user.getUserRole())) {
                MainStage.getApplicationStage().loadUserMainView();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public boolean validateLoginForm() {
        boolean valid = true;
        if (!ValidationUtils.validateEmptyTextField(loginField, loginValidationLabel)) {
            valid = false;
        }
        if (!ValidationUtils.validateEmptyTextField(passwordField, passwordValidationLabel)) {
            valid = false;
        }
        if (valid) {
            userService.login(loginField.getText(), passwordField.getText());
            if (AuthUser.getInstance().getLoggedUser() == null) {
                valid = false;
                passwordValidationLabel.setText("Niepoprawne dane logowania");
            }
        }
        return valid;
    }

}
