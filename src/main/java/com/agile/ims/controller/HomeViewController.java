/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.controller;

import com.agile.ims.IMS;
import com.agile.ims.entity.UserMenu;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.agile.ims.helper.Routes;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    @FXML
    private AnchorPane homeAnchorPane;

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
            AnchorPane welcome = FXMLLoader.load(getClass().getResource(Routes.WELCOMEVIEW));
            setNode(welcome);
            drawer.setSidePane(sidePane);

            for (Node node : sidePane.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent ev) -> {
                        switch (node.getAccessibleText()) {
                            case "homeMenu":
                                drawer.close();
                                txtCurrentWindow.setText("X-Net");
                                setNode(welcome);
                                break;
                            case "logOut":
                                try {

                                    new IMS().start(new Stage());
                                    IMS.stage.close();
                                } catch (Exception ex) {
                                    Logger.getLogger(DrawerController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                        }
                    });
                }
                if (node instanceof JFXTextField && node.getId().equals("searchTextField")) {

                    JFXTextField searchTEXTField = (JFXTextField) node;
                    searchTEXTField.setOnAction((ActionEvent v) -> {

                        if (!searchTEXTField.getText().isEmpty()) {
                            try {
                                Routes.openNode(this, Integer.parseInt(searchTEXTField.getText()));
                            } catch (NumberFormatException ex) {
                                new Alert(Alert.AlertType.ERROR, "من فضلك  ادخل رقم صحيح").show();
                                Logger.getLogger(DrawerController.class.getName()).log(Level.SEVERE, null, ex);
                            }

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
        for (UserMenu uMenu : IMS.user.getUserMenuCollection()) {
            if (uMenu.getParent() == null) {
                rootMenu = new MenuButton(uMenu.getTitle());
                rootMenu.setPrefHeight(43.0);
                rootMenu.setPrefWidth(200.0);
                rootMenu.setLayoutX(10.0);
                rootMenu.setLayoutY(10.0);

                rootMenu.getStylesheets().add("@../styles/styles.css");
                rootMenu.getStyleClass().add("drawer-buttons");
                for (UserMenu m : IMS.user.getUserMenuCollection()) {
                    if (m.getParent() != null && m.getParent().getId() == uMenu.getId()) {
                        Menu subMenu = new Menu(m.getTitle());
                        subMenu.setOnAction(v -> {
                            Routes.openNode(this, m.getId());
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

    public AnchorPane getHolderPane() {
        return holderPane;
    }

    public JFXDrawer getDrawer() {
        return drawer;
    }

    public Label getTxtCurrentWindow() {
        return txtCurrentWindow;
    }

}
