module com.pizzariaelgrably.pizzariaelgrably {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pizzariaelgrably.pizzariaelgrably to javafx.fxml;
    exports com.pizzariaelgrably.pizzariaelgrably;
}