module com.example.examfinaljava {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;


    opens com.example.examfinaljava to javafx.fxml;
    exports com.example.examfinaljava;
    exports com.example.examfinaljava.application;
    opens com.example.examfinaljava.controllers to javafx.fxml;
}