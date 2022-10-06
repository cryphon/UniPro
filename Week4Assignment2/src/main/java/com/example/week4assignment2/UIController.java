package com.example.week4assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UIController {
    @FXML TextField daysRented;
    @FXML TextField kmDriven;
    @FXML CheckBox FuelTankStatus;
    @FXML TextField nLiters;
    @FXML
    Label AmountDue;


    public void onCalculateButtonClick(){
        int rentedDays;
        int drivenKm;
        int liters;
        try{
            rentedDays = Integer.parseInt(daysRented.getText());
            drivenKm = Integer.parseInt(kmDriven.getText());
            liters = Integer.parseInt(nLiters.getText());
        }catch (Exception e){
            System.out.print("one of the values is in incorrect format");
            return;
        }
        //out
        AmountDue.setText(String.valueOf(CalculatePrice(rentedDays, drivenKm, liters)));
    }

    protected double CalculatePrice(int rentedDays, int drivenKm, int liters){
        double total = 0;
        //days
        total += rentedDays * 45;
        //km
        int freeKM = rentedDays * 100;
        if(drivenKm > freeKM)
            total += (drivenKm - freeKM) * 0.25;
        //fuel
        if(FuelTankStatus.isSelected())
            total += liters * 2;
        return  total;
    }
}
