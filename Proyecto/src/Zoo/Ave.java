package Zoo;

import java.util.Calendar;

/**
 * 
 * @author Antonio Luque Bravo
 *
 */
public class Ave extends Animal implements Desplazable, Energizable {
	private EspeciesAves especiesAves;
	private boolean migrando;

	public Ave(Alimentacion tipoAlimentacion, String codigo, int energia,
			double peso, Calendar fecha, EspeciesAves especiesAves,
			boolean migrando) throws CodigoNoValidoException {
		super(tipoAlimentacion, codigo, energia, peso, fecha);
		setEspeciesAves(especiesAves);
		setMigrando(migrando);

	}

	public static Ave instanciarAve(Alimentacion tipoAlimentacion,
			String codigo, int energia, double peso, Calendar fecha,
			EspeciesAves especiesAves, boolean migrando)
			throws CodigoNoValidoException {
		return new Ave(tipoAlimentacion, codigo, energia, peso, fecha,
				especiesAves, migrando);
	}

	@Override
	public void desplazarse() {
		switch (getEspeciesAves()) {
		case AVESTRUZ:
			correr();
			break;
		default:
			volar();
			break;
		}
	}

	private void correr() {

	}

	private void volar() {

	}

	public EspeciesAves getEspeciesAves() {
		return especiesAves;
	}

	public void setEspeciesAves(EspeciesAves especiesAves) {
		this.especiesAves = especiesAves;
	}

	public boolean isMigrando() {
		return migrando;
	}

	public void setMigrando(boolean migrando) {
		this.migrando = migrando;
	}

	@Override
	public void comer() {

	}

}
