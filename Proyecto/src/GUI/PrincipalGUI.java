package GUI;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;

import Zoo.Fichero;
import Zoo.Zoologico;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Ventana principal de la Interfaz Gr&aacute;fica del Zoo.
 * 
 * @author Antonio Luque Bravo
 *
 */
public class PrincipalGUI {

	private static JFrame frmZoologicoCordoba;
	private AnnadirMamifero annadirMamifero = new AnnadirMamifero();
	private AnnadirAve annadirAve = new AnnadirAve();
	private AnnadirPez annadirPez = new AnnadirPez();

	private EliminarAnimal eliminarAnimal = new EliminarAnimal();
	static AyudaGeneral ayudaGeneral = new AyudaGeneral();
	static AcercaDe acercaDe = new AcercaDe();
	private static JFrame nuevo = new JFrame();
	private File file;
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter(
			"Archivos .zoo", "zoo");
	private File selectedFile;
	private JMenuItem mntmNumeroDeAnimales;

	/**
	 * Lanza la aplicaci&oacute;n
	 * 
	 * @param args
	 *            args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGUI window = new PrincipalGUI();
					window.frmZoologicoCordoba.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frmZoologicoCordoba,
							"El programa no se ha podido iniciar.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Genera la Ventana
	 */
	public PrincipalGUI() {
		initialize();
	}

