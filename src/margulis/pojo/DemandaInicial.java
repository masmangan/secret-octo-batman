package margulis.pojo;

public class DemandaInicial {
	
	private double padrao;
	private double preco;
	private double marketing;
	
	public DemandaInicial(double padrao, double preco, double marketing) {
		super();
		this.padrao = padrao;
		this.preco = preco;
		this.marketing = marketing;
	}

	public double getPadrao() {
		return padrao;
	}

	public void setPadrao(double padrao) {
		this.padrao = padrao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getMarketing() {
		return marketing;
	}

	public void setMarketing(double marketing) {
		this.marketing = marketing;
	}

	@Override
	public String toString() {
		return "DemandaInicial [padrao=" + padrao + ", preco=" + preco
				+ ", marketing=" + marketing + "]";
	}
	
	
}
