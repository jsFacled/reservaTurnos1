package com.dh.reservaTurnoOdontologico.configuraciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionH2 {
    public String driver = "org.h2.Driver";
    public String url = "jdbc:h2:~/test";
    public String username = "sa";
    public String password = "";

    public Connection conectarH2(){
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        }catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }



}
