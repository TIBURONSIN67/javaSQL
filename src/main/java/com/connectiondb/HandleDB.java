package com.connectiondb;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.HashMap;

public class HandleDB extends HandleDBInit{
   public HandleDB(){
      super();
   }
   public void addTask(String task){
      String sql = "INSERT INTO "+ this.tableTaskName1 + "(" + this.table1ColumnName + ") VALUES (?)";
      try  {
         PreparedStatement pstmt = this.connection.prepareStatement(sql);
         pstmt.setString(1, task);
         pstmt.executeUpdate();
      } catch (SQLException e) {
         System.out.println("ERROR : " + e);
      }
   }

   public Map<Integer, String> listTasks1() {
      String sql = "SELECT id, " + this.table1ColumnName + " FROM " + this.tableTaskName1 + ";";
      Map<Integer, String> tasks = new HashMap<>();

      try {
         PreparedStatement pstmt = this.connection.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
            int id = rs.getInt("id");
            String value = rs.getString(this.table1ColumnName);
            tasks.put(id, value);
         }
      } catch (SQLException e) {
         System.out.println("ERROR: " + e);
      }
      return tasks;
   }
   public Map<Integer, String> listTasks2() {
      String sql = "SELECT id, " + this.table2ColumnName + " FROM " + this.tableTaskName2 + ";";
      Map<Integer, String> tasks = new HashMap<>();

      try {
         PreparedStatement pstmt = this.connection.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
            int id = rs.getInt("id");
            String value = rs.getString(this.table2ColumnName);
            tasks.put(id, value);
         }
      } catch (SQLException e) {
         System.out.println("ERROR: " + e);
      }
      return tasks;
   }

   public void markTaskAlreadyDone(String task){
      String sql = "INSERT INTO " + this.tableTaskName2 + " (" + this.table2ColumnName + ") " +
              "SELECT " + this.table1ColumnName + " FROM " + this.tableTaskName1 +
              " WHERE " + this.table1ColumnName + " = ?";
      try  {
         PreparedStatement pstmt = this.connection.prepareStatement(sql);
         pstmt.setString(1, task);
         pstmt.executeUpdate();
      } catch (SQLException e) {
         System.out.println("ERROR : " + e);
      }
   }
   public void removeTask1(int taskId){
      String sql = "DELETE FROM "+this.tableTaskName1 + " WHERE id = ?";
      try  {
         PreparedStatement pstmt = this.connection.prepareStatement(sql);
         pstmt.setInt(1, taskId);
         pstmt.executeUpdate();
      } catch (SQLException e) {
         System.out.println("ERROR : " + e);
      }
   }
   public void removeTask2(int taskId){
      String sql = "DELETE FROM "+this.tableTaskName2 + " WHERE id = ?";
      try  {
         PreparedStatement pstmt = this.connection.prepareStatement(sql);
         pstmt.setInt(1, taskId);
         pstmt.executeUpdate();
      } catch (SQLException e) {
         System.out.println("ERROR : " + e);
      }
   }
}
