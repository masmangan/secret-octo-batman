package margulis.pojo;

/**
 * 
 * @author marco
 *
 */
public class Demonstrativo {
	
	private int empID;
	private int rodada;
	private float resultado;
	private int vendas;
	private double demanda;
	
	
	public Demonstrativo(int empid, int rodada, float resultado, int vendas, double demanda) {
		super();
		this.empID = empid;
		this.rodada = rodada;
		this.resultado = resultado;
		this.vendas = vendas;
		this.demanda = demanda;
	}
	
	public Demonstrativo(int rodada, float resultado, int vendas, double demanda) {
		this(-1, rodada, resultado, vendas, demanda);
	}

	public int getEmpid() {
		return empID;
	}

	public int getRodada() {
		return rodada;
	}

	public float getResultado() {
		return resultado;
	}

	public int getVendas() {
		return vendas;
	}

	public void setEmpid(int empid) {
		this.empID = empid;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}

	public void setResultado(float resultado) {
		this.resultado = resultado;
	}

	public void setVendas(int vendas) {
		this.vendas = vendas;
	}
	
	public double getDemanda() {
		return demanda;
	}

	@Override
	public String toString() {
		return "Demonstrativo [empid=" + empID + ", rodada=" + rodada
				+ ", resultado=" + resultado + ", vendas=" + vendas + "]";
	}
	
	

}
