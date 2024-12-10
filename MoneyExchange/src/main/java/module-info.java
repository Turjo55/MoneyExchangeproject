module com.example.moneyexchange {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.moneyexchange to javafx.fxml;
    exports com.example.moneyexchange;
}