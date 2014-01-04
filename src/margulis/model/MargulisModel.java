package margulis.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import margulis.pojo.Decisao;
import margulis.pojo.Demonstrativo;

/**
 * Class {@code MargulisModel} is a simple simulation model.
 * 
 * @author marco
 */
public class MargulisModel {

	/**
	 * Current round.
	 */
	private int round;

	/**
	 * Simulation already started.
	 */
	private boolean started;

	/**
	 * Holds decisions for each company.
	 */
	private DecisaoTableModel decisaoModel;

	/**
	 * Holds company descriptions.
	 */
	private EmpresaTableModel empresaModel;

	/**
	 * Holds company results.
	 */
	private DemonstrativoTableModel demonstrativoModel;

	/**
	 * 
	 */
	private Decisao decisaoInicial;

	/**
	 * 
	 */
	private Demonstrativo demonstrativoInicial;

	/**
	 * Support for listeners.
	 */
	private PropertyChangeSupport mPcs = new PropertyChangeSupport(this);

	/**
	 * Sets a new simulation instance.
	 */
	public MargulisModel() {
		round = -1;
		started = false;
		decisaoModel = new DecisaoTableModel();
		empresaModel = new EmpresaTableModel();
		demonstrativoModel = new DemonstrativoTableModel(this);
		decisaoInicial = new Decisao();
		demonstrativoInicial = new Demonstrativo();
		addPropertyChangeListener(demonstrativoModel);
	}

	/**
	 * Notifies listeners about a new round.
	 */
	public void forward() {
		int oldRound = round;
		round++;
		started = true;
		mPcs.firePropertyChange("round", oldRound, round);
	}

	/**
	 * 
	 * @param listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		mPcs.addPropertyChangeListener(listener);
	}

	/**
	 * 
	 * @param listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		mPcs.removePropertyChangeListener(listener);
	}

	/**
	 * 
	 * @return
	 */
	public int getRound() {
		return round;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isStarted() {
		return started;
	}

	/**
	 * 
	 * @return
	 */
	public DecisaoTableModel getDecisaoModel() {
		return decisaoModel;
	}

	/**
	 * 
	 * @return
	 */
	public EmpresaTableModel getEmpresaModel() {
		return empresaModel;
	}

	/**
	 * 
	 * @return
	 */
	public DemonstrativoTableModel getDemonstrativoModel() {
		return demonstrativoModel;
	}

	/**
	 * 
	 * @return
	 */
	public Decisao getDecisaoInicial() {
		return decisaoInicial;
	}

	/**
	 * 
	 * @return
	 */
	public Demonstrativo getDemonstrativoInicial() {
		return demonstrativoInicial;
	}

}
