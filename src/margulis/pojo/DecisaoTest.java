package margulis.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecisaoTest {

	@Test
	public void testDecisaoIntIntStringDoubleDoubleInt() {
		int decisaoid = 5;
		int empid = 4;
		int rodada = 1;
		double preco = 124.50;
		double marketing = 550.80;
		int producao = 153;
		Decisao d = new Decisao(decisaoid, empid, rodada, preco, marketing,
				producao);
		assertEquals(decisaoid, d.getDecisaoid());
		assertEquals(empid, d.getEmpid());
		assertEquals(rodada, d.getRodada(), 0.01);
		assertEquals(preco, d.getPreco(), 0.01);
		assertEquals(marketing, d.getMarketing(), 0.01);
		assertEquals(producao, d.getProducao());
	}

	@Test
	public void testDecisaoIntStringDoubleDoubleInt() {
		int empid = 6;
		int rodada = 3;
		double preco = 153.50;
		double marketing = 560.20;
		int producao = 80;
		Decisao d = new Decisao(empid, rodada, preco, marketing, producao);
		assertEquals(empid, d.getEmpid());
		assertEquals(rodada, d.getRodada());
		assertEquals(preco, d.getPreco(), 0.01);
		assertEquals(marketing, d.getMarketing(), 0.01);
		assertEquals(producao, d.getProducao());
	}

	@Test
	public void testGetDecisaoid() {
		int decisaoid = 6;
		int empid = 6;
		int rodada = 3;
		double preco = 153.50;
		double marketing = 560.20;
		int producao = 80;
		Decisao d = new Decisao(decisaoid, empid, rodada, preco, marketing,
				producao);
		assertEquals(decisaoid, d.getDecisaoid());
	}

	@Test
	public void testGetEmpid() {
		int decisaoid = 5;
		int empid = 4;
		int rodada = 22;
		double preco = 124.50;
		double marketing = 550.80;
		int producao = 153;
		Decisao d = new Decisao(decisaoid, empid, rodada, preco, marketing,
				producao);
		assertEquals(empid, d.getEmpid());
	}

	@Test
	public void testGetRodada() {
		int decisaoid = 5;
		int empid = 4;
		int rodada = 5;
		double preco = 124.50;
		double marketing = 550.80;
		int producao = 153;
		Decisao d = new Decisao(decisaoid, empid, rodada, preco, marketing,
				producao);
		assertEquals(rodada, d.getRodada());
	}

	@Test
	public void testGetPreco() {
		int decisaoid = 5;
		int empid = 4;
		int rodada = 2;
		double preco = 124.50;
		double marketing = 550.80;
		int producao = 153;
		Decisao d = new Decisao(decisaoid, empid, rodada, preco, marketing,
				producao);
		assertEquals(preco, d.getPreco(), 0.01);
	}

	@Test
	public void testGetMarketing() {
		int decisaoid = 5;
		int empid = 4;
		int rodada = 2;
		double preco = 124.50;
		double marketing = 550.80;
		int producao = 153;
		Decisao d = new Decisao(decisaoid, empid, rodada, preco, marketing,
				producao);
		assertEquals(marketing, d.getMarketing(), 0.01);
	}

	@Test
	public void testGetQuantidade() {
		int decisaoid = 5;
		int empid = 4;
		int rodada = 2;
		double preco = 124.50;
		double marketing = 550.80;
		int producao = 153;
		Decisao d = new Decisao(decisaoid, empid, rodada, preco, marketing,
				producao);
		assertEquals(producao, d.getProducao());
	}

	@Test
	public void testToString() {
		int decisaoid = 5;
		int empid = 4;
		int rodada = 1;
		double preco = 124.50;
		double marketing = 550.80;
		int producao = 153;
		Decisao d = new Decisao(decisaoid, empid, rodada, preco, marketing,
				producao);

		StringBuilder sb = new StringBuilder();

		sb.append("Decisao [decisaoid=" + decisaoid + ", " + "empid=" + empid
				+ ", rodada=" + rodada + ", " + "preco=" + preco
				+ ", marketing=" + marketing + ", producao=" + producao + "]");

		assertEquals(sb.toString(), d.toString());
	}

}