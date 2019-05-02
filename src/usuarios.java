import java.sql.ResultSet;
import java.sql.SQLException;

public class usuarios {
	
	public static String[] usuario() throws SQLException {
		ResultSet usuarios;
		int i = 0;
		usuarios = conexion.EjecutarSentencia("SELECT usuario from clientes");
		String[] usuario = new String[2];
		while(usuarios.next()) {
			usuario[i]=usuarios.getString("usuario");
			i++;
		}
		return usuario;
	}


}
