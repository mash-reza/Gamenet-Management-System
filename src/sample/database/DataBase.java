package sample.database;

import javafx.scene.control.ListCell;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataBase {
    Logger logger = Logger.getLogger("database_logger");

    private static DataBase INSTANCE;
    private Connection connection;
    private Statement statement;

    public static synchronized DataBase getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new DataBase();
            INSTANCE.connect();
            return INSTANCE;
        } else return INSTANCE;
    }

    private void connect() {
        try {
//            connection = DriverManager.getConnection("jdbc:sqlite::resource:assets/station.db");
            connection = DriverManager.getConnection("jdbc:sqlite:D:/Projects/GameNetManagementSystem/src/assets/gamenet.db");
            statement = connection.createStatement();
//            statement.execute("insert into customer (name,charge,phone) values ('reza',160500,'09194821975')");
            logger.log(Level.INFO, "database connection was successful");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public List<Customer> getCustumers() {
        List<Customer> customers = new ArrayList<>();
        try {
            ResultSet set = statement.executeQuery("select * from customer");
            while (set.next()){
                customers.add(new Customer(
                        set.getInt(Fileds.id),
                        set.getString(Fileds.name),
                        set.getInt(Fileds.charge),
                        set.getString(Fileds.phone)));
            }
            return customers;
        }catch (SQLException e){
            e.printStackTrace();
            logger.log(Level.SEVERE,e.getMessage(),e);
            return customers;
        }
    }

}
