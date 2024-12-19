module org.example.chatserver {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.chatserver to javafx.fxml;
    exports org.example.chatserver;
    exports org.example.chatserver.controller;
    opens org.example.chatserver.controller to javafx.fxml;
}