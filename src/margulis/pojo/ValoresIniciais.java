package margulis.pojo;

/**
 * 
 * @author 
 *
 */
public class ValoresIniciais {

	private double estoqueInicial;
	private double custosVariaveis;
	private double custosFixos;
	private double despesasAdministrativas;
	private double jurosEmprestimosBancarios;
	private double impostoDeRenda;

	/**
	 * 
	 * @param estoqueInicial
	 * @param custosVariaveis
	 * @param custosFixos
	 * @param despesasAdministrativas
	 * @param jurosEmprestimosBancarios
	 * @param impostoDeRenda
	 */
	public ValoresIniciais(double estoqueInicial, double custosVariaveis,
			double custosFixos, double despesasAdministrativas,
			double jurosEmprestimosBancarios, double impostoDeRenda) {
		this.estoqueInicial = estoqueInicial;
		this.custosVariaveis = custosVariaveis;
		this.custosFixos = custosFixos;
		this.despesasAdministrativas = despesasAdministrativas;
		this.jurosEmprestimosBancarios = jurosEmprestimosBancarios;
		this.impostoDeRenda = impostoDeRenda;
	}

	/**
	 * 
	 * @return
	 */
	public double getEstoqueInicial() {
		return estoqueInicial;
	}

	/**
	 * 
	 * @return
	 */
	public double getCustosVariaveis() {
		return custosVariaveis;
	}

	/**
	 * 
	 * @return
	 */
	public double getCustosFixos() {
		return custosFixos;
	}

	/**
	 * 
	 * @return
	 */
	public double getDespesasAdministrativas() {
		return despesasAdministrativas;
	}

	/**
	 * 
	 * @return
	 */
	public double getJurosEmprestimosBancarios() {
		return jurosEmprestimosBancarios;
	}

	/**
	 * 
	 * @return
	 */
	public double getImpostoDeRenda() {
		return impostoDeRenda;
	}

	@Override
	public String toString() {
		return "ValoresIniciaisPOJO [estoqueInicial=" + estoqueInicial
				+ ", custosVariaveis=" + custosVariaveis + ", custosFixos="
				+ custosFixos + ", despesasAdministrativas="
				+ despesasAdministrativas + ", jurosEmprestimosBancarios="
				+ jurosEmprestimosBancarios + ", impostoDeRenda="
				+ impostoDeRenda + "]";
	}
}
