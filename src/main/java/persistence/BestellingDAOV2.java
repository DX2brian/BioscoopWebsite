package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.BestellingV2;
import domain.Bioscoopmedewerker;
import domain.Drinken;
import domain.Eten;


public class BestellingDAOV2 extends BaseDAO {
	
	private List<BestellingV2> selectBestelling(String query) {
		List<BestellingV2> results = new ArrayList<BestellingV2>();
		
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			
			while (dbResultSet.next()) {
				int bestellingnummer = dbResultSet.getInt("bestellingnummer");
				int klant = dbResultSet.getInt("klant");
				int bioscoopmedewerker = dbResultSet.getInt("bioscoopmedewerker");
				String eten = dbResultSet.getString("eten");
				String drinken = dbResultSet.getString("drinken");
				int film = dbResultSet.getInt("film");
				int prijs = dbResultSet.getInt("prijs");
				String status = dbResultSet.getString("status");
				
				results.add(new BestellingV2(bestellingnummer, klant, bioscoopmedewerker, eten, drinken, film, prijs, status));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Hij geeft een foutmelding in bestellingDAOV2 (selectBestelling)");
		}
		
		return results;
	}
	
	/***************************** READ methods *****************************/
	
	public List<BestellingV2> findAll() {
		return selectBestelling("SELECT * FROM bestelling");
	}
	
	public List<BestellingV2> vindJeBestelling(int klantnummer) {
		return selectBestelling(String.format("SELECT * FROM bestelling WHERE klant = %d", klantnummer));
	}
	
	public BestellingV2 findById(int bestellingnummer) {
		return selectBestelling(String.format("SELECT * FROM bestelling WHERE bestellingnummer = %d", bestellingnummer )).get(0);
	}
	
	public BestellingV2 findByKlantnummer(int klant) {
		return selectBestelling(String.format("SELECT * FROM bestelling WHERE klant = %d", klant )).get(0);
	}
	
	/***************************** DELETE methods *****************************/
	
	   public boolean deleteBestelling(BestellingV2 bestellingv2) {
	        boolean result = false;
	        boolean bestellingExists = findById(bestellingv2.getBestellingnummer()) != null;

	        if (bestellingExists) {

	            try (Connection con = super.getConnection()) {
	                PreparedStatement stmt = con.prepareStatement("DELETE FROM bestelling WHERE bestellingnummer = ?");
	                stmt.setInt(1, bestellingv2.getBestellingnummer());

	                return stmt.executeUpdate() == 1;
	            } catch (SQLException sqle) {
	                sqle.printStackTrace();
	                System.out.println("Er zit een error in bestellingDAOV2 (deleteBestelling)");

	            }
	        }

	        return result;
	    }
	   
	/***************************** Insert methods *****************************/
	   
    public boolean insertFilmInBestelling(BestellingV2 bestellingv2) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO bestelling (Bestellingnummer, Klant, Film, Prijs) VALUES ( ?, ?, ?, ?)");
            stmt.setInt(1, bestellingv2.getBestellingnummer());
            stmt.setInt(2, bestellingv2.getKlant());
            stmt.setInt(3, bestellingv2.getFilm());
            stmt.setInt(4, bestellingv2.getPrijs());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in bestellingDAOV2 (insert into)");

        }
		return false;
    }
    
    public boolean insertBestelling(BestellingV2 bestellingv2) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO bestelling (Bestellingnummer, Klant, Bioscoopmedewerker, Eten, Drinken, Film, Prijs, Status) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, bestellingv2.getBestellingnummer());
            stmt.setInt(2, bestellingv2.getKlant());
            stmt.setInt(3, bestellingv2.getBioscoopmedewerker());
            stmt.setString(4, bestellingv2.getEten());
            stmt.setString(5, bestellingv2.getDrinken());
            stmt.setInt(6, bestellingv2.getFilm());
            stmt.setInt(7, bestellingv2.getPrijs());
            stmt.setString(8, bestellingv2.getStatus());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in BestellingDAOV2 (insert into)");

        }
		return false;
	}
    
    /***************************** Update methods *****************************/
    
    public boolean UpdateStatusBestellingBezig(BestellingV2 bestellingv2) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE bestelling SET status='Mee bezig' WHERE bestellingnummer= ? ");
            stmt.setInt(1, bestellingv2.getBestellingnummer());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in bestellingDAOV2 (update bestelling)");

        }
		return false;
    }
    
    public boolean UpdateStatusBestellingKlaar(BestellingV2 bestellingv2) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE bestelling SET status='Klaar' WHERE bestellingnummer= ? ");
            stmt.setInt(1, bestellingv2.getBestellingnummer());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in bestellingDAOV2 (update bestelling)");

        }
		return false;
    }
    
    public boolean UpdateBioscoopmedewerkerInBestelling(BestellingV2 bestellingv2, Bioscoopmedewerker bioscoopmedewerker) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE bestelling SET bioscoopmedewerker= ? WHERE bestellingnummer= ?");
            stmt.setInt(1, bioscoopmedewerker.getPersoneelsnummer());
            stmt.setInt(2, bestellingv2.getBestellingnummer());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in bestellingDAOV2 (update bioscoopmedewerker)");

        }
		return false;
    }
    
    public boolean updateDrinkenInBestelling(Drinken drinken, BestellingV2 bestellingv2) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE bestelling SET drinken= ? where bestellingnummer= ?");
            stmt.setString(1, drinken.getBarcode());
            stmt.setInt(2, bestellingv2.getBestellingnummer());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in BestellingDAO (update Drinken)");

        }
		return false;
    }
    
    public boolean updateEtenInBestelling(Eten eten, BestellingV2 bestellingv2) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE bestelling SET eten= ? where bestellingnummer= ?");
            stmt.setString(1, eten.getBarcode());
            stmt.setInt(2, bestellingv2.getBestellingnummer());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in BestellingDAO (update Eten)");

        }
		return false;
    }    
}
