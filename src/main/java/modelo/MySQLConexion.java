package modelo;
import java.sql.*;
public class MySQLConexion {
    public static Connection getConexion(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost/peluqueria";
//            String url="jdbc:mysql://localhost:3307/peluqueria_v4";
            String usr="root";
            String psw="*SoloLeveling20*";
            con= DriverManager.getConnection(url,usr,psw);
            System.out.println("Conexión exitosa");
        } catch(ClassNotFoundException ex){
            System.out.println("No se encontro Driver");
        } catch(SQLException ex){
            System.out.println("Error con la base de datos");
        }
        return con; 
    }
}
