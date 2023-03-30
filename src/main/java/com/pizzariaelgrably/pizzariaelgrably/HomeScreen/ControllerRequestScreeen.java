package com.pizzariaelgrably.pizzariaelgrably.HomeScreen;

import com.pizzariaelgrably.pizzariaelgrably.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class ControllerRequestScreeen {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button ButtonRequestToHome;

    @FXML
    void ButtonInvateRequest(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Application.class.getResource("HomeScreen.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
