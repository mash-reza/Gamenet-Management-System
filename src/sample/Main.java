package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.util.Locale;

public class Main extends Application {
    enum SceneType {
        MANAGEMENT, MANAGEMENT_PREFERENCES, CUSTOMER_MANAGEMENT, CUSTOMER_PREFERENCES
    }

    private Parent managementRoot;
    private Parent managementPreferencesRoot;
    private Parent customerManagementRoot;
    private Parent customerPreferencesRoot;

    @Override
    public void start(Stage primaryStage) throws Exception {
        managementRoot = FXMLLoader.load(getClass().getResource("../resource/fxml/management.fxml"));
        managementPreferencesRoot = FXMLLoader.load(getClass().getResource("../resource/fxml/management_preferences.fxml"));
        customerManagementRoot = FXMLLoader.load(getClass().getResource("../resource/fxml/customer_management.fxml"));
        customerPreferencesRoot = FXMLLoader.load(getClass().getResource("../resource/fxml/customer_preferences.fxml"));

        //menu bar
        MenuBar menuBar = new MenuBar();
        //managementRoot menu
        Menu managementMenu = new Menu("Management");
        MenuItem managementMenuItem = new MenuItem("Manage Devices");
        MenuItem managementPreferencesMenuItem = new MenuItem("Device Settings");
        //customer menu
        Menu customerMenu = new Menu("Customer");
        MenuItem customerManagementMenuItem = new MenuItem("Customer Management");
        MenuItem customerPreferencesMenuItem = new MenuItem("Customer Preferences");
        //help menu
        Menu HelpMenu = new Menu("Help");


        //preparing menus and menubar
        managementMenu.getItems().addAll(managementMenuItem, managementPreferencesMenuItem);
        customerMenu.getItems().addAll(customerManagementMenuItem, customerPreferencesMenuItem);
        menuBar.getMenus().addAll(managementMenu, customerMenu, HelpMenu);


        //first time scene
        BorderPane pane = new BorderPane(managementRoot, menuBar, null, null, null);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        //menu item click handling

        managementMenuItem.setOnAction(sceneBuilder(SceneType.MANAGEMENT, scene, pane));
        managementPreferencesMenuItem.setOnAction(sceneBuilder(SceneType.MANAGEMENT_PREFERENCES, scene, pane));
        customerManagementMenuItem.setOnAction(sceneBuilder(SceneType.CUSTOMER_MANAGEMENT, scene, pane));
        customerPreferencesMenuItem.setOnAction(sceneBuilder(SceneType.CUSTOMER_PREFERENCES, scene, pane));

        //show
        primaryStage.setTitle("GameNet Management System (GnMS)");
        primaryStage.show();
//        Locale[] list = DateFormat.getAvailableLocales();
//        for (Locale aLocale : list) {
//            System.out.println(aLocale.toString());
//        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public EventHandler<ActionEvent> sceneBuilder(SceneType type, Scene scene, BorderPane pane) throws Exception {
        switch (type) {
            case MANAGEMENT:
                return event -> {
                    try {
                        pane.setCenter(managementRoot);
                        scene.setRoot(pane);
                        System.out.println("file");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                };
            case MANAGEMENT_PREFERENCES:
                return event -> {
                    try {
                        pane.setCenter(managementPreferencesRoot);
                        scene.setRoot(pane);
                        System.out.println("file");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                };
            case CUSTOMER_MANAGEMENT:
                return event -> {
                    try {
                        pane.setCenter(customerManagementRoot);
                        scene.setRoot(pane);
                        System.out.println("file");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                };
            case CUSTOMER_PREFERENCES:
                return event -> {
                    try {
                        pane.setCenter(customerPreferencesRoot);
                        scene.setRoot(pane);
                        System.out.println("file");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                };
            default:
                return event -> {
                    try {
                        pane.setCenter(managementRoot);
                        scene.setRoot(pane);
                        System.out.println("file");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                };
        }
    }
}
