package pl.programowanie.zespolowe;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import pl.programowanie.zespolowe.service.UserService;

public class MainApp extends Application {

    public static final String APP_TITLE = "Aplikacja";

    public MainApp() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        MainStage.setApplicationStage(stage);
        MainStage.getApplicationStage().loadLoginPage();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
