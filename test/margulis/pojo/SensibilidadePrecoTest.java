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
		final double actual = SensibilidadePreco.getSensibilidade(0.0);
		final double expected = 0.9;
		assertEquals(expected, actual, 0.0001);
	}
	@Test  
	public final void testOne() {
		final double actual = SensibilidadePreco.getSensibilidade(1.0);
		final double expected = 0.9;
		assertEquals(expected, actual, 0.0001);
	}	
	@Test  
	public final void testFirstTierAbove() {
		final double actual = SensibilidadePreco.getSensibilidade(5.0);
		final double expected = 0.85;
		assertEquals(expected, actual, 0.0001);
	}	
	@Test  
	public final void testFirstTierBellow() {
		final double actual = SensibilidadePreco.getSensibilidade(4.0);
		final double expected = 0.9;
		assertEquals(expected, actual, 0.0001);
	}	
	@Test  
	public final void testFirstTierBellowBellow() {
		final double actual = SensibilidadePreco.getSensibilidade(3.0);
		final double expected = 0.9;
		assertEquals(expected, actual, 0.0001);
	}
	@Test  
	public final void testLastTier() {
		final double actual = SensibilidadePreco.getSensibilidade(275.0);
		final double expected = -1.0;
		assertEquals(expected, actual, 0.0001);
	}
}
