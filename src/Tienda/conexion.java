package Tienda;




import java.sql.*;
import javax.swing.JOptionPane;

public class conexion {
	
	static String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String dbName = "trabajo";
	static String url = "jdbc:mysql://localhost:3306/" + dbName + timeZone + "&useSSL=false" ;
	static String user = "root";
	static String pass = "manolo";
	//static String driver = "com.mysql.cj.jdbc.Driver";
    
    static Connection conexion;
    static Statement consulta;
    static ResultSet resultado;
    
    public static void Conectar(){
    	try {
       //    Class.forName(driver) ;
           conexion = DriverManager.getConnection(url, user, pass);
           //System.out.println("Base de datos clientes.fdb situada en :\n "+url);
           consulta = conexion.createStatement();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
    public static Connection conexionBBDD () throws SQLException {
   	 String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
   	 String dbName = "Trabajo";
   	 String url = "jdbc:mysql://localhost:3306/" + dbName + timeZone + "&useSSL=false";
   	 String user = "root";
   	 String pass = "manolo";
   	 Connection conexion2;
   	 Statement consulta;
   	 ResultSet resultado;
   	conexion2 = DriverManager.getConnection(url, user, pass);
		return conexion2;
   	
   }
    
    public static ResultSet EjecutarSentencia(String Sentencia){
        try {
        	resultado = consulta.executeQuery(Sentencia);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return resultado;
    }
      
    public static void EjecutarUpdate(String Sentencia) throws SQLException{
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    	}catch(SQLException e){

    	} 
    }
    
    public static void CerrarConexion(){
        try{
        	consulta.close();
        }catch(Exception e){}
    }
    
}
