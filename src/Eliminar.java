import java.sql.ResultSet;
import java.sql.SQLException;

public class Eliminar {
	public static String[] eliminar() throws SQLException {
        ResultSet usuarios;
        int i = 0;
        int a = 0;
        usuarios = conexion.EjecutarSentencia("Select Articulo from articulos");
        while (usuarios.next()) {
            a++;
        }
        String[] usuario = new String[a];
        usuarios.beforeFirst();
        while(usuarios.next()) {
            usuario[i]=usuarios.getString("Articulo");
            i++;
        }
        return usuario;
    }

}
