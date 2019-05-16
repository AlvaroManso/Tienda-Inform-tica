
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTable;

public class Software extends JFrame {

	private JPanel contentPane;

	public Software() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 432);
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
				Principal a=new Principal();
				dispose();
				a.setVisible(true);
				}
		});
		btnMain.setBounds(431, 289, 89, 23);
		panel.add(btnMain);
		
		JButton btnAadir = new JButton("Add");
		btnAadir.setBounds(0, 80, 89, 23);
		panel.add(btnAadir);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(0, 137, 89, 23);
		panel.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(0, 190, 89, 23);
		panel.add(btnEdit);
		
		JTable table = new JTable();
		table.setEnabled(false);
		table.setAutoCreateRowSorter(true);
		table.setBounds(99, 69, 486, 144);
		panel.add(table);
		
		Object[][] datos = new Object[0][0];
        String[] titulo = {"Article", "Stock", "Price"};
        DefaultTableModel Software = new DefaultTableModel(datos,titulo);
        
        table.setModel(Software);
        String consulta = "Select Articulo, Stock, precio from articulos where tipos=?";
        PreparedStatement sentencia = (PreparedStatement) conexion.conexionBBDD().prepareStatement (consulta);
        sentencia.setString(1, "Software");
        ResultSet rs = sentencia.executeQuery();
        
        try {
            while (rs.next()) {
            String [] Software1 = new String[3];
            for (int i = 0; i<3; i++) {
                Software1[i] = rs.getString(i+1);
            }


            Software.addRow(Software1);
            //panel.add(table);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}
	private static void addColumn(String string) {
        // TODO Auto-generated method stub

    }
}