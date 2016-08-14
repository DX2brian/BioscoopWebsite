package domain;

public class Eten {
	private String barcode;
	private String naam;
	private String merk;
	private int prijs;
	private String grootte;
	private int gram;
	
	public Eten(String barcode, String naam, String merk, int prijs, String grootte, int gram) {
		this.barcode = barcode;
		this.naam = naam;
		this.merk = merk;
		this.prijs = prijs;
		this.grootte = grootte;
		this.gram = gram;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getNaam() {
		return naam;
	}

	public String getMerk() {
		return merk;
	}

	public int getPrijs() {
		return prijs;
	}

	public String getGrootte() {
		return grootte;
	}

	public int getGram() {
		return gram;
	}	
}
