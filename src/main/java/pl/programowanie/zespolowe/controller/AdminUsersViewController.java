/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.programowanie.zespolowe.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pl.programowanie.zespolowe.MainStage;
import pl.programowanie.zespolowe.ViewNames;
import pl.programowanie.zespolowe.model.User;
import pl.programowanie.zespolowe.service.UserService;

public class AdminUsersViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<User, String> firstNameColumn;

    @FXML
    private TableColumn<User, String> lastNameColumn;

    @FXML
    private TableColumn<User, String> loginColumn;

    @FXML
    private TableColumn<User, String> roleColumn;

    @FXML
    public TableView<User> usersTable;

    private UserService userService;

    public AdminUsersViewController() {
        this.userService = new UserService();
    }

    @FXML
    void initialize() {
        loadUserList();
        firstNameColumn.setCellValueFactory(
                new PropertyValueFactory<User, String>("imie")
        );
        lastNameColumn.setCellValueFactory(
                new PropertyValueFactory<User, String>("nazwisko")
        );
        loginColumn.setCellValueFactory(
                new PropertyValueFactory<User, String>("login")
        );
        roleColumn.setCellValueFactory(
                new PropertyValueFactory<User, String>("userRole")
        );
        roleColumn.setCellFactory(column -> {
                return new TableCell<User, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                            setStyle("");
                        } else {
                            setText(item.equals(User.ADMIN_ROLE) ? "Admin" : "Nauczyciel");
                        }
                    }
                };
            });
    }

    public void loadUserList() {
        List<User> users = userService.listAllUsers();
        usersTable.setItems(FXCollections.observableArrayList(users));
    }

    @FXML
    void addUser2(ActionEvent event) {
        MainStage.getApplicationStage().loadView(ViewNames.USER_FORM_VIEW);
    }

}
