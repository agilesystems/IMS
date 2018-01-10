/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.helper;

import com.agile.ims.IMS;
import com.agile.ims.entity.UserMenu;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

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
    public static int HOME_ID = 1;
    public static HashMap<Integer, AnchorPane> forms;

    public static AnchorPane anchorPane(int id) {

        for (int key : forms.keySet()) {
            if (key == id) {
                if (forms.get(key) == null) {
                    try {
                        return FXMLLoader.load(IMS.class.getClass().getResource(getFXML(key)));
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
}
