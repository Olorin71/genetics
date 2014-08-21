package blog.genetics.test;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

import java.util.Map;

import blog.genetics.AllelePair;
import blog.genetics.Breeding;

public class BreedingCalculationTest {

	private Mockery context;

	@Before
	public void initalizeTest() {
		context = new Mockery();
	}

	@Test
	public void bothParentsDominantHomozygous_Returns100PerCentDominantHomozigous() {
		AllelePair parentalAllelePair = createDominantHomozigousMock("parental");
		AllelePair maternalAllelePair = createDominantHomozigousMock("maternal");

		Map<String, Double> results = Breeding.calculateOutcome(
				parentalAllelePair, maternalAllelePair);

		assertEquals(1.0, results.get("AA").doubleValue(), 0.001);
	}
	
	@Test
	public void bothParentsRecessiveHomozygous_Returns100PerCentRecessiveHomozigous() {
		AllelePair parentalAllelePair = createRecessiveHomozigousMock("parental");
		AllelePair maternalAllelePair = createRecessiveHomozigousMock("maternal");

		Map<String, Double> results = Breeding.calculateOutcome(
				parentalAllelePair, maternalAllelePair);

		assertEquals(1.0, results.get("aa").doubleValue(), 0.001);
	}
	
	private AllelePair createRecessiveHomozigousMock(String name) {
		AllelePair allelePair = context.mock(AllelePair.class,
				name);
		context.checking(new Expectations() {{
				oneOf(allelePair).getFirstAllele();
				will(returnValue("a"));
				oneOf(allelePair).getSecondAllele();
				will(returnValue("a"));
			}});
		return allelePair;
	}
	
	private AllelePair createDominantHomozigousMock(String name) {
		AllelePair allelePair = context.mock(AllelePair.class,
				name);
		context.checking(new Expectations() {{
				oneOf(allelePair).getFirstAllele();
				will(returnValue("A"));
				oneOf(allelePair).getSecondAllele();
				will(returnValue("A"));
			}});
		return allelePair;
	}
}
