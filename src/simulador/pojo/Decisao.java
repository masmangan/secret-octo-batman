package simulador.pojo;

public class Decisao {
	
	private int empid;
	private String periodo;
	private double preco;
	private double marketing;
	private int quantidade;
	
	public Decisao(int empid, String periodo, double preco, double marketing,
			int quantidade) {
		super();
		this.empid = empid;
		this.periodo = periodo;
		this.preco = preco;
		this.marketing = marketing;
		this.quantidade = quantidade;
	}

	public Decisao(String periodo, double preco, double marketing,
			int quantidade) {
		super();
		this.periodo = periodo;
		this.preco = preco;
		this.marketing = marketing;
		this.quantidade = quantidade;
	}

	public int getEmpid() {
		return empid;
	}

	public String getPeriodo() {
		return periodo;
	}

	public double getPreco() {
		return preco;
	}

	public double getMarketing() {
		return marketing;
	}

	public int getQuantidade() {
		return quantidade;
	}

	@Override
	public String toString() {
		return String
				.format("Decisao [empid=%s, periodo=%s, preco=%s, marketing=%s, quantidade=%s]",
						empid, periodo, preco, marketing, quantidade);
	}

	
	

}
