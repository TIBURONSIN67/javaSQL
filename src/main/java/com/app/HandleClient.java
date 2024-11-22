package com.app;
import com.connectiondb.HandleDB;
import java.util.Scanner;

public class HandleClient {
   protected HandleDB serve;
   private boolean exit;
   private String userInputOption;
   protected Scanner scanner;
   protected String task;
   protected void run(){
      scanner = new Scanner(System.in);
      exit = false;
      serve = new HandleDB();
      while (!exit){
         showOptions();
         System.out.print("Elija una opcion : ");
         userInputOption = scanner.nextLine();

         switch (userInputOption){
            case "1":
               System.out.print("cual es la tarea que decea agregar :");
               task = scanner.nextLine();
               serve.addTask(task);
               break;
            case "3":
               System.out.println(serve.listTasks1());
         }
      }
   }
   protected void showOptions(){
      String options = "1.    AGREGAR TAREA"+"\n"+
              "2.    MARKAR TAREA"+"\n"+
              "3.    VER TODAS LAS TAREAS PENDIENTES"+"\n"+
              "4.    SALIR"+"\n";
      System.out.println(options);
   }
}
