package Tienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;


	public Delete(String usuario, String Articulo) throws SQLException {
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
		//creamos un comboBox que es un desplegable para seleccionar
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 58, 174, 20);
		//usamos la clase delete que contiene todos los articulos para que los muestre el desplegable
		String[] articulos=Eliminar.eliminar();
        for (int i = 0; i < articulos.length; i++) {
            comboBox.addItem(articulos[i]);
        }
		panel.add(comboBox);
		
		JButton btnMain = new JButton("Main");
		btnMain.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				Principal a=new Principal(usuario, Articulo);
				dispose();
				a.setVisible(true);
				}
		});
		btnMain.setBounds(284, 217, 89, 23);
		panel.add(btnMain);
		
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent arg0) {
			
			
				String Articulo = (String) comboBox.getSelectedItem();
				
				try {

                    //ponemos la sentencia

                    conexion.EjecutarUpdate(
                    		//a�adimos el delete sobre la base de datos
                            "DELETE FROM `articulos` WHERE Articulo ='"+Articulo+"'");
                    JOptionPane.showMessageDialog(null, "Delete "+ Articulo);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
		 });
		 
		Delete.setBounds(284, 57, 89, 23);
		panel.add(Delete);
		
		JLabel lblArticle = new JLabel("Article:");
		lblArticle.setForeground(Color.WHITE);
		lblArticle.setBounds(44, 61, 46, 14);
		panel.add(lblArticle);
	}
}
