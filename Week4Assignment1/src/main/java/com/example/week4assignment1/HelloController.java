package com.example.week4assignment1;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML TextField txtInput;
    @FXML Label txtOutput;
    @FXML
    protected void onConvertButtonClick(){
        double Euro;
        try {
            Euro = Integer.parseInt(txtInput.getText());
        } catch (Exception e) {throw null; }
        double Dollar = Euro * 1.18;
        txtOutput.setText(String.format("€ %.2f", Dollar));
    }




}