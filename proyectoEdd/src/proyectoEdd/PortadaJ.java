package proyectoEdd;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PortadaJ extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PortadaJ frame = new PortadaJ();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		 });
	 
	 

}
	/**
	 * Create the frame.
	 */
	public PortadaJ() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Consultar Libros\r\n");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CatalogoLibros newFrame= new CatalogoLibros();
				newFrame.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Prestar Libro\r\n");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Devolver Libro\r\n");
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setToolTipText("Biblioteca\r\n");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("BIBLIOTECA VIRTUAL\r\n    \r\n");
		lblTitulo.setFont(new Font("Ravie", Font.BOLD, 16));
		lblTitulo.setForeground(new Color(0, 0, 128));
		lblTitulo.setBounds(252, -16, 325, 122);
		contentPane.add(lblTitulo);
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon("imagenes\\images4.jpg"));
		lblFondo.setBounds(-12, 76, 759, 330);
		contentPane.add(lblFondo);
		
		
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(381, 386, 49, 14);
		contentPane.add(lblNewLabel_1);
	}
}

		 