	/**
	 * Inicializa el contenido de la ventana.
	 */
	private void initialize() {
		frmZoologicoCordoba = new JFrame();
		frmZoologicoCordoba.setResizable(false);
		frmZoologicoCordoba.setTitle("Zool\u00F3gico de C\u00F3rdoba");
		frmZoologicoCordoba.setBounds(100, 100, 803, 455);
		frmZoologicoCordoba
				.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmZoologicoCordoba.addWindowListener(new WindowAdapter() {
			/**
			 * Lo que har&aacute; la ventana mientras que se cierra.
			 */
			@Override
			public void windowClosing(WindowEvent arg0) {
				salir();
			}
		});

		JMenuBar menuBar = new JMenuBar();
		frmZoologicoCordoba.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			/**
			 * Nuevo Zoo.
			 */
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mnArchivo.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			/**
			 * Abre un archivo donde est&aacute; almacenado un Zoo.
			 */
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));
		mnArchivo.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			/**
			 * Guarda el Zoo.
			 */
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.ALT_MASK));
		mnArchivo.add(mntmGuardarComo);

		JSeparator separador = new JSeparator();
		mnArchivo.add(separador);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			/**
			 * Sale del programa.
			 */
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,
				InputEvent.CTRL_MASK));
		mnArchivo.add(mntmSalir);

		JMenu mnEdicion = new JMenu("Edici\u00F3n");
		mnEdicion.setMnemonic('E');
		menuBar.add(mnEdicion);

		JMenu mnAnnadirAnimal = new JMenu("A\u00F1adir Animal");
		mnEdicion.add(mnAnnadirAnimal);

		JMenuItem mntmAnnadir = new JMenuItem("A\u00F1adir Mam\u00EDfero");
		mntmAnnadir.addActionListener(new ActionListener() {
			/**
			 * Pone visible la ventana para a&ntilde;adir un mam&iacute;fero al
			 * Zoo.
			 */
			public void actionPerformed(ActionEvent arg0) {
				annadirMamifero.setVisible(true);
			}
		});
		mnAnnadirAnimal.add(mntmAnnadir);
		mntmAnnadir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
				InputEvent.CTRL_MASK));

		JMenuItem mntmAnnadirAve = new JMenuItem("A\u00F1adir Ave");
		mntmAnnadirAve.addActionListener(new ActionListener() {
			/**
			 * Pone visible la ventana para a&ntilde;adir un ave al Zoo.
			 */
			public void actionPerformed(ActionEvent arg0) {
				annadirAve.setVisible(true);
			}
		});
		mnAnnadirAnimal.add(mntmAnnadirAve);
		mntmAnnadirAve.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));

		JMenuItem mntmAnnadirPez = new JMenuItem("A\u00F1adir Pez");
		mntmAnnadirPez.addActionListener(new ActionListener() {
			/**
			 * Pone visible la ventana para a&ntilde;adir un pez al Zoo.
			 */
			public void actionPerformed(ActionEvent e) {
				annadirPez.setVisible(true);
			}
		});
		mnAnnadirAnimal.add(mntmAnnadirPez);
		mntmAnnadirPez.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				InputEvent.CTRL_MASK));

		JMenuItem mntmEliminarAnimal = new JMenuItem("Eliminar Animal");
		mntmEliminarAnimal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
				InputEvent.CTRL_MASK));
		mntmEliminarAnimal.addActionListener(new ActionListener() {
			/**
			 * Pone visible la ventana para eliminar a un animal del Zoo.
			 */
			public void actionPerformed(ActionEvent arg0) {
				eliminarAnimal.setVisible(true);
			}
		});
		mnEdicion.add(mntmEliminarAnimal);

		JMenu mnNewMenu = new JMenu("Interacci\u00F3n");
		mnNewMenu.setMnemonic('I');
		menuBar.add(mnNewMenu);

		JMenuItem mntmDarDeComer = new JMenuItem("Alimentar Animales");
		mntmDarDeComer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.SHIFT_MASK));
		mntmDarDeComer.addActionListener(new ActionListener() {
			/**
			 * Pone visible la ventana para alimentar animales.
			 */
			public void actionPerformed(ActionEvent e) {
				if (General.zoologico.size() == 0) {
					JOptionPane.showMessageDialog(frmZoologicoCordoba,
							"El Zoológico está vacío.");
				} else {
					AlimentarAnimal alimentarAnimales = new AlimentarAnimal();
					alimentarAnimales.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmDarDeComer);

		JMenuItem mnDesplazarAnimales = new JMenuItem("Desplazar Animales");
		mnDesplazarAnimales.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_D, InputEvent.SHIFT_MASK));
		mnDesplazarAnimales.addActionListener(new ActionListener() {
			/**
			 * Pone visible la ventana para desplazar animales.
			 */
			public void actionPerformed(ActionEvent e) {
				if (General.zoologico.size() == 0) {
					JOptionPane.showMessageDialog(frmZoologicoCordoba,
							"El Zoológico está vacío.");
				} else {
					DesplazarAnimal desplazarAnimal = new DesplazarAnimal();
					desplazarAnimal.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mnDesplazarAnimales);

		JMenu mnMostrar = new JMenu("Mostrar");
		mnMostrar.setMnemonic('M');
		menuBar.add(mnMostrar);

		mntmNumeroDeAnimales = new JMenuItem("Numero de Animales");
		mntmNumeroDeAnimales.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_C, InputEvent.ALT_MASK));
		mnMostrar.add(mntmNumeroDeAnimales);

		JMenuItem mntmBuscarPorAlias = new JMenuItem("Mostrar Zoologico");
		mntmBuscarPorAlias.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
				InputEvent.SHIFT_MASK));
		mnMostrar.add(mntmBuscarPorAlias);
		mntmBuscarPorAlias.addActionListener(new ActionListener() {
			/**
			 * Pone visible la ventana para mostrar los animales del Zoo.
			 */
			public void actionPerformed(ActionEvent arg0) {
				if (General.zoologico.size() == 0) {
					JOptionPane.showMessageDialog(frmZoologicoCordoba,
							"El Zoológico está vacío.");
				} else {
					MostrarZoologico mostrarZoologico = new MostrarZoologico();
					mostrarZoologico.setVisible(true);
				}
			}
		});
		mntmNumeroDeAnimales.addActionListener(new ActionListener() {
			/**
			 * Pone visible la ventana para el n&uacute;mero de animales.
			 */
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(mntmNumeroDeAnimales,
						"Número total de animales en el Zoologico: "
								+ General.zoologico.size());
			}
		});

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('Y');
		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmAcercaDe.addActionListener(new ActionListener() {
			/**
			 * Pone visible la ventana para Acerca del programa.
			 */
			public void actionPerformed(ActionEvent e) {
				acercaDe.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);

		JMenuItem mnAyudaDe = new JMenuItem("Ayuda");
		mnAyudaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
				InputEvent.CTRL_MASK));
		mnAyudaDe.addActionListener(new ActionListener() {
			/**
			 * Pone visible la ventana para la ayuda del programa.
			 */
			public void actionPerformed(ActionEvent e) {
				ayudaGeneral.setVisible(true);
			}
		});
		mnAyuda.add(mnAyudaDe);
		frmZoologicoCordoba.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Zool\u00F3gico de C\u00F3rdoba");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(384, 0, 515, 88);
		frmZoologicoCordoba.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PrincipalGUI.class
				.getResource("/img/principal.jpg")));
		lblNewLabel.setBounds(0, 0, 800, 408);
		frmZoologicoCordoba.getContentPane().add(lblNewLabel);
	}

	public File getSelectedFile() {
		return selectedFile;
	}

	public void setSelectedFile(File selectedFile) {
		this.selectedFile = selectedFile;
	}

	/**
	 * M&eacute;todo para salir del Zoo.
	 */
	private void salir() {
		if (General.zoologico.isModificado()) {
			int opcion = JOptionPane.showConfirmDialog(nuevo,
					"¿Deseas guardar el Zoologico?");
			if (opcion == 0) {
				JFileChooser guardar = new JFileChooser();
				guardar.setFileFilter(filtro);
				opcion = guardar.showSaveDialog(frmZoologicoCordoba);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					file = guardar.getSelectedFile();
					try {
						Fichero.guardar(General.zoologico, file);

					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(frmZoologicoCordoba,
								"El archivo no se ha encontrado.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(frmZoologicoCordoba,
								"Error de E/S.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				System.exit(0);
			} else if (opcion == 2) {
				nuevo.setVisible(false);
			} else if (opcion == 1) {
				System.exit(0);
			} else {
				nuevo.setVisible(false);
			}
		} else
			System.exit(0);
	}

	/**
	 * M&eacute;todo para crear un nuevo Zoo.
	 */
	private void nuevo() {
		if (General.zoologico.isModificado()) {
			int opcion = JOptionPane.showConfirmDialog(nuevo,
					"¿Deseas guardar el Zoologico?");
			if (opcion == 0) {
				JFileChooser guardar = new JFileChooser();
				guardar.setFileFilter(filtro);
				opcion = guardar.showSaveDialog(frmZoologicoCordoba);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					file = guardar.getSelectedFile();
					try {
						Fichero.guardar(General.zoologico, file);

					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(frmZoologicoCordoba,
								"El archivo no se ha encontrado.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(frmZoologicoCordoba,
								"Error de E/S.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				General.zoologico = new Zoologico();
				frmZoologicoCordoba
						.setTitle("Sin Título - Zoologico de Cordoba");
			} else if (opcion == 2)
				nuevo.setVisible(false);
			else
				General.zoologico = new Zoologico();
		} else
			General.zoologico = new Zoologico();
	}

	/**
	 * M&eacute;todo para abrir un Zoo ya almacenado previamente.
	 */
	private void abrir() {
		JFileChooser abrir = new JFileChooser();
		abrir.setFileFilter(filtro);
		int opcion = abrir.showOpenDialog(frmZoologicoCordoba);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			file = abrir.getSelectedFile();
			try {
				General.zoologico = (Zoologico) Fichero.leer(file);
				frmZoologicoCordoba.setTitle(file.getPath());
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(frmZoologicoCordoba,
						"El archivo no se ha encontrado.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ClassNotFoundException e2) {
				JOptionPane.showMessageDialog(frmZoologicoCordoba,
						"La información no coincide.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e3) {
				JOptionPane.showMessageDialog(frmZoologicoCordoba,
						"Error de E/S.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			General.zoologico.setModificado(false);
		}
	}

	/**
	 * M&eacute;todo para guardar un Zoo almacenado o no anteriormente.
	 */
	private void guardar() {
		if (getSelectedFile() == null) {
			JFileChooser guardar = new JFileChooser();
			guardar.setFileFilter(filtro);
			int opcion = guardar.showSaveDialog(frmZoologicoCordoba);
			if (opcion == JFileChooser.APPROVE_OPTION) {
				file = guardar.getSelectedFile();
				try {
					Fichero.guardar(General.zoologico, file);
					frmZoologicoCordoba.setTitle(file.getPath());
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(frmZoologicoCordoba,
							"El archivo no se ha encontrado.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					JOptionPane
							.showMessageDialog(frmZoologicoCordoba,
									"Error de E/S.", "Error",
									JOptionPane.ERROR_MESSAGE);
				}
				General.zoologico.setModificado(false);
				setSelectedFile(file);
			}
		} else
			try {
				Fichero.guardar(General.zoologico, file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		General.zoologico.setModificado(false);
	}

	/**
	 * M&eacute;todo para guardar un Zoo.
	 */
	private void guardarComo() {
		JFileChooser guardarComo = new JFileChooser();
		guardarComo.setFileFilter(filtro);
		int opcion = guardarComo.showSaveDialog(frmZoologicoCordoba);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			file = guardarComo.getSelectedFile();
			try {
				Fichero.guardar(General.zoologico, file);
				frmZoologicoCordoba.setTitle(file.getPath());
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(frmZoologicoCordoba,
						"El archivo no se ha encontrado.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(frmZoologicoCordoba,
						"Error de E/S.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			General.zoologico.setModificado(false);
		}
	}
}
