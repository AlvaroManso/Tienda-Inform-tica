package Tienda;

import java.sql.ResultSet;
import java.sql.SQLException;

public class contraseņas {
	//Creamos una funcion que seleccione las contraseņas de los usuarios de la base de datos
	public static String[] contraseņa() throws SQLException {
		ResultSet contraseņas;
		int i = 0;
		int a = 0;
		contraseņas = conexion.EjecutarSentencia("Select contraseņa from clientes");
		
		while (contraseņas.next()) {
			a++;
			}
			contraseņas.beforeFirst();
			String[] contraseņa = new String[a];
		
		while(contraseņas.next()) {
			contraseņa[i]=contraseņas.getString("contraseņa");
			i++;
		}
		return contraseņa;
	}
}
