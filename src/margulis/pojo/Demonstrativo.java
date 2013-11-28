package margulis.pojo;

public class Demonstrativo {
	
	int empid;
	int rodada;
	float resultado;
	int vendas;
	
	
	public Demonstrativo(int empid, int rodada, float resultado, int vendas) {
		super();
		this.empid = empid;
		this.rodada = rodada;
		this.resultado = resultado;
		this.vendas = vendas;
	}
	
	public Demonstrativo(int rodada, float resultado, int vendas) {
		super();
		this.empid = -1;
		this.rodada = rodada;
		this.resultado = resultado;
		this.vendas = vendas;
	}

	public int getEmpid() {
		return empid;
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
		this.empid = empid;
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
		return "Demonstrativo [empid=" + empid + ", rodada=" + rodada
				+ ", resultado=" + resultado + ", vendas=" + vendas + "]";
	}
	
	

}
