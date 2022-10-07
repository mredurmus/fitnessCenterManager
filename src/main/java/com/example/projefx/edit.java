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

public class edit extends tableLoader implements Initializable {
    @FXML
    private TextField edit_name;
    @FXML
    private TextField edit_surname;
    @FXML
    private MenuButton edit_membership;
    @FXML
    private DatePicker edit_startDate;
    @FXML
    private DatePicker edit_expDate;
    @FXML
    private Label edit_discount;
    @FXML
    private Label edit_totalPrice;
    @FXML
    private TableView<Fitness> editdata_table;
    @FXML
    private TableColumn<Fitness, Integer> idcol;
    @FXML
    private TableColumn<Fitness,String> namecol;
    @FXML
    private TableColumn<Fitness,String> surnamecol;
    @FXML
    private TableColumn<Fitness,String> membershipcol;
    @FXML
    private TableColumn<Fitness,String> startdatecol;
    @FXML
    private TableColumn<Fitness,String> expirationdatecol;
    @FXML
    private TableColumn<Fitness,Integer> discountcol;
    @FXML
    private TableColumn<Fitness,Integer> totalPricecol;
    @FXML
    private TextField searchField;
    @FXML
    private Label yuzdeLabel;
    ObservableList<Fitness> oblist = FXCollections.observableArrayList();

    double totalPriceSum,discountSum;
    @FXML
    protected void setDiscountPrice(){
        yuzdeLabel.setVisible(true);
        if((edit_expDate.getValue().getMonthValue() - edit_startDate.getValue().getMonthValue()) >= 0 && (edit_expDate.getValue().getMonthValue() - edit_startDate.getValue().getMonthValue()) < 6){
            edit_discount.setText("0");
            discountSum = 0;
            edit_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
        if((edit_expDate.getValue().getMonthValue() - edit_startDate.getValue().getMonthValue()) >= 6 && (edit_expDate.getValue().getMonthValue() - edit_startDate.getValue().getMonthValue()) < 12){
            edit_discount.setText("5");
            discountSum = 5;
            edit_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
        if((edit_expDate.getValue().getMonthValue() - edit_startDate.getValue().getMonthValue()) >= 0 && ((edit_expDate.getValue().getMonthValue() - edit_startDate.getValue().getMonthValue()) < 12) && (edit_expDate.getValue().getYear() - edit_startDate.getValue().getYear()) >= 1 && ((edit_expDate.getValue().getYear() - edit_startDate.getValue().getYear()) < 2)){
            edit_discount.setText("10");
            discountSum = 10;
            edit_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
        if((edit_expDate.getValue().getMonthValue() - edit_startDate.getValue().getMonthValue()) >= 0 && ((edit_expDate.getValue().getMonthValue() - edit_startDate.getValue().getMonthValue()) < 12) && (edit_expDate.getValue().getYear() - edit_startDate.getValue().getYear()) >= 2 && ((edit_expDate.getValue().getYear() - edit_startDate.getValue().getYear()) < 4)){
            edit_discount.setText("15");
            discountSum = 15;
            edit_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
    }
    @FXML
    protected void selectMembershipType(ActionEvent event){
        edit_membership.setText(((MenuItem)event.getSource()).getText());
        if(edit_membership.getText().equals("Fullpack")){
            totalPriceSum = 180;
            edit_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
        if(edit_membership.getText().equals("Dualpack")){
            totalPriceSum = 150;
            edit_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
        if(edit_membership.getText().equals("Swimming")){
            totalPriceSum = 120;
            edit_totalPrice.setText(String.valueOf((totalPriceSum-((discountSum/100)*totalPriceSum))));
        }
    }
    @FXML
    protected void updateSelectedUser(){
        getUpdater(edit_name,edit_surname,edit_membership,edit_startDate,edit_expDate,edit_discount,edit_discount,editdata_table);
        oblist.clear();
        getTableLoader(oblist,editdata_table,idcol,namecol,surnamecol,membershipcol,startdatecol,expirationdatecol,discountcol,totalPricecol);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        getTableLoader(oblist,editdata_table,idcol,namecol,surnamecol,membershipcol,startdatecol,expirationdatecol,discountcol,totalPricecol);
        getSearch(searchField,oblist,editdata_table);
    }
}
