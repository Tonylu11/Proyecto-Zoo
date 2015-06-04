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
import Zoo.AnimalNoExisteException;
import Zoo.Ave;
import Zoo.CodigoNoValidoException;
import Zoo.EspeciesAves;
import Zoo.EspeciesMamiferos;
import Zoo.EspeciesPeces;
import Zoo.Mamifero;
import Zoo.Pez;

/**
 * Elimina a un animal del zoo.
 * 
 * @author Antonio Luque Bravo
 *
 */
public class EliminarAnimal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int indice = 0;
	private JButton btnMostrar;
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
	private JButton btnEliminar;

	/**
	 * Crea la ventana.
	 */
	public EliminarAnimal() {
		setResizable(false);
		setModal(true);
		setTitle("Eliminar Animal");
		setBounds(100, 100, 393, 349);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JList list = new JList();
		list.setBounds(90, 155, -57, -63);
		contentPanel.add(list);

		aliasTxtField = new JTextField();
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

		hibernandoRButton.setBounds(175, 10, 117, 20);
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

			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					/**
					 * Acci&oacute;n del bot&oacute;n Salir.
					 */
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});

				btnMostrar = new JButton("Mostrar");
				btnMostrar.addActionListener(new ActionListener() {
					/**
					 * Acci&oacute;n del bot&oacute;n Mostrar.
					 */
					public void actionPerformed(ActionEvent arg0) {
						if (General.zoologico.size() == 0)
							JOptionPane.showMessageDialog(contentPanel,
									"El zoológico esta vacío", "Error",
									JOptionPane.ERROR_MESSAGE);

						mostrarAnimal();
						btnEliminar.setVisible(true);
						btnMostrar.setVisible(true);

					}
				});

				btnEliminar = new JButton("Eliminar");
				btnEliminar.setVisible(false);
				btnEliminar.addActionListener(new ActionListener() {
					/**
					 * Acci&oacute;n del bot&oacute;n Eliminar.
					 */
					public void actionPerformed(ActionEvent e) {
						try {
							General.zoologico.eliminar(General.zoologico
									.get(aliasTxtField.getText()),
									aliasTxtField.getText());
							JOptionPane.showMessageDialog(contentPanel,
									"Animal eliminado con éxito.");
						} catch (AnimalNoExisteException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"El Animal no existe.", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (CodigoNoValidoException e2) {
							JOptionPane.showMessageDialog(contentPanel,
									"El código no es válido.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				buttonPane.add(btnEliminar);
				buttonPane.add(btnMostrar);
				buttonPane.add(cancelButton);
			}
		}

	}

	/**
	 * Muestra el animal el cual le pasamos todos sus campos.
	 * 
	 */
	private void mostrarAnimal() {

		try {
			Animal animal = General.zoologico.get(aliasTxtField.getText());
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
				especiesAvesCBox.setSelectedItem(((Ave) animal)
						.getEspeciesAves());
				especiesMamiferosCBox.setSelectedIndex(-1);
				especiesPecesCBox.setSelectedIndex(-1);
			} else if (animal.getCodigo().startsWith("PEZ")) {
				if (((Pez) animal).isEscamas() == true) {
					colocarCheckBox(false, false, true);
				} else {
					colocarCheckBox(false, false, false);
				}
				especiesPecesCBox.addItem(((Pez) animal).getEspeciesPeces());
				especiesPecesCBox.setSelectedItem(((Pez) animal)
						.getEspeciesPeces());
				especiesMamiferosCBox.setSelectedIndex(-1);
				especiesAvesCBox.setSelectedIndex(-1);
			}

		} catch (AnimalNoExisteException e) {
			JOptionPane.showMessageDialog(contentPanel, "El Animal no existe.",
					"Error", JOptionPane.ERROR_MESSAGE);
		} catch (CodigoNoValidoException e) {
			JOptionPane.showMessageDialog(contentPanel,
					"El código no es válido.", "Error",
					JOptionPane.ERROR_MESSAGE);
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

}
