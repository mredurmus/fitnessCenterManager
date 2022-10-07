package com.example.projefx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class listviewController extends tableLoader implements Initializable{
    @FXML
    private TableView<Fitness> dataTable;
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
    protected void onRegisterButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("register-view.fxml"));
        Stage stage1 = new Stage();
        Scene scene1 = new Scene(root);
        JMetro jMetro = new JMetro(Style.DARK);
        jMetro.setScene(scene1);
        stage1.setTitle("Register Panel");
        stage1.setScene(scene1);
        stage1.show();
    }
    @FXML
    protected void onRemoveButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("remove-view.fxml"));
        Stage stage1 = new Stage();
        Scene scene1 = new Scene(root);
        JMetro jMetro = new JMetro(Style.DARK);
        jMetro.setScene(scene1);
        stage1.setTitle("Remove Panel");
        stage1.setScene(scene1);
        stage1.show();
    }
    @FXML
    protected void onEditButtonClick(ActionEvent event) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("edit-view.fxml"));
        Stage stage1 = new Stage();
        Scene scene1 = new Scene(root);
        JMetro jMetro = new JMetro(Style.DARK);
        jMetro.setScene(scene1);
        stage1.setTitle("Edit Panel");
        stage1.setScene(scene1);
        stage1.show();
    }

    @FXML
    protected void onRefreshButtonClick(ActionEvent event) throws IOException {
        oblist.clear();
        getTableLoader(oblist,dataTable,idcol,namecol,surnamecol,membershipcol,startdatecol,expirationdatecol,discountcol,totalPricecol);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getTableLoader(oblist,dataTable,idcol,namecol,surnamecol,membershipcol,startdatecol,expirationdatecol,discountcol,totalPricecol);
        getSearch(searchField,oblist,dataTable);
    }
}