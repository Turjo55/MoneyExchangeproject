module com.example.oopmoneyexchangeproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oopmoneyexchangeproject to javafx.fxml;
    exports com.example.oopmoneyexchangeproject;
}