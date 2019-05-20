package Tienda;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JButton;

public class Hardware extends JFrame {

	private JPanel contentPane;
	 
	public Hardware(String usuario, String Articulo) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 51, 102));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnMain = new JButton("Main");
		btnMain.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				Principal a=new Principal(usuario, Articulo);
				dispose();
				a.setVisible(true);
				}
		});
		btnMain.setBounds(431, 289, 89, 23);
		panel.add(btnMain);
		

		JButton btnAadir = new JButton("Add");
		btnAadir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				AddArticulo a=new AddArticulo(usuario, Articulo);
				dispose();
				a.setVisible(true);
			}
		});
		btnAadir.setBounds(0, 80, 89, 23);
		panel.add(btnAadir);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Delete o = new Delete(usuario, Articulo);	
					dispose();
				o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
			}
		});
		btnDelete.setBounds(0, 137, 89, 23);
		panel.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarArticulo p;
				try {
					p = new EditarArticulo(usuario, Articulo);	
					dispose();
				p.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			

				
			}
		});
		
		btnEdit.setBounds(0, 190, 89, 23);
		panel.add(btnEdit);
		//creamos la tabla donde muestre los articulos de la ventana en la que estamos en este caso Hardware
		JTable table = new JTable();
		table.setEnabled(false);
		table.setAutoCreateRowSorter(true);
		table.setBounds(99, 69, 486, 144);
		panel.add(table);
		
		Object[][] datos = new Object[0][0];
        String[] titulo = {"Article", "Stock", "Price"};
        DefaultTableModel Hardware = new DefaultTableModel(datos,titulo);
        
        table.setModel(Hardware);
        //hacemos el select en la base de datos para ver los articulos que nos va a mostrar la tabla
        String consulta = "Select Articulo, Stock, precio from articulos where tipos=?";
        PreparedStatement sentencia = (PreparedStatement) conexion.conexionBBDD().prepareStatement (consulta);
        sentencia.setString(1, "Hardware");
        ResultSet rs = sentencia.executeQuery();
        
        try {
            while (rs.next()) {
            String [] Hardware1 = new String[3];
            for (int i = 0; i<3; i++) {
            	Hardware1[i] = rs.getString(i+1);
            }


            Hardware.addRow(Hardware1);
            //panel.add(table);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(99, 69, 486, 144);
        panel.add(scrollPane);
        scrollPane.setEnabled(false);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setVisible(true);
	}
	private static void addColumn(String string) {
	}

}

