package com.connectiondb;

import java.sql.SQLException;
import java.sql.PreparedStatement;

public class HandleDBInit extends HandleDbConnected {
   protected String tableTaskName1 = "tasks_not_none";
   protected String tableTaskName2 = "tasks_done";
   protected String table1ColumnName = "task";
   protected String table2ColumnName = "task";
   public HandleDBInit(){
      super("jdbc:mysql://localhost:3306/tasks", "root", "67220467");
      this.intConnect();
      this.createAllTables();
   }
   private void intConnect(){
      try{
         this.connect();
      }catch (SQLException e){
         System.out.println(e);
      }
   }
   private void createAllTables(){
      String sql1 = "CREATE TABLE IF NOT EXISTS " + this.tableTaskName1 + " (" +
              "id INT AUTO_INCREMENT PRIMARY KEY, " +
              this.table1ColumnName + " VARCHAR(50)" +
              ")";

      String sql2 = "CREATE TABLE IF NOT EXISTS " + this.tableTaskName2 + " (" +
              "id INT AUTO_INCREMENT PRIMARY KEY, " +
              this.table2ColumnName + " VARCHAR(50)" +
              ")";

      try{
         PreparedStatement pstmt1 = this.connection.prepareStatement(sql1);
         PreparedStatement pstmt2 = this.connection.prepareStatement(sql2);

         pstmt1.executeUpdate();
         pstmt2.executeUpdate();
      } catch (SQLException e) {
         System.out.println("ERROR: " + e.getMessage());
      }
   }
}
