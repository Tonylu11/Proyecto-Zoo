package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;

import Zoo.Alimentacion;
import Zoo.Animal;
import Zoo.AnimalSinEnergiaException;
import Zoo.Ave;
import Zoo.EnergiaInvalidaException;
import Zoo.EspeciesAves;
import Zoo.EspeciesMamiferos;
import Zoo.EspeciesPeces;
import Zoo.Mamifero;
import Zoo.PesoInvalidoException;
import Zoo.Pez;

/**
 * Muestra el Zool&oacute;gico.
 * 
 * @author Antonio Luque Bravo
 *
 */
public class MostrarZoologico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int indice = 0;
	private JButton botonAnterior;
	private JButton botonSiguiente;
	private JTextField aliasTxtField;
	private JTextField pesoTxtField;
	private JTextField energiaTxtField;
	private JComboBox<Alimentacion> alimentacionCBox;
	private JComboBox<EspeciesAves> especiesAvesCBox;
	private JComboBox<EspeciesPeces> especiesPecesCBox;
	private JComboBox<EspeciesMamiferos> especiesMamiferosCBox;
	private JTextField fechaTxtField;
	private JCheckBox migrandoRButton;
	private JCheckBox escamasRButton;
	private JCheckBox hibernandoRButton;

	/**
	 * Genera la Ventana
	 */
	public MostrarZoologico() {
		setResizable(false);
		setModal(true);
		setTitle("Mostrar Zoologico");
		setBounds(100, 100, 393, 349);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JList list = new JList();
		list.setBounds(90, 155, -57, -63);
		contentPanel.add(list);

		aliasTxtField = new JTextField();
		aliasTxtField.setEditable(false);
		aliasTxtField.setColumns(10);
		aliasTxtField.setBounds(59, 10, 106, 20);
		contentPanel.add(aliasTxtField);

		JLabel aliasLabel = new JLabel("Alias");
		aliasLabel.setBounds(10, 13, 46, 14);
		contentPanel.add(aliasLabel);

		JLabel pesoLabel = new JLabel("Peso");
		pesoLabel.setBounds(10, 44, 46, 14);
		contentPanel.add(pesoLabel);

		pesoTxtField = new JTextField();
		pesoTxtField.setEditable(false);
		pesoTxtField.setColumns(10);
		pesoTxtField.setBounds(59, 41, 106, 20);
		contentPanel.add(pesoTxtField);

		energiaTxtField = new JTextField();
		energiaTxtField.setEditable(false);
		energiaTxtField.setColumns(10);
		energiaTxtField.setBounds(59, 72, 106, 20);
		contentPanel.add(energiaTxtField);

		JLabel energiaLabel = new JLabel("Energia");
		energiaLabel.setBounds(10, 75, 65, 14);
		contentPanel.add(energiaLabel);

		JLabel especieMamiferosLabel = new JLabel("Especies de Mam\u00EDferos");
		especieMamiferosLabel.setBounds(10, 192, 155, 14);
		contentPanel.add(especieMamiferosLabel);

		JLabel alimentacionLabel = new JLabel("Tipo de alimentaci\u00F3n");
		alimentacionLabel.setBounds(10, 103, 169, 14);
		contentPanel.add(alimentacionLabel);

		alimentacionCBox = new JComboBox();
		alimentacionCBox.setEnabled(false);
		alimentacionCBox.setBounds(10, 128, 117, 28);
		contentPanel.add(alimentacionCBox);

		especiesMamiferosCBox = new JComboBox();
		especiesMamiferosCBox.setEnabled(false);
		especiesMamiferosCBox.setBounds(10, 217, 117, 28);
		contentPanel.add(especiesMamiferosCBox);

		especiesAvesCBox = new JComboBox();
		especiesAvesCBox.setEnabled(false);
		especiesAvesCBox.setBounds(137, 217, 117, 28);
		contentPanel.add(especiesAvesCBox);

		especiesPecesCBox = new JComboBox();
		especiesPecesCBox.setEnabled(false);
		especiesPecesCBox.setBounds(264, 217, 117, 28);
		contentPanel.add(especiesPecesCBox);

		JLabel especiesAvesLabel = new JLabel("Especies de Aves");
		especiesAvesLabel.setBounds(137, 192, 155, 14);
		contentPanel.add(especiesAvesLabel);

		JLabel especiesDePeces = new JLabel("Especies de Peces");
		especiesDePeces.setBounds(264, 192, 155, 14);
		contentPanel.add(especiesDePeces);

		fechaTxtField = new JTextField();
		fechaTxtField.setEditable(false);
		fechaTxtField.setBounds(137, 132, 86, 20);
		contentPanel.add(fechaTxtField);
		fechaTxtField.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(137, 103, 46, 14);
		contentPanel.add(lblFecha);

		hibernandoRButton = new JCheckBox("Hibernando");
		hibernandoRButton.setEnabled(false);

		hibernandoRButton.setBounds(175, 10, 96, 20);
		contentPanel.add(hibernandoRButton);

		migrandoRButton = new JCheckBox("Migrando");
		migrandoRButton.setEnabled(false);

		migrandoRButton.setBounds(175, 41, 117, 20);
		contentPanel.add(migrandoRButton);

		escamasRButton = new JCheckBox("Escamas");
		escamasRButton.setEnabled(false);

		escamasRButton.setBounds(175, 72, 117, 20);
		contentPanel.add(escamasRButton);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			botonAnterior = new JButton("<");
			botonAnterior.setVisible(true);
			botonAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarAnterior();
				}

			});
			buttonPane.add(botonAnterior);

			botonSiguiente = new JButton(">");
			botonSiguiente.setVisible(true);
			botonSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarSiguiente();
				}
			});
			buttonPane.add(botonSiguiente);

			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		empieza();
	}

	/**
	 * Inicia la b&uacute;squeda de los animales en el Zoo.
	 */
	private void empieza() {
		if (General.zoologico.size() == 0) {
			return;
		}
		indice = 0;
		mostrarAnimal(General.zoologico.get(indice));
		comprobarTama�o();
	}

	/**
	 * Muestra el siguiente animal.
	 */
	private void mostrarSiguiente() {
		mostrarAnimal(General.zoologico.get(++indice));
		comprobarTama�o();
	}

	/**
	 * Muestra el animal anterior.
	 */
	private void mostrarAnterior() {
		mostrarAnimal(General.zoologico.get(--indice));
		comprobarTama�o();
	}

	/**
	 * Muestra el animal el cual le pasamos todos sus campos.
	 * 
	 * @param animal
	 *            Animal en cuesti&oacute;n
	 */
	private void mostrarAnimal(Animal animal) {
		aliasTxtField.setText(animal.getCodigo());
		pesoTxtField.setText((Double.toString(animal.getPeso())));
		energiaTxtField.setText((Integer.toString(animal.getEnergia())));
		alimentacionCBox.addItem(animal.getTipoAlimentacion());
		alimentacionCBox.setSelectedItem(animal.getTipoAlimentacion());
		if (animal.getCodigo().startsWith("MAM")) {
			if (((Mamifero) animal).isHibernando() == true) {
				colocarCheckBox(true, false, false);
			} else {
				colocarCheckBox(false, false, false);
			}
			especiesMamiferosCBox.addItem(((Mamifero) animal)
					.getEspeciesMamiferos());
			especiesMamiferosCBox.setSelectedItem(((Mamifero) animal)
					.getEspeciesMamiferos());
			especiesAvesCBox.setSelectedIndex(-1);
			especiesPecesCBox.setSelectedIndex(-1);
		} else if (animal.getCodigo().startsWith("AVE")) {
			if (((Ave) animal).isMigrando() == true) {
				colocarCheckBox(false, true, false);
			} else {
				colocarCheckBox(false, false, false);

			}
			especiesAvesCBox.addItem(((Ave) animal).getEspeciesAves());
			especiesAvesCBox.setSelectedItem(((Ave) animal).getEspeciesAves());
			especiesMamiferosCBox.setSelectedIndex(-1);
			especiesPecesCBox.setSelectedIndex(-1);
		} else if (animal.getCodigo().startsWith("PEZ")) {
			if (((Pez) animal).isEscamas() == true) {
				colocarCheckBox(false, false, true);
			} else {
				colocarCheckBox(false, false, false);
			}
			especiesPecesCBox.addItem(((Pez) animal).getEspeciesPeces());
			especiesPecesCBox
					.setSelectedItem(((Pez) animal).getEspeciesPeces());
			especiesMamiferosCBox.setSelectedIndex(-1);
			especiesAvesCBox.setSelectedIndex(-1);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String str = sdf.format(General.zoologico.getFecha().getTime());
		fechaTxtField.setText(str);
	}

	private void colocarCheckBox(boolean hibernando, boolean migrando,
			boolean escamas) {
		hibernandoRButton.setSelected(hibernando);
		migrandoRButton.setSelected(migrando);
		escamasRButton.setSelected(escamas);
	}

	/**
	 * Comprueba el tama&ntilde;o desactivando o activando los botones de
	 * Anterior y Siguiente.
	 */
	private void comprobarTama�o() {
		if (General.zoologico.get(indice + 1) == null)
			botonSiguiente.setEnabled(false);
		else
			botonSiguiente.setEnabled(true);

		if (General.zoologico.get(indice - 1) == null)
			botonAnterior.setEnabled(false);
		else
			botonAnterior.setEnabled(true);
	}
}
