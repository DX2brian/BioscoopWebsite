package model;

import java.util.List;

import domain.Bestelling;
import domain.BestellingV2;
import domain.Bioscoopmedewerker;
import domain.Drinken;
import domain.Eten;
import domain.Film;
import domain.Klant;
import persistence.BestellingDAO;
import persistence.BestellingDAOV2;
import persistence.BioscoopmedewerkerDAO;
import persistence.DrinkenDAO;
import persistence.EtenDAO;
import persistence.FilmDAO;
import persistence.KlantDAO;

public class CompanyService {
	private BestellingDAO bestellingDAO = new BestellingDAO();
	private BestellingDAOV2 bestellingDAOV2 = new BestellingDAOV2();
	private BioscoopmedewerkerDAO bioscoopmedewerkerDAO = new BioscoopmedewerkerDAO();
	private DrinkenDAO drinkenDAO = new DrinkenDAO();
	private EtenDAO etenDAO = new EtenDAO();
	private FilmDAO filmDAO = new FilmDAO();
	private KlantDAO klantDAO = new KlantDAO();
	
	/***************************** Bestelling methods *****************************/
	
	public List<Bestelling> getAllBestellingen() {
		return bestellingDAO.findAll();
	}
	
	public List<Bestelling> getJouwBestelling(int klantnummer) {
		return bestellingDAO.vindJeBestelling(klantnummer);
	}
	
	/***************************** BestellingV2 methods *****************************/
	
	public List<BestellingV2> getAllBestellingenV2() {
		return bestellingDAOV2.findAll();
	}
	
	public List<BestellingV2> getJouwBestellingV2(int klantnummer) {
		return bestellingDAOV2.vindJeBestelling(klantnummer);
	}
	
	public void voegFilmToe(BestellingV2 bestellingv2) {
		bestellingDAOV2.insertFilmInBestelling(bestellingv2);
	}
	
	public void verwijderBestelling(int bestellingv2) {
		BestellingV2 b = bestellingDAOV2.findById(bestellingv2);
		
		if (b != null) {
			bestellingDAOV2.deleteBestelling(b);
		} else throw new IllegalArgumentException("Bestelling bestaat niet!");
	}
	
	public void updateStatusBestellingBezig(int bestellingv2) {
		BestellingV2 b = bestellingDAOV2.findById(bestellingv2);
		
		if (b != null) {
			bestellingDAOV2.UpdateStatusBestellingBezig(b);
		} else throw new IllegalArgumentException("Bestelling bestaat niet!");
	}
	
	public void updateStatusBestellingKlaar(int bestellingv2) {
		BestellingV2 b = bestellingDAOV2.findById(bestellingv2);
		
		if (b != null) {
			bestellingDAOV2.UpdateStatusBestellingKlaar(b);
		} else throw new IllegalArgumentException("Bestelling bestaat niet!");
	}
	
	public void updateBioscoopmedewerkerBestelling(int bestellingv2, int personeelsnummer) {
		BestellingV2 b = bestellingDAOV2.findById(bestellingv2);
		Bioscoopmedewerker bio = bioscoopmedewerkerDAO.findByPersoneelsnummer(personeelsnummer);
		
		if (b != null || bio != null) {
			bestellingDAOV2.UpdateBioscoopmedewerkerInBestelling(b, bio);
		} else throw new IllegalArgumentException("Bestelling bestaat niet!");
	}
	
	public void updateEtenInBestelling(String barcode, int bestelnummer) {
		BestellingV2 b = bestellingDAOV2.findById(bestelnummer);
		Eten e = etenDAO.findByBarcode(barcode);
		
		if (b != null || e != null) {
			bestellingDAOV2.updateEtenInBestelling(e, b);
		} else throw new IllegalArgumentException("Bestelling bestaat niet!");
	}
	
	public void updateDrinkenInBestelling(String barcode, int bestelnummer) {
		BestellingV2 b = bestellingDAOV2.findById(bestelnummer);
		Drinken d = drinkenDAO.findByBarcode(barcode);
		
		if (b != null || d != null) {
			bestellingDAOV2.updateDrinkenInBestelling(d, b);
		} else throw new IllegalArgumentException("Bestelling bestaat niet!");
	}
	
	public void insertBestelling(BestellingV2 bestellingv2) {
		bestellingDAOV2.insertBestelling(bestellingv2);
	}
	
	
	/***************************** Bioscoopmedewerker methods *****************************/
	
