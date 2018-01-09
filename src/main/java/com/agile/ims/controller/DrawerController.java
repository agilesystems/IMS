/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.controller;

import com.agile.ims.IMS;
import com.agile.ims.entity.Menu;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class DrawerController implements Initializable {

    @FXML
    private JFXButton exitBtn;
    @FXML
    private VBox drawerVBox;
    @FXML
    private JFXButton homeBtn;
    @FXML
    private JFXButton doctorBtn;
    @FXML
    private JFXButton appointmentBtn;
    @FXML
    private JFXButton paymentBtn;
    @FXML
    private JFXButton logoutBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//drawMenus();
    }

    public void drawMenus() {

        MenuButton rootMenu = null;
        for (Menu uMenu : IMS.user.getMenuCollection()) {
            if (uMenu.getParent() == null) {
                rootMenu = new MenuButton(uMenu.getTitle());
                rootMenu.setPrefHeight(43.0);
                rootMenu.setPrefWidth(200.0);
                rootMenu.setLayoutX(10.0);
                rootMenu.setLayoutY(10.0);
                rootMenu.getStylesheets().add("@../styles/styles.css");
                rootMenu.getStyleClass().add("drawer-buttons");
                for (Menu m : IMS.user.getMenuCollection()) {
                    if (m.getParent() != null && m.getParent().equals(uMenu)) {
                        javafx.scene.control.Menu subMenu = new javafx.scene.control.Menu(m.getTitle());

                        rootMenu.getItems().add(subMenu);
                    }
                }
            }

            if (rootMenu != null) {
                drawerVBox.getChildren().add(rootMenu);
            }

        }
    }

    @FXML
    private void logOut(ActionEvent event) {
        try {
            Stage window = (Stage) exitBtn.getScene().getWindow();
            IMS hospitalFX = new IMS();
            hospitalFX.start(new Stage());
            window.close();
        } catch (Exception ex) {
            Logger.getLogger(DrawerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }

}
