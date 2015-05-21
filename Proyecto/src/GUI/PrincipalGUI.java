package GUI;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalGUI {

	private JFrame frmZoolgicoCrdoba;
	private AnnadirMamifero annadirMamifero = new AnnadirMamifero();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGUI window = new PrincipalGUI();
					window.frmZoolgicoCrdoba.setVisible(true);
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
		frmZoolgicoCrdoba = new JFrame();
		frmZoolgicoCrdoba.setResizable(false);
		frmZoolgicoCrdoba.setTitle("Zool\u00F3gico de C\u00F3rdoba");
		frmZoolgicoCrdoba.setBounds(100, 100, 450, 300);
		frmZoolgicoCrdoba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmZoolgicoCrdoba.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mnArchivo.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));
		mnArchivo.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.ALT_MASK));
		mnArchivo.add(mntmGuardarComo);

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
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
		mnAadirAnimal.add(mntmAadirAve);
		mntmAadirAve.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));

		JMenuItem mntmAadirPez = new JMenuItem("A\u00F1adir Pez");
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

		JMenu mnNewMenu = new JMenu("Interacci\u00F3n");
		menuBar.add(mnNewMenu);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		frmZoolgicoCrdoba.getContentPane().setLayout(null);
	}
}
