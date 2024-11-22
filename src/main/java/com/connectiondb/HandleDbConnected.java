package com.connectiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class HandleDbConnected {
   private String url,user,password;
   protected Connection connection;
   public HandleDbConnected(String url, String user, String password){
      this.url = url;
      this.user = user;
      this.password = password;
      this.connection = null;
   }
   protected void connect() throws SQLException{
      try {
         connection = DriverManager.getConnection(url, user, password);
      }catch (SQLException e) {
         throw new SQLException("No se pudo conectar a la base de datos", e);
      }
   }
   protected void disconnect() throws SQLException{
      try {
         if (connection != null) {
            connection.close();
         }else{
            throw new SQLException("no tienes una conexion establecida");
         }
      }catch (SQLException e){
         throw new SQLException("No se pudo desconectar de la base de datos", e);
      }
   }
}
