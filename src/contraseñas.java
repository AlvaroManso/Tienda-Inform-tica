import java.sql.ResultSet;
import java.sql.SQLException;

public class contrase�a {
	
	public static String[] contrase�a() throws SQLException {
		ResultSet contrase�as;
		int i = 0;
		contrase�as = conexion.EjecutarSentencia("Select contrase�a from clientes");
		String[] contrase�a = new String[2];
		while(contrase�as.next()) {
			contrase�a[i]=contrase�as.getString("contrase�a");
			i++;
		}
		return contrase�a;
	}
}
