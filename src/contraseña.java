import java.sql.ResultSet;
import java.sql.SQLException;

public class contraseņa {
	
	public static String[] contraseņa() throws SQLException {
		ResultSet contraseņas;
		int i = 0;
		contraseņas = conexion.EjecutarSentencia("Select contraseņa from clientes");
		String[] contraseņa = new String[2];
		while(contraseņas.next()) {
			contraseņa[i]=contraseņas.getString("contraseņa");
			i++;
		}
		return contraseņa;
	}
}
