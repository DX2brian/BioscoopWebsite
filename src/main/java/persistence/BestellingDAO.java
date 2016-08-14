package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Bestelling;
import domain.Bioscoopmedewerker;
import domain.Drinken;
import domain.Eten;
import domain.Film;
import domain.Klant;


public class BestellingDAO extends BaseDAO {
	//Importeer alle Primary keys
	private BioscoopmedewerkerDAO bioscoopmedewerkerDAO = new BioscoopmedewerkerDAO();
	private DrinkenDAO drinkenDAO = new DrinkenDAO();
	private EtenDAO etenDAO = new EtenDAO();
	private FilmDAO filmDAO = new FilmDAO();
	private KlantDAO klantDAO = new KlantDAO();
	
	private List<Bestelling> selectBestelling(String query) {
		List<Bestelling> results = new ArrayList<Bestelling>();
		
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			
			while (dbResultSet.next()) {
				int bestellingnummer = dbResultSet.getInt("bestellingnummer");
				int prijs = dbResultSet.getInt("prijs");
				String status = dbResultSet.getString("status");
				
				int klant = dbResultSet.getInt("klant");
				Klant klantFK = klantDAO.findByKlantnummer(klant);
				
				int personeelsnummer = dbResultSet.getInt("bioscoopmedewerker");
				Bioscoopmedewerker bioscoopmedewerkerFK = bioscoopmedewerkerDAO.findByPersoneelsnummer(personeelsnummer);
				
				String barcodeeten = dbResultSet.getString("eten");
				Eten etenFK = etenDAO.findByBarcode(barcodeeten);
				
				String barcodedrinken = dbResultSet.getString("drinken");
				Drinken drinkenFK = drinkenDAO.findByBarcode(barcodedrinken);
				
				int filmcode = dbResultSet.getInt("film");
				Film filmFK = filmDAO.findByFilmcode(filmcode);
				
				Bestelling bestelling = new Bestelling(bestellingnummer, prijs, status);
				bestelling.setKlant(klantFK);
				bestelling.setBioscoopmedewerker(bioscoopmedewerkerFK);
				bestelling.setEten(etenFK);
				bestelling.setDrinken(drinkenFK);
				bestelling.setFilm(filmFK);

				
				results.add(bestelling);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Hij geeft een foutmelding in bestellingDAO (selectBestelling)");
		}
		
		return results;
	}
	
	/***************************** READ methods *****************************/
	
	public List<Bestelling> findAll() {
		return selectBestelling("SELECT * FROM bestelling");
	}
	
	public List<Bestelling> findKlantandFilm() {
		return selectBestelling("SELECT bestellingnummer, klant, film, prijs FROM bestelling");
	}
	
	public List<Bestelling> vindJeBestelling(int klantnummer) {
		return selectBestelling(String.format("SELECT * FROM bestelling WHERE klant = %d", klantnummer));
	}
	
	public Bestelling findById(int bestellingnummer) {
		return selectBestelling(String.format("SELECT * FROM bestelling WHERE bestellingnummer = %d", bestellingnummer )).get(0);
	}
	
	
	/***************************** DELETE methods *****************************/
	
	   public boolean deleteBestelling(Bestelling bestelling) {
	        boolean result = false;
	        boolean bestellingExists = findById(bestelling.getBestellingnummer()) != null;

	        if (bestellingExists) {

	            try (Connection con = super.getConnection()) {
	                PreparedStatement stmt = con.prepareStatement("DELETE FROM bestelling WHERE bestellingnummer = ?");
	                stmt.setInt(1, bestelling.getBestellingnummer());

	                return stmt.executeUpdate() == 1;
	            } catch (SQLException sqle) {
	                sqle.printStackTrace();
	                System.out.println("Er zit een error in bestellingDAO (deleteBestelling)");

	            }
	        }

	        return result;
	    }
}
