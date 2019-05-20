package Tienda;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Editar extends JFrame {

	private JPanel contentPane;
	private JTextField Article;
	private JTextField Stock;
	private JTextField Price;

	
	public Editar(String articulo, String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 51, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.text);
		panel.setBackground(new Color(153, 51, 153));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("Back");
	btnBack.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				Principal a=new Principal(articulo, usuario);
				dispose();
				a.setVisible(true);
				}
		});
		btnBack.setBounds(335, 217, 89, 23);
		panel.add(btnBack);
		
		JLabel lblNombre = new JLabel("Article");
		lblNombre.setForeground(SystemColor.text);
		lblNombre.setBounds(10, 51, 66, 14);
		panel.add(lblNombre);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setForeground(SystemColor.text);
		lblStock.setBounds(10, 117, 46, 14);
		panel.add(lblStock);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(SystemColor.text);
		lblPrice.setBounds(10, 183, 46, 14);
		panel.add(lblPrice);
		
		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(227, 60, 60, 34);
		panel.add(lblNewLabel);
		
		JComboBox Type = new JComboBox();
		Type.setModel(new DefaultComboBoxModel(new String[] {}));
		Type.setBounds(200, 68, 110, 20);
		Type.addItem("Mantenimiento");
		Type.addItem("Hardware");
		Type.addItem("Software");
		Type.setBounds(311, 68, 113, 20);
		panel.add(Type);

		Price = new JTextField();
		Price.setColumns(10);
		Price.setBounds(49, 180, 86, 20);
		panel.add(Price);

		Stock = new JTextField();
		Stock.setColumns(10);
		Stock.setBounds(49, 114, 86, 20);
		panel.add(Stock);

		Article = new JTextField();
		Article.setColumns(10);
		Article.setBounds(49, 48, 86, 20);
		panel.add(Article);
	
		JButton Editar = new JButton("Editar");
		Editar.setForeground(new Color(255, 0, 255));
		Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//funcion que edita el articulo que hemos seleccionado en la ventana anterior
				String Tipo = (String) Type.getSelectedItem();
				try {
					conexion.EjecutarUpdate("UPDATE `articulos` SET `Tipos`='" + Tipo + "',`Articulo`='" + Article.getText()
							+ "',`Stock`='" + Stock.getText() + "',`Precio`='" + Price.getText()
							+ "' WHERE `Articulo`='" + articulo + "'");
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "El artículo se ha modificado correctamente ");
			}
		});
		Editar.setBounds(49, 217, 89, 23);
		panel.add(Editar);
	}
	}


