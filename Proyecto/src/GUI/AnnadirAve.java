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
import Zoo.Ave;
import Zoo.CodigoNoValidoException;
import Zoo.EspeciesAves;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Ventana que a&ntilde;ade un Ave al Zool&oacute;gico
 * 
 * @author Antonio Luque Bravo
 *
 */
public class AnnadirAve extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField aliasTxtField;
	private JTextField pesoTxtField;
	private JTextField energiaTxtField;
	private JComboBox alimentacionCBox;
	private JComboBox especieCBox;
	private Animal fecha;
	private JCheckBox chckbxMigrando;
	private JButton okButton;
	private JTextField fechaTxtField;

	/**
	 * Crea la ventana.
	 */
	public AnnadirAve() {
		setTitle("A\u00F1adir Ave");
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
				if (!Ave.esValido(aliasTxtField.getText())) {
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
		aliasTxtField.setColumns(10);
		aliasTxtField.setBounds(91, 31, 106, 20);
		contentPanel.add(aliasTxtField);

		JLabel aliasLabel = new JLabel("Alias");
		aliasLabel.setBounds(42, 34, 46, 14);
		contentPanel.add(aliasLabel);

		JLabel pesoLabel = new JLabel("Peso");
		pesoLabel.setBounds(42, 65, 46, 14);
		contentPanel.add(pesoLabel);

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

			/**
			 * Cuando gane el foco se volver&aacute; el texto negro.
			 */
			@Override
			public void focusGained(FocusEvent e) {
				pesoTxtField.setForeground(Color.BLACK);
			}
		});
		pesoTxtField.setColumns(10);
		pesoTxtField.setBounds(91, 62, 106, 20);
		contentPanel.add(pesoTxtField);

		JLabel energiaLabel = new JLabel("Energia");
		energiaLabel.setBounds(42, 96, 65, 14);
		contentPanel.add(energiaLabel);

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
			 * valido, de ser asi lo mostrar&aacute; el texto de color negro, de
			 * lo contrario lo mostrar&aacute; rojo.
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
		energiaTxtField.setBounds(91, 93, 106, 20);
		contentPanel.add(energiaTxtField);

		JLabel especieLabel = new JLabel("Especie");
		especieLabel.setBounds(42, 176, 155, 14);
		contentPanel.add(especieLabel);

		especieCBox = new JComboBox();
		especieCBox.setModel(new DefaultComboBoxModel(EspeciesAves.values()));
		especieCBox.setBounds(42, 201, 114, 28);
		contentPanel.add(especieCBox);

		JLabel alimentacionLabel = new JLabel("Tipo de alimentaci\u00F3n");
		alimentacionLabel.setBounds(189, 176, 155, 14);
		contentPanel.add(alimentacionLabel);

		alimentacionCBox = new JComboBox();
		alimentacionCBox.setModel(new DefaultComboBoxModel(Alimentacion
				.values()));
		alimentacionCBox.setBounds(189, 201, 114, 28);
		contentPanel.add(alimentacionCBox);

		chckbxMigrando = new JCheckBox("Migrando");
		chckbxMigrando.setBounds(42, 144, 97, 23);
		contentPanel.add(chckbxMigrando);

		fechaTxtField = new JTextField();
		fechaTxtField.setEditable(false);
		fechaTxtField.setBounds(189, 145, 86, 20);
		contentPanel.add(fechaTxtField);
		fechaTxtField.setColumns(10);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String str = sdf.format(General.zoologico.getFecha().getTime());
		fechaTxtField.setText(str);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(189, 124, 46, 14);
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	/**
	 * Da de alta a un ave en el Zoo
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
			Animal ave = new Ave(
					(Alimentacion) alimentacionCBox.getSelectedItem(),
					aliasTxtField.getText(), Integer.parseInt(energiaTxtField
							.getText()), Double.parseDouble(pesoTxtField
							.getText()), General.zoologico.getFecha(),
					(EspeciesAves) especieCBox.getSelectedItem(), 2,
					chckbxMigrando.isSelected());
			if (General.zoologico.annadir(ave)) {
				JOptionPane
						.showMessageDialog(okButton, "Ave añadido con exito");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPanel, "Formato no válido",
					"Error", JOptionPane.ERROR_MESSAGE);
		} catch (HeadlessException e) {
			e.printStackTrace();
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
			JOptionPane.showMessageDialog(contentPanel, "El Ave ya existe.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
