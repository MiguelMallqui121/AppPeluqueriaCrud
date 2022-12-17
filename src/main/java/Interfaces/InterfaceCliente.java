package Interfaces;

import java.util.List;
import modelo.Cliente;

public interface InterfaceCliente {
    public String agregar (Cliente e);
    public String eliminar (int cod);
    public String modificar(Cliente e);
    public List<Cliente> listar();
    public Cliente getOne(int cod);
}
