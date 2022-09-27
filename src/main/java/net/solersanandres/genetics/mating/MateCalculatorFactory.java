package net.solersanandres.genetics.mating;

public class MateCalculatorFactory {
    public static MateCalculator createMendelianInheritanceCalculator() {
        return new MendelianInheritanceCalculator();
    }
}
