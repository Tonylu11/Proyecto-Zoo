package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;

public class AnnadirMamifero extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		setBounds(100, 100, 309, 304);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(111, 26, 106, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(55, 29, 46, 14);
		contentPanel.add(lblCdigo);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Colores",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(35, 58, 121, 98);
			contentPanel.add(panel);
			panel.setLayout(null);

			JRadioButton rdbtnNegro = new JRadioButton("Negro");
			rdbtnNegro.setBounds(6, 42, 109, 23);
			panel.add(rdbtnNegro);
			buttonGroup.add(rdbtnNegro);
			{
				JRadioButton rdbtnMarrn = new JRadioButton("Marr\u00F3n");
				rdbtnMarrn.setBounds(6, 68, 109, 23);
				panel.add(rdbtnMarrn);
				buttonGroup.add(rdbtnMarrn);
			}
			{
				JRadioButton rdbtnGris = new JRadioButton("Blanco");
				rdbtnGris.setBounds(6, 16, 109, 23);
				panel.add(rdbtnGris);
				buttonGroup.add(rdbtnGris);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
