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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.InputMethodEvent;

/**
 * FXML Controller class
 *
 * @author ramy
 */
public class ProductControllerX implements Initializable {

    private TableView<Product> productsTable;
    private TextField searchTextFiled;
    ObservableList<Product> pList;
    @FXML
    private Button deleteBtn;
    @FXML
    private ToggleButton btnStock;
    @FXML
    private ToggleButton btnSupplyer;
    @FXML
    private ToggleButton btnBrands;
    @FXML
    private ToggleButton btnCatagory;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> idCol;
    @FXML
    private TableColumn<?, ?> nameCol;
    @FXML
    private TableColumn<?, ?> unitIdCol;
    @FXML
    private TableColumn<?, ?> groupIdCol;
    @FXML
    private TableColumn<?, ?> buyPriceCol;
    @FXML
    private TableColumn<?, ?> sellPriceCol;
    @FXML
    private TableColumn<?, ?> barcodeCol;
    @FXML
    private TableColumn<?, ?> globalCodeCol;
    @FXML
    private TableColumn<?, ?> localCodeCol;
    @FXML
    private TableColumn<?, ?> lowestPriceCol;
    @FXML
    private TableColumn<?, ?> lowestQuantityCol;
    @FXML
    private TableColumn<?, ?> expireDateCol;
    @FXML
    private TableColumn<?, ?> expiredCol;
    @FXML
    private TableColumn<?, ?> extraInfoCol;
    @FXML
    private TableColumn<?, ?> photoCol;
    @FXML
    private TableColumn<?, ?> createdByCol;
    @FXML
    private TableColumn<?, ?> createdAtCol;
    @FXML
    private TableColumn<?, ?> updatedByCol;
    @FXML
    private TableColumn<?, ?> updatedAtCol;
    @FXML
    private TableColumn<?, ?> deletedCol;
    @FXML
    private TableColumn<?, ?> deletedByCol;

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
    private void btnStockOnAction(ActionEvent event) {
    }

    @FXML
    private void btnSupplyerOnAction(ActionEvent event) {
    }

    @FXML
    private void btnBrandsOnAction(ActionEvent event) {
    }

    @FXML
    private void btnCatagoryOnAction(ActionEvent event) {
    }

}
