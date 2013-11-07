
public class empresa {
	
	private int empid;
	private String nome,responsavel;
	
	public empresa(int empid, String nome, String responsavel) {
		super();
		this.empid = empid;
		this.nome = nome;
		this.responsavel = responsavel;
	}

	public int getEmpid() {
		return empid;
	}

	public String getNome() {
		return nome;
	}

	public String getResponsavel() {
		return responsavel;
	}

	@Override
	public String toString() {
		return "empresa [empid=" + empid + ", nome=" + nome + ", responsavel="
				+ responsavel + "]";
	}
	
	

}
