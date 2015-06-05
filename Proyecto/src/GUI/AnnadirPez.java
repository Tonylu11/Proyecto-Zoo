package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import Zoo.Alimentacion;
import Zoo.Animal;
import Zoo.AnimalSinEnergiaException;
import Zoo.AnimalSinPesoException;
import Zoo.AnimalYaExisteException;
import Zoo.CodigoNoValidoException;
import Zoo.EspeciesPeces;
import Zoo.Pez;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Ventana que a&ntilde;ade un Pez al Zool&oacute;gico
 * 
 * @author Antonio Luque Bravo
 *
 */
public class AnnadirPez extends JDialog {

	private final JPanel contentPanel = new JPanel();
	/**
	 * Campo de Alias.
	 */
	private JTextField aliasTxtField;
	/**
	 * Campo del peso.
	 */
	private JTextField pesoTxtField;
	/**
	 * Campo de la energ&iacute;a.
	 */
	private JTextField energiaTxtField;
	/**
	 * Combo Box de las especies de Peces.
	 */
	private JComboBox especieCBox;
	private JButton okButton;
	/**
	 * Combo Box del tipo de alimentaci&oacute;n.
	 */
	private JComboBox alimentacionCBox;
	/**
	 * Fecha del almacenamiento del animal.
	 */
	private GregorianCalendar fecha;
	/**
	 * Check Box para las escamas.
	 */
	private JCheckBox chckbxEscamas;
	private JTextField fechaTxtField;

