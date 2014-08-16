package net.solersanandres.genetical;

public class Allele
{
	private String locusIdentification;
	private String symbol;

	public Allele(String locusIdentification, String symbol)
	{
		this.locusIdentification = locusIdentification;
		this.symbol = symbol;
	}
	public String getLocusIdentification()
	{
		return locusIdentification;
	}

	public String getSymbol()
	{
		return symbol;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o==null)
			return false;
		if (o.getClass() != Allele.class)
			return false;
		return equals((Allele)o);
	}
	
	public boolean equals(Allele allele)
	{
		if (allele == null) return false;
		return (locusIdentification == allele.getLocusIdentification() && symbol == allele.getSymbol());
	}
}
