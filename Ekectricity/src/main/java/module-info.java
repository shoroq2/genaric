module com.example.ekectricity {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.ekectricity to javafx.fxml;
    exports com.example.ekectricity;
}