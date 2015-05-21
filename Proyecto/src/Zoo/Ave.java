package Zoo;

import java.util.Calendar;

/**
 * 
 * @author Antonio Luque Bravo
 *
 */
public class Ave extends Animal implements Desplazable {
	private EspeciesAves especiesAves;
	private boolean migrando;

	public Ave(Alimentacion tipoAlimentacion, String codigo, int energia,
			double peso, Calendar fecha) throws CodigoNoValidoException {
		super(tipoAlimentacion, codigo, energia, peso, fecha);
		setEspeciesAves(especiesAves);
		setMigrando(migrando);

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
		// TODO Auto-generated method stub

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

}
