package domain;

public class BestellingV2 {
	private int bestellingnummer;
	private int klant;
	private int bioscoopmedewerker;
	private String eten;
	private String drinken;
	private int film;
	private int prijs;
	private String status;
	
	public BestellingV2(int bestellingnummer, int klant, int bioscoopmedewerker, String eten, String drinken, int film,
			int prijs, String status) {
		this.bestellingnummer = bestellingnummer;
		this.klant = klant;
		this.bioscoopmedewerker = bioscoopmedewerker;
		this.eten = eten;
		this.drinken = drinken;
		this.film = film;
		this.prijs = prijs;
		this.status = status;
	}

	public BestellingV2(int bestelcode, int bioscoopmedewerker, int klantnummer, int filmID, int prijs) {
		this.bestellingnummer = bestelcode;
		this.bioscoopmedewerker = bioscoopmedewerker;
		this.klant = klantnummer;
		this.film = filmID;
		this.prijs = prijs;
		}
	
	public BestellingV2(int bestelcode, int klantnummer, int film, int prijs) {
		this.bestellingnummer = bestelcode;
		this.klant = klantnummer;
		this.film = film;
		this.prijs = prijs;
	}

	public int getBestellingnummer() {
		return bestellingnummer;
	}

	public int getKlant() {
		return klant;
	}

	public int getBioscoopmedewerker() {
		return bioscoopmedewerker;
	}

	public String getEten() {
		return eten;
	}

	public String getDrinken() {
		return drinken;
	}

	public int getFilm() {
		return film;
	}

	public int getPrijs() {
		return prijs;
	}

	public String getStatus() {
		return status;
	}

}
