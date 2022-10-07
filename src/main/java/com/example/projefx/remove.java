package com.example.projefx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

public class remove extends tableLoader implements Initializable {
    @FXML
    private Label info_name;
    @FXML
    private Label info_surname;
    @FXML
    private Label info_membership;
    @FXML
    private Label info_startDate;
    @FXML
    private Label info_expDate;
    @FXML
    private Label info_discount;
    @FXML
    private Label info_totalPrice;
    @FXML
    private TableView<Fitness> removedata_table;
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
    ObservableList<Fitness> oblist = FXCollections.observableArrayList();

    @FXML
    protected void deleteSelectedUser(){
        getRemover(info_name,info_surname,info_membership,info_startDate,info_expDate,info_discount,info_totalPrice);
        oblist.clear();
        getTableLoader(oblist,removedata_table,idcol,namecol,surnamecol,membershipcol,startdatecol,expirationdatecol,discountcol,totalPricecol);
    }

    @FXML
    protected void showinfo(){
        info_name.setText(removedata_table.getSelectionModel().getSelectedItem().getName());
        info_surname.setText(removedata_table.getSelectionModel().getSelectedItem().getSurname());
        info_membership.setText(removedata_table.getSelectionModel().getSelectedItem().getMembership());
        info_startDate.setText(removedata_table.getSelectionModel().getSelectedItem().getStartDate());
        info_expDate.setText(removedata_table.getSelectionModel().getSelectedItem().getExpirationDate());
        info_discount.setText(String.valueOf(removedata_table.getSelectionModel().getSelectedItem().getDiscount()));
        info_totalPrice.setText(String.valueOf(removedata_table.getSelectionModel().getSelectedItem().getTotalPrice()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        getTableLoader(oblist,removedata_table,idcol,namecol,surnamecol,membershipcol,startdatecol,expirationdatecol,discountcol,totalPricecol);
        getSearch(searchField,oblist,removedata_table);
    }
}
