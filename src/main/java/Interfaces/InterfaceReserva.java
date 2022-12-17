package Interfaces;

import java.util.List;
import modelo.Reserva;

public interface InterfaceReserva {
     public int agregar (Reserva r);
    public String eliminar (int cod);
    public String modificar(Reserva r);
    public List<Reserva> listar();
    public List<Reserva> ordenarPorFecha();
    public Reserva getOne(int cod);
    public Reserva ultimaReserva();
}
