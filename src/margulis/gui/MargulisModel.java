package margulis.gui;

public class MargulisModel {

	private int round;
	private boolean started;

	public MargulisModel() {
		round = 0;
		started = false;
	}

	public void forward() {
		round++;
		started = true;
		// TODO gerar demonstrativos para cada empresa

	}
	
	public int getRound() {
		return round;
	}

	public boolean isStarted() {
		return started;
	}	
}
