package margulis.pojo;

/**
 * Records the decisions of a company in a single simulation round.
 * 
 * There are three decisions, product price, marketing investiment, and
 * production order.
 * 
 * @author Dias
 * @author marco.mangan@gmail.com
 */
public class Decisao {

	private int decisaoId;
	private int empId;

	private int rodada;

	private double preco;
	private double marketing;
	private int producao;

	/**
	 * Default values for initial decision.
	 */
	public Decisao() {
		this(-1, -1, -1, 80.0, 20000.0, 5000);
	}

	/**
	 * 
	 * @param empId
	 * @param rodada
	 * @param preco
	 * @param marketing
	 * @param producao
	 */
	public Decisao(int empId, int rodada, double preco, double marketing,
			int producao) {
		this(-1, empId, rodada, preco, marketing, producao);
	}

	/**
	 * 
	 * @param decisaoId
	 * @param empId
	 * @param rodada
	 * @param preco
	 * @param marketing
	 * @param producao
	 */
	public Decisao(int decisaoId, int empId, int rodada, double preco,
			double marketing, int producao) {
		super();
		this.decisaoId = decisaoId;
		this.empId = empId;
		this.rodada = rodada;
		this.preco = preco;
		this.marketing = marketing;
		this.producao = producao;
	}

	/**
	 * 
	 * @return
	 */
	public int getDecisaoId() {
		return decisaoId;
	}

	/**
	 * 
	 * @return
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * 
	 * @return
	 */
	public int getRodada() {
		return rodada;
	}

	/**
	 * 
	 * @return
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * 
	 * @return
	 */
	public double getMarketing() {
		return marketing;
	}

	/**
	 * 
	 * @return
	 */
	public int getProducao() {
		return producao;
	}

	@Override
	public String toString() {
		return String
				.format("Decisao [decisaoid=%s, empid=%s, rodada=%s, preco=%s, marketing=%s, producao=%s]",
						decisaoId, empId, rodada, preco, marketing, producao);
	}

}
