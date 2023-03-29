package com.pizzariaelgrably.pizzariaelgrably;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("HomeScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        Requests request = new Requests("", "", "", ' ', 0);
        Deque<Requests> requestList = new LinkedList<>();
        requestList.add(new Requests("Isadora Lacerda", "Cenoura ", "Toca do Coelho", 'P', 1));
        requestList.add(new Requests("Bruna Melido", "Mista :p", "em baixo da ponte", 'M', 1));
        requestList.add(new Requests("Ícaro Macedo", "Bacon", "onde a felicidade está", 'G', 5));
        System.out.println(requestList);

    }
}