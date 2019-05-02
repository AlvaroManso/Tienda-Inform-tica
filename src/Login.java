import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JPasswordField password;
	private JPasswordField Password;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conexion.Conectar();
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 408);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Name = new JTextField();
		Name.setBackground(Color.LIGHT_GRAY);
		Name.setBounds(304, 93, 213, 20);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/logo.png")));
		lblNewLabel.setBounds(10, 11, 264, 318);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Password");
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(304, 210, 74, 14);
		contentPane.add(lblLogin);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(304, 68, 46, 14);
		contentPane.add(lblName);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			try {
				boolean entrar=usuarioaceptado.usuariocorrecto(Name.getText(), Password.getText());
				if (entrar) {
					Principal a=new Principal();
					dispose();
					a.setVisible(true);
				}else {
					System.out.println("error");
					JOptionPane.showMessageDialog(null, "error", "Contraseña o usuario incorrecto",JOptionPane.ERROR_MESSAGE);
					
				}
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}		

				
		}
		});
		btnLogin.setBounds(412, 306, 89, 23);
		contentPane.add(btnLogin);
		
		Password = new JPasswordField();
		Password.setBackground(Color.LIGHT_GRAY);
		Password.setBounds(304, 235, 213, 20);
		contentPane.add(Password);
	}
}
