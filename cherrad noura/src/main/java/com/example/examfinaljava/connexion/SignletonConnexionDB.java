package com.example.examfinaljava.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class SignletonConnexionDB {
        public static Connection connection;

        public static Connection getConnection(){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
            }catch (SQLException e){
                e.printStackTrace();
            }
            return connection;
        }
    }

