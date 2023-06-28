package ModelosDao;

import Configuracion.Conexion;
import Modelos.Ruta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RutaImp implements IRuta{

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Ruta ruta = new Ruta();

    @Override
    public List<Ruta> listar() {
        ArrayList<Ruta> lista = new ArrayList<>();
        String sql = "SELECT * FROM rutas";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ruta ruta = new Ruta(); // Crear una nueva instancia en cada iteración
                ruta.setId(rs.getInt("id"));
                ruta.setInicio(rs.getString("inicio"));
                ruta.setDestino(rs.getString("destino"));
                lista.add(ruta);
            }
        } catch (Exception e) {
            // Manejo de excepciones
        }
        return lista;
    }

    @Override
    public Ruta obtenerPorId(int id) {
        String sql = "SELECT * FROM rutas WHERE id="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ruta.setId(rs.getInt("id"));
                ruta.setInicio(rs.getString("inicio"));
                ruta.setDestino(rs.getString("destino"));
            }
        } catch (Exception e) {
            // Manejo de excepciones
        }
        return ruta;
    }

    @Override
    public boolean editar(Ruta ruta) {
        String sql = "UPDATE rutas SET inicio=?, destino=? WHERE id=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ruta.getInicio());
            ps.setString(2, ruta.getDestino());
            ps.setInt(3, ruta.getId());
            ps.executeUpdate();


        }catch (Exception e) {
            // Manejo de excepciones
        }
        return false;
    }
    @Override
    public boolean agregar(Ruta ruta) {
        String sql = "INSERT INTO rutas (inicio, destino) VALUES (?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ruta.getInicio());
            ps.setString(2, ruta.getDestino());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            // Manejo de excepciones
        }
        return false;
    }


    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE from rutas WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            // Manejo de excepciones
        }
        return false;
    }

}
