/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import com.agile.ims.helper.Routes;
import com.agile.ims.IMS;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import com.agile.ims.entity.User;
import com.agile.ims.service.UserService;
import java.util.HashMap;
import javafx.application.Platform;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FXML Controller class
 *
 * @author danml
 */
@Component
public class LoginController implements Initializable {

    @Autowired
    UserService userService;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private JFXSpinner loggingProgress;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loggingProgress.setVisible(false);
        IMS.user = null;
//        IMS.stage=null;
        Routes.forms = null;
        //*********To focus on userName field*********
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                txtUsername.requestFocus();
            }
        });
        //*********To Use Enter Key To login*********
        txtPassword.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                ActionEvent ev = null;
                try {
                    loginAction(ev);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        loggingProgress.setVisible(true);
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(1));
        pauseTransition.setOnFinished(ev -> {
            System.out.println("Complte one");
            completeLogin();
            System.out.println("Complte two");
        });
        pauseTransition.play();

    }

    private boolean isValidInput() {
        IMS.user = userService.authenticated(txtUsername.getText().trim(), txtPassword.getText().trim());
        return (IMS.user != null);
        //  return (txtUsername.getText().trim().length() > 0) && (txtPassword.getText().trim().length() > 0);
    }

    private void completeLogin() {
        loggingProgress.setVisible(false);
        if (isValidInput()) {

            try {
                User user = new User();
                user.setUsername(txtUsername.getText());
                loadAllFroms();
                IMS.stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource(Routes.MAINVIEW), IMS.bundle);
                root.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                JFXDecorator decorator = new JFXDecorator(IMS.stage, root, false, true, true);
                decorator.setCustomMaximize(true);
                decorator.setBorder(Border.EMPTY);

                //*********To get screen resolution (width and hight) and use it to maximize to full screen*********
//                Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
                Scene scene = new Scene(decorator/*, visualBounds.getWidth(), visualBounds.getHeight()*/);
                scene.getStylesheets().add(IMS.class.getResource("/styles/styles.css").toExternalForm());
                IMS.stage.initStyle(StageStyle.UNDECORATED);
                IMS.stage.setScene(scene);
                IMS.stage.setTitle("X-NET");
                IMS.stage.setIconified(false);
                IMS.stage.show();
                Routes.fadeInTransition(root, 2.0);
                //Hide login window
                btnLogin.getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void loadAllFroms() {
        Routes.forms = new HashMap<Integer, Node>();
        IMS.user.getUserMenuCollection().stream().filter((m) -> !(m.getFxml() == null)).map((m) -> {
            return m;
        }).forEachOrdered((m) -> {
            try {

                System.out.println("add form" + m.toString());
                Node anchorPane = FXMLLoader.load(getClass().getResource(m.getFxml()), IMS.bundle);
                if (anchorPane != null) {
                    Routes.forms.put(m.getId(),
                            null
                    //                            FXMLLoader.load(getClass().getResource(m.getFxml()))
                    );
                }
            } catch (IOException ex) {

                Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
}
