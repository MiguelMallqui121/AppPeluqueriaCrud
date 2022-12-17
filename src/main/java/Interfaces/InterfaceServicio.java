package Interfaces;

import java.util.List;
import modelo.Servicio;

public interface InterfaceServicio {
    public String agregar (Servicio s);
    public String eliminar (int cod);
    public String modificar(Servicio s);
    public List<Servicio> listar();
    public Servicio getOne(int cod);
}
