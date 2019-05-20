package Tienda;

import java.sql.ResultSet;
import java.sql.SQLException;

public class contraseñas {
	//Creamos una funcion que seleccione las contraseñas de los usuarios de la base de datos
	public static String[] contraseña() throws SQLException {
		ResultSet contraseñas;
		int i = 0;
		int a = 0;
		contraseñas = conexion.EjecutarSentencia("Select contraseña from clientes");
		
		while (contraseñas.next()) {
			a++;
			}
			contraseñas.beforeFirst();
			String[] contraseña = new String[a];
		
		while(contraseñas.next()) {
			contraseña[i]=contraseñas.getString("contraseña");
			i++;
		}
		return contraseña;
	}
}
