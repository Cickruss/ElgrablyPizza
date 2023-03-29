package com.pizzariaelgrably.pizzariaelgrably.HomeScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerHomeScreen {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Bem vindo a pizzaria Elgrably");
    }
}