package Tienda;

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
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JPasswordField password;
	private JPasswordField Password;

  	public Login(String usuario, String Articulo) {
  		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
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
		
		
		//creamos el boton de login con su funcion
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//creamos la funcion que controle si el usuario y la contraseña son correctos respecto a la base de datos
		btnLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			try {
				boolean entrar=usuarioaceptado.usuariocorrecto(Name.getText(), Password.getText());
				if (entrar) {
					Principal a=new Principal(usuario, Articulo);
					dispose();
					a.setVisible(true);
				}else {
					System.out.println("error");
					JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecto", "Error",JOptionPane.ERROR_MESSAGE);
					
				}
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}		

				
		}
		});
		btnLogin.setBounds(304, 306, 89, 23);
		contentPane.add(btnLogin);
		
		Password = new JPasswordField();
		Password.setBackground(Color.LIGHT_GRAY);
		Password.setBounds(304, 235, 213, 20);
		contentPane.add(Password);
		
		JButton btnNewUser = new JButton("New User");
		btnNewUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					NewUser a=new NewUser(usuario, Articulo);
					dispose();
					a.setVisible(true);
			}
		});
		btnNewUser.setBounds(428, 306, 89, 23);
		contentPane.add(btnNewUser);
		
		JButton btnInforme = new JButton("User report");
		btnInforme.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
			}
		});
		//preparamos el select para que verifique en la base de datos
		btnInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs=conexion.EjecutarSentencia("Select * from clientes");
                try {
                   
                	//añadimos un boton que carge los cambios en los clientes y los almacene en un archivo .csv
                    String ruta= "src/imagenes/cliente.csv";
                    FileWriter fichero=new FileWriter(ruta);

          
                    fichero.write("clientes; contraseña");

                    while(rs.next()) {
                        fichero.write(rs.getString("usuario")+";"+rs.getString("contraseña")+";"+"\n");
                    }
                    fichero.close();
                }catch(Exception e1) {
                    System.out.println(e1);
                }
            }
        });
				
		btnInforme.setBounds(20, 345, 134, 23);
		contentPane.add(btnInforme);
		//creamos un boton que almacene los cambios en los articulos en un archivo .csv
		JButton btnInformeArticulos = new JButton("Article report");
		btnInformeArticulos.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				ResultSet rs=conexion.EjecutarSentencia("Select * from articulos");
                try {
                   

                    String ruta= "src/imagenes/articulos.csv";
                    FileWriter fichero1=new FileWriter(ruta);

          
                    fichero1.write("Articulo; Stock, Price");

                    while(rs.next()) {
                        fichero1.write(rs.getString("Articulo")+";"+rs.getString("Stock")+";"+rs.getString("Precio")+";"+"\n");
                    }
                    fichero1.close();
                }catch(Exception e1) {
                    System.out.println(e1);
                }
            }
        });
		btnInformeArticulos.setBounds(184, 345, 134, 23);
		contentPane.add(btnInformeArticulos);
		
	}
}
