
package cade;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
     public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String us = "system";
    public static final String pass = "system";

    public static Connection getConnnection() {
        Connection connection = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(URL, us, pass);

        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

}
    

