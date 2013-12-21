package test;

import static org.junit.Assert.*;
import margulis.pojo.SensibilidadeMarketing;

import org.junit.Test;

public class SensibilidadeMarketingTest {

	@Test(expected = IllegalArgumentException.class)  
	public final void testTooSmall() {
		SensibilidadeMarketing.getSensibilidade(-1);
		fail();
	}
	@Test  
	public final void testZero() {
		double actual = SensibilidadeMarketing.getSensibilidade(0.0);
		double expected = 0.0;
		assertEquals(expected, actual, 0.0001);
	}
	@Test  
	public final void testOne() {
		double actual = SensibilidadeMarketing.getSensibilidade(1.0);
		double expected = 0.0;
		assertEquals(expected, actual, 0.0001);
	}	
	@Test  
	public final void testFirstTierAbove() {
		double actual = SensibilidadeMarketing.getSensibilidade(1000.0);
		double expected = 0.0033;
		assertEquals(expected, actual, 0.0001);
	}	
	@Test  
	public final void testFirstTierBellow() {
		double actual = SensibilidadeMarketing.getSensibilidade(999.0);
		double expected = 0.0;
		assertEquals(expected, actual, 0.0001);
	}	
	@Test  
	public final void testFirstTierBellowBellow() {
		double actual = SensibilidadeMarketing.getSensibilidade(998.0);
		double expected = 0.0;
		assertEquals(expected, actual, 0.0001);
	}
	@Test  
	public final void testLastTier() {
		double actual = SensibilidadeMarketing.getSensibilidade(57000.0);
		double expected = 0.0567;
		assertEquals(expected, actual, 0.0001);
	}
}
