/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.helper;

import java.util.HashMap;
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
    public static int HOME_ID=1;
    public static HashMap<Integer, AnchorPane> forms;
}
