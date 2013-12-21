package margulis.pojo;

/**
 * 
 * @author marco
 *
 */
public class SensibilidadeMarketing {

	public static double[][] tabela = { { 0, 0.0000 }, { 1000, 0.0033 },
			{ 4500, 0.0067 }, { 8000, 0.0100 }, { 11500, 0.0133 },
			{ 15000, 0.0167 }, { 18500, 0.0200 }, { 22000, 0.0233 },
			{ 25500, 0.0267 }, { 29000, 0.0300 }, { 32500, 0.0333 },
			{ 36000, 0.0367 }, { 39500, 0.0400 }, { 43000, 0.0433 },
			{ 46500, 0.0467 }, { 50000, 0.0500 }, { 53500, 0.0533 },
			{ 57000, 0.0567 }, { 60500, 0.0600 }, { 64000, 0.0633 },
			{ 67500, 0.0667 }, { 71000, 0.0700 }, { 74500, 0.0733 },
			{ 78000, 0.0767 }, { 81500, 0.0800 }, { 85000, 0.0833 },
			{ 88500, 0.0867 }, { 92000, 0.0900 }, { 95500, 0.0933 },
			{ 99000, 0.0967 }, { 100000, 0.1000 } };

	/**
	 * 
	 * @param valor
	 * @return
	 */
	public static double getSensibilidade(double valor) {
		if (valor < tabela[0][0]) {
			throw new IllegalArgumentException();
		}
		double sensibilidade = 0;
		int i = 0;
		while (valor >= tabela[i][0]) {
			i++;
		}
		i--;
		sensibilidade = tabela[i][1];
		return sensibilidade;
	}
}
