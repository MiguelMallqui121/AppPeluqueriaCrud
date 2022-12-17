package Interfaces;

import java.util.List;
import modelo.Empleado;

public interface InterfaceEmpleado {
    public String agregar (Empleado e);
    public String eliminar (int cod);
    public String modificar(Empleado e);
    public List<Empleado> listar();
    public Empleado getOne(int cod);
    public int ValidarEmpleado(Empleado e);
}
