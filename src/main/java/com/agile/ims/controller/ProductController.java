/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.controller;

import com.agile.ims.IMS;
import com.agile.ims.helper.AutoCompleteComboBoxListener;
import com.agile.ims.helper.Helper;
import com.agile.ims.helper.Routes;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.PopOver;
import org.hibernate.validator.internal.util.logging.Messages_$bundle;

/**
 * FXML Controller class
 *
 * @author mhdsy
 */
public class ProductController implements Initializable {

    private TableColumn<?, ?> idCol;
    private TableColumn<?, ?> nameCol;
    @FXML
    private TableView<?> tableView;
    @FXML
    private BorderPane homeAnchorPane;
    @FXML
    private JFXButton addbtn;
    @FXML
    private JFXButton updatebtn;
    @FXML
    private JFXButton delbtn;
    @FXML
    private JFXTextField searchtxt;

    public static Node addProduct;
    private HBox SearchBox;
    @FXML
    private JFXButton searchbtn;
    @FXML
    private HBox searchBoxParent;
    @FXML
    private HBox searchBox;
    @FXML
    private JFXComboBox<?> categoryCB;
    @FXML
    private JFXComboBox<?> brandCB;
    @FXML
    private JFXComboBox<?> supplierCB;

    public TableColumn<?, ?> getIdCol() {
        return idCol;
    }

    public void setIdCol(TableColumn<?, ?> idCol) {
        this.idCol = idCol;
    }

    public TableColumn<?, ?> getNameCol() {
        return nameCol;
    }

    public void setNameCol(TableColumn<?, ?> nameCol) {
        this.nameCol = nameCol;
    }

    public TableView<?> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<?> tableView) {
        this.tableView = tableView;
    }
    
    //Dummy DATA Just For Test.....
    private static final String[] LISTA = { "Abacate", "Abacaxi", "Ameixa", "Amora", "Araticum", "Atemoia", "Avocado",
			"Banana prata", "Caju", "Cana descascada", "Caqui", "Caqui Fuyu", "Carambola", "Cereja", "Coco verde",
			"Figo", "Figo da Índia", "Framboesa", "Goiaba", "Graviola", "Jabuticaba", "Jambo", "Jambo rosa", "Jambolão",
			"Kino (Kiwano)", "Kiwi", "Laranja Bahia", "Laranja para suco", "Laranja seleta", "Laranja serra d’água",
			"Laranjinha kinkan", "Lichia", "Lima da pérsia", "Limão galego", "Limão Taiti", "Maçã argentina",
			"Maçã Fuji", "Maçã gala", "Maçã verde", "Mamão formosa", "Mamão Havaí", "Manga espada", "Manga Haden",
			"Manga Palmer", "Manga Tommy", "Manga Ubá", "Mangostim", "Maracujá doce", "Maracujá para suco", "Melancia",
			"Melancia sem semente", "Melão", "Melão Net", "Melão Orange", "Melão pele de sapo", "Melão redinha",
			"Mexerica carioca", "Mexerica Murcote", "Mexerica Ponkan", "Mirtilo", "Morango", "Nectarina",
			"Nêspera ou ameixa amarela", "Noni", "Pera asiática", "Pera portuguesa", "Pêssego", "Physalis", "Pinha",
			"Pitaia", "Romã", "Tamarilo", "Tamarindo", "Uva red globe", "Uva rosada", "Uva Rubi", "Uva sem semente",
			"Abobora moranga", "Abobrinha italiana", "Abobrinha menina", "Alho", "Alho descascado",
			"Batata baroa ou cenoura amarela", "Batata bolinha", "Batata doce", "Batata inglesa", "Batata yacon",
			"Berinjela", "Beterraba", "Cebola bolinha", "Cebola comum", "Cebola roxa", "Cenoura", "Cenoura baby",
			"Couve flor", "Ervilha", "Fava", "Gengibre", "Inhame", "Jiló", "Massa de alho", "Maxixe", "Milho",
			"Pimenta biquinho fresca", "Pimenta de bode fresca", "Pimentão amarelo", "Pimentão verde",
			"Pimentão vermelho", "Quiabo", "Repolho", "Repolho roxo", "Tomate cereja", "Tomate salada",
			"Tomate sem acidez", "Tomate uva", "Vagem", "Agrião", "Alcachofra", "Alface", "Alface americana",
			"Almeirão", "Brócolis", "Broto de alfafa", "Broto de bambu", "Broto de feijão", "Cebolinha", "Coentro",
			"Couve", "Espinafre", "Hortelã", "Mostarda", "Rúcula", "Salsa", "Ovos brancos", "Ovos de codorna",
			"Ovos vermelhos" };

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Start with hiden SratchBox
        searchBoxParent.setVisible(false);
        searchBoxParent.getChildren().clear();
        
        autoCompleteComboBox(categoryCB);
        autoCompleteComboBox(brandCB);
        autoCompleteComboBox(supplierCB);

    }

    @FXML
    private void addProduct(ActionEvent event) {
        Helper.newStage(addProduct, Routes.ADDPRODUCT, homeAnchorPane, "add.pro");

    }
    
    @FXML
    private void advacedSearch(ActionEvent event) {
        if (!searchBoxParent.isVisible()) {
            //searchBoxParent.getChildren().clear();
            searchBoxParent.setVisible(true);
            searchBoxParent.getChildren().add(searchBox);
            
            Routes.fadeInTransition(searchBoxParent, 1.0);

        } else {
            //Routes.fadeOutTransition(searchBoxParent, 1.0);
            searchBoxParent.setVisible(false);
            searchBoxParent.getChildren().clear();
        }
    }

    @FXML
    private void updateProduct(ActionEvent event) {
    }
    
    private void autoCompleteComboBox(JFXComboBox comboBox) {
        comboBox.getItems().addAll(LISTA);
        new AutoCompleteComboBoxListener(comboBox);
        
    }

}
