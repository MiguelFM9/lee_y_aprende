package daos;

import beans.BeanUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import leeyaprende.Usuario;
import utilerias.ConexionSQLServer;

public class DaoUsuario {
    
    public void registrarUsuario(BeanUsuario beanUsuario) {

        try {
            Connection conexion = utilerias.ConexionSQLServer.getConnection();
            String sentencia = "INSERT INTO usuario (nombre,direccion,telefono,email,tipo_usuario) VALUES (?,?,?,?,?);";
            PreparedStatement ps = conexion.prepareCall(sentencia);
            ps.setString(1, beanUsuario.getNombre());
            ps.setString(2, beanUsuario.getDireccion());
            ps.setString(3, beanUsuario.getTelefono());
            ps.setString(4, beanUsuario.getEmail());
            ps.setString(5, beanUsuario.getTipo_usuario());
            ps.executeUpdate();

            ps.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro");
            e.printStackTrace();
        }
    }
    public void actualizarUsuario(BeanUsuario beanUsuario, String NombreU) {

        try {
            Connection conexion = utilerias.ConexionSQLServer.getConnection();
            String sentencia = "update usuario set nombre='"+beanUsuario.getNombre()+"', direccion='"+beanUsuario.getDireccion()+"', telefono='"+beanUsuario.getTelefono()+"', email='"+beanUsuario.getEmail()+"' where nombre='"+NombreU+"'";
            PreparedStatement ps = conexion.prepareCall(sentencia);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario Acutalizado con exito");
            ps.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar");
            System.out.println("No se pudo actualizar");
            e.printStackTrace();
        }
    }

    public List<String[]> consultarUsuarios() {
        List<String[]> lista = new ArrayList<String[]>();
        try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia = "SELECT * FROM usuario;";
            PreparedStatement ps = conexion.prepareStatement(sentencia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new String[]{rs.getInt(1) + "", rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});

            }
            
            ps.close();
            conexion.close();
        } catch (Exception e) {

            System.out.println("Error al actualizar");
            e.printStackTrace();
        }
        return lista;
    }
     public String[] consultarUsuario(String nombre) {
         String[] resultado= new String[4];
        try {
            Connection conexion = ConexionSQLServer.getConnection();
            String sentencia = "SELECT nombre,direccion,telefono,email FROM usuario where nombre='"+nombre+"'";
            PreparedStatement ps = conexion.prepareStatement(sentencia);
            ResultSet rs = ps.executeQuery();
            rs.next();
            JOptionPane.showMessageDialog(null, "Usuario Encontrado");
            resultado[0]=rs.getString(1);
            resultado[1]=rs.getString(2);
            resultado[2]=rs.getString(3);
            resultado[3]=rs.getString(4);
            ps.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            System.out.println("Error al actualizar");
            e.printStackTrace();
        }
        return resultado;
    }
   
    public void eliminarUsuario() {

        try {
            String nombre=JOptionPane.showInputDialog("Ingrese el nombre completo del usuario");
            Connection conexion = utilerias.ConexionSQLServer.getConnection();
            String sentencia = "DELETE FROM usuario where nombre='"+nombre+"'";
            PreparedStatement ps = conexion.prepareCall(sentencia);
            ps.executeUpdate();

            ps.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se ah eliminado correctamente");
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro");
            e.printStackTrace();
        }

    }

}
