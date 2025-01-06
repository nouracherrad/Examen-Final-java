package com.example.examfinaljava.controllrs;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class TicketController {

    @FXML
    private TextArea ticketTextArea;

    public void setTicketInfo(String plat, String total) {
        ticketTextArea.setText("=== Ticket ===\nPlat choisi : " + plat + "\n" + total);
    }

    @FXML
    public void closeApp() {
        Stage stage = (Stage) ticketTextArea.getScene().getWindow();
        stage.close();
    }
}
