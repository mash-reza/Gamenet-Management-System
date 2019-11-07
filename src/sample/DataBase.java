package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private Connection connection = null;

    public void connect(){
        try {
//            connection = DriverManager.getConnection("jdbc:sqlite::resource:assets/station.db");
            connection = DriverManager.getConnection("jdbc:sqlite:D:/Projects/GameNetManagementSystem/src/assets/gamenet.db");
            Statement statement = connection.createStatement();
            statement.execute("insert into customer (name,charge,phone) values ('reza',160500,'09194821975')");
            System.out.println("succesful");
        }catch (SQLException e){
            System.out.println("painful");
            e.printStackTrace();
        }
    }
}
