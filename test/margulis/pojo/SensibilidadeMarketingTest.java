package margulis.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author marco
 *
 */
public class SensibilidadeMarketingTest {

	@Test(expected = IllegalArgumentException.class)  
	public final void testTooSmall() {
		SensibilidadeMarketing.getSensibilidade(-1);
		fail();
	}
	@Test  
	public final void testZero() {
		final  double actual = SensibilidadeMarketing.getSensibilidade(0.0);
		final double expected = 0.0;
		assertEquals(expected, actual, 0.0001);
	}
	@Test  
	public final void testOne() {
		final double actual = SensibilidadeMarketing.getSensibilidade(1.0);
		final double expected = 0.0;
		assertEquals(expected, actual, 0.0001);
	}	
	@Test  
	public final void testFirstTierAbove() {
		final double actual = SensibilidadeMarketing.getSensibilidade(1000.0);
		final double expected = 0.0033;
		assertEquals(expected, actual, 0.0001);
	}	
	@Test  
	public final void testFirstTierBellow() {
		final double actual = SensibilidadeMarketing.getSensibilidade(999.0);
		final double expected = 0.0;
		assertEquals(expected, actual, 0.0001);
	}	
	@Test  
	public final void testFirstTierBellowBellow() {
		final double actual = SensibilidadeMarketing.getSensibilidade(998.0);
		final double expected = 0.0;
		assertEquals(expected, actual, 0.0001);
	}
	@Test  
	public final void testLastTier() {
		final double actual = SensibilidadeMarketing.getSensibilidade(57000.0);
		final double expected = 0.0567;
		assertEquals(expected, actual, 0.0001);
	}
}
