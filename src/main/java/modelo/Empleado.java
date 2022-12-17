package modelo;

public class Empleado {
    private int codE;
    private String nombre;
    private String apellido;
    private String Correo;
    private int celular;
    private String distrito;
    private String direccion;
    private String username;
    private String password;
    private int cargo;

    public Empleado() {
    
    }

    public Empleado(int codE, String nombre, String apellido, String Correo, int celular, String distrito, String direccion, String username, String password, int cargo) {
        this.codE = codE;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Correo = Correo;
        this.celular = celular;
        this.distrito = distrito;
        this.direccion = direccion;
        this.username = username;
        this.password = password;
        this.cargo = cargo;
    }

    public Empleado(String nombre, String apellido, String Correo, int celular, String distrito, String direccion, String username, String password, int cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.Correo = Correo;
        this.celular = celular;
        this.distrito = distrito;
        this.direccion = direccion;
        this.username = username;
        this.password = password;
        this.cargo = cargo;
    }
    
    public Empleado(int codE, String nombre) {
        this.codE = codE;
        this.nombre = nombre;
    }

    public int getCodE() {
        return codE;
    }

    public void setCodE(int codE) {
        this.codE = codE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public String toString() {
        return this.getNombre();
    }
}
