package margulis.pojo;

/**
 * A sensibilidade do preço é calculada pelo valor inicial da influência do
 * preço.
 * 
 * <p>
 * Cada faixa é separada pelo intervalo ((valor inicial) - 0.1)/16.
 * 
 * <p>
 * A primeira faixa inicia no valor zero, cada faixa é separada pelo intervalo
 * 5.
 * 
 * <p>
 * As primeiras faixas são (0; 0,90), (5; 0,85), (10; 0,80)...(85; 0,05), (90;
 * 0), (95; 0,05)...(185; -0,95), (190; -1,00), (195; -1,00)... (290; -1,00)
 * 
 * <p>
 * A influência negativa é limitada no valor -1.
 * 
 * @author marco
 * 
 */
public class SensibilidadePreco {

	/**
	 * 
	 */
	public static double[][] tabela = { { 0, 0.90 }, { 5, 0.85 }, { 10, 0.80 },
			{ 15, 0.75 }, { 20, 0.70 }, { 25, 0.65 }, { 30, 0.60 },
			{ 35, 0.55 }, { 40, 0.50 }, { 45, 0.45 }, { 50, 0.40 },
			{ 55, 0.35 }, { 60, 0.30 }, { 65, 0.25 }, { 70, 0.20 },
			{ 75, 0.15 }, { 80, 0.10 }, { 85, 0.05 }, { 90, 0 }, { 95, -0.05 },
			{ 100, -0.10 }, { 105, -0.15 }, { 110, -0.20 }, { 115, -0.25 },
			{ 120, -0.30 }, { 125, -0.35 }, { 130, -0.40 }, { 135, -0.45 },
			{ 140, -0.50 }, { 145, -0.55 }, { 150, -0.60 }, { 155, -0.65 },
			{ 160, -0.70 }, { 165, -0.75 }, { 170, -0.80 }, { 175, -0.85 },
			{ 180, -0.90 }, { 185, -0.95 }, { 190, -1.00 }, { 195, -1.00 },
			{ 200, -1.00 }, { 205, -1.00 }, { 210, -1.00 }, { 215, -1.00 },
			{ 220, -1.00 }, { 225, -1.00 }, { 230, -1.00 }, { 235, -1.00 },
			{ 240, -1.00 }, { 245, -1.00 }, { 250, -1.00 }, { 255, -1.00 },
			{ 260, -1.00 }, { 265, -1.00 }, { 270, -1.00 }, { 275, -1.00 },
			{ 280, -1.00 }, { 285, -1.00 }, { 290, -1.00 }, };

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
