/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.controller;

import com.agile.ims.IMS;
import com.agile.ims.helper.Helper;
import com.agile.ims.helper.Routes;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.PopOver;
import org.hibernate.validator.internal.util.logging.Messages_$bundle;

/**
 * FXML Controller class
 *
 * @author mhdsy
 */
public class ProductController implements Initializable {

    private TableColumn<?, ?> idCol;
    private TableColumn<?, ?> nameCol;
    @FXML
    private TableView<?> tableView;
    @FXML
    private BorderPane homeAnchorPane;
    @FXML
    private JFXButton addbtn;
    @FXML
    private JFXButton updatebtn;
    @FXML
    private JFXButton delbtn;
    @FXML
    private JFXTextField searchtxt;

    public static Node addProduct;
    private HBox SearchBox;
    @FXML
    private JFXButton searchbtn;
    @FXML
    private HBox searchBoxParent;
    @FXML
    private HBox searchBox;

    public TableColumn<?, ?> getIdCol() {
        return idCol;
    }

    public void setIdCol(TableColumn<?, ?> idCol) {
        this.idCol = idCol;
    }

    public TableColumn<?, ?> getNameCol() {
        return nameCol;
    }

    public void setNameCol(TableColumn<?, ?> nameCol) {
        this.nameCol = nameCol;
    }

    public TableView<?> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<?> tableView) {
        this.tableView = tableView;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Start with hiden SratchBox
        searchBoxParent.setVisible(false);
        searchBoxParent.getChildren().clear();

    }

    @FXML
    private void addProduct(ActionEvent event) {
        Helper.newStage(addProduct, Routes.ADDPRODUCT, homeAnchorPane, "add.pro");

    }
    
    @FXML
    private void advacedSearch(ActionEvent event) {
        if (!searchBoxParent.isVisible()) {
            //searchBoxParent.getChildren().clear();
            searchBoxParent.setVisible(true);
            searchBoxParent.getChildren().add(searchBox);
            
            Routes.fadeInTransition(searchBoxParent, 1.0);

        } else {
            //Routes.fadeOutTransition(searchBoxParent, 1.0);
            searchBoxParent.setVisible(false);
            searchBoxParent.getChildren().clear();
        }
    }

    @FXML
    private void updateProduct(ActionEvent event) {
    }

}
