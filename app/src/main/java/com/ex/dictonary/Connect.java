package com.ex.dictonary;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Connect {

    public Connection connection(){

        Connection conn = null;
        String dbServer = "mssql-144251-0.cloudclusters.net"; // change it to your database server name
        int dbPort = 19725; // change it to your database server port
        String dbName = "deneme";
        String userName = "Admin";
        String password = "Admin123";
        String url = String.format("jdbc:jtds:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=true",
                dbServer, dbPort, dbName, userName, password);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return conn;

    }
}
