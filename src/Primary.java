import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Button;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Primary extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;

	public Primary(String usuario, String Articulo) {
		//creamos el panel
		setBackground(new Color(0, 0, 0));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		//añadimos una imagen
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(Primary.class.getResource("/Imagenes/logo.png")));
		lblNewLabel.setBounds(10, 39, 264, 320);
		panel.add(lblNewLabel);
		//creamos un boton, en este caso login
		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		//asignamos una accion en este caso llamamos a la ventana de login
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login a=new Login(usuario, Articulo);
				dispose();
				a.setVisible(true);
				
			}
		});
		
		btnNewButton.setBackground(UIManager.getColor("CheckBox.focus"));
		btnNewButton.setBorder(new LineBorder(new Color(221, 160, 221)));
		btnNewButton.setBounds(296, 125, 103, 51);
		panel.add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					NewUser a=new NewUser(usuario, Articulo);
					dispose();
					a.setVisible(true);
			}
		});
		btnSignUp.setBorder(new LineBorder(Color.MAGENTA));
		btnSignUp.setBounds(296, 239, 103, 51);
		panel.add(btnSignUp);

			
		}

	}

