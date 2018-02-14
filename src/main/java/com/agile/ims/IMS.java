package com.agile.ims;

import com.agile.ims.entity.User;
import com.agile.ims.helper.Routes;
import com.jfoenix.controls.JFXDecorator;
import java.util.ResourceBundle;
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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IMS extends Application {

    public static User user;
    public static ConfigurableApplicationContext context;
    private Parent root;
    public static Stage stage;
    public static ResourceBundle bundle;

    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(IMS.class);
        builder.headless(false);
        context = builder.run(getParameters().getRaw().toArray(new String[0]));
       

    }

    @Override
    public void stop() throws Exception {
        context.close();
    }

    @Override
    public void start(Stage stage) throws Exception {
        bundle = ResourceBundle.getBundle("bundle_ar");
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Routes.LOGINVIEW),bundle);
        loader.setControllerFactory(context::getBean);
        root = loader.load();
        JFXDecorator decorator = new JFXDecorator(stage, root, false, false, true);
        decorator.setCustomMaximize(false);
        decorator.setBorder(Border.EMPTY);
        Scene scene = new Scene(decorator);
        scene.getStylesheets().add(IMS.class.getResource("/styles/styles.css").toExternalForm());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setTitle("X-NET V 1.0");
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
