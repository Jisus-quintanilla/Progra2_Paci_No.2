/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra2.parci2;

import java.sql.*;

/**
 *
 * @author Usuario
 */
public class Pacial2 {
    
public static void Parci2(){
    
int TotalMeses;
int TotalEnero = 0, TotalFebrero = 0, TotalMarzo = 0, TotalAbril = 0, TotalMayo = 0, TotalJunio = 0;
int TotalTodo = 0;

        String url = "jdbc:mysql://localhost:3306/dbempleados?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
       
            Connection conexion = DriverManager.getConnection(url,"root","Jisus55");
            
            Statement sentencia = conexion.createStatement();
            
            String sql = "select * from tb_empleados ";
           
            ResultSet resultado = sentencia.executeQuery(sql);

            System.out.println("Niv\tVendedor\tEnero\tFebrero\tMarzo\tAbril\tMayo\tJunio\tTotal fila meses");
            while(resultado.next()){
                TotalMeses = resultado.getInt(3)+resultado.getInt(4)+resultado.getInt(5)+resultado.getInt(6)+
                resultado.getInt(7)+resultado.getInt(8); 
                
                TotalEnero = resultado.getInt(3)+TotalEnero;
                TotalFebrero = resultado.getInt(4)+TotalFebrero;
                TotalMarzo = resultado.getInt(5)+TotalMarzo;
                TotalAbril = resultado.getInt(6)+TotalAbril;
                TotalMayo = resultado.getInt(7)+TotalMayo;
                TotalJunio = resultado.getInt(8)+TotalJunio;
                TotalTodo = TotalMeses+TotalTodo;

                System.out.println(resultado.getInt(1)+"\t"+resultado.getString(2)+"\t\t"+resultado.getInt(3)+
                "\t"+resultado.getInt(4)+"\t"+resultado.getInt(5)+"\t"+resultado.getInt(6)+
                "\t"+resultado.getInt(7)+"\t"+resultado.getInt(8)+"\t"+TotalMeses);
            }    
            
        } catch (SQLException ex) {
            System.out.println("Hubo clavo:"+ex.getMessage());
        }
        
        System.out.println("Total columna mes\t"+TotalEnero+"\t"+TotalFebrero+"\t"+TotalMarzo+"\t"+TotalAbril+
        "\t"+TotalMayo+"\t"+TotalJunio+"\t"+TotalTodo);
}

public static void Actualizar(int niv, String nombre){

        String url = "jdbc:mysql://localhost:3306/dbempleados?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
       
            Connection conexion = DriverManager.getConnection(url,"root","Jisus55");
            
            Statement sentencia = conexion.createStatement();
            
            int sql = sentencia.executeUpdate("update tb_empleados set vendedor = '"+nombre+"' where niv = "+niv);
            
        } catch (SQLException ex) {
            System.out.println("Hubo clavo:"+ex.getMessage());
        }
}

public static void Eliminar(int niv){
        
        String url = "jdbc:mysql://localhost:3306/dbempleados?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            Connection conexion = DriverManager.getConnection(url,"root","Jisus55");

            Statement sentencia = conexion.createStatement();

            String sql = "delete from tb_empleados where niv = "+niv ;
            String res = "alter table tb_empleados AUTO_INCREMENT 1";
            System.out.println(sql);

            sentencia.execute(sql);
            sentencia.execute(res);
     
        } catch (SQLException ex) {
            System.out.println("Hubo clavo:"+ex.getMessage());
        }
}

    public static void main(String[] args) {
        
        
//        Actualizar(6,"Polo");
        Eliminar(7);
        Parci2();
    }
}
