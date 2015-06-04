package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Ayuda del concesionario de coches.
 * 
 * @author Antonio Luque Bravo
 *
 */
@SuppressWarnings("serial")
public class AyudaGeneral extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Crea el di&aacute;logo.
	 */
	public AyudaGeneral() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				PrincipalGUI.ayudaGeneral = new AyudaGeneral();
				dispose();
			}
		});
		setResizable(false);
		setModal(false);
		setTitle("Ayuda");
		setBounds(100, 100, 589, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 573, 330);
		contentPanel.add(scrollPane);

		JEditorPane editor = new JEditorPane();
		editor.setEditable(false);
		editor.setContentType("text/html");
		editor.setText("<h1>Ayuda para Zool&oacute;gico de C&oacute;rdoba.</h1>\r\n<h2>Men&uacute;s implementados:</h2>\r\n<ol>\r\n\t<li>Men&uacute; Archivo contiene las siguientes opciones:</li>\r\n\t<ul>\r\n\t\t<li>Nuevo (Tecla de acceso r&aacute;pido Ctrl+N): Crea un nuevo zool&oacute;gico, pidiendo guardar si hubo alg&uacute;n zool&oacute;gico anterior sin guardar.</li>\r\n\t\t<li>Abrir (Tecla de acceso r&aacute;pido Ctrl+O): Abre un archivo que contenga un zool&oacute;gico previamente guardado, debe contener la extensi&oacute;n .zoo</li>\r\n\t\t<li>Guardar (Tecla de acceso r&aacute;pido Ctrl+S): Guarda un zool&oacute;gico en la carpeta que le indiques si no existiese tal archivo, de ser as&iacute; se guardar&aacute; automaticamente.</li>\r\n\t\t<li>Guardar como (Tecla de acceso r&aacute;pido Alt+S): Guarda un zool&oacute;gico en la carpeta que le indiques.</li>\r\n\t\t<li>Salir (Tecla de acceso r&aacute;pido Ctrl+Intro): Sale del programa.</li>\r\n\t</ul>\r\n\t<li>Men&uacute; Edici&oacute;n contiene las siguientes opciones:</li>\r\n\t<ul>\r\n\t\t<li>A&ntilde;adir Animal que a su vez contiene los men&uacute;s:</li>\r\n\t\t<ul>\r\n\t\t\t<li>A&ntilde;adir Mam&iacute;fero (Tecla de acceso r&aacute;pido Ctrl+M): A&ntilde;ade un mam&iacute;fero conteniendo su alias (El cual contiene las letras MAM seguido de un gui&oacute;n y cinco letras seguido de un gui&oacute;n y dos n&uacute;meros), peso (S&oacute;lo se admiten tres n&uacute;meros), energ&iacute;a (S&oacute;lo se admiten cuatro n&uacute;meros), una casilla para indicar si esta hibernando o no, la especie (Oso, Suricato, Tigre y Marmota), tipo de alimentaci&oacute;n (Carn&iacute;voro, Herb&iacute;voro u Omn&iacute;voro) y la fecha de cuando se ha almacenado el mam&iacute;fero.</li>\r\n\t\t\t<li>A&ntilde;adir Ave (Tecla de acceso r&aacute;pido Ctrl+A): A&ntilde;ade un ave conteniendo su alias (El cual contiene las letras AVE seguido de un gui&oacute;n y cinco letras seguido de un gui&oacute;n y dos n&uacute;meros), peso (S&oacute;lo se admiten tres n&uacute;meros), energ&iacute;a (S&oacute;lo se admiten cuatro n&uacute;meros), una casilla para indicar si esta migrando o no, la especie (Avestruz, &Aacute;guila, Golondrina), tipo de alimentaci&oacute;n (Carn&iacute;voro, Herb&iacute;voro u Omn&iacute;voro) y la fecha de cuando se ha almacenado el ave.\r\n\t\t\t<li>A&ntilde;adir Pez (Tecla de acceso r&aacute;pido Ctrl+P): A&ntilde;ade un pez conteniendo su alias (El cual contiene las letras PEZ seguido de un gui&oacute;n y cinco letras seguido de un gui&oacute;n y dos n&uacute;meros), peso (S&oacute;lo se admiten tres n&uacute;meros), energ&iacute;a (S&oacute;lo se admiten cuatro n&uacute;meros), una casilla para indicar si posee escamas o no, la especie (Tibur&oacute;n, Salm&oacute;n, Carpa, Pez gato), tipo de alimentaci&oacute;n (Carn&iacute;voro, Herb&iacute;voro u Omn&iacute;voro) y la fecha de cuando se ha almacenado el pez.\r\n\t\t</ul>\r\n\t\t<li>Eliminar Animal (Tecla de acceso r&aacute;pido Ctrl+D): Elimina un animal del zool&oacute;gico por su alias.</li>\r\n\t</ul>\r\n\t<li>Men&uacute; Interacci&oacute;n contiene las siguientes opciones:</li>\r\n\t<ul>\r\n\t\t<li>Alimentar Animales (Tecla de acceso r&aacute;pido Shift+C): Muestra los animales del Zoo y puedes darle de comer aumentando as&iacute; su energ&iacute;a y su peso dependiendo del animal que sea.</li>\r\n\t\t<li>Desplazar Animales (Tecla de acceso r&aacute;pido Shift+D): Muestra los animales del Zoo y puedes desplazarlos disminuyendo as&iacute; su energ&iacute;a y su peso dependiendo del animal que sea.</li>\r\n\t</ul>\r\n\t<li>Men&uacute; Mostrar contiene las siguientes opciones:</li>\r\n\t<ul>\r\n\t\t<li>Numero de Animales (Tecla de acceso r&aacute;pido Alt+C): Muestra el n&uacute;mero de animales en el Zoo.</li>\r\n\t\t<li>Mostrar Zoologico (Tecla de acceso r&aacute;pido Shift+M): Muestra los animales del Zoo mostrando su alias, energ&iacute;a y peso actuales, una casilla seleccionada o no si esta hibernando (Mam&iacute;fero), migrando (Ave) o si posee escamas (Pez), la especie del animal dependiendo de si es Mam&iacute;fero, Ave o Pez, y la fecha de cuando se almacen&oacute; el animal.</li>\r\n\t</ul>\r\n\t<li>Men&uacute; Ayuda contiene las siguientes opciones:</li>\r\n\t<ul>\r\n\t\t<li>Acerca de (Tecla de acceso r&aacute;pido Ctrl+Shift+A): Muestra el nombre del programa, su versi&oacute;n, informaci&oacute;n del creador, curso al que pertenece y el tipo de licencia a la que est&aacute; sujeto el programa.</li>\r\n\t\t<li>Ayuda (Tecla de acceso r&aacute;pido Ctrl+Y): Manual de los distintos men&uacute;s que implementa este programa.</li>\r\n\t</ul>\r\n</ol>\r\n");
		scrollPane.setViewportView(editor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JButton okButton = new JButton("Atr\u00E1s");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						PrincipalGUI.ayudaGeneral = new AyudaGeneral();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}

	}
}