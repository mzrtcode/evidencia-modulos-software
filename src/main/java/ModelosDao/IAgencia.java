package ModelosDao;

import Modelos.Agencia;
import java.util.List;

public interface IAgencia {
    
    public List listar(); // Método para listar todas las agencias
    public Agencia obtenerPorId(int id); // Método para obtener una agencia por su ID
    public boolean editar(Agencia agencia); // Método para editar una agencia
    public boolean agregar(Agencia agencia); // Método para agregar una nueva agencia
    public boolean eliminar(int id); // Método para eliminar una agencia por su ID
    
}
