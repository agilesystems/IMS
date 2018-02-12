/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.helper;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author mhdsy
 */
public class Validation {

    /*
     *Check if field empty....
     *
     */
    public static boolean isEmpty(JFXTextField fXTextField) {
        if (fXTextField.getText().isEmpty()) {
            errorAlert(fXTextField.getPromptText() + " is Empty!");
            return false;
        }
        return true;
    }

    //Show message if user leave field empty and make field accept numeric only....
    public static void validate_Required_IsNumeric(JFXTextField fXTextField) {

        fXTextField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                RequiredFieldValidator validator = new RequiredFieldValidator();
                fXTextField.getValidators().add(validator);
                validator.setMessage("Required Field!!");
                fXTextField.validate();
            }
        });
        fXTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    fXTextField.setText(newValue.replaceAll("[^\\d*]", ""));
                    errorAlert("Only Numbers Are Allowed!");
                }
            }
        });
    }

    //Show message if user leave field empty and make field accept numeric and letters only....
    public static void Validate_Required_IsLetters_IsNumeric(JFXTextField fXTextField) {
        fXTextField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                RequiredFieldValidator validator = new RequiredFieldValidator();
                fXTextField.getValidators().add(validator);
                validator.setMessage("Required Field!!");
                fXTextField.validate();
            }
        });
        fXTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("[A-Za-z0-9]*")) {
                    errorAlert("Only Letters & Numbers Are Allowed!");
                    fXTextField.setText(newValue.replaceAll("[^A-Za-z0-9]*", ""));
                }
            }
        });
    }

    //Error notification with dark Style & default error image & default title & body...
    public static void errorNotifications(String msg) {
        Notifications notificationBuilder = Notifications.create().action()
                .title("Error")
                .text(msg)
                .position(Pos.BOTTOM_RIGHT)
                .hideAfter(Duration.millis(1500));
        notificationBuilder.showError();
    }

    //Simple error alert!
    public static void errorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR, msg);
        alert.show();
    }

}
