
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddArticulo extends JFrame {

	private JPanel contentPane;
	private JTextField Article;
	private JTextField Stock;
	private JTextField Price;


	public AddArticulo(String usuario, String Articulo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 51, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 51, 153));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton Back = new JButton("Back");
		Back.setBounds(325, 217, 89, 23);
		Back.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				Principal a=new Principal(usuario, Articulo);
				dispose();
				a.setVisible(true);
			}
			});
		panel.add(Back);
		
		Article = new JTextField();
		Article.setColumns(10);
		Article.setBounds(59, 38, 86, 20);
		panel.add(Article);
		
		JLabel label = new JLabel("Article");
		label.setForeground(Color.WHITE);
		label.setBounds(20, 41, 66, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Stock");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(20, 107, 46, 14);
		panel.add(label_1);
		
		Stock = new JTextField();
		Stock.setColumns(10);
		Stock.setBounds(59, 104, 86, 20);
		panel.add(Stock);
		
		JLabel label_2 = new JLabel("Price");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(20, 173, 46, 14);
		panel.add(label_2);
		
		Price = new JTextField();
		Price.setColumns(10);
		Price.setBounds(59, 170, 86, 20);
		panel.add(Price);
		
		JLabel label_3 = new JLabel("Type");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(217, 41, 60, 34);
		panel.add(label_3);
		
		JComboBox Type = new JComboBox();
		Type.addItem("Mantenimiento");
		Type.addItem("Hardware");
		Type.addItem("Software");
		Type.setBounds(301, 49, 113, 20);
		panel.add(Type);
		
		JButton btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String type = (String) Type.getSelectedItem();
				try {
                    conexion.EjecutarUpdate(
                            "INSERT INTO `articulos`(`Tipos`, `Id`, `Articulo`, `Stock`, `Precio`) VALUES ('" + type + "',null,'" + Article.getText() + "','" + Stock.getText() + "','" + Price.getText() + "')");
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Añadido ");
			}
		});
			
				btnAdd.setBounds(56, 217, 89, 23);
				panel.add(btnAdd);	
	}
}