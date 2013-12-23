package margulis.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * 
 * @author marco
 *
 */
public class MargulisModel {

	private int round;
	private boolean started;
	
	private DecisaoTableModel decisaoModel;
	private EmpresaTableModel empresaModel;
	private DemonstrativoTableModel demonstrativoModel;


	private PropertyChangeSupport mPcs = new PropertyChangeSupport(this);

	/**
	 * 
	 */
	public MargulisModel() {
		round = 0;
		started = false;
		decisaoModel = new DecisaoTableModel();
		empresaModel = new EmpresaTableModel();
		demonstrativoModel = new DemonstrativoTableModel(decisaoModel);
		addPropertyChangeListener(demonstrativoModel);
	}

	/**
	 * 
	 */
	public void forward() {
		int oldRound = round;
		round++;
		started = true;
		// TODO gerar demonstrativos para cada empresa
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

	public DecisaoTableModel getDecisaoModel() {
		return decisaoModel;
	}

	public EmpresaTableModel getEmpresaModel() {
		return empresaModel;
	}

	public DemonstrativoTableModel getDemonstrativoModel() {
		return demonstrativoModel;
	}
	
	
	
}
