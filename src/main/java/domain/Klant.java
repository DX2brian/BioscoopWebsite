package domain;

public class Klant {
	private int klantnummer;
	private String achternaam;
	private String tussenvoegsel;
	private String initialen;
	private String email_adres;
	private String wachtwoord;
	private int leeftijd;

	public Klant(int klantnummer, String achternaam, String tussenvoegsel, String initialen, String email_adres,
			String wachtwoord, int leeftijd) {
		this.klantnummer = klantnummer;
		this.achternaam = achternaam;
		this.tussenvoegsel = tussenvoegsel;
		this.initialen = initialen;
		this.email_adres = email_adres;
		this.wachtwoord = wachtwoord;
		this.leeftijd = leeftijd;
	}

	public Klant(int klantnummer, String controleww3) {
		this.klantnummer = klantnummer;
		this.wachtwoord = controleww3;
	}

	public int getKlantnummer() {
		return klantnummer;
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

	public String getEmail_adres() {
		return email_adres;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public boolean checkPassword(String wachtwoordcheck) {
		boolean correct = false;
		if (wachtwoordcheck.equals(wachtwoord)) {
			correct = true;
		}
		return correct;
	}

	public int getLeeftijd() {
		return leeftijd;
	}
}
