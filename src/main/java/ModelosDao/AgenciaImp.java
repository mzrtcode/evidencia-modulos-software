package ModelosDao;

import Configuracion.Conexion;
import Modelos.Agencia;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AgenciaImp implements IAgencia{

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Agencia agencia = new Agencia();
    @Override
    public List<Agencia> listar() {
        ArrayList<Agencia> lista = new ArrayList<>();
        String sql = "SELECT * FROM agencias";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Agencia agencia = new Agencia(); // Crear una nueva instancia en cada iteración

                agencia.setId(rs.getInt("id"));
                agencia.setNombre(rs.getString("nombre"));
                agencia.setCodigo_interno(rs.getString("codigo_interno"));
                agencia.setDireccion(rs.getString("direccion"));
                agencia.setEstado(rs.getInt("estado") == 1);

                lista.add(agencia);
            }
        } catch (Exception e) {
            // Manejo de excepciones
        }
        return lista;
    }

    @Override
    public Agencia obtenerPorId(int id) {
        String sql = "SELECT * FROM agencias WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id); // Establecer el valor del parámetro id
            rs = ps.executeQuery();
            while(rs.next()){
                agencia.setId(rs.getInt("id"));
                agencia.setNombre(rs.getString("nombre"));
                agencia.setCodigo_interno(rs.getString("codigo_interno"));
                agencia.setDireccion(rs.getString("direccion"));
                agencia.setEstado(rs.getInt("estado") == 1);
            }
        } catch (Exception e) {
            // Manejo de excepciones
        }
        return agencia;
    }


    @Override
    public boolean editar(Agencia agencia) {

        String sql = "UPDATE agencias SET nombre=?, codigo_interno=?, direccion=?, estado=? WHERE id=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, agencia.getNombre());
            ps.setString(2, agencia.getCodigo_interno());
            ps.setString(3, agencia.getDireccion());
            ps.setString(4, agencia.isEstado() ? "true" : "false");
            ps.setInt(5, agencia.getId());
            ps.executeUpdate();


        }catch (Exception e) {
            // Manejo de excepciones
        }
        return false;
    }

    @Override
    public boolean agregar(Agencia agencia) {
        String sql = "INSERT INTO agencias (nombre, codigo_interno, direccion) VALUES (?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, agencia.getNombre());
            ps.setString(2, agencia.getCodigo_interno());
            ps.setString(3, agencia.getDireccion());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            // Manejo de excepciones
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE from agencias WHERE id=?";
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
