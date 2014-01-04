package margulis.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import margulis.pojo.Decisao;
import margulis.pojo.Demonstrativo;
import margulis.pojo.SensibilidadePreco;

/**
 * 
 * @author Dias
 * @author marco.mangan@gmail.com
 * 
 */
public class DemonstrativoTableModel extends AbstractTableModel implements
		PropertyChangeListener {

	/**
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private List<Demonstrativo> demonstrativos;

	private DecisaoTableModel decisaoModel;

	private MargulisModel model;

	/**
	 * @param decisaoModel
	 * 
	 */
	public DemonstrativoTableModel(MargulisModel model) {
		// DemonstrativoDAO dao = new DemonstrativoDAO();

		// lista = dao.findDemonstrativoByPeriodo();
		demonstrativos = new ArrayList<Demonstrativo>();
		decisaoModel = model.getDecisaoModel();
		this.model = model;
	}

	@Override
	public int getColumnCount() {
		return 24;
	}

	@Override
	public int getRowCount() {
		return demonstrativos.size();
	}

	@Override
	public Object getValueAt(int lin, int col) {
		Demonstrativo demonstrativo = demonstrativos.get(lin);
		Object value;

		switch (col) {
		case 0:
			value = demonstrativo.getEmpid();
			break;
		case 1:
			value = demonstrativo.getRodada();
			break;
		case 2:
			value = demonstrativo.getCaixa();
			break;
		case 3:
			value = demonstrativo.getEstoque();
			break;
		case 4:
			value = demonstrativo.getEstoqueEmUN();
			break;
		case 5:
			value = demonstrativo.getMaquinas();
			break;
		case 6:
			value = demonstrativo.getDepreciacao();
			break;
		case 7:
			value = demonstrativo.getContasAPagar();
			break;
		case 8:
			value = demonstrativo.getEmprestimos();
			break;
		case 9:
			value = demonstrativo.getProvisao();
			break;
		case 10:
			value = demonstrativo.getCapitalSocial();
			break;
		case 11:
			value = demonstrativo.getLucrosPrejuizos();
			break;
		case 12:
			value = demonstrativo.getReceita();
			break;
		case 13:
			value = demonstrativo.getCpv();
			break;
		case 14:
			value = demonstrativo.getLucroBruto();
			break;
		case 15:
			value = demonstrativo.getDespesasVendas();
			break;
		case 16:
			value = demonstrativo.getResultadoFinanceiro();
			break;
		case 17:
			value = demonstrativo.getDespesasAdministrativas();
			break;
		case 18:
			value = demonstrativo.getLair();
			break;
		case 19:
			value = demonstrativo.getProvisaoIR();
			break;
		case 20:
			value = demonstrativo.getResultado();
			break;
		case 21:
			value = demonstrativo.getVendas();
			break;
		case 22:
			value = demonstrativo.getDemanda();
			break;
		case 23:
			value = demonstrativo.getDemandaNaoAtendida();
			break;
		default:
			value = "*ERRO*";
			break;
		}
		return value;
	}

	@Override
	public String getColumnName(int col) {
		String value;
		switch (col) {
		case 0:
			value = "Empid";
			break;
		case 1:
			value = "Rodada";
			break;
		case 2:
			value = "Caixa";
			break;
		case 3:
			value = "Estoque";
			break;
		case 4:
			value = "EstoqueEmUN";
			break;
		case 5:
			value = "Maquinas";
			break;
		case 6:
			value = "Depreciacao";
			break;
		case 7:
			value = "ContasAPagar";
			break;
		case 8:
			value = "Emprestimos";
			break;
		case 9:
			value = "Provisao";
			break;
		case 10:
			value = "CapitalSocial";
			break;
		case 11:
			value = "LucrosPrejuizos";
			break;
		case 12:
			value = "Receita";
			break;
		case 13:
			value = "Cpv";
			break;
		case 14:
			value = "LucroBruto";
			break;
		case 15:
			value = "DespesasVendas";
			break;
		case 16:
			value = "ResultadoFinanceiro";
			break;
		case 17:
			value = "DespesasAdministrativas";
			break;
		case 18:
			value = "Lair";
			break;
		case 19:
			value = "ProvisaoIR";
			break;
		case 20:
			value = "Resultado";
			break;
		case 21:
			value = "Vendas";
			break;
		case 22:
			value = "Demanda";
			break;
		case 23:
			value = "DemandaNaoAtendida";
			break;
		default:
			value = "*ERRO*";
			break;
		}
		return value;
	}

	/**
	 * 
	 * @param rodada
	 */
	public void step(int rodada) {
		// FIXME: calculate results
		int firstRow = demonstrativos.size();
		if (0 == rodada) {
			// para cada EMPRESA, incluir decisao inicial...
			for (Decisao d : decisaoModel) {
				if (rodada == d.getRodada()) {
					Demonstrativo demonstrativoInicial = model
							.getDemonstrativoInicial();
					// FIXME: select * from decisoes where rodada = ?
					Demonstrativo de = new Demonstrativo(d.getEmpId(), rodada);
					de.resultado = demonstrativoInicial.getResultado();
					de.vendas = demonstrativoInicial.getVendas();
					de.demanda = demonstrativoInicial.getDemanda();
					demonstrativos.add(de);
				}
			}
		} else {
			// Valor interpolado - preço
			double mediaPreco = decisaoModel.getMediaPreco(rodada);
			double efeitoPercentual = SensibilidadePreco
					.getSensibilidade(mediaPreco);
			double precoDaFaixa;
			double precoFaixaSeguinte;
			double efeitoPercentual2;
			double vipreco;

			// Atratividade Proporcional

			double ap = 0;
			double somaAPs = 0;

			// Demanda Empresa
			double di = 0;
			double Aproporcional = ap / somaAPs;

			for (Decisao d : decisaoModel) {
				// FIXME: select * from decisoes where rodada = ?
				int demanda = 0;
				if (0 < d.getRodada()) {
					Demonstrativo de = new Demonstrativo(d.getEmpId(), rodada);
					// FIXME: teste com um dos itens do calculo
					de.demanda = (int) (di * Aproporcional);
					// 10, 20, 1.0));
					demonstrativos.add(de);
				}
			}
		}
		int lastRow = demonstrativos.size();

		fireTableRowsInserted(firstRow, lastRow);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		step((Integer) evt.getNewValue());
	}

}
