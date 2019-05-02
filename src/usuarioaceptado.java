import java.sql.SQLException;

public class usuarioaceptado {
	public static boolean usuariocorrecto(String usuario, String claves) throws SQLException {
		int i = 0;
		String[] users = usuarios.usuario();
		String[] clave = contraseña.contraseña();
		while(i<users.length) {
			if(usuario.equals(users[i])) {
				if(claves.equals(clave[i])) {
					return true;
				}
			
			}
			i++;
		}
		return false;
	}
}
