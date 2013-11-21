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

	public double getEstoqueInicial() {
		return estoqueInicial;
	}

	public double getCustosVariaveis() {
		return custosVariaveis;
	}

	public double getCustosFixos() {
		return custosFixos;
	}

	public double getDespesasAdministrativas() {
		return despesasAdministrativas;
	}

	public double getJurosEmprestimosBancarios() {
		return jurosEmprestimosBancarios;
	}

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
