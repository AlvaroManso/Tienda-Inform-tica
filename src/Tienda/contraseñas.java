package Tienda;

import java.sql.ResultSet;
import java.sql.SQLException;

public class contrase�as {
	//Creamos una funcion que seleccione las contrase�as de los usuarios de la base de datos
	public static String[] contrase�a() throws SQLException {
		ResultSet contrase�as;
		int i = 0;
		int a = 0;
		contrase�as = conexion.EjecutarSentencia("Select contrase�a from clientes");
		
		while (contrase�as.next()) {
			a++;
			}
			contrase�as.beforeFirst();
			String[] contrase�a = new String[a];
		
		while(contrase�as.next()) {
			contrase�a[i]=contrase�as.getString("contrase�a");
			i++;
		}
		return contrase�a;
	}
}
