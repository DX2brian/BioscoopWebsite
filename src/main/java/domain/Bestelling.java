package domain;

public class Bestelling {
	private int bestellingnummer;
	private Klant klant;
	private Bioscoopmedewerker bioscoopmedewerker;
	private Eten eten;
	private Drinken drinken;
	private Film film;
	private int prijs;
	private String status;
	
	public Bestelling(int bestellingnummer, int prijs, String status) {
		this.bestellingnummer = bestellingnummer;
		this.prijs = prijs;
		this.status = status;
	}

	public int getBestellingnummer() {
		return bestellingnummer;
	}

	public void setBestellingnummer(int bestellingnummer) {
		this.bestellingnummer = bestellingnummer;
	}

	public Klant getKlant() {
		return klant;
	}

	public void setKlant(Klant klantFK) {
		this.klant = klantFK;
	}

	public Bioscoopmedewerker getBioscoopmedewerker() {
		return bioscoopmedewerker;
	}

	public void setBioscoopmedewerker(Bioscoopmedewerker bioscoopmedewerkerFK) {
		this.bioscoopmedewerker = bioscoopmedewerkerFK;
	}

	public Eten getEten() {
		return eten;
	}

	public void setEten(Eten etenFK) {
		this.eten = etenFK;
	}

	public Drinken getDrinken() {
		return drinken;
	}

	public void setDrinken(Drinken drinkenFK) {
		this.drinken = drinkenFK;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film filmFK) {
		this.film = filmFK;
	}

	public int getPrijs() {
		return prijs;
	}

	public void setPrijs(int prijs) {
		this.prijs = prijs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
