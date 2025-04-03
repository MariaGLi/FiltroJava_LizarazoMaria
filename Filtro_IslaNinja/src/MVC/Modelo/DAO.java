package MVC.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO extends Conexion{
    
        
    // Obtener todos los ninjas
    public List<Ninja> obtenerTodos() {
        List<Ninja> lista = new ArrayList<>();
        Connection con = getConexion();
        
        String sql = "SELECT * FROM Ninja";
        try ( PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                lista.add(new Ninja(
                        rs.getInt("id"), 
                        rs.getString("nombre"), 
                        rs.getString("rango"),
                        rs.getString("aldea")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    //agregar mision a un ninja
    public void agregar(MisionNinja mision) {
        Connection con = getConexion(); 
        
        String sql = "INSERT INTO Mision_Ninja (id_ninja, id_mision, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql);){
            ps.setInt(1, mision.getId_ninja());
            ps.setInt(2, mision.getId_mision());
            ps.setString(3, mision.getFechaInicio());
            ps.setString(4, mision.getFechaFin());
            ps.executeUpdate();
            System.out.println("Misión para el ninja agg con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
