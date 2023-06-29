package Modelos;

import java.sql.Date;

public class Empleado {
    
    private int id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String celular;
    private Date fecha_nacimiento;
    private String direccion;

    public Empleado(int id, String nombres, String apellidos, String correo, String celular, Date fecha_nacimiento, String direccion) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.celular = celular;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
    }

    public Empleado(String nombres, String apellidos, String correo, String celular, Date fecha_nacimiento, String direccion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.celular = celular;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
    }

    public Empleado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", celular='" + celular + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
