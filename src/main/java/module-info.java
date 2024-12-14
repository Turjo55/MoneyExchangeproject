module com.example.group57moneyexchangeproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.group57moneyexchangeproject to javafx.fxml;
    exports com.example.group57moneyexchangeproject;
}