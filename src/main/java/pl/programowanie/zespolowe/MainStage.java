/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.programowanie.zespolowe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static pl.programowanie.zespolowe.MainApp.APP_TITLE;

public class MainStage {

    private static Stage appStage;

    private static MainStage mainStage;

    private static final String STYLE_PATH = "/styles/Styles.css";

    private MainStage() {

    }

    public static MainStage getApplicationStage() {
        return mainStage;
    }

    public static void setApplicationStage(Stage stage) {
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.exit(0);
            }
        });
        stage.setTitle(APP_TITLE);
        appStage = stage;
        mainStage = new MainStage();
    }

    public void loadView(String view) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(view));
            Scene scene = new Scene(root);
            appStage.setScene(scene);
            scene.getStylesheets().add(STYLE_PATH);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Stage getStage() {
        return appStage;
    }

    public void loadLoginPage() {
        loadView(ViewNames.LOGIN_PAGE);
    }

    public void loadAdminUsersPage() {
        loadView(ViewNames.ADMIN_USERS_VIEW);
    }

    public void loadUserMainView() {
        loadView(ViewNames.USER_MAIN_VIEW);
    }
}
