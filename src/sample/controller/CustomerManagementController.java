package sample.controller;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.database.Customer;
import sample.database.DataBase;
import sample.database.Fileds;

import java.util.ArrayList;
import java.util.List;


public class CustomerManagementController {

    @FXML
    TableView<Customer> tableView;
    @FXML
    TableColumn<Integer, Customer> idColumn;
    @FXML
    TableColumn<String, Customer> nameColumn;
    @FXML
    TableColumn<Integer, Customer> chargeColumn;
    @FXML
    TableColumn<String, Customer> phoneColumn;

    private List<Customer> customers = new ArrayList<>();

    public void initialize() {
        customers = DataBase.getINSTANCE().getCustumers();
        tableView.getItems().addAll(customers);
        idColumn.setCellValueFactory(new PropertyValueFactory<Integer, Customer>(Fileds.id));
        nameColumn.setCellValueFactory(new PropertyValueFactory<String, Customer>(Fileds.name));
        chargeColumn.setCellValueFactory(new PropertyValueFactory<Integer, Customer>(Fileds.charge));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<String, Customer>(Fileds.phone));
    }
}
