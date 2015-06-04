package Zoo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Clase para el almacenamiento en ficheros del Zoo.
 * 
 * @author Antonio Luque Bravo
 *
 */
@SuppressWarnings({ "serial", "unused" })
public class Fichero implements Serializable {
	public static File fichero = new File("Sin-titulo.zoo");

	/**
	 * Guarda el archivo.
	 * 
	 * @param object
	 *            Zoo.
	 * @param archivo
	 *            archivo de destino.
	 * @throws IOException
	 *             Error de E/S.
	 */
	public static void guardar(Object object, File archivo) throws IOException {
		archivo = annadirExtension(archivo);
		try (ObjectOutputStream salida = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(archivo, false)))) {
			salida.writeObject(object);
		}

	}

	/**
	 * Abre un archivo.
	 * 
	 * @param archivo
	 *            Archivo.
	 * @return Devuelve la lectura del archivo.
	 * @throws FileNotFoundException
	 *             No se encuentra el archivo.
	 * @throws IOException
	 *             Error de E/S.
	 * @throws ClassNotFoundException
	 *             La informaci&oacute;n no coincide.
	 */
	public static Object leer(File archivo) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		archivo = annadirExtension(archivo);
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(archivo)))) {
			return (Object) ois.readObject();
		}
	}

	/**
	 * Le a&ntilde;ade la extensi&oacute;n al archivo
	 * 
	 * @param archivo
	 *            Archivo.
	 * @return devuelve el archivo ya con la extensi&oacute;n.
	 */
	public static File annadirExtension(File archivo) {
		String extension = archivo.getPath();
		if (!extension.endsWith(".zoo"))
			return new File(archivo + ".zoo");
		return archivo;
	}

	/**
	 * Comprueba si el archivo ya existe.
	 * 
	 * @param archivo
	 *            Archivo.
	 * @return Devuelve su existencia.
	 */
	public static boolean confirmarExistencia(File archivo) {
		archivo = annadirExtension(archivo);
		return archivo.exists();
	}
}
