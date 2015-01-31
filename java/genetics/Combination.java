package genetics;

class Combination {

    private final AllelePair firstAllele;
    private final AllelePair secondAllele;

    public Combination(AllelePair firstAllele, AllelePair secondAllele) {
        this.firstAllele = firstAllele;
        this.secondAllele = secondAllele;
    }
    
    @Override
    public boolean equals(Object other) {
        Combination otherCombination = (Combination)other;
        if (otherCombination == null)
            return false;
        return equals(otherCombination);
    }
    
    public boolean equals(Combination other) {
        return (firstAllele == other.firstAllele && secondAllele == other.secondAllele) ||
                (firstAllele == other.secondAllele && secondAllele == other.firstAllele);
    }    
}
