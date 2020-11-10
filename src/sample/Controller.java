package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {

    @FXML
    private Button bFatButton;

    @FXML
    void initialize() {
        bFatButton.setOnAction(event -> {
            bFatButton.getScene().getWindow().hide();
            changeScreen("fxml/fatCalculator.fxml");

        });
    }

    void changeScreen(String url) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(url));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("sample/assets/icon.png"));
        stage.setTitle("CHECK YOUR HEALTH & FITNESS CONDITION");
        stage.showAndWait();
    }

}


