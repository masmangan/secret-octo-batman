package margulis.pojo;

/**
 * 
 * @author 
 *
 */
public class Empresa {
	
	private int empid;
	private String nome,responsavel;
	
	public Empresa(int empid, String nome, String responsavel) {
		super();
		this.empid = empid;
		this.nome = nome;
		this.responsavel = responsavel;
	}
	

	public Empresa(String nome, String responsavel) {
		super();
		this.empid= -1;
		this.nome = nome;
		this.responsavel = responsavel;
	}


	public int getEmpId() {
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
