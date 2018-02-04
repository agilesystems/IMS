/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.helper;

import com.agile.ims.IMS;
import com.agile.ims.controller.HomeViewController;
import com.agile.ims.entity.UserMenu;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 *
 * @author danml
 */
public class Routes {

    public static String LOGINVIEW = "/fxml/login/Login.fxml";
    public static String MAINVIEW = "/fxml/home/HomeView.fxml";
    public static String DRAWERVIEW = "/fxml/home/Drawer.fxml";
    public static String PAYMENTSVIEW = "/fxml/payment/PaymentsView.fxml";
    public static String APPOINTMENTSVIEW = "/fxml/appointment/AppointmentView.fxml";
    public static String DOCTORSVIEW = "/fxml/doctor/DoctorsView.fxml";
    public static String WELCOMEVIEW = "/fxml/home/WelcomeView.fxml";
    public static String ADDPRODUCT = "/fxml/product/AddProduct.fxml";
    
    public static int HOME_ID = 1;
    public static HashMap<Integer, Node> forms;

    public static Node anchorPane(int id) {

        for (int key : forms.keySet()) {
            if (key == id) {
                if (forms.get(key) == null) {
                    try {
                        return FXMLLoader.load(IMS.class.getClass().getResource(getFXML(key)), IMS.bundle);
                    } catch (IOException ex) {
                        Logger.getLogger(Routes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    return forms.get(key);
                }
            }
        }
        return null;
    }

    private static String getFXML(int id) {

        for (UserMenu um : IMS.user.getUserMenuCollection()) {

            if (id == um.getId()) {
                return um.getFxml();
            }
        }
        return null;
    }

    /**
     * add node to the holderPane
     *
     * @param holderPane current opening holder pane
     * @param drawer
     * @param node node to be open
     */
    public static void openNode(HomeViewController home, int formId) {
        Node form = Routes.anchorPane(formId);
        if (form == null) {
            return;
        }
        home.getDrawer().close();
        home.getHolderPane().getChildren().clear();
        home.getHolderPane().getChildren().add(form);
        fadeInTransition(form, 2.0);
        for (UserMenu um : IMS.user.getUserMenuCollection()) {
            if (um.getId() == formId) {
                home.getTxtCurrentWindow().setText(um.getTitle());
                return;
            }
        }

    }

    public static void fadeInTransition(Node node, Double duration) {
        FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(duration), node);
        fadeInTransition.setFromValue(0.0);
        fadeInTransition.setToValue(1.0);
        fadeInTransition.play();
    }

}
