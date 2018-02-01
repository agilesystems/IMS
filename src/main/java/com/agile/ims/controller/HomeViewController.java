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
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class HomeViewController implements Initializable {

    @FXML
    private JFXHamburger hamburger;
    @FXML
    private StackPane holderPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private Label txtCurrentWindow;
    private VBox sidePane;
    @FXML
    private AnchorPane homeAnchorPane;

    TranslateTransition sideMenu;
    @FXML
    private JFXButton langbtn;
    @FXML
    private AnchorPane mainAnchorPane;

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
            OpenCloseDrawer(sideMenu, holderPane);

        });

        try {
            sidePane = FXMLLoader.load(getClass().getResource(Routes.DRAWERVIEW), IMS.bundle);
            drawMenus();
            Node welcome = FXMLLoader.load(getClass().getResource(Routes.WELCOMEVIEW), IMS.bundle);
            setNode(welcome);
            drawer.setSidePane(sidePane);

            for (Node node : sidePane.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent ev) -> {
                        switch (node.getAccessibleText()) {
                            case "homeMenu":
                                Routes.fadeInTransition(holderPane, 2.0);
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
                            OpenCloseDrawer(sideMenu, holderPane);
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

    public void OpenCloseDrawer(TranslateTransition sideMenu, Node node) {
        sideMenu = new TranslateTransition(Duration.millis(400.0), node);
        if (drawer.isHidden()) {

//            sideMenu.setFromX(-140);
//            sideMenu.setToX(0);
//            sideMenu.play();
//            drawer.setVisible(true);
            drawer.open();

        } else {
//            
//           sideMenu.setFromX(0);
//            sideMenu.setToX(-140);
//            sideMenu.play();
            drawer.close();
//            drawer.setVisible(false);
        }
    }

    @FXML
    private void changeLanguage(ActionEvent event) throws IOException {

        if (event.getSource().equals(langbtn) && langbtn.getText().equals("العربية")) {
            IMS.bundle = ResourceBundle.getBundle("bundle_ar");
            IMS.stage.close();
            IMS.stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(Routes.MAINVIEW), IMS.bundle);
            root.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            JFXDecorator decorator = new JFXDecorator(IMS.stage, root, false, true, true);
            decorator.setCustomMaximize(true);
            decorator.setBorder(Border.EMPTY);

            Scene scene = new Scene(decorator/*, visualBounds.getWidth(), visualBounds.getHeight()*/);
            scene.getStylesheets().add(IMS.class.getResource("/styles/styles.css").toExternalForm());
            IMS.stage.initStyle(StageStyle.UNDECORATED);
            IMS.stage.setScene(scene);
            IMS.stage.setTitle("X-NET");
            IMS.stage.setIconified(false);
            IMS.stage.show();
        } else if (event.getSource().equals(langbtn) && langbtn.getText().equals("English")) {
            IMS.bundle = ResourceBundle.getBundle("bundle_en");
            IMS.stage.close();
            IMS.stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(Routes.MAINVIEW), IMS.bundle);
            root.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            JFXDecorator decorator = new JFXDecorator(IMS.stage, root, false, true, true);
            decorator.setCustomMaximize(true);
            decorator.setBorder(Border.EMPTY);

            Scene scene = new Scene(decorator/*, visualBounds.getWidth(), visualBounds.getHeight()*/);
            scene.getStylesheets().add(IMS.class.getResource("/styles/styles.css").toExternalForm());
            IMS.stage.initStyle(StageStyle.UNDECORATED);
            IMS.stage.setScene(scene);
            IMS.stage.setTitle("X-NET");
            IMS.stage.setIconified(false);
            IMS.stage.show();
        }
    }

    public StackPane getHolderPane() {
        return holderPane;
    }

    public JFXDrawer getDrawer() {
        return drawer;
    }

    public Label getTxtCurrentWindow() {
        return txtCurrentWindow;
    }

}
