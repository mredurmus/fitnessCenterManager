package com.example.projefx;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tableLoader {
    public void getTableLoader(ObservableList oblist,TableView table,TableColumn idcol,TableColumn namecol,TableColumn surnamecol,TableColumn membershipcol,TableColumn startdatecol,TableColumn expirationdatecol,TableColumn discountcol,TableColumn totalPricecol) {
        try {
            Connection connection = DBConnection.getConnection();
            ResultSet rs = connection.createStatement().executeQuery("select * from fitness");
            while (rs.next()) {
                oblist.add(new Fitness(rs.getInt("id"), rs.getString("name"), rs.getString("surname"),
                        rs.getString("membership"), rs.getString("startDate"), rs.getString("expirationDate"),
                        rs.getInt("discount"), rs.getInt("totalPrice")));
            }
        } catch (SQLException err) {
            System.out.println(err);
        }
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnamecol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        membershipcol.setCellValueFactory(new PropertyValueFactory<>("membership"));
        startdatecol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        expirationdatecol.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
        discountcol.setCellValueFactory(new PropertyValueFactory<>("discount"));
        totalPricecol.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        table.setItems(oblist);
    }
    public void getRemover(Label info_name,Label info_surname,Label info_membership,Label info_startDate,Label info_expDate,Label info_discount,Label info_totalPrice){
        PreparedStatement statement = null;
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "DELETE FROM fitness_club.fitness where name=? and surname=? and membership=? and startDate=? and expirationDate=? and discount=? and totalPrice=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,info_name.getText());
            statement.setString(2,info_surname.getText());
            statement.setString(3,info_membership.getText());
            statement.setString(4,info_startDate.getText());
            statement.setString(5,info_expDate.getText());
            statement.setString(6,info_discount.getText());
            statement.setString(7,info_totalPrice.getText());
            int result = statement.executeUpdate();
        }catch(SQLException err){
            System.out.println(err);
        }
    }
    public void getRegister(TextField register_name, TextField register_surname, MenuButton register_membership,DatePicker register_startDate,DatePicker register_expDate,Label register_discount,Label register_totalPrice){
        PreparedStatement statement = null;
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "insert into fitness (name,surname,membership,startDate,expirationDate,discount,totalPrice) values(?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,register_name.getText());
            statement.setString(2,register_surname.getText());
            statement.setString(3,register_membership.getText());
            statement.setString(4,register_startDate.getValue().toString());
            statement.setString(5,register_expDate.getValue().toString());
            statement.setString(6,register_discount.getText());
            statement.setString(7,register_totalPrice.getText());
            int result = statement.executeUpdate();
        }catch(SQLException err){
            System.out.println(err);
        }
    }
    public void getUpdater(TextField edit_name,TextField edit_surname,MenuButton edit_membership,DatePicker edit_startDate,DatePicker edit_expDate,Label edit_discount,Label edit_totalPrice,TableView<Fitness> editdata_table){
        PreparedStatement statement = null;
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "update fitness_club.fitness set name = ?,surname = ?,membership =?,startDate=?,expirationDate=?,discount=?,totalPrice=? where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,edit_name.getText());
            statement.setString(2,edit_surname.getText());
            statement.setString(3,edit_membership.getText());
            statement.setString(4,edit_startDate.getValue().toString());
            statement.setString(5,edit_expDate.getValue().toString());
            statement.setString(6,edit_discount.getText());
            statement.setString(7,edit_totalPrice.getText());
            statement.setString(8, String.valueOf(editdata_table.getSelectionModel().getSelectedItem().getId()));
            int result = statement.executeUpdate();
        }catch(SQLException err){
            System.out.println(err);
        }
    }
    public void getSearch(TextField searchField,ObservableList oblist,TableView table){
        FilteredList<Fitness> filteredData = new FilteredList<>(oblist, b -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(fitness -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (fitness.getName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;
                } else if (fitness.getSurname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if (String.valueOf(fitness.getMembership()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else
                    return false; // Does not match.
            });
        });
        SortedList<Fitness> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }
}
