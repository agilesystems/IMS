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
//xxx
    public static User user;
    public static ConfigurableApplicationContext context;
    private Parent root;
    public static Stage stage;

    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(IMS.class);
        context = builder.run(getParameters().getRaw().toArray(new String[0]));
       

    }

    @Override
    public void stop() throws Exception {
        context.close();
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(Routes.LOGINVIEW));
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
