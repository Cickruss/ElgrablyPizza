package com.pizzariaelgrably.pizzariaelgrably;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Bem vindo a pizzaria Elgrably");
    }
}