package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;

import Zoo.Animal;
import Zoo.CodigoNoValidoException;
import Zoo.Mamifero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class AnnadirMamifero extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AnnadirMamifero dialog = new AnnadirMamifero();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AnnadirMamifero() {
		setBounds(100, 100, 358, 392);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(88, 63, 106, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}

		JLabel lblCdigo = new JLabel("Alias");
		lblCdigo.setBounds(32, 66, 46, 14);
		contentPanel.add(lblCdigo);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(115, 122, 114, 28);
		contentPanel.add(comboBox);

		JLabel lblTipoDeAlimentacin = new JLabel("Tipo de alimentaci\u00F3n");
		lblTipoDeAlimentacin.setBounds(10, 129, 155, 14);
		contentPanel.add(lblTipoDeAlimentacin);

		textField_1 = new JTextField();
		textField_1.setBounds(115, 11, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblCdigo_1 = new JLabel("C\u00F3digo");
		lblCdigo_1.setBounds(32, 14, 46, 14);
		contentPanel.add(lblCdigo_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// alta();
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
			}
		}
	}
}
