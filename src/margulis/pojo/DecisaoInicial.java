package margulis.pojo;

/**
 * 
 * @author 
 *
 */
public class DecisaoInicial {

	private double preco;
	private double marketing;
	private int producao;
	
	
	public DecisaoInicial(double preco, double marketing, int producao) {
		super();
		this.preco = preco;
		this.marketing = marketing;
		this.producao = producao;
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


	public int getProducao() {
		return producao;
	}


	public void setProducao(int producao) {
		this.producao = producao;
	}
	
	
	
	
}
