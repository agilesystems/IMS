package com.agile.ims.controller;

import com.agile.ims.entity.Item;
import com.agile.ims.helper.Validation;
import com.agile.ims.service.ItemService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FXML Controller class
 *
 * @author mhdsy
 */
@Component
public class AddProductController implements Initializable {

    @Autowired
    ItemService itemService;
    @Autowired
    ProductController productController;
    private File file;
    private BufferedImage bufferedImage;
    private Image image;
    private String imagePath;

    @FXML
    private JFXTextField name;
    @FXML
    private JFXDatePicker expDate;
    @FXML
    private JFXDatePicker mfgDate;
    private HBox rootPane;
    @FXML
    private JFXTextField lowestPrice;
    @FXML
    private JFXTextField lowestQunt;
    @FXML
    private JFXTextField barcode;
    @FXML
    private JFXTextField localCode;
    @FXML
    private JFXTextField globalCode;
    @FXML
    private JFXTextField sellPrice;
    @FXML
    private JFXTextArea extraInfo;
    @FXML
    private ImageView imgView;
    @FXML
    private JFXTextField expired;
    @FXML
    private JFXTextField groupId;
    @FXML
    private JFXTextField unitId;
    @FXML
    private JFXTextField BuyPrice;
    @FXML
    private HBox addProductRoot;
    @FXML
    private JFXButton saveBtn;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Validation.Validate_Required_IsLetters_IsNumeric(name);
        Validation.validate_Required_IsNumeric(barcode);
        Validation.validate_Required_IsNumeric(BuyPrice);
        Validation.validate_Required_IsNumeric(sellPrice);

    }

    @FXML
    private void saveproduct(ActionEvent event) {

        if (!Validation.isEmpty(name)
                || !Validation.isEmpty(barcode)
                || !Validation.isEmpty(BuyPrice)
                || !Validation.isEmpty(sellPrice)) {
            return;
        }

        Item i = new Item();
        i.setName(name.getText());
        i.setBarcode(barcode.getText());
        i.setBuyprice(new BigDecimal(BuyPrice.getText()));
        i.setSalprice(new BigDecimal(sellPrice.getText()));

        add(i);
        productController.tableList();

    }

    @FXML
    private void resetFields(ActionEvent event) {
        //id.clear();
        name.clear();
        lowestPrice.clear();
        lowestQunt.clear();
        barcode.clear();
        localCode.clear();
        globalCode.clear();
        sellPrice.clear();
        extraInfo.clear();
        expired.clear();
        unitId.clear();
        groupId.clear();
        BuyPrice.clear();
        expDate.setValue(null);
        mfgDate.setValue(null);
        imgView.setImage(null);

    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) addProductRoot.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnAttachImageOnAction(ActionEvent event) {

        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All (All Extensions)", "*.png", "*.jpg", "*.jpeg"),
                    new FileChooser.ExtensionFilter("JPG (Joint Photographic Group)", "*.jpg"),
                    new FileChooser.ExtensionFilter("JPEG (Joint Photographic Experts Group)", "*.jpeg"),
                    new FileChooser.ExtensionFilter("PNG (Portable Network Graphics)", "*.png"));
            fileChooser.setTitle("Choose a Image File");
            file = fileChooser.showOpenDialog(null);
            if (file != null) {
                System.out.println(file);
                bufferedImage = ImageIO.read(file);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                imgView.setImage(image);
                imagePath = file.getAbsolutePath();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean add(Item item) {

        return itemService.save(item);
    }

}
