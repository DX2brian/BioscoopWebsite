package domain;

public class Drinken {
	private String barcode;
	private String naam;
	private String merk;
	private int prijs;
	private int liters;
	private String gekoelt;
	
	public Drinken(String barcode, String naam, String merk, int prijs, int liters, String gekoelt) {
		this.barcode = barcode;
		this.naam = naam;
		this.merk = merk;
		this.prijs = prijs;
		this.liters = liters;
		this.gekoelt = gekoelt;
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

	public int getLiters() {
		return liters;
	}

	public String getGekoelt() {
		return gekoelt;
	}
	
}
