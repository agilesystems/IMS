/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.helper;

import java.lang.reflect.Field;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

}
