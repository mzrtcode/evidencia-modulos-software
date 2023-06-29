package ModelosDao;

import Configuracion.Conexion;
import Modelos.Empleado;
import Modelos.Ruta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoImp implements IEmpleado {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Empleado empleado = new Empleado();
    @Override
    public List<Empleado> listar() {
        ArrayList<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado(); // Crear una nueva instancia en cada iteración

                empleado.setId(rs.getInt("id"));
                empleado.setNombres(rs.getString("nombres"));
                empleado.setApellidos(rs.getString("apellidos"));
                empleado.setCorreo(rs.getString("correo"));
                empleado.setCelular(rs.getString("celular"));
                empleado.setFecha_nacimiento(Date.valueOf(rs.getString("fecha_nacimiento")));
                empleado.setDireccion(rs.getString("direccion"));
                lista.add(empleado);
            }
        } catch (Exception e) {
            // Manejo de excepciones
        }
        return lista;
    }

    @Override
    public Empleado obtenerPorId(int id) {
        String sql = "SELECT * FROM empleados WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id); // Establecer el valor del parámetro id
            rs = ps.executeQuery();
            while(rs.next()){
                empleado.setId(rs.getInt("id"));
                empleado.setNombres(rs.getString("nombres"));
                empleado.setApellidos(rs.getString("apellidos"));
                empleado.setCorreo(rs.getString("correo"));
                empleado.setCelular(rs.getString("celular"));
                empleado.setFecha_nacimiento(Date.valueOf(rs.getString("fecha_nacimiento")));
                empleado.setDireccion(rs.getString("direccion"));
            }
        } catch (Exception e) {
            // Manejo de excepciones
        }
        return empleado;
    }

    @Override
    public boolean editar(Empleado empleado) {
        String sql = "UPDATE empleados SET nombres=?, apellidos=?, correo=?, celular=?, fecha_nacimiento=?, direccion=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getNombres());
            ps.setString(2, empleado.getApellidos());
            ps.setString(3, empleado.getCorreo());
            ps.setString(4, empleado.getCelular());
            ps.setDate(5, empleado.getFecha_nacimiento());
            ps.setString(6, empleado.getDireccion());
            ps.setInt(7, empleado.getId());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            // Manejo de excepciones
        }
        return false;
    }


    @Override
    public boolean agregar(Empleado empleado) {
        String sql = "INSERT INTO empleados (nombres, apellidos, correo, celular, fecha_nacimiento, direccion) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getNombres());
            ps.setString(2, empleado.getApellidos());
            ps.setString(3, empleado.getCorreo());
            ps.setString(4, empleado.getCelular());
            ps.setDate(5, empleado.getFecha_nacimiento());
            ps.setString(6, empleado.getDireccion());
            System.out.println("Consulta SQL: " + ps.toString());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            // Manejo de excepciones
        }
        return false;
    }


    @Override
    public boolean eliminar(int id) {

        String sql = "DELETE from empleados WHERE id=?";
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

