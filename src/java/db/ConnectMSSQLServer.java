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
 * @author Lenovo
 */
public abstract class ConnectMSSQLServer {
    private Connection con;

    public Connection getCon() {
        return con;
    }


    public ConnectMSSQLServer()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String db_connect_string = "jdbc:sqlserver://192.168.133.1:1433;databaseName=manolo";

            con = DriverManager.getConnection(db_connect_string,"sa", "sa");


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
