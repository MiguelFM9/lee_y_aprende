/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import beans.BeanArea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilerias.ConexionSQLServer;

/**
 *
 * @author MiguelAngel
 */
public class DaoArea {

    public static void eliminarAutor(String eliminar) {
        try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia="update area set activo='0' where descripcion='"+eliminar+"';";
            PreparedStatement ps =conexion.prepareCall(sentencia);
            ps.executeUpdate();
            ps.close();
            conexion.close();
        } catch (Exception e) {
            
            System.out.println("Error al eliminar");
            e.printStackTrace();
        }
    }

    public void registrarArea(BeanArea beanArea) {

        try {
            Connection conexion = utilerias.ConexionSQLServer.getConnection();
            String sentencia = "INSERT INTO area (descripcion) VALUES (?);";
            PreparedStatement ps = conexion.prepareCall(sentencia);
            ps.setString(1, beanArea.getNombre());

            ps.executeUpdate();

            ps.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro");
            e.printStackTrace();
        }

    }

    public List<String[]> consultarArea(){
         List<String[]> lista = new ArrayList <String[]>();
         try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia="SELECT * FROM area where activo ='1';";
            PreparedStatement ps =conexion.prepareStatement(sentencia);
             ResultSet rs=ps.executeQuery();
            while(rs.next()){
                lista.add(new String[]{rs.getInt(1)+"",rs.getString(2)});
                
            }
            
            ps.close();
            conexion.close();
        } catch (Exception e) {
            
            System.out.println("Error al actualizar");
            e.printStackTrace();
        }
        return lista;
    }
    public List<String []> busquedaAreas(String busqueda){
        List<String[]> lista = new ArrayList <String[]>();
         try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia="SELECT area_id, descripcion FROM area where descripcion like '%"+busqueda+"%'";
            PreparedStatement ps =conexion.prepareStatement(sentencia);
             ResultSet rs=ps.executeQuery();
            while(rs.next()){
                lista.add(new String[]{rs.getInt(1)+"", rs.getString(2)});
                
            }
            
            ps.close();
            conexion.close();
        } catch (Exception e) {
            
            System.out.println("Error al buscar");
            e.printStackTrace();
        }
        return lista;
    }

    public String[] editarArea(String editar) {
  
        String[] resultado= new String[1];
        try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia="SELECT descripcion FROM area where descripcion ='"+editar+"';";
            PreparedStatement ps =conexion.prepareStatement(sentencia);
            ResultSet rs=ps.executeQuery();
            rs.next();
              resultado[0]=rs.getString(1);
                
            
            
            ps.close();
            conexion.close();
        } catch (Exception e) {
            
            System.out.println("Error al buscar");
            e.printStackTrace();
        }
        
        return resultado;
    }

    public void guardarArea(String text, String[]resultado) {
        try {
            Connection conexion = utilerias.ConexionSQLServer.getConnection();
            String sentencia = "update area set descripcion='"+text+"' where descripcion='"+resultado[0]+"';";
            PreparedStatement ps = conexion.prepareCall(sentencia);
           
            ps.executeUpdate();

            ps.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro");
            e.printStackTrace();
        }
    }

   
   
}

