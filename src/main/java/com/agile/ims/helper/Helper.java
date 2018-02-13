/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.helper;

import com.agile.ims.IMS;
import static com.agile.ims.IMS.bundle;
import static com.agile.ims.IMS.context;
import com.agile.ims.controller.ProductController;
import com.jfoenix.controls.JFXDecorator;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.PopOver;

/**
 *
 * @author ramy
 */
public class Helper {

    public static void setTableColumns(ObservableList<?> list, TableView table, String... fields) {

        if (fields == null) {
            return;
        }

        table.getItems().clear();
        table.getColumns().clear();
        table.setItems(list);
        for (Field f : list.get(0).getClass().getDeclaredFields()) {
            for (String fName : fields) {
                if (fName.equalsIgnoreCase(f.getName())) {
                    TableColumn col = new TableColumn(f.getName());

                    col.setCellValueFactory(new PropertyValueFactory<>(f.getName()));
                    table.getColumns().add(col);
                }
            }
        }
    }

    public static void setTableColumns(ObservableList<?> list, TableView table) {

        table.getItems().clear();
        table.getColumns().clear();
        table.setItems(list);
        for (Field f : list.get(0).getClass().getDeclaredFields()) {
            TableColumn col = new TableColumn(f.getName());
            col.setCellValueFactory(new PropertyValueFactory<>(f.getName()));
            table.getColumns().add(col);

        }

    }

    public static void showPopup(Node contentNode, Node owner, String title, PopOver.ArrowLocation location) {

        PopOver popOver = new PopOver();
        //if(!contentNode.isVisible())contentNode.setVisible(true);
        popOver.setContentNode(contentNode);
        popOver.setAutoFix(true);
        popOver.setFadeInDuration(Duration.seconds(1.0));
        popOver.setTitle(title);
        popOver.setArrowLocation(location);
        popOver.show(owner);

    }

    public static void newStage(Node fxmlLoader, String resource, Node parentNodeOrientation, String decoratorTitle) {
        try {
            //fxmlLoader = FXMLLoader.load(IMS.class.getClass().getResource(resource), IMS.bundle);
            FXMLLoader loader=new FXMLLoader(IMS.class.getClass().getResource(resource),bundle);
            
            loader.setControllerFactory(context::getBean);
            fxmlLoader=loader.load();
            NodeOrientation orientation = parentNodeOrientation.getEffectiveNodeOrientation();
            if (orientation == NodeOrientation.RIGHT_TO_LEFT) {
                fxmlLoader.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            }
            Stage stage = new Stage();
            JFXDecorator decorator = new JFXDecorator(stage, fxmlLoader, false, true, true);
            decorator.setCustomMaximize(true);
            decorator.setBorder(Border.EMPTY);
            decorator.setText(IMS.bundle.getString(decoratorTitle));
            //Block owner window.....
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(stage.getOwner());
            //stage.setTitle(IMS.bundle.getString("add.pro"));
            Scene scene = new Scene(decorator);
            stage.setScene(scene);
            scene.getStylesheets().add(IMS.class.getResource("/styles/styles.css").toExternalForm());
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
