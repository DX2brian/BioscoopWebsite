package domain;

public class Bioscoopmedewerker {
	private int personeelsnummer;
	private String email_adres;
	private String wachtwoord;
	private String achternaam;
	private String tussenvoegsel;
	private String initialen;
	private String status;
	private String rang;
	private int leeftijd;
	
	public Bioscoopmedewerker(int personeelsnummer, String email_adres, String wachtwoord, String achternaam, String tussenvoegsel, String initialen,
			String status, String rang, int leeftijd) {
		this.personeelsnummer = personeelsnummer;
		this.email_adres = email_adres;
		this.wachtwoord = wachtwoord;
		this.achternaam = achternaam;
		this.tussenvoegsel = tussenvoegsel;
		this.initialen = initialen;
		this.status = status;
		this.rang = rang;
		this.leeftijd = leeftijd;
	}

	public int getPersoneelsnummer() {
		return personeelsnummer;
	}

	public String getEmail_adres() {
		return email_adres;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public String getInitialen() {
		return initialen;
	}
	
	public String getStatus() {
		return status;
	}

	public String getRang() {
		return rang;
	}

	public int getLeeftijd() {
		return leeftijd;
	}
	
}
