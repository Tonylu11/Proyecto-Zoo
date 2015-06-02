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

public class PrincipalGUI {

	private JFrame frmZoologicoCordoba;
	private AnnadirMamifero annadirMamifero = new AnnadirMamifero();
	private AnnadirAve annadirAve = new AnnadirAve();
	private AnnadirPez annadirPez = new AnnadirPez();
	private MostrarZoologico mostrarZoologico = new MostrarZoologico();
	private static JFrame nuevo = new JFrame();
	private File file;
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter(
			"Archivos .obj", "obj");
	private File selectedFile;
	private JMenuItem mntmNumeroDeAnimales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGUI window = new PrincipalGUI();
					window.frmZoologicoCordoba.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmZoologicoCordoba = new JFrame();
		frmZoologicoCordoba.setResizable(false);
		frmZoologicoCordoba.setTitle("Zool\u00F3gico de C\u00F3rdoba");
		frmZoologicoCordoba.setBounds(100, 100, 803, 455);
		frmZoologicoCordoba
				.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmZoologicoCordoba.addWindowListener(new WindowAdapter() {
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
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mnArchivo.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));
		mnArchivo.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
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

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,
				InputEvent.CTRL_MASK));
		mnArchivo.add(mntmSalir);

		JMenu mnEdicin = new JMenu("Edici\u00F3n");
		mnEdicin.setMnemonic('E');
		menuBar.add(mnEdicin);

		JMenu mnAadirAnimal = new JMenu("A\u00F1adir Animal");
		mnEdicin.add(mnAadirAnimal);

		JMenuItem mntmAadir = new JMenuItem("A\u00F1adir Mam\u00EDfero");
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadirMamifero.setVisible(true);
			}
		});
		mnAadirAnimal.add(mntmAadir);
		mntmAadir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
				InputEvent.CTRL_MASK));

		JMenuItem mntmAadirAve = new JMenuItem("A\u00F1adir Ave");
		mntmAadirAve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadirAve.setVisible(true);
			}
		});
		mnAadirAnimal.add(mntmAadirAve);
		mntmAadirAve.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));

		JMenuItem mntmAadirPez = new JMenuItem("A\u00F1adir Pez");
		mntmAadirPez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadirPez.setVisible(true);
			}
		});
		mnAadirAnimal.add(mntmAadirPez);
		mntmAadirPez.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				InputEvent.CTRL_MASK));

		JMenu mnEliminarAnimal = new JMenu("Eliminar Animal");
		mnEdicin.add(mnEliminarAnimal);

		JMenuItem mntmEliminarMamifero = new JMenuItem("Eliminar Mam\u00EDfero");
		mntmEliminarMamifero.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_M, InputEvent.SHIFT_MASK));
		mnEliminarAnimal.add(mntmEliminarMamifero);

		JMenuItem mntmEliminarAve = new JMenuItem("Eliminar Ave");
		mntmEliminarAve.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.SHIFT_MASK));
		mnEliminarAnimal.add(mntmEliminarAve);

		JMenuItem mntmEliminarPez = new JMenuItem("Eliminar Pez");
		mntmEliminarPez.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				InputEvent.SHIFT_MASK));
		mnEliminarAnimal.add(mntmEliminarPez);

		mntmNumeroDeAnimales = new JMenuItem("Numero de Animales");
		mntmNumeroDeAnimales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(mntmNumeroDeAnimales,
						"Número total de animales en el Zoologico: "
								+ General.zoologico.size());
			}
		});
		mnEdicin.add(mntmNumeroDeAnimales);

		JMenu mnNewMenu = new JMenu("Interacci\u00F3n");
		mnNewMenu.setMnemonic('I');
		menuBar.add(mnNewMenu);

		JMenu mnBsqueda = new JMenu("B\u00FAsqueda");
		menuBar.add(mnBsqueda);

		JMenuItem mntmBuscarPorAlias = new JMenuItem("Buscar por Alias..");
		mntmBuscarPorAlias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarZoologico.setVisible(true);
			}
		});
		mnBsqueda.add(mntmBuscarPorAlias);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('Y');
		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(mntmAcercaDe);

		JMenu mnAyuda_1 = new JMenu("Ayuda");
		mnAyuda.add(mnAyuda_1);

		JMenuItem mntmMamferos = new JMenuItem("Mam\u00EDferos");
		mntmMamferos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
				InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnAyuda_1.add(mntmMamferos);

		JMenuItem mntmAves = new JMenuItem("Aves");
		mntmAves.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnAyuda_1.add(mntmAves);

		JMenuItem mntmPeces = new JMenuItem("Peces");
		mntmPeces.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnAyuda_1.add(mntmPeces);
		frmZoologicoCordoba.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Zool\u00F3gico de C\u00F3rdoba");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(384, 0, 515, 88);
		frmZoologicoCordoba.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon(
						"C:\\Users\\AntonioLuque\\Desktop\\_estudodomeiovisitaaozool.zoom.jpg"));
		lblNewLabel.setBounds(0, 0, 800, 408);
		frmZoologicoCordoba.getContentPane().add(lblNewLabel);
	}

	public File getSelectedFile() {
		return selectedFile;
	}

	public void setSelectedFile(File selectedFile) {
		this.selectedFile = selectedFile;
	}

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
			} else
				System.exit(0);
		} else
			System.exit(0);
	}

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
