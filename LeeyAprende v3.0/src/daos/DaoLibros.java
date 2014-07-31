package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utilerias.ConexionSQLServer;

public class DaoLibros {
    
    public List<String[]> consultaLibros(String sentencia) {
        List<String[]> lista = new ArrayList<String[]>();
        try {
            Connection conexion = ConexionSQLServer.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sentencia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new String[]{rs.getString(1), rs.getString(2), rs.getInt(3)+"",rs.getString(4),rs.getString(5)});
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
