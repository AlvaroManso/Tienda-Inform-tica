import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;

	public Principal(String usuario, String Articulo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 423);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblArticulos = new JLabel("Article");
		lblArticulos.setBounds(10, 11, 128, 40);
		lblArticulos.setForeground(Color.WHITE);
		panel.add(lblArticulos);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/logo.png")));
		label.setBounds(251, 0, 273, 352);
		panel.add(label);
		
		JButton btnLogout = new JButton("Sign Out");
		btnLogout.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				Login a=new Login(usuario, Articulo);
				dispose();
				a.setVisible(true);

			}
		});
		btnLogout.setBounds(425, 340, 89, 23);
		panel.add(btnLogout);
		
		JButton btnGo = new JButton("Hardware");
		btnGo.setBackground(new Color(153, 51, 255));
		btnGo.setForeground(Color.MAGENTA);
		btnGo.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				Hardware a = null;
				try {
					a = new Hardware(usuario, Articulo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				a.setVisible(true);
			}
		});
		btnGo.setBounds(10, 46, 119, 23);
		panel.add(btnGo);
		
		JButton btnSoftware = new JButton("Software");
		btnSoftware.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				Software a = null;
				try {
					a = new Software(usuario, Articulo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				a.setVisible(true);
			}
		});
		btnSoftware.setForeground(Color.MAGENTA);
		btnSoftware.setBackground(new Color(153, 51, 255));
		btnSoftware.setBounds(10, 80, 119, 23);
		panel.add(btnSoftware);
		
		JButton btnMaintance = new JButton("Maintenance");
		btnMaintance.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				Maintenance a = null;
				try {
					a = new Maintenance(usuario, Articulo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				a.setVisible(true);
			}
		});
		btnMaintance.setForeground(Color.MAGENTA);
		btnMaintance.setBackground(new Color(153, 51, 255));
		btnMaintance.setBounds(10, 114, 119, 23);
		panel.add(btnMaintance);
	}
}
