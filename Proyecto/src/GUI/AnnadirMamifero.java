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
import javax.swing.ButtonGroup;

import Zoo.Alimentacion;
import Zoo.Animal;
import Zoo.AnimalSinEnergiaException;
import Zoo.AnimalSinPesoException;
import Zoo.AnimalYaExisteException;
import Zoo.CodigoNoValidoException;
import Zoo.EspeciesMamiferos;
import Zoo.Mamifero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JCheckBox;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Ventana que a&ntilde;ade un Mam&iacute;fero al Zool&oacute;gico
 * 
 * @author Antonio Luque Bravo
 *
 */
@SuppressWarnings("serial")
public class AnnadirMamifero extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField aliasTxtField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField pesoTxtField;
	private JTextField energiaTxtField;
	private JButton okButton;
	private JComboBox especieCBox;
	private JComboBox alimentacionCBox;
	private GregorianCalendar fecha;
	private JCheckBox chckbxHibernando;
	private JTextField fechaTxtField;

	/**
	 * Crea la ventana.
	 */
	public AnnadirMamifero() {
		setTitle("A\u00F1adir Mamifero");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 330, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		aliasTxtField = new JTextField();
		aliasTxtField.addFocusListener(new FocusAdapter() {
			/**
			 * Cuando pierde el foco el campo del alias, comprueba si es valido,
			 * de ser asi lo mostrar&aacute; el texto de color negro, de lo
			 * contrario lo mostrar&aacute; rojo.
			 */
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!Mamifero.esValido(aliasTxtField.getText())) {
					aliasTxtField.setForeground(Color.RED);
				} else {
					aliasTxtField.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				aliasTxtField.setForeground(Color.BLACK);
			}
		});
		aliasTxtField.setBounds(81, 35, 106, 20);
		contentPanel.add(aliasTxtField);
		aliasTxtField.setColumns(10);

		JLabel lblCdigo = new JLabel("Alias");
		lblCdigo.setBounds(32, 38, 46, 14);
		contentPanel.add(lblCdigo);

		alimentacionCBox = new JComboBox();
		alimentacionCBox.setModel(new DefaultComboBoxModel(Alimentacion
				.values()));
		alimentacionCBox.setBounds(179, 205, 114, 28);
		contentPanel.add(alimentacionCBox);

		JLabel lblTipoDeAlimentacin = new JLabel("Tipo de alimentaci\u00F3n");
		lblTipoDeAlimentacin.setBounds(179, 180, 155, 14);
		contentPanel.add(lblTipoDeAlimentacin);

		especieCBox = new JComboBox();
		especieCBox.setModel(new DefaultComboBoxModel(EspeciesMamiferos
				.values()));
		especieCBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

			}
		});
		especieCBox.setBounds(32, 205, 114, 28);
		contentPanel.add(especieCBox);

		JLabel lblEspecie = new JLabel("Especie");
		lblEspecie.setBounds(32, 180, 155, 14);
		contentPanel.add(lblEspecie);

		pesoTxtField = new JTextField();
		pesoTxtField.addFocusListener(new FocusAdapter() {
			/**
			 * Cuando pierde el foco el campo de peso, comprueba si es valido,
			 * de ser asi lo mostrar&aacute; el texto de color negro, de lo
			 * contrario lo mostrar&aacute; rojo.
			 */
			@Override
			public void focusLost(FocusEvent e) {
				if (!Animal.pesoEsValido(pesoTxtField.getText())) {
					pesoTxtField.setForeground(Color.RED);

				} else {
					pesoTxtField.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				pesoTxtField.setForeground(Color.BLACK);
			}
		});
		pesoTxtField.setBounds(81, 66, 106, 20);
		contentPanel.add(pesoTxtField);
		pesoTxtField.setColumns(10);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(32, 69, 46, 14);
		contentPanel.add(lblPeso);

		energiaTxtField = new JTextField();
		energiaTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				energiaTxtField.setForeground(Color.BLACK);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!Animal.energiaEsValida(energiaTxtField.getText())) {
					energiaTxtField.setForeground(Color.RED);
				} else {
					energiaTxtField.setForeground(Color.BLACK);
				}
			}
		});
		energiaTxtField.setBounds(81, 97, 106, 20);
		contentPanel.add(energiaTxtField);
		energiaTxtField.setColumns(10);

		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(32, 100, 65, 14);
		contentPanel.add(lblEnergia);

		chckbxHibernando = new JCheckBox("Hibernando");
		chckbxHibernando.setBounds(32, 140, 97, 23);
		contentPanel.add(chckbxHibernando);
		fechaTxtField = new JTextField();
		fechaTxtField.setEditable(false);
		fechaTxtField.setBounds(179, 149, 86, 20);
		contentPanel.add(fechaTxtField);
		fechaTxtField.setColumns(10);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String str = sdf.format(General.zoologico.getFecha().getTime());
		fechaTxtField.setText(str);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(179, 128, 46, 14);
		contentPanel.add(lblFecha);
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
			}
		}
	}

	/**
	 * Da de alta a un Mam&iacute;fero en el Zoo
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
			Animal mamifero = new Mamifero(
					(Alimentacion) alimentacionCBox.getSelectedItem(),
					aliasTxtField.getText(), Integer.parseInt(energiaTxtField
							.getText()), Double.parseDouble(pesoTxtField
							.getText()), General.zoologico.getFecha(), 1,
					(EspeciesMamiferos) especieCBox.getSelectedItem(),
					getHibernando());
			if (General.zoologico.annadir(mamifero)) {
				JOptionPane.showMessageDialog(okButton,
						"Mamifero añadido con exito");
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
			JOptionPane.showMessageDialog(contentPanel,
					"El Mamifero ya existe.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public boolean getHibernando() {
		if (chckbxHibernando.isSelected() == true) {
			return true;
		} else
			return false;
	}

}
