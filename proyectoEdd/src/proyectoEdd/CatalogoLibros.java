package proyectoEdd;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CatalogoLibros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatalogoLibros frame = new CatalogoLibros();
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
	public CatalogoLibros() {
		setTitle("Catalogo Libros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		getContentPane().setLayout(new GridLayout(5,4));
		
		JButton btnNewButton_15 = new JButton("Beowulf");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:Beowulf" + "\n" +
                        "Autor:	Seamus Heaney" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 034545104X" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 3 " + "\n" );
			}
		});
		btnNewButton_15.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_15.setForeground(new Color(255, 255, 255));
		btnNewButton_15.setIcon(new ImageIcon("imagenes\\Beowulf.jpg"));
		getContentPane().add(btnNewButton_15);
		
		JButton btnNewButton_10 = new JButton("BatmanAñoUno");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:Batman: Year One" + "\n" +
                        "Autor:Frank Miller" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN:155061224" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 2" + "\n" );
			}
		});
		btnNewButton_10.setIcon(new ImageIcon("imagenes\\Batman año uno.jpg"));
		getContentPane().add(btnNewButton_10);
		
		JButton btnNewButton_24 = new JButton("Menu\r\n");
		btnNewButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortadaJ inicio = new PortadaJ();
				inicio.setVisible(true);
			}
		});
		btnNewButton_24.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_24.setBackground(new Color(128, 128, 255));
		getContentPane().add(btnNewButton_24);
		
		JButton btnNewButton_6 = new JButton("Hija de humo");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:Daughter of Smoke & Bone" + "\n" +
                        "Autor:Laini Taylor" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN:	521795028" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 8 " + "\n" );
			}
		});
		btnNewButton_6.setIcon(new ImageIcon("imagenes\\Hija de humo y hueso.jpg"));
		getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("Reina Roja");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:Red Queen" + "\n" +
                        "Autor: Victoria Aveyard" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 2080674722" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 5 " + "\n" );
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("imagenes\\ReinaRoja.jpg"));
		getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_2 = new JButton("Pequeña princesa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro: A Little Princess" + "\n" +
                        "Autor:Frances Hodgson Burnett" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 342310538" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 7 " + "\n" );
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("imagenes\\Una pequeña princesa.jpg"));
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("El poder de los habitos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:The Power of Habit" + "\n" +
                        "Autor: Charles Duhigg" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 3257224281" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 2 " + "\n" );
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("imagenes\\El poder de los habitos.jpg"));
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Hopeless");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:Hopeless" + "\n" +
                        "Autor:Colleen Hoover " + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 038550120X" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 4 " + "\n" );
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("imagenes\\El caballo y su niño.jpg"));
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton(":The Way of Kings");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:The Way of Kings" + "\n" +
                        "Autor: Brandon Sanderson " + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 034544003X" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 3 " + "\n" );
			}
		});
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setIcon(new ImageIcon("imagenes\\El conejo de pana.jpg"));
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_8 = new JButton("The war of the Worlds");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:Salad and more" + "\n" +
                        "Autor:Brandon Sanderson " + "\n" +
                        "Genero: Realidad " + "\n" +
                        "ISBN: 451167317" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 4 " + "\n" );
			}
		});
		btnNewButton_8.setIcon(new ImageIcon("imagenes\\The war of the Worlds.jpg"));
		getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_7 = new JButton(" The Language of Flowers");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro: The Language of Flowers" + "\n" +
                        "Autor: Vanessa Diffenbaugh " + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 843920262" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 5 " + "\n" );
			}
		});
		btnNewButton_7.setIcon(new ImageIcon("imagenes\\pretty-little-.jpg"));
		getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_12 = new JButton("Go Set a Watchman");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro: Go Set a Watchman" + "\n" +
                        "Autor:Harper Lee" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN:446520802" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 3 " + "\n" );
			}
		});
		btnNewButton_12.setIcon(new ImageIcon("imagenes\\dilenma.jpg"));
		getContentPane().add(btnNewButton_12);
		
		JButton btnNewButton = new JButton("Corduroy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro: Corduroy" + "\n" +
                        "Autor: Don Freeman " + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 609801279" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 3 " + "\n" );
			}
		});
		btnNewButton.setIcon(new ImageIcon("imagenes\\corduroy.jpg"));
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_9 = new JButton("Life after life");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:Life After Life" + "\n" +
                        "Autor:	Kate Atkinson" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 679776818" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 3 " + "\n" );
			}
		});
		btnNewButton_9.setIcon(new ImageIcon("imagenes\\life after life.jpg"));
		getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_16 = new JButton("The rescue");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:The Rescue" + "\n" +
                        "Autor:	Nicholas Sparks	ficcion	9	943066433" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 943066433" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 9 " + "\n" );
			}
		});
		btnNewButton_16.setIcon(new ImageIcon("imagenes\\The rescue.jpg"));
		getContentPane().add(btnNewButton_16);
		
		JButton btnNewButton_11 = new JButton("Needful");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:Needful Things" + "\n" +
                        "Autor:	Stephen King" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN:1570231028" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 8" + "\n" );
			}
		});
		btnNewButton_11.setIcon(new ImageIcon("imagenes\\Needful.jpg"));
		getContentPane().add(btnNewButton_11);
		
		JButton btnNewButton_13 = new JButton("voyager");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:Voyager" + "\n" +
                        "Autor:	Diana Gabaldon" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN:1885408226" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 7 " + "\n" );
			}
		});
		btnNewButton_13.setIcon(new ImageIcon("imagenes\\voyager.jpg"));
		getContentPane().add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Hamlet");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro: Hamlet" + "\n" +
                        "Autor:William Shakespeare	ficcion	6	747558167" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN:747558167" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 6 " + "\n" );
			}
		});
		btnNewButton_14.setIcon(new ImageIcon("imagenes\\Hamlet.jpg"));
		getContentPane().add(btnNewButton_14);
		
		JButton btnNewButton_17 = new JButton("Cujo");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro: Cujo" + "\n" +
                        "Autor:Stephen King	" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 3442437407" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 5 " + "\n" );
			}
		});
		btnNewButton_17.setIcon(new ImageIcon("imagenes\\cujo.jpg"));
		getContentPane().add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("Madame bovary");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:Madame Bovary" + "\n" +
                        "Autor: Gustave Flaubert " + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 451166892" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 7 " + "\n" );
			}
		});
		btnNewButton_18.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_18.setIcon(new ImageIcon("imagenes\\madame bovary.jpg"));
		getContentPane().add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("The phantom");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro:The Phantom Tollbooth	" + "\n" +
                        "Autor: Jules Feiffer" + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 8440682697" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 3 " + "\n" );
			}
		});
		btnNewButton_19.setIcon(new ImageIcon("imagenes\\the phantom.jpg"));
		getContentPane().add(btnNewButton_19);
		
		JButton btnNewButton_21 = new JButton("Are you my nother?");
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro: Are you my nother?" + "\n" +
                        "Autor: P.D. Eastman" + "\n" +
                        "Genero: ficcion" + "\n" +
                        "ISBN: 3453185323" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 3 " + "\n" );
			}
		});
		btnNewButton_21.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_21.setIcon(new ImageIcon("imagenes\\maxresdefault.jpg"));
		getContentPane().add(btnNewButton_21);
		
		JButton btnNewButton_20 = new JButton("The story of art");
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro: The story of art" + "\n" +
                        "Autor: E.H. Gombrich " + "\n" +
                        "Genero: ficcion " + "\n" +
                        "ISBN: 3453213025" + "\n" +
                        "Estado: Disponible" + "\n" +
                        "Copias Disponibles: 4 " + "\n" );
			}
		});
		btnNewButton_20.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_20.setIcon(new ImageIcon("imagenes\\the story of art.jpg"));
		getContentPane().add(btnNewButton_20);
		
		JButton btnNewButton_22 = new JButton("Christine");
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro: Christine" + "\n" +
                        "Autor: Stephen King " + "\n" +
                        "Genero: Realidad " + "\n" +
                        "ISBN: 3453185137 " + "\n" +
                        "Estado:No Disponible" + "\n" +
                        "Copias Disponibles: 0 " + "\n" );

			}
		});
		btnNewButton_22.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_22.setIcon(new ImageIcon("imagenes\\christine.jpg"));
		getContentPane().add(btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("Vortaire");
		btnNewButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Titulo del Libro: Candide" + "\n" +
				                                    "Autor: Voltarie " + "\n" +
				                                    "Genero: Ficcion " + "\n" +
				                                    "ISBN: 3453157745 " + "\n" +
				                                    "Estado: Disponible" + "\n" +
				                                    "Copias Disponibles: 5 " + "\n" );
			}
		});
		btnNewButton_23.setIcon(new ImageIcon("imagenes\\voltaire.jpg"));
		getContentPane().add(btnNewButton_23);
		
		
		
	}

}
