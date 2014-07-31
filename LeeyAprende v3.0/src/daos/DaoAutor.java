/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import beans.BeanAutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utilerias.ConexionSQLServer;

/**
 *
 * @author MiguelAngel
 */
public class DaoAutor {
     public void registrarAutor(BeanAutor beanAutor) {

        try {
            Connection conexion = utilerias.ConexionSQLServer.getConnection();
            String sentencia = "INSERT INTO autor (nombre) VALUES (?);";
            PreparedStatement ps = conexion.prepareCall(sentencia);
            ps.setString(1, beanAutor.getNombre());

            ps.executeUpdate();

            ps.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro");
            e.printStackTrace();
        }

    }
     public List<String[]> consultarAutor(){
         List<String[]> lista = new ArrayList <String[]>();
         try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia="SELECT * FROM autor where activo='1';";
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
     public List<String[]> busquedaAutor(String busqueda){
          List<String[]> lista = new ArrayList <String[]>();
         try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia="SELECT autor_id, nombre FROM autor where nombre like '%"+busqueda+"%';";
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
     public void eliminarAutor(String eliminar){
         try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia="update autor set activo='0' where nombre='"+eliminar+"';";
            PreparedStatement ps =conexion.prepareCall(sentencia);
            ps.executeUpdate();
            ps.close();
            conexion.close();
        } catch (Exception e) {
            
            System.out.println("Error al eliminar");
            e.printStackTrace();
        }
     }

    public String[] editarAutor(String editar) {
         String[] resultado= new String[1];
        try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia="SELECT nombre FROM autor where nombre ='"+editar+"';";
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

    public void guardarArea(String text, String[] resultado) {
        try {
            Connection conexion = utilerias.ConexionSQLServer.getConnection();
            String sentencia = "update autor set nombre='"+text+"' where nombre='"+resultado[0]+"';";
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

