package com.pizzariaelgrably.pizzariaelgrably.Controllers;

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

public class ControllerHomeScreen {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button Button1;

    @FXML
    public void SwitchRequestScreen(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Application.class.getResource("RequestScreen.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    }
