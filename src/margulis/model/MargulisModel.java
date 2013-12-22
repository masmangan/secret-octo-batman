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

	private PropertyChangeSupport mPcs = new PropertyChangeSupport(this);

	/**
	 * 
	 */
	public MargulisModel() {
		round = 0;
		started = false;
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
}
