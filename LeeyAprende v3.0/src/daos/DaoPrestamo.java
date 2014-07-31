/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import beans.BeanPrestamo;
import beans.BeanUsuario;
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
public class DaoPrestamo {
     public List<BeanUsuario> consultarUsuario(){
        List<BeanUsuario> lista = new ArrayList<BeanUsuario>();
        try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia="Select usuario_id from usuario ";
             PreparedStatement ps= conexion.prepareStatement(sentencia);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 BeanUsuario beanAutor = new BeanUsuario( rs.getString(1),null,null,null,null);
               lista.add(beanAutor);
            }
             ps.execute();
             
             
             
             
             ps.close();
             conexion.close();
        } catch (Exception e) {
            System.out.println("Error al consultar");
            e.printStackTrace();
        }
        return lista;
    }
     public void registrarPrestamo(BeanPrestamo beanPrestamo) {

        try {
            Connection conexion = utilerias.ConexionSQLServer.getConnection();
            String sentencia = "INSERT INTO prestamo (fecha_devolucion, ejemplar_id, usuario_id) VALUES (?,?,?);";
            PreparedStatement ps = conexion.prepareCall(sentencia);
            ps.setString(1, beanPrestamo.getFechaDevolucion());
//            ps.setString(2, beanPrestamo.getBeanEjemplar());
//            ps.setString(3, beanPrestamo.getBeanUsuario());
            

            ps.executeUpdate();

            ps.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro");
            e.printStackTrace();
        }

    }
     public  List<String[]> consultarPrestamo(){
         List<String[]> lista = new ArrayList <String[]>();
         try {
             Connection conexion = utilerias.ConexionSQLServer.getConnection();
             String sentencia ="Select prestamo.prestamo_id, prestamo.fecha_prestamo, prestamo.fecha_devolucion, prestamo.ejemplar_id, usuario.nombre,prestamo.usuario_id  from prestamo join usuario on prestamo.usuario_id=usuario.usuario_id;";
             PreparedStatement ps =conexion.prepareStatement(sentencia);
              ResultSet rs=ps.executeQuery();
            while(rs.next()){
                lista.add(new String[]{rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6)});
                
            }
            
            ps.close();
            conexion.close();
         } catch (Exception e) {
              System.out.println("Error al actualizar");
            e.printStackTrace();
         }
         return lista;
     }
}
