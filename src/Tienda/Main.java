package Tienda;
//llamamos a primary para abrir el programa
public class Main {

	public static void main(String[] args) {
		conexion.Conectar();
		Primary a = new Primary (null, null);
		a.setVisible(true);

	}

}
