/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author mhdsy
 */
public class ProductController {

    @FXML
    private JFXButton addbtn;
    @FXML
    private JFXButton updatebtn;
    @FXML
    private JFXButton delbtn;
    @FXML
    private JFXButton adSearchbtn;
    @FXML
    private JFXTextField searchtxt;
    @FXML
    private TableView<?> tableView;
    @FXML
    private BorderPane homeAnchorPane;
    
}
