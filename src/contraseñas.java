import java.sql.ResultSet;
import java.sql.SQLException;

public class contraseñas {
	
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
