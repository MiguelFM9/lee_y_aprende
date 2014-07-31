/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import beans.BeanArea;
import beans.BeanAutor;
import beans.BeanEditorial;
import beans.BeanLibro;
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
public class DaoLibro {
    public void registrarLibro(BeanLibro beanLibro) {

        try {
            Connection conexion = utilerias.ConexionSQLServer.getConnection();
            String sentencia = "INSERT INTO libro (isbn, titulo, num_pag, editorial_id, area_id) VALUES (?,?,?,?,?);";
            PreparedStatement ps = conexion.prepareCall(sentencia);
            ps.setString(1, beanLibro.getIsbn());
            ps.setString(2, beanLibro.getTitulo());
            ps.setInt(3, beanLibro.getNum_pag());
            ps.setInt(4, beanLibro.getEditorial().getId());
            ps.setInt(5, beanLibro.getArea().getId());
//            ps.setInt(6, beanLibro.getAutor().getId());

            ps.executeUpdate();

            ps.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro");
            e.printStackTrace();
        }

    }
     public List<BeanAutor> consultarAutor(){
        List<BeanAutor> lista = new ArrayList<BeanAutor>();
        try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia="Select * from autor ";
             PreparedStatement ps= conexion.prepareStatement(sentencia);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 BeanAutor beanAutor = new BeanAutor(rs.getInt(1), rs.getString(2));
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
     public List<BeanArea> consultarArea(){
        List<BeanArea> lista = new ArrayList<BeanArea>();
        try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia="Select * from area ";
             PreparedStatement ps= conexion.prepareStatement(sentencia);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 BeanArea beanArea = new BeanArea( rs.getInt(1),rs.getString(2));
               lista.add(beanArea);
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

    public List<BeanEditorial> consultarEditorial() {
        List<BeanEditorial> lista = new ArrayList<BeanEditorial>();
        try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia="Select * from editorial ";
             PreparedStatement ps= conexion.prepareStatement(sentencia);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 BeanEditorial beanEditorial = new BeanEditorial( rs.getInt(1), rs.getString(2));
               lista.add(beanEditorial);
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

    public List<String[]> busquedaLibro(String busqueda) {
          List<String[]> lista = new ArrayList <String[]>();
         try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia="SELECT libro.libro_id, libro.titulo, autor.nombre FROM libro join escribe on libro.libro_id=escribe.libro_id join autor on autor.autor_id=escribe.autor_id where titulo like '%"+busqueda+"%';";
            PreparedStatement ps =conexion.prepareStatement(sentencia);
             ResultSet rs=ps.executeQuery();
            while(rs.next()){
                lista.add(new String[]{rs.getInt(1)+"", rs.getString(2),rs.getString(3)});
                
            }
            
            ps.close();
            conexion.close();
        } catch (Exception e) {
            
            System.out.println("Error al buscar");
            e.printStackTrace();
        }
        
        return lista;
    }
    
}
