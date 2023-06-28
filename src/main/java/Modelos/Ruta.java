package Modelos;

public class Ruta {
    
    private int id;
    private String inicio;
    private String destino;

    public Ruta(String inicio, String destino) {
        this.inicio = inicio;
        this.destino = destino;
    }

    public Ruta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    
}
