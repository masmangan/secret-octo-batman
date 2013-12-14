package margulis.pojo;

public class Demonstrativo {
	
	private int empID;
	private int rodada;
	private float resultado;
	private int vendas;
	
	
	public Demonstrativo(int empid, int rodada, float resultado, int vendas) {
		super();
		this.empID = empid;
		this.rodada = rodada;
		this.resultado = resultado;
		this.vendas = vendas;
	}
	
	public Demonstrativo(int rodada, float resultado, int vendas) {
		this(-1, rodada, resultado, vendas);
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

	@Override
	public String toString() {
		return "Demonstrativo [empid=" + empID + ", rodada=" + rodada
				+ ", resultado=" + resultado + ", vendas=" + vendas + "]";
	}
	
	

}
