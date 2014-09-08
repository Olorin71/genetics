package blog.genetics.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;

import java.util.Map;

import blog.genetics.AllelePair;
import blog.genetics.Breeding;

public class BreedingCalculationTest {

    @Test
    public void bothParentsDominantHomozygous_Returns100PerCentDominantHomozygous() {
        AllelePair parentalAllelePair = createDominantHomozygousMock("parental");
        AllelePair maternalAllelePair = createDominantHomozygousMock("maternal");

        Map<String, Double> results = Breeding.calculateOutcome(
                parentalAllelePair, maternalAllelePair);

        assertEquals(1.0, results.get("AA").doubleValue(), 0.001);
    }

    @Test
    public void bothParentsRecessiveHomozygous_Returns100PerCentRecessiveHomozygous() {
        AllelePair parentalAllelePair = createRecessiveHomozygousMock("parental");
        AllelePair maternalAllelePair = createRecessiveHomozygousMock("maternal");

        Map<String, Double> results = Breeding.calculateOutcome(
                parentalAllelePair, maternalAllelePair);

        assertEquals(1.0, results.get("aa").doubleValue(), 0.001);
    }

    @Test
    public void fatherDominantHomozygous_MotherRecessiveHomozygous_ReturnsOnlyHeterozygous() {
        AllelePair parentalAllelePair = createDominantHomozygousMock("parental");
        AllelePair maternalAllelePair = createRecessiveHomozygousMock("maternal");

        Map<String, Double> results = Breeding.calculateOutcome(
                parentalAllelePair, maternalAllelePair);

        assertEquals(1.0, results.get("Aa").doubleValue(), 0.001);
    }

    @Test
    public void motherDominantHomozygous_FatherRecessiveHomozygous_ReturnsOnlyHeterozygous() {
        AllelePair parentalAllelePair = createRecessiveHomozygousMock("parental");
        AllelePair maternalAllelePair = createDominantHomozygousMock("maternal");

        Map<String, Double> results = Breeding.calculateOutcome(
                parentalAllelePair, maternalAllelePair);

        assertEquals(1.0, results.get("Aa").doubleValue(), 0.001);
    }

    @Test
    public void dominatHomozygousPlusHeterozigous_Returns50PerCentDominantHomozygous() {
        AllelePair parentalAllelePair = createDominantHomozygousMock("parental");
        AllelePair maternalAllelePair = createHeterozygousMock("maternal");

        Map<String, Double> results = Breeding.calculateOutcome(
                parentalAllelePair, maternalAllelePair);

        assertEquals(0.5, results.get("AA").doubleValue(), 0.001);
    }

    private AllelePair createRecessiveHomozygousMock(String name) {
        AllelePair allelePair = CreateAllelePairMock(name, "a", "a");
        when(allelePair.isRecessiveHomozygous()).thenReturn(true);
        return allelePair;
    }

    private AllelePair createDominantHomozygousMock(String name) {
        AllelePair allelePair = CreateAllelePairMock(name, "A", "A");
        when(allelePair.isDominantHomozygous()).thenReturn(true);
        return allelePair;
    }

    private AllelePair createHeterozygousMock(String name) {
        AllelePair allelePair = CreateAllelePairMock(name, "A", "a");
        when(allelePair.isHeterozygous()).thenReturn(true);
        return allelePair;
    }

    private AllelePair CreateAllelePairMock(String name, String firstAllele,
            String secondAllele) {
        AllelePair allelePair = mock(AllelePair.class, name);

        when(allelePair.getFirstAllele()).thenReturn(firstAllele);
        when(allelePair.getSecondAllele()).thenReturn(secondAllele);
        return allelePair;
    }
}
