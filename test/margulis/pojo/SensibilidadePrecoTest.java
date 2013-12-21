package margulis.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author marco
 *
 */
public class SensibilidadePrecoTest {

	@Test(expected = IllegalArgumentException.class)  
	public final void testTooSmall() {
		SensibilidadePreco.getSensibilidade(-1);
		fail();
	}
	@Test  
	public final void testZero() {
		double actual = SensibilidadePreco.getSensibilidade(0.0);
		double expected = 0.9;
		assertEquals(expected, actual, 0.0001);
	}
	@Test  
	public final void testOne() {
		double actual = SensibilidadePreco.getSensibilidade(1.0);
		double expected = 0.9;
		assertEquals(expected, actual, 0.0001);
	}	
	@Test  
	public final void testFirstTierAbove() {
		double actual = SensibilidadePreco.getSensibilidade(5.0);
		double expected = 0.85;
		assertEquals(expected, actual, 0.0001);
	}	
	@Test  
	public final void testFirstTierBellow() {
		double actual = SensibilidadePreco.getSensibilidade(4.0);
		double expected = 0.9;
		assertEquals(expected, actual, 0.0001);
	}	
	@Test  
	public final void testFirstTierBellowBellow() {
		double actual = SensibilidadePreco.getSensibilidade(3.0);
		double expected = 0.9;
		assertEquals(expected, actual, 0.0001);
	}
	@Test  
	public final void testLastTier() {
		double actual = SensibilidadePreco.getSensibilidade(275.0);
		double expected = -1.0;
		assertEquals(expected, actual, 0.0001);
	}
}
