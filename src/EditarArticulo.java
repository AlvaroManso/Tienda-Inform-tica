import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarArticulo extends JFrame {

	private JPanel contentPane;


	public EditarArticulo(String Articulo, String usuario) throws SQLException {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 58, 174, 20);
		
		String[] articulos=Edit.editar();
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
		btnMain.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnMain.setBounds(284, 217, 89, 23);
		panel.add(btnMain);
		
		JButton Edit = new JButton("Edit");
		Edit.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent arg0) {
				String Articulo = (String) comboBox.getSelectedItem();
				Editar o = new Editar(Articulo, usuario);
				dispose();
				o.setVisible(true);
			}
		});
	
		Edit.setBounds(284, 57, 89, 23);
		panel.add(Edit);
		
		JLabel lblArticle = new JLabel("Article:");
		lblArticle.setForeground(Color.WHITE);
		lblArticle.setBounds(44, 61, 46, 14);
		panel.add(lblArticle);
	}
}
