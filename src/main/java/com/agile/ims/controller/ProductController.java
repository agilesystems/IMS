/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.controller;

import com.agile.ims.entity.Product;
import com.agile.ims.helper.Helper;
import com.jfoenix.controls.JFXButton;
import java.awt.Dialog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

/**
 * FXML Controller class
 *
 * @author ramy
 */
public class ProductController implements Initializable {

    @FXML
    private TableView<Product> productsTable;
    @FXML
    private TextField searchTextFiled;
    ObservableList<Product> pList;
    @FXML
    private JFXButton addBtn;
    @FXML
    private JFXButton editBtn;
    @FXML
    private JFXButton deleteBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pList = FXCollections.observableArrayList(
                new Product(1, "p1", 12),
                new Product(2, "p2", 12),
                new Product(3, "p3", 12),
                new Product(4, "p4", 12),
                new Product(5, "p5", 12),
                new Product(6, "p6", 12),
                new Product(1, "p1", 12),
                new Product(2, "p2", 12),
                new Product(3, "p3", 12),
                new Product(4, "p4", 12),
                new Product(5, "p5", 12),
                new Product(6, "p6", 12),
                new Product(1, "p1", 12),
                new Product(2, "p2", 12),
                new Product(3, "p3", 12),
                new Product(4, "p4", 12),
                new Product(5, "p5", 12),
                new Product(6, "p6", 12),
                new Product(1, "p1", 12),
                new Product(2, "p2", 12),
                new Product(3, "p3", 12),
                new Product(4, "p4", 12),
                new Product(5, "p5", 12),
                new Product(6, "p6", 12),
                new Product(1, "p1", 12),
                new Product(2, "p2", 12),
                new Product(3, "p3", 12),
                new Product(4, "p4", 12),
                new Product(5, "p5", 12),
                new Product(6, "p6", 12),
                new Product(1, "p1", 12),
                new Product(2, "p2", 12),
                new Product(3, "p3", 12),
                new Product(4, "p4", 12),
                new Product(5, "p5", 12),
                new Product(6, "p6", 12)
        );
        Helper.setTableColumns(pList, productsTable);
        searchTextFiled.textProperty().addListener(v -> {
            Helper.setTableColumns(find(searchTextFiled.getText()), productsTable);
        });
        productsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                if (productsTable.getSelectionModel().getSelectedItem() != null) {
                    Product p = productsTable.getSelectionModel().getSelectedItem();
                    new Alert(Alert.AlertType.CONFIRMATION, p.getName()).show();

                    System.out.println("Selected Value" + p.getName());
                }
            }
        });

    }

    private ObservableList<Product> find(String value) {

        ObservableList<Product> list = FXCollections.observableArrayList();
        pList.stream().filter((p) -> (p.getName().startsWith(value) || String.valueOf(p.getId()).startsWith(value))).forEachOrdered((p) -> {
            list.add(p);
        });
        return list;
    }

    @FXML
    private void addProduct(ActionEvent event) {
    }

    @FXML
    private void editProduct(ActionEvent event) {
    }

    @FXML
    private void deleteProduct(ActionEvent event) {
    }

}
