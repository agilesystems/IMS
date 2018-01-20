/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;

/**
 *
 * @author mhdsy
 */
public class ProductController {

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
    @FXML
    private Button deleteBtn;

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

    @FXML
    private void addProduct(ActionEvent event) {
    }
    
}
