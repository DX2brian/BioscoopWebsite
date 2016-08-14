package domain;

public class Film {
	private int filmcode;
	private String naam;
	private String cast;
	private String beschrijving;
	private String genre;
	private String visie;
	private int zaalnummer;
	private String beschikbaarheid;
	private int prijs;
	private int IMDB_rating;
	
	public Film(int filmcode, String naam, String cast, String beschrijving, String genre, String visie, int zaalnummer,
			String beschikbaarheid, int prijs, int iMDB_rating) {
		this.filmcode = filmcode;
		this.naam = naam;
		this.cast = cast;
		this.beschrijving = beschrijving;
		this.genre = genre;
		this.visie = visie;
		this.zaalnummer = zaalnummer;
		this.beschikbaarheid = beschikbaarheid;
		this.prijs = prijs;
		this.IMDB_rating = iMDB_rating;
	}

	public int getFilmcode() {
		return filmcode;
	}

	public String getNaam() {
		return naam;
	}

	public String getCast() {
		return cast;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public String getGenre() {
		return genre;
	}

	public String getVisie() {
		return visie;
	}

	public int getZaalnummer() {
		return zaalnummer;
	}

	public String getBeschikbaarheid() {
		return beschikbaarheid;
	}

	public int getPrijs() {
		return prijs;
	}

	public int getIMDB_rating() {
		return IMDB_rating;
	}	
}
