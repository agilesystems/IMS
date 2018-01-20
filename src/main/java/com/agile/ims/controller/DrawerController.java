/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.controller;

import com.agile.ims.IMS;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class DrawerController implements Initializable {

    private JFXButton exitBtn;
    @FXML
    private VBox drawerVBox;
    @FXML
    private JFXButton homeBtn;
    private JFXTextField searchTEXTField;
    @FXML
    private JFXTextField searchTextField;
    @FXML
    private JFXButton logoutBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void logOut(ActionEvent event) {
      

    }

    private void exit(ActionEvent event) {
        Platform.exit();
    }

}
