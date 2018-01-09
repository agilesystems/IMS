package com.agile.ims;

import com.agile.ims.entity.User;
import com.agile.ims.helper.Routes;
import com.jfoenix.controls.JFXDecorator;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IMS extends Application {

//    
//    private double xOffset = 0;
//    private double yOffset = 0;
    public static User user;
    public static ConfigurableApplicationContext context;
    private Parent root;
//    public static final String TITLE = "Inventory v 1.0";
//    public static final String ICON_PATH="/images/logo.png";
//    public static final String LOGIN_PATH="/fxml/Login.fxml";
//    @Override
//    public void start(Stage stage) throws Exception {
//
//        rootNode.setOnMousePressed((MouseEvent event) -> {
//            xOffset = event.getSceneX();
//            yOffset = event.getSceneY();
//        });
//        rootNode.setOnMouseDragged((MouseEvent event) -> {
//            stage.setX(event.getScreenX() - xOffset);
//            stage.setY(event.getScreenY() - yOffset);
//        });
//        Scene scene = new Scene(rootNode);
//        stage.setTitle("Inventory: Version 1.0");
//        stage.initStyle(StageStyle.UNDECORATED);
//        stage.setScene(scene);
//        stage.show();
//
//    }
//

    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(IMS.class);
        context = builder.run(getParameters().getRaw().toArray(new String[0]));
        System.out.println(getClass().getResource(Routes.LOGINVIEW));
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Routes.LOGINVIEW));
        loader.setControllerFactory(context::getBean);
        root = loader.load();
        
    }
    
    @Override
    public void stop() throws Exception {
        context.close();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource(Routes.LOGINVIEW));

        JFXDecorator decorator = new JFXDecorator(stage, root, false, false, true);
        decorator.setCustomMaximize(false);
        decorator.setBorder(Border.EMPTY);
        
        Scene scene = new Scene(decorator);
        scene.getStylesheets().add(IMS.class.getResource("/styles/styles.css").toExternalForm());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setTitle("PHARMA NET V 1.0");
        stage.setIconified(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
