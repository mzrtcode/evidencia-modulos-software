package Modelos;

public class Agencia {
    
    private int id;
    private String nombre;
    private String codigo_interno;
    private String direccion;
    private boolean estado;

    public Agencia(int id, String nombre, String codigo_interno, String direccion, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.codigo_interno = codigo_interno;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Agencia(String nombre, String codigo_interno, String direccion, boolean estado) {
        this.nombre = nombre;
        this.codigo_interno = codigo_interno;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Agencia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo_interno() {
        return codigo_interno;
    }

    public void setCodigo_interno(String codigo_interno) {
        this.codigo_interno = codigo_interno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
