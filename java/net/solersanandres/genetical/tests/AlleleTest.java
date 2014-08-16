package net.solersanandres.genetical.tests;

import static org.junit.Assert.*;
import net.solersanandres.genetical.Allele;
import org.junit.Before;
import org.junit.Test;

public class AlleleTest {
	private Allele alleleA;
	private Allele alleleB;
	private Allele anotherAlleleA;

	@Before
	public void initializeTest() {
		alleleA = new Allele("A", "a");
		anotherAlleleA = new Allele("A", "a");
		alleleB = new Allele("B", "c");
	}

	@Test
	public void AlleleEqualityTest_True() {
		assertTrue(alleleA.equals(anotherAlleleA));
	}

	@Test
	public void AlleleEqualityTest_False() {
		assertFalse(alleleA.equals(alleleB));
	}

	@Test
	public void ObjectEqualityTest_True() {
		assertTrue(alleleA.equals((Object) anotherAlleleA));
	}

	@Test
	public void ObjectEqualityTest_False() {
		assertFalse(alleleA.equals((Object) alleleB));
	}

	@Test
	public void ObjectEqualityTestWithFalseType_False() {
		assertFalse(alleleA.equals((Object) new Object()));
	}
	
	@Test
	public void ObjectEqualityTestWithNull_False() {
		assertFalse(alleleA.equals((Object)null));
	}
	
	@Test
	public void AlleleEqualityTestWithNull_False() {
		assertFalse(alleleA.equals((Allele)null));
	}
}