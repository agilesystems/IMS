/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.controlsfx.control.ListSelectionView;

/**
 * FXML Controller class
 *
 * @author mhdsy
 */
public class AddUserController implements Initializable {

    @FXML
    private ListSelectionView<Object> listSelectionView;
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXComboBox<String> roleCB;
    private static final String [] roleList = {"Role1","Role2","Role3"};
    private static final String [] menuList = {"Menu1 >"+"subMenu1","Menu1 >"+"subMenu2","Menu1 >"+"subMenu3","Menu1 >"+"subMenu4"};
    private static final String [] menuList1 = {"Menu1 >"+"subMenu2","Menu1 >"+"subMenu4"};
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        roleCB.getItems().addAll(roleList);
        listSelectionView.getSourceItems().addAll(menuList);
        
    }    

    @FXML
    private void save(ActionEvent event) {
    }

    @FXML
    private void roleCBSelected(ActionEvent event) {
        if(roleCB.getSelectionModel().getSelectedItem().equals("Role1")){
            System.out.println("Done");
            //ObservableList<Object> observableList = FXCollections.observableArrayList(menuList1);
            listSelectionView.getSourceItems().removeAll(menuList1);
            listSelectionView.getTargetItems().addAll(menuList1);
        }
        System.out.println(listSelectionView.getSourceItems());
    }
    
}
