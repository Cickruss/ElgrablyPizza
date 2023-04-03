package com.pizzariaelgrably.pizzariaelgrably.Controllers;

import com.pizzariaelgrably.pizzariaelgrably.Application;
import com.pizzariaelgrably.pizzariaelgrably.Requests;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ControllerMain implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Alert alert;
    @FXML
    private Button ButtonRequestToHome;
    @FXML
    private Spinner<Integer> spinnerAmount;

    @FXML
    private ChoiceBox<String> choiceBoxFlavor;

    @FXML
    private ChoiceBox<String> choiceBoxSize;

    @FXML
    private TextField inputClientAddress;

    //private DialogPane dialogPane;

    @FXML
    private TextField inputClientName;
    private String clientName;
    private String clientAddress;
    private String flavor;
    private String size;
    private int amount = 0;
    private final String[] flavors = {"Margerita", "Frango com catupiri", "Bacon", "Mista"};
    private final String[] sizes = {"Pequena", "Media", "Grande", "Familia"};
    private final String[] amounts = {"1","2","3","4","5"};
    private Deque<String> requestsDeque = new LinkedList<>();
    @FXML
    ListView<String> listViewRequests;
    private ObservableList<String> requestsObservableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxFlavor.getItems().addAll(flavors);
        choiceBoxSize.getItems().addAll(sizes);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,5);
        valueFactory.setValue(1);
        spinnerAmount.setValueFactory(valueFactory);

        System.out.println("Obsevable List: \n" + requestsObservableList);
        System.out.println("Deque List: \n" + requestsDeque);
    }

    public void invateRequest(ActionEvent event) throws IOException {
        getClientName(event);
        getClientAddress(event);
        getFlavor(event);
        getSize(event);
        getAmount(event);

        if(clientName.length() < 2){
            showAlertClientNameInvalid(event);
        }else if (clientAddress.length() < 5){
            showAlertClientAddressInvalid(event);
        }else if (flavor == null){
            showAlertFlavorInvalid(event);
        }else if (size == null){
            showAlertSizeInvalid(event);
        }else {
            Requests request = new Requests(clientName, clientAddress, flavor, size, amount);
            requestsDeque.addLast(
                    "Nome: "+ request.getClientName() + " | " +
                    "Endereço: " + request.getAddress() + " | " +
                    "Sabor: " + request.getFlavor() + " | " +
                    "Tamanho: " + request.getSize() + " | " +
                    "Quantidade: " + request.getSize());
            System.out.println(requestsDeque.toString());
            showAlertRequestSuccess(event);
            requestsObservableList = FXCollections.observableArrayList(requestsDeque);
            listViewRequests.setItems(requestsObservableList);
        }
    }
    public void invateRequestUrgency(ActionEvent event) throws IOException {

        getClientName(event);
        getClientAddress(event);
        getFlavor(event);
        getSize(event);
        getAmount(event);

        if(clientName.length() < 2){
            showAlertClientNameInvalid(event);
        }else if (clientAddress.length() < 5){
            showAlertClientAddressInvalid(event);
        }else if (flavor == null){
            showAlertFlavorInvalid(event);
        }else if (size == null){
            showAlertSizeInvalid(event);
        }else {
            Requests request = new Requests(clientName, clientAddress, flavor, size, amount);
            requestsDeque.addFirst(
                    "Nome: "+ request.getClientName() + " | " +
                            "Endereço: " + request.getAddress() + " | " +
                            "Sabor: " + request.getFlavor() + " | " +
                            "Tamanho: " + request.getSize() + " | " +
                            "Quantidade: " + request.getSize());
            System.out.println(requestsDeque.toString());
            showAlertRequestUrgencySuccess(event);
            requestsObservableList = FXCollections.observableArrayList(requestsDeque);
            listViewRequests.setItems(requestsObservableList);
        }
    }
    public void completeOrder(ActionEvent event){
        requestsDeque.removeFirst();
        System.out.println("Pedidos concluido - Primeiro Removido");
        showAlertCompleteRequest(event);
        requestsObservableList = FXCollections.observableArrayList(requestsDeque);
        listViewRequests.setItems(requestsObservableList);
    }
    public void removeLastOrder(ActionEvent event){
        requestsDeque.removeLast();
        System.out.println("Pedidos concluido - Primeiro Removido");
        showAlertCompleteRequest(event);
        requestsObservableList = FXCollections.observableArrayList(requestsDeque);
        listViewRequests.setItems(requestsObservableList);
    }
    private void getClientName(ActionEvent event){clientName = inputClientName.getText();inputClientName.clear();}
    private void getClientAddress(ActionEvent event){clientAddress = inputClientAddress.getText();inputClientAddress.clear();}
    private void getFlavor(ActionEvent event){flavor = choiceBoxFlavor.getValue();choiceBoxFlavor.valueProperty().set(null);}
    private void getSize(ActionEvent event){size = choiceBoxSize.getValue();choiceBoxSize.valueProperty().set(null);}
    private void getAmount(ActionEvent event){amount = spinnerAmount.getValue();spinnerAmount.getValueFactory().setValue(1);}
    private void showAlertRequestSuccess(ActionEvent event){
        alert = new Alert(Alert.AlertType.INFORMATION, "Alert", ButtonType.CLOSE);
        alert.setResizable(false);
        alert.setTitle("Status pedido");
        alert.setHeaderText("PEDIDO CONFIRMADO");
        alert.setContentText("Você pode observar seu pedido em andamento no menu de gerenciamento ao lado");
        alert.showAndWait();
    }
    public void showAlertRequestUrgencySuccess(ActionEvent event){
        alert = new Alert(Alert.AlertType.INFORMATION, "Alert", ButtonType.CLOSE);
        alert.setResizable(false);
        alert.setTitle("Status pedido");
        alert.setHeaderText("PEDIDO COM URGENCIA URGENCIA CONFIRMADO");
        alert.setContentText("Você pode observar seu pedido em andamento no menu de gerenciamento ao lado");
        alert.showAndWait();
    }
    public void showAlertCompleteRequest(ActionEvent event){
        alert = new Alert(Alert.AlertType.INFORMATION, "Alert", ButtonType.CLOSE);
        alert.setResizable(false);
        alert.setTitle("Status pedido");
        alert.setHeaderText("PEDIDO CONCLUIDO");
        alert.setContentText("Bom trabalho!");
        alert.showAndWait();
    }
    private void showAlertClientNameInvalid(ActionEvent event){
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ops! Você esqueceu algo..");
        alert.setResizable(false);
        alert.setHeaderText("Campo de Nome inválido");
        alert.setContentText("O campo de nome deve conter mais de 3 caracteres.");
        alert.showAndWait();
    }
    private void showAlertClientAddressInvalid(ActionEvent event){
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ops! Você esqueceu algo..");
        alert.setResizable(false);
        alert.setHeaderText("Campo de Endereço inválido.");
        alert.setContentText("O campo de nome deve conter mais de 5 caracteres.");
        alert.showAndWait();
    }
    private void showAlertFlavorInvalid(ActionEvent event){
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ops! Você esqueceu algo..");
        alert.setResizable(false);
        alert.setHeaderText("Você deve escolher um sabor para sua pizza!");
        alert.setContentText("Escolha na caixa de seleção SABOR qual o sabor da(s) pizza(s).");
        alert.showAndWait();
    }
    private void showAlertSizeInvalid(ActionEvent event){
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ops! Você esqueceu algo..");
        alert.setResizable(false);
        alert.setHeaderText("Não se esqueça de escolher qual tamanho da(s) sua(s) pizza(s)!");
        alert.setContentText("Escolha na caixa de seleção TAMANHO qual o tamanho da pizza que você quer.");
        alert.showAndWait();
    }
    @FXML
    void ReturnHomeScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Application.class.getResource("HomeScreen.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
