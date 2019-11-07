package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class DataBase {
    private Connection connection = null;

    public void connect(){
        try {
//            connection = DriverManager.getConnection("jdbc:sqlite::resource:assets/station.db");
            connection = DriverManager.getConnection("jdbc:sqlite:D:/Projects/GameNetManagementSystem/src/assets/station.db");
            Statement statement = connection.createStatement();
            statement.execute("insert into brt (name,line,lat,lon) values ('dff',5,45,56)");
            System.out.println("succesful");
        }catch (SQLException e){
            System.out.println("painful");
            e.printStackTrace();
        }
    }
}
