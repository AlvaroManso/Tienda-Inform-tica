package Tienda;

import java.sql.SQLException;

public class usuarioaceptado {
	public static boolean usuariocorrecto(String usuario, String passwords) throws SQLException {
		//creamos la funcion mediante dos string que revise todas las contrase�as y todos los usuarios de la base de datos
		int i = 0;
		String[] users = usuarios.usuario();
		String[] Password = contrase�as.contrase�a();
		while(i<users.length) {
			if(usuario.equals(users[i])) {
				if(passwords.equals(Password[i])) {
					return true;
				}
			
			}
			i++;
		}
		return false;
	}
}
