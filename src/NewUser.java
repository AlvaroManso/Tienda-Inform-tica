import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewUser extends JFrame {

	private JPanel contentPane;
	private JPasswordField Password;
	private JTextField Username;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnCreateUser;

	public NewUser(String usuario, String Articulo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 463, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 458, 350);
		contentPane.add(panel);
		panel.setLayout(null);

		Password = new JPasswordField();
		Password.setBounds(313, 200, 135, 20);
		panel.add(Password);

		Username = new JTextField();
		Username.setBounds(313, 104, 135, 20);
		panel.add(Username);
		Username.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(0, 0, 461, 353);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(NewUser.class.getResource("/Imagenes/logo.png")));

		lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(313, 79, 103, 14);
		panel.add(lblUsername);

		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(313, 175, 70, 14);
		panel.add(lblPassword);

		btnCreateUser = new JButton("Create User");
		btnCreateUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String usuario = Username.getText();
					String password = Password.getText();
					if(comprobarUsuario(usuario)) {
						// INSERT INTO `clientes`(`usuario`, `contraseña`) VALUES ([value-1],[value-2])
						conexion.EjecutarUpdate("INSERT INTO `clientes`(`usuario`, `contraseña`) VALUES ('"
								+ usuario + "','" + password+ "')");
					}else {
						JOptionPane.showMessageDialog(null, "El usuario ya existe en la BBDD");
					}
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCreateUser.setBounds(334, 248, 114, 23);
		panel.add(btnCreateUser);

		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				Login a = new Login(usuario, Articulo);
				dispose();
				a.setVisible(true);
			}
		});
		btnLogin.setBounds(334, 293, 114, 23);
		panel.add(btnLogin);
	}
	public static boolean comprobarUsuario(String usuario)  {
		try {
			if (conexion.EjecutarSentencia("SELECT * FROM clientes WHERE usuario='"+usuario+"'").next()) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
