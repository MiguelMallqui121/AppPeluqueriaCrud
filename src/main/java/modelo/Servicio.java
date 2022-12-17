package modelo;

public class Servicio {
    private int id;
    private String nombre;
    private String duracion;
    private double costo;

    public Servicio() {
    }
    
    public Servicio(int id, String nombre, String duracion, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.costo = costo;
    }

    public Servicio(String nombre, String duracion, double costo) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.costo = costo;
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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
