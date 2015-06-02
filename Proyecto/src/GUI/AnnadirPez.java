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
import Zoo.AnimalYaExisteException;
import Zoo.CodigoNoValidoException;
import Zoo.EspeciesPeces;
import Zoo.Pez;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnnadirPez extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField aliasTxtField;
	private JTextField pesoTxtField;
	private JTextField energiaTxtField;
	private JComboBox especieCBox;
	private JButton okButton;
	private JComboBox alimentacionCBox;
	private GregorianCalendar fecha;
	private JCheckBox chckbxEscamas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AnnadirPez dialog = new AnnadirPez();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AnnadirPez() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 330, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			aliasTxtField = new JTextField();
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
			energiaTxtField.setColumns(10);
			energiaTxtField.setBounds(92, 100, 106, 20);
			contentPanel.add(energiaTxtField);
		}
		{
			chckbxEscamas = new JCheckBox("Escamas");
			chckbxEscamas.setBounds(39, 141, 97, 23);
			contentPanel.add(chckbxEscamas);
		}
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
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

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
							.getText()), fecha.getInstance(),
					(EspeciesPeces) especieCBox.getSelectedItem(),
					chckbxEscamas.isSelected());
			if (General.zoologico.annadir(pez, aliasTxtField.getText())) {
				JOptionPane
						.showMessageDialog(okButton, "Pez añadido con exito");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPanel, "Formato no válido",
					"Error", JOptionPane.ERROR_MESSAGE);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
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
			// } catch (AnimalYaExisteException e) {
			// JOptionPane.showMessageDialog(contentPanel,
			// "El Mamifero ya existe.", "Error",
			// JOptionPane.ERROR_MESSAGE);
		}

	}
}
