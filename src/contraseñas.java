import java.sql.ResultSet;
import java.sql.SQLException;

public class contraseña {
	
	public static String[] contraseña() throws SQLException {
		ResultSet contraseñas;
		int i = 0;
		contraseñas = conexion.EjecutarSentencia("Select contraseña from clientes");
		String[] contraseña = new String[2];
		while(contraseñas.next()) {
			contraseña[i]=contraseñas.getString("contraseña");
			i++;
		}
		return contraseña;
	}
}
