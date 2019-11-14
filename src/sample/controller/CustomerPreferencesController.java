package sample.controller;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;


public class CustomerPreferencesController {

    @FXML
    MenuItem newCustomerMenuItem;
    @FXML
    MenuItem managementPanelMenuItem;
    @FXML
    MenuItem addDeviceMenuItem;
    @FXML
    MenuItem preferencesMenuItem;
    @FXML
    MenuItem aboutMenuItem;
    @FXML
    MenuItem errorLogMenuItem;


    public void initialize() {
        newCustomerMenuItem.setOnAction(event -> {
            System.out.println("click");
        });
    }
}
