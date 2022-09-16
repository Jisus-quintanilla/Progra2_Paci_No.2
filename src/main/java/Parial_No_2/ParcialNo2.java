/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parial_No_2;

import java.sql.*;

/**
 *
 * @author Usuario
 */
public class ParcialNo2 {
    
    public static void VendedoresMeses(){

        String url = "jdbc:mysql://localhost:3306/dbempleados?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
     
            Connection conexion = DriverManager.getConnection(url,"root","Jisus55");
    
            Statement sentencia = conexion.createStatement();

            String sql = "SELECT * FROM tb_empleados";

            ResultSet resultado = sentencia.executeQuery(sql);

            while(resultado.next()){
                System.out.println("\nNiv ="+resultado.getInt(1));
                System.out.println("Nombre = "+resultado.getString(2));
                System.out.println("Enero ="+resultado.getInt(3));
                System.out.println("Febrero ="+resultado.getInt(4));
                System.out.println("Marzo ="+resultado.getInt(5));
                System.out.println("Abril ="+resultado.getInt(6));
                System.out.println("Mayo ="+resultado.getInt(7));
                System.out.println("Junio ="+resultado.getInt(8));
            }
        } catch (SQLException ex) {
            System.out.println("Hubo hay problemas:"+ex.getMessage());
        }
}
    
    public static void Actualizar(int niv, String nombre){
        int cantidad1 = 0;
        String url = "jdbc:mysql://localhost:3306/dbempleados?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {

            Connection conexion = DriverManager.getConnection(url,"root","Jisus55");

            Statement sentencia = conexion.createStatement();

            String sql = "Update tb_empleados set vendedor = '"+nombre+"' where niv = "+niv ;
            System.out.println(sql);

            sentencia.execute(sql);
     
            
        } catch (SQLException ex) {
            System.out.println("Hubo clavo:"+ex.getMessage());
        }
}
    
     public static void SumasMesesVentas(){

        String url = "jdbc:mysql://localhost:3306/dbempleados?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {

            Connection conexion = DriverManager.getConnection(url,"root","Jisus55");

            Statement sentencia = conexion.createStatement();

            String sql = "Select niv, vendedor, (enero+febrero+marzo+abril+mayo+junio) from tb_empleados";
            System.out.println(sql);

            ResultSet resultado = sentencia.executeQuery(sql);
            
            while(resultado.next()){
                System.out.println("\nNiv ="+resultado.getInt(1));
                System.out.println("Vendedor = "+resultado.getString(2));
                System.out.println("Total meses venta ="+resultado.getInt(3));   
            }
     
            
        } catch (SQLException ex) {
            System.out.println("Hubo clavo:"+ex.getMessage());
        }
}
     
     public static void MesesTotal(){

        String url = "jdbc:mysql://localhost:3306/dbempleados?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {

            Connection conexion = DriverManager.getConnection(url,"root","Jisus55");

            Statement sentencia = conexion.createStatement();

            String sql = "select sum(enero), sum(febrero), sum(marzo), sum(abril), sum(mayo), sum(junio) from tb_empleados";
            System.out.println(sql);

            ResultSet resultado = sentencia.executeQuery(sql);
            
            while(resultado.next()){
                System.out.println("Sumas meses Total");
                System.out.println("Enero ="+resultado.getInt(1));
                System.out.println("Febrero ="+resultado.getInt(2));
                System.out.println("Marzo ="+resultado.getInt(3));
                System.out.println("Abril ="+resultado.getInt(4));
                System.out.println("Mayo ="+resultado.getInt(5));
                System.out.println("Junio ="+resultado.getInt(6));   
            }
     
            
        } catch (SQLException ex) {
            System.out.println("Hubo clavo:"+ex.getMessage());
        }
}
     
     public static void Eliminar(int niv){
        int cantidad1 = 0;
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
//        VendedoresMeses();
//        Actualizar(6,"Paco");
//        SumasMesesVentas();
//          MesesTotal();
//        Eliminar(7);
    }
}
