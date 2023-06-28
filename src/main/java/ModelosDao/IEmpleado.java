package ModelosDao;

import Modelos.Empleado;
import java.util.List;

public interface IEmpleado {
    
    public List listar(); // Método para listar todas los Empleados
    public Empleado obtenerPorId(int id); // Método para obtener una Empleado por su ID
    public boolean editar(Empleado empleado); // Método para editar una Empleado
    public boolean agregar(Empleado empleado); // Método para agregar un nuevo Empleado
    public boolean eliminar(int id); // Método para eliminar un Empleado por su ID
    
}
