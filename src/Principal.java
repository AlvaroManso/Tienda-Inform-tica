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

public class Principal extends JFrame {

	private JPanel contentPane;

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblArticulos = new JLabel("Articulos");
		lblArticulos.setBounds(28, 90, 46, 14);
		panel.add(lblArticulos);
		
		JComboBox Articulo = new JComboBox();
		Articulo.addItem("Hardware");
		Articulo.addItem("Software");
		Articulo.addItem("Mantenimiento");
	
		Articulo.setBounds(84, 87, 102, 20);
		panel.add(Articulo);
	}
}
