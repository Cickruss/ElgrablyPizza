module com.pizzariaelgrably.pizzariaelgrably {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pizzariaelgrably.pizzariaelgrably to javafx.fxml;
    exports com.pizzariaelgrably.pizzariaelgrably;
    exports com.pizzariaelgrably.pizzariaelgrably.HomeScreen;
    opens com.pizzariaelgrably.pizzariaelgrably.HomeScreen to javafx.fxml;
}