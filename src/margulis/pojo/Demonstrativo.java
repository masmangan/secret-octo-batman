package margulis.pojo;

/**
 * 
 * @author marco
 *
 */
public class Demonstrativo {
	
	private int empID;
	private int rodada;
	public double caixa;
	public double estoque;
	public int estoqueEmUN;
	public double maquinas;
	public double depreciacao;
	public double contasAPagar;
	public double emprestimos;
	public double provisao;
	public double capitalSocial;
	public double lucrosPrejuizos;
	public double receita;
	public double cpv;
	public double lucroBruto;
	public double despesasVendas;
	public double resultadoFinanceiro;
	public double despesasAdministrativas;
	public double lair;
	public double provisaoIR;
	public double resultado;
	public int vendas;
	public int demanda;
	private int demandaNaoAtendida;	
	
	public Demonstrativo(int empid, int rodada) {
		super();
		this.empID = empid;
		this.rodada = rodada;
	}
	
	public Demonstrativo() {
		this(-1, 0);
		caixa = 110000;
		estoque = 0;
		estoqueEmUN = 0;
		maquinas = 100000;
		depreciacao = 0;
		contasAPagar = 0;
		emprestimos = 0;
		provisaoIR = 1500;
		capitalSocial = 200000;
		
		receita = 400000;
		cpv = 360000;
//		LPINICIAL = 8500
//				LOBINICIAL = RECEITAINICIAL - CPVINICIAL
		
//				DESPVENDAINICIAL = 20000
//				RESFININICIAL = 0
//				DESPADMINCIAL = 10000
//				LAIRINICIAL = LOBINICIAL - DESPVENDAINICIAL - RESFININICIAL - DESPADMINCIAL

//				IRINICIAL = LAIRINICIAL * 0.15
//				LLINICIAL = LAIRINICIAL - IRINICIAL

//				UNDSVENDIDAS = 5000
		demanda = 6327;				
//				DEMANDANAOATENDIDAINICIAL = DEMANDAINICIAL - UNDSVENDIDAS

//				PRODUCAOEMUNMONETARIASINICIAL = 360000
	}	

	public int getEmpid() {
		return empID;
	}

	public int getRodada() {
		return rodada;
	}

	public double getResultado() {
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
	
	public int getDemanda() {
		return demanda;
	}

	@Override
	public String toString() {
		return "Demonstrativo [empid=" + empID + ", rodada=" + rodada
				+ ", resultado=" + resultado + ", vendas=" + vendas + "]";
	}

	public int getEmpID() {
		return empID;
	}

	public double getCaixa() {
		return caixa;
	}

	public double getEstoque() {
		return estoque;
	}

	public int getEstoqueEmUN() {
		return estoqueEmUN;
	}

	public double getMaquinas() {
		return maquinas;
	}

	public double getDepreciacao() {
		return depreciacao;
	}

	public double getContasAPagar() {
		return contasAPagar;
	}

	public double getEmprestimos() {
		return emprestimos;
	}

	public double getProvisao() {
		return provisao;
	}

	public double getCapitalSocial() {
		return capitalSocial;
	}

	public double getLucrosPrejuizos() {
		return lucrosPrejuizos;
	}

	public double getReceita() {
		return receita;
	}

	public double getCpv() {
		return cpv;
	}

	public double getLucroBruto() {
		return lucroBruto;
	}

	public double getDespesasVendas() {
		return despesasVendas;
	}

	public double getResultadoFinanceiro() {
		return resultadoFinanceiro;
	}

	public double getDespesasAdministrativas() {
		return despesasAdministrativas;
	}

	public double getLair() {
		return lair;
	}

	public double getProvisaoIR() {
		return provisaoIR;
	}

	public int getDemandaNaoAtendida() {
		return demandaNaoAtendida;
	}
	
	

}
