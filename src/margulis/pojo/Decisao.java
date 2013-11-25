package margulis.pojo;

/**
 * 
 * @author Dias
 *
 */
public class Decisao {
	
	private int decisaoid;
	private int empid;
	private int rodada;
	private double preco;
	private double marketing;
	private int producao;
	public Decisao(int empid, int rodada, double preco, double marketing,
			int producao) {
		super();
		this.empid = empid;
		this.rodada = rodada;
		this.preco = preco;
		this.marketing = marketing;
		this.producao = producao;
	}
	public Decisao(int decisaoid, int empid, int rodada, double preco,
			double marketing, int producao) {
		super();
		this.decisaoid = decisaoid;
		this.empid = empid;
		this.rodada = rodada;
		this.preco = preco;
		this.marketing = marketing;
		this.producao = producao;
	}
	public int getDecisaoid() {
		return decisaoid;
	}
	public int getEmpid() {
		return empid;
	}
	public int getRodada() {
		return rodada;
	}
	public double getPreco() {
		return preco;
	}
	public double getMarketing() {
		return marketing;
	}
	public int getProducao() {
		return producao;
	}
	@Override
	public String toString() {
		return String
				.format("Decisao [decisaoid=%s, empid=%s, rodada=%s, preco=%s, marketing=%s, producao=%s]",
						decisaoid, empid, rodada, preco, marketing, producao);
	}
	
}
