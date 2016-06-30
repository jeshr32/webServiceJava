/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jesu
 */
public abstract class ConnectMySql {
    
    private Connection con;

    public Connection getCon() {
        return con;
    }


    public ConnectMySql()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String db_connect_string = "jdbc:mysql://localhost:3306/manolo";

            con = DriverManager.getConnection(db_connect_string,"root", "1234");


        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void desconectar(){
        con = null;
    }
}
