package Tienda;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Edit {
	//hacemos una seleccion de articulos
    public static String[] editar() throws SQLException {
        ResultSet clientes;
        int i = 0;
        int a = 0;
        clientes = conexion.EjecutarSentencia("Select Articulo from articulos");
        while (clientes.next()) {
            a++;
        }
        String[] usuario = new String[a];
        clientes.beforeFirst();
        while(clientes.next()) {
            usuario[i]=clientes.getString("Articulo");
            i++;
        }
        return usuario;
    }
}