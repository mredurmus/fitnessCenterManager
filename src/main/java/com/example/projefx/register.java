package com.example.projefx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.Text;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class register extends tableLoader implements Initializable {
    @FXML
    private TextField register_name;
    @FXML
    private TextField register_surname;
    @FXML
    private MenuButton register_membership;
    @FXML
    private DatePicker register_startDate;
    @FXML
    private DatePicker register_expDate;
    @FXML
    private Label register_discount;
    @FXML
    private Label register_totalPrice;
    @FXML
    private Label yuzdeLabel;
    double totalPriceSum,discountSum;
    @FXML
    protected void setDiscountPrice(){
        yuzdeLabel.setVisible(true);
        if((register_expDate.getValue().getMonthValue() - register_startDate.getValue().getMonthValue()) >= 0 && (register_expDate.getValue().getMonthValue() - register_startDate.getValue().getMonthValue()) < 6){
            register_discount.setText("0");
            discountSum = 0;
            register_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
        if((register_expDate.getValue().getMonthValue() - register_startDate.getValue().getMonthValue()) >= 6 && (register_expDate.getValue().getMonthValue() - register_startDate.getValue().getMonthValue()) < 12){
            register_discount.setText("5");
            discountSum = 5;
            register_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
        if((register_expDate.getValue().getMonthValue() - register_startDate.getValue().getMonthValue()) >= 0 && ((register_expDate.getValue().getMonthValue() - register_startDate.getValue().getMonthValue()) < 12) && (register_expDate.getValue().getYear() - register_startDate.getValue().getYear()) >= 1 && ((register_expDate.getValue().getYear() - register_startDate.getValue().getYear()) < 2)){
            register_discount.setText("10");
            discountSum = 10;
            register_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
        if((register_expDate.getValue().getMonthValue() - register_startDate.getValue().getMonthValue()) >= 0 && ((register_expDate.getValue().getMonthValue() - register_startDate.getValue().getMonthValue()) < 12) && (register_expDate.getValue().getYear() - register_startDate.getValue().getYear()) >= 2 && ((register_expDate.getValue().getYear() - register_startDate.getValue().getYear()) < 4)){
            register_discount.setText("15");
            discountSum = 15;
            register_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
    }
    @FXML
    protected void selectMembershipType(ActionEvent event){
        register_membership.setText(((MenuItem)event.getSource()).getText());
        if(register_membership.getText().equals("Fullpack")){
            totalPriceSum = 180;
            register_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
        if(register_membership.getText().equals("Dualpack")){
            totalPriceSum = 150;
            register_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
        if(register_membership.getText().equals("Swimming")){
            totalPriceSum = 120;
            register_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
    }
    @FXML
    protected void registerUser(){
        getRegister(register_name,register_surname,register_membership,register_startDate,register_expDate,register_discount,register_totalPrice);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
