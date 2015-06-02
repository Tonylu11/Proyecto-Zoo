package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import Zoo.EspeciesMamiferos;

public class MostrarZoologico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int indice = 0;
	private JButton botonAnterior;
	private JButton botonSiguiente;
	private JButton btnMostrar;
	private JTextField aliasTxtField;
	private JTextField pesoTxtField;
	private JTextField energiaTxtField;
	private JCheckBox chckbxEscamas;
	private JCheckBox chckbxMigrando;
	private JCheckBox chckbxHibernando;
	private JComboBox alimentacionCBox;
	private JTextField mostrarEspecie;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarZoologico dialog = new MostrarZoologico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarZoologico() {
		setModal(true);
		setTitle("Mostrar Zoologico");
		setBounds(100, 100, 350, 321);
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

		JLabel especieLabel = new JLabel("Especie");
		especieLabel.setBounds(10, 107, 65, 14);
		contentPanel.add(especieLabel);

		JLabel alimentacionLabel = new JLabel("Tipo de alimentaci\u00F3n");
		alimentacionLabel.setBounds(10, 135, 169, 14);
		contentPanel.add(alimentacionLabel);

		alimentacionCBox = new JComboBox();
		alimentacionCBox.setBounds(10, 155, 117, 28);
		contentPanel.add(alimentacionCBox);

		chckbxHibernando = new JCheckBox("Hibernando");
		buttonGroup.add(chckbxHibernando);
		chckbxHibernando.setEnabled(false);
		chckbxHibernando.setBounds(205, 9, 97, 23);
		contentPanel.add(chckbxHibernando);

		chckbxEscamas = new JCheckBox("Escamas");
		buttonGroup.add(chckbxEscamas);
		chckbxEscamas.setEnabled(false);
		chckbxEscamas.setBounds(205, 71, 97, 23);
		contentPanel.add(chckbxEscamas);

		chckbxMigrando = new JCheckBox("Migrando");
		buttonGroup.add(chckbxMigrando);
		chckbxMigrando.setEnabled(false);
		chckbxMigrando.setBounds(205, 40, 97, 23);
		contentPanel.add(chckbxMigrando);

		mostrarEspecie = new JTextField();
		mostrarEspecie.setEditable(false);
		mostrarEspecie.setBounds(59, 104, 106, 20);
		contentPanel.add(mostrarEspecie);
		mostrarEspecie.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			botonAnterior = new JButton("<");
			botonAnterior.setVisible(false);
			botonAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarAnterior();
				}

			});
			buttonPane.add(botonAnterior);

			botonSiguiente = new JButton(">");
			botonSiguiente.setVisible(false);
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

				btnMostrar = new JButton("Mostrar");
				btnMostrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (General.zoologico.size() == 0)
							JOptionPane.showMessageDialog(contentPanel,
									"El zoológico esta vacío", "Error",
									JOptionPane.ERROR_MESSAGE);
						if (General.zoologico.get(0) != null) {
							mostrarAnimal(General.zoologico.get(indice));
							comprobarTamaño();
							botonSiguiente.setVisible(true);
							botonAnterior.setVisible(true);
							btnMostrar.setVisible(false);
						}
					}
				});
				buttonPane.add(btnMostrar);
				buttonPane.add(cancelButton);
			}
		}

	}

	private void mostrarSiguiente() {
		mostrarAnimal(General.zoologico.get(++indice));
		comprobarTamaño();
	}

	private void mostrarAnterior() {
		mostrarAnimal(General.zoologico.get(--indice));
		comprobarTamaño();
	}

	@SuppressWarnings("unchecked")
	private void mostrarAnimal(Animal animal) {
		aliasTxtField.setText(animal.getCodigo());
		pesoTxtField.setText((Double.toString(animal.getPeso())));
		// mostrarEspecie.setText();
		alimentacionCBox.addItem(animal.getTipoAlimentacion());

		// Faltan los Check Box

	}

	private void comprobarTamaño() {
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
