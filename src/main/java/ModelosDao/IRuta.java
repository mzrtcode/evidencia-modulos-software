package ModelosDao;

import Modelos.Ruta;
import java.util.List;

public interface IRuta {
    
    public List listar(); // Método para listar todas las rutas
    public Ruta obtenerPorId(int id); // Método para obtener una ruta por su ID
    public boolean editar(Ruta ruta); // Método para editar una ruta
    public boolean agregar(Ruta ruta); // Método para agregar una nueva ruta
    public boolean eliminar(int id); // Método para eliminar una ruta por su ID
    
}
