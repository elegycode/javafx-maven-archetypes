#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import static ${package}.util.ResourceBundleConstants.APP_NAME;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ${package}.control.AppController;
import ${package}.util.Settings;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * JavaFX App
 */
public class App extends Application {
    public static final String APP_EXTENSION = "*.xml";


    private static final String RESOURCE_PATH = "${packageInPathFormat}/";
    public static final String MESSAGES_PATH = RESOURCE_PATH + "messages/messages";
    public static final String CSS_PATH = RESOURCE_PATH + "css/";
    public static final String FXML_PATH = RESOURCE_PATH + "fxml/";
    public static final String ICONS_PATH = RESOURCE_PATH + "icons/";

    private static final String APP_ICON = ICONS_PATH + "app.png";


    private static Scene scene;

    private static Stage primaryStage;

    private static Settings settings;


    private AppController controller;

    private ResourceBundle bundle;


    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;

        loadSettings();
        bundle = ResourceBundle.getBundle(MESSAGES_PATH, settings.getLocale());

        FXMLLoader loader = createFXMLLoader("window");
        Parent root = loader.load();
        controller = loader.getController();

        primaryStage.setOnCloseRequest(event -> {
            storeSettings();
            controller.handleExit();
        });

        scene = new Scene(root);
        scene.getStylesheets().add(getCSS(settings.getStyle().getValue()));


        primaryStage.setScene(scene);
        primaryStage.setTitle(bundle.getString(APP_NAME));
//        primaryStage.getIcons().add(new Image(APP_ICON));
        primaryStage.setX(settings.getX());
        primaryStage.setY(settings.getY());
        primaryStage.setHeight(settings.getHeight());
        primaryStage.setWidth(settings.getWidth());
        primaryStage.setMaximized(settings.isMaximized());
        primaryStage.show();
    }


    private FXMLLoader createFXMLLoader(String fxml) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource(FXML_PATH + fxml + ".fxml"));
        loader.setResources(bundle);

        return loader;
    }

    private String getCSS(String css) {
        return getClass().getClassLoader().getResource(CSS_PATH + css + ".css").toExternalForm();
    }

    private void loadSettings() {
        settings = new Settings();
        try {
            settings.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        settings.styleProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != null){
                scene.getStylesheets().remove(getCSS(oldValue.getValue()));
                scene.getStylesheets().add(getCSS(newValue.getValue()));
            }
        });
        settings.localeProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != null){
                bundle = ResourceBundle.getBundle(MESSAGES_PATH, settings.getLocale());
            }
        });
    }

    private void storeSettings() {
        try {
            Settings settings = App.getSettings();
            File file = controller.getFile();
            if (file != null) {
                settings.setLastFile(file.getAbsolutePath());
            } else {
                settings.setLastFile("");
            }
            Stage primaryStage = App.getPrimaryStage();
            if (!primaryStage.isMaximized()) {
                settings.setX(primaryStage.getX());
                settings.setY(primaryStage.getY());
                settings.setHeight(primaryStage.getHeight());
                settings.setWidth(primaryStage.getWidth());
            }
            settings.setMaximized(primaryStage.isMaximized());
            settings.store();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static Settings getSettings() {
        return settings;
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void setRoot(String fxml, ResourceBundle bundle) throws IOException {
        scene.setRoot(loadFXML(fxml, bundle));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getClassLoader().getResource(FXML_PATH + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    private static Parent loadFXML(String fxml, ResourceBundle bundle) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getClassLoader().getResource(FXML_PATH + fxml + ".fxml"), bundle);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}