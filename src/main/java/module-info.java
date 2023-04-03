module com.pizzariaelgrably.pizzariaelgrably {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pizzariaelgrably.pizzariaelgrably to javafx.fxml;
    exports com.pizzariaelgrably.pizzariaelgrably;
    exports com.pizzariaelgrably.pizzariaelgrably.Controllers;
    opens com.pizzariaelgrably.pizzariaelgrably.Controllers to javafx.fxml;
}