/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.controller;

import com.agile.ims.IMS;
import com.agile.ims.entity.Menu;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.agile.ims.helper.Routes;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class HomeViewController implements Initializable {
    
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private AnchorPane holderPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private Label txtCurrentWindow;
    private VBox sidePane;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();
            
            if (drawer.isShown()) {
                drawer.close();
            } else {
                drawer.open();
            }
            
        });
        
        try {
            sidePane = FXMLLoader.load(getClass().getResource(Routes.DRAWERVIEW));
            drawMenus();

//            AnchorPane doctorsPane = FXMLLoader.load(getClass().getResource(Routes.DOCTORSVIEW));
//            AnchorPane login = FXMLLoader.load(getClass().getResource(Routes.LOGINVIEW));
//            AnchorPane payments = FXMLLoader.load(getClass().getResource(Routes.PAYMENTSVIEW));
//            AnchorPane appointment = FXMLLoader.load(getClass().getResource(Routes.APPOINTMENTSVIEW));
            AnchorPane welcome = FXMLLoader.load(getClass().getResource(Routes.WELCOMEVIEW));
            setNode(welcome);
            drawer.setSidePane(sidePane);
            
            for (Node node : sidePane.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent ev) -> {
                        switch (node.getAccessibleText()) {
                            case "homeMenu":
                                drawer.close();
                                txtCurrentWindow.setText("Pharma Net");
                                setNode(welcome);
                                break;
                            
                        }
                    });
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setNode(Node node) {
        
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
    }
    
    public void drawMenus() {
        
        MenuButton rootMenu = null;
        for (Menu uMenu : IMS.user.getMenuCollection()) {
            if (uMenu.getParent() == null) {

//                if (uMenu.getSubMenus().size() == 0) {
//
//                    JFXButton button = new JFXButton(uMenu.getTitle());
//                    button.setPrefHeight(43.0);
//                    button.setPrefWidth(200.0);
//                    button.setLayoutX(10.0);
//                    button.setLayoutY(10.0);
//                    button.getStylesheets().add("@../styles/styles.css");
//                    button.getStyleClass().add("drawer-buttons");
//                 
//                    sidePane.getChildren().add(button);
//                    button = null;
//                    continue;
//                }
                rootMenu = new MenuButton(uMenu.getTitle());
                rootMenu.setPrefHeight(43.0);
                rootMenu.setPrefWidth(200.0);
                rootMenu.setLayoutX(10.0);
                rootMenu.setLayoutY(10.0);
                rootMenu.getStylesheets().add("@../styles/styles.css");
                rootMenu.getStyleClass().add("drawer-buttons");
                
                for (Menu m : IMS.user.getMenuCollection()) {
                    if (m.getParent() != null && m.getParent().getId() == uMenu.getId()) {
                        javafx.scene.control.Menu subMenu = new javafx.scene.control.Menu(m.getTitle());
                        subMenu.setOnAction(v -> {

                            //AnchorPane newNode = FXMLLoader.load(getClass().getResource(m.getForm().getFxml()));
//                                try {
//                                    if (holderPane.getChildren().get(0).getId().equals(newNode.getId())) {
//                                        return;
//                                    }
//
//                                } catch (Exception e) {
//
//                                }
                            drawer.close();
                            
                            setNode(Routes.forms.get(m.getForm().getId()));
                            txtCurrentWindow.setText(m.getForm().getTitle());
                        });
                        
                        rootMenu.getItems().add(subMenu);
                    }
                }
                
                if (rootMenu != null) {
                    
                    sidePane.getChildren().add(rootMenu);
                    rootMenu = null;
                }
            }
            
        }
    }
}