	/**
	 * Crea la ventana.
	 */
	public AnnadirPez() {
		addWindowListener(new WindowAdapter() {
			/**
			 * Acci&oacute;n que lleva a cabo mientras que se cierra la ventana.
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				limpiar();
				setVisible(false);
			}
		});
		setTitle("A\u00F1adir Pez");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 330, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			aliasTxtField = new JTextField();
			aliasTxtField.addFocusListener(new FocusAdapter() {
				/**
				 * Cuando pierde el foco el campo del alias, comprueba si es
				 * valido, de ser asi lo mostrar&aacute; el texto de color
				 * negro, de lo contrario lo mostrar&aacute; rojo.
				 */
				@Override
				public void focusLost(FocusEvent arg0) {
					if (!Pez.esValido(aliasTxtField.getText())) {
						aliasTxtField.setForeground(Color.RED);
					} else {
						aliasTxtField.setForeground(Color.BLACK);
					}
				}

				/**
				 * Cuando gana el foco, el texto del alias se vuelve de color
				 * negro.
				 */
				@Override
				public void focusGained(FocusEvent e) {
					aliasTxtField.setForeground(Color.BLACK);
				}
			});
			aliasTxtField.setColumns(10);
			aliasTxtField.setBounds(92, 38, 106, 20);
			contentPanel.add(aliasTxtField);
		}
		{
			JLabel aliasLabel = new JLabel("Alias");
			aliasLabel.setBounds(43, 41, 46, 14);
			contentPanel.add(aliasLabel);
		}
		{
			JLabel pesoLabel = new JLabel("Peso");
			pesoLabel.setBounds(43, 72, 46, 14);
			contentPanel.add(pesoLabel);
		}
		{
			pesoTxtField = new JTextField();
			pesoTxtField.addFocusListener(new FocusAdapter() {
				/**
				 * Cuando pierde el foco el campo de peso, comprueba si es
				 * valido, de ser asi lo mostrar&aacute; el texto de color
				 * negro, de lo contrario lo mostrar&aacute; rojo.
				 */
				@Override
				public void focusLost(FocusEvent e) {
					if (!Animal.pesoEsValido(pesoTxtField.getText())) {
						pesoTxtField.setForeground(Color.RED);

					} else {
						pesoTxtField.setForeground(Color.BLACK);
					}
				}

				/**
				 * Cuando gane el foco se volver&aacute; el texto negro.
				 */
				@Override
				public void focusGained(FocusEvent e) {
					pesoTxtField.setForeground(Color.BLACK);
				}
			});
			pesoTxtField.setColumns(10);
			pesoTxtField.setBounds(92, 69, 106, 20);
			contentPanel.add(pesoTxtField);
		}
		{
			JLabel energiaLabel = new JLabel("Energia");
			energiaLabel.setBounds(43, 103, 65, 14);
			contentPanel.add(energiaLabel);
		}
		{
			energiaTxtField = new JTextField();
			energiaTxtField.addFocusListener(new FocusAdapter() {
				/**
				 * Cuando gane el foco se volver&aacute; el texto negro.
				 */
				@Override
				public void focusGained(FocusEvent e) {
					energiaTxtField.setForeground(Color.BLACK);
				}

				/**
				 * Cuando pierde el foco el campo de la energia, comprueba si es
				 * valido, de ser asi lo mostrar&aacute; el texto de color
				 * negro, de lo contrario lo mostrar&aacute; rojo.
				 */
				@Override
				public void focusLost(FocusEvent e) {
					if (!Animal.energiaEsValida(energiaTxtField.getText())) {
						energiaTxtField.setForeground(Color.RED);
					} else {
						energiaTxtField.setForeground(Color.BLACK);
					}
				}
			});
			energiaTxtField.setColumns(10);
			energiaTxtField.setBounds(92, 100, 106, 20);
			contentPanel.add(energiaTxtField);
		}
		{
			chckbxEscamas = new JCheckBox("Escamas");
			chckbxEscamas.setBounds(39, 141, 97, 23);
			contentPanel.add(chckbxEscamas);
		}
		fechaTxtField = new JTextField();
		fechaTxtField.setEditable(false);
		fechaTxtField.setBounds(189, 152, 86, 20);
		contentPanel.add(fechaTxtField);
		fechaTxtField.setColumns(10);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String str = sdf.format(General.zoologico.getFecha().getTime());
		fechaTxtField.setText(str);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(189, 131, 46, 14);
		contentPanel.add(lblFecha);
		{
			especieCBox = new JComboBox();
			especieCBox.setModel(new DefaultComboBoxModel(EspeciesPeces
					.values()));
			especieCBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
				}
			});
			especieCBox.setBounds(43, 208, 114, 28);
			contentPanel.add(especieCBox);
		}
		{
			JLabel especieLabel = new JLabel("Especie");
			especieLabel.setBounds(43, 183, 155, 14);
			contentPanel.add(especieLabel);
		}
		{
			JLabel alimentacionLabel = new JLabel("Tipo de alimentaci\u00F3n");
			alimentacionLabel.setBounds(190, 183, 155, 14);
			contentPanel.add(alimentacionLabel);
		}
		{
			alimentacionCBox = new JComboBox();
			alimentacionCBox.setModel(new DefaultComboBoxModel(Alimentacion
					.values()));
			alimentacionCBox.setBounds(190, 208, 114, 28);
			contentPanel.add(alimentacionCBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						alta(energiaTxtField.getText(), pesoTxtField.getText());
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limpiar();
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	/**
	 * Da de alta a un pez en el Zoo
	 * 
	 * @param comprobarEnergia
	 *            Comprueba si la energ&iacute;a es v&aacute;lida.
	 * @param comprobarPeso
	 *            Comprueba si el peso es v&aacute;lido.
	 */
	protected void alta(String comprobarEnergia, String comprobarPeso) {
		try {
			if (!Animal.energiaEsValida(comprobarEnergia))
				throw new AnimalSinEnergiaException("");
			if (!Animal.pesoEsValido(comprobarPeso))
				throw new AnimalSinPesoException("");
			Animal pez = new Pez(
					(Alimentacion) alimentacionCBox.getSelectedItem(),
					aliasTxtField.getText(), Integer.parseInt(energiaTxtField
							.getText()), Double.parseDouble(pesoTxtField
							.getText()), General.zoologico.getFecha(),
					(EspeciesPeces) especieCBox.getSelectedItem(),
					chckbxEscamas.isSelected());
			if (General.zoologico.annadir(pez)) {
				JOptionPane
						.showMessageDialog(okButton, "Pez añadido con exito");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPanel, "Formato no válido",
					"Error", JOptionPane.ERROR_MESSAGE);

		} catch (CodigoNoValidoException e) {
			JOptionPane
					.showMessageDialog(contentPanel, "El código es invalido",
							"Error", JOptionPane.ERROR_MESSAGE);
		} catch (AnimalSinPesoException e) {
			JOptionPane.showMessageDialog(contentPanel, "El peso es inválido",
					"Error", JOptionPane.ERROR_MESSAGE);
		} catch (AnimalSinEnergiaException e) {
			JOptionPane.showMessageDialog(contentPanel,
					"La energia es inválida", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (AnimalYaExisteException e) {
			JOptionPane.showMessageDialog(contentPanel, "El Pez ya existe.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Limpia los campos de la ventana.
	 */
	private void limpiar() {
		aliasTxtField.setText("");
		pesoTxtField.setText("");
		energiaTxtField.setText("");

	}
}