	public List<Bioscoopmedewerker> getAllBioscoopmedewerkers() {
		return bioscoopmedewerkerDAO.findAll();
	}
	
	public Bioscoopmedewerker findBioscoopmedewerkerByPersoneelsnummer(int personeelsnummer) {
		return bioscoopmedewerkerDAO.findByPersoneelsnummer(personeelsnummer);
	}
	
	public Bioscoopmedewerker findBioscoopmedewerkerByEmail(String email_adres) {
		return bioscoopmedewerkerDAO.findByEmail_adres(email_adres);
	}
	
	public void updateStatusNAHW(Bioscoopmedewerker bioscoopmedewerker) {
		bioscoopmedewerkerDAO.updateBioscoopmedewerkStatusNAHW(bioscoopmedewerker);
	}
	
	public void updateStatusAHW(Bioscoopmedewerker bioscoopmedewerker) {
		bioscoopmedewerkerDAO.updateBioscoopmedewerkStatusAHW(bioscoopmedewerker);
	}
	
	public void updateStatusZ(Bioscoopmedewerker bioscoopmedewerker) {
		bioscoopmedewerkerDAO.updateBioscoopmedewerkStatusZ(bioscoopmedewerker);
	}
	
	public void insertBioscoopmedewerker(Bioscoopmedewerker bioscoopmedewerker) {
		bioscoopmedewerkerDAO.insertBioscoopmedewerker(bioscoopmedewerker);
	}
	
	public void deleteBioscoopmedewerker(int personeelsnummer) {
		Bioscoopmedewerker b = bioscoopmedewerkerDAO.findByPersoneelsnummer(personeelsnummer);
		
		if (b != null) {
			bioscoopmedewerkerDAO.deleteBioscoopmedewerker(b);
		} else throw new IllegalArgumentException("Bioscoopmedewerker bestaat niet!");
	}
	
	/***************************** Drinken methods *****************************/
	
	public List<Drinken> getAllDrinken() {
		return drinkenDAO.findAll();
	}
	
	public Drinken findDrinkenByBarcode(String barcode) {
		return drinkenDAO.findByBarcode(barcode);
	}
	
	public void insertDrinken(Drinken drinken) {
		drinkenDAO.insertDrinken(drinken);
	}
	
	public void deleteDrinken(String barcode) {
		Drinken d = drinkenDAO.findByBarcode(barcode);
		
		if (d != null) {
			drinkenDAO.deleteDrinken(d);
		} else throw new IllegalArgumentException("Drinken bestaat niet!");
	}
	
	/***************************** Eten methods *****************************/
	
	public List<Eten> getAllEten() {
		return etenDAO.findAll();
	}
	
	public Eten findEtenByBarcode(String barcode) {
		return etenDAO.findByBarcode(barcode);
	}
	
	public void insertEten(Eten eten) {
		etenDAO.insertEten(eten);
	}
	
	public void deleteEten(String barcode) {
		Eten e = etenDAO.findByBarcode(barcode);
		
		if (e != null) {
			etenDAO.deleteEten(e);
		} else throw new IllegalArgumentException("Eten bestaat niet!");
	}
	
	/***************************** Film methods *****************************/
	
	public List<Film> getAllFilms() {
		return filmDAO.findAll();
	}
	
	public Film findFilmByBarcode(int filmcode) {
		return filmDAO.findByFilmcode(filmcode);
	}
	
	public void insertFilm(Film film) {
		filmDAO.insertFilm(film);
	}
	
	public void deleteFilm(int filmcode) {
		Film f = filmDAO.findByFilmcode(filmcode);
		
		if (f != null) {
			filmDAO.deleteFilm(f);
		} else throw new IllegalArgumentException("Film bestaat niet!");
	}
	
	/***************************** Klant methods *****************************/
	
	public List<Klant> getAllKlanten() {
		return klantDAO.findAll();
	}
	
	public Klant findKlantByEmail(String email_adres) {
		return klantDAO.findByEmail(email_adres);
	}
	
	public void deleteKlant(int klantnummer) {
		Klant k = klantDAO.findByKlantnummer(klantnummer);
		
		if (k != null) {
			klantDAO.deleteKlant(k);
		} else throw new IllegalArgumentException("Klant bestaat niet!");
	}
	
	public void insertKlant(Klant klant) {
		klantDAO.insertKlant(klant);
	}
	
	public void updateww(Klant klant) {
		klantDAO.veranderwwKlant(klant);
	}
	
}