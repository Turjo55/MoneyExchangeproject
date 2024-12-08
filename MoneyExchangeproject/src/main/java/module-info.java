module com.oop.example.moneyexchangeproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.example.moneyexchangeproject to javafx.fxml;
    exports com.oop.example.moneyexchangeproject;
}