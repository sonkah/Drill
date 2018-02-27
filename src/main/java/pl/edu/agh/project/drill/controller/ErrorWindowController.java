package pl.edu.agh.project.drill.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrorWindowController implements Initializable {

    @FXML
    public Label messageError;

    public void setText(String mes) {
        messageError.setText(mes);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
