package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Bioscoopmedewerker;


public class BioscoopmedewerkerDAO extends BaseDAO {
	private List<Bioscoopmedewerker> selectKlanten(String query) {
		List<Bioscoopmedewerker> results = new ArrayList<Bioscoopmedewerker>();

		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);

			while (dbResultSet.next()) {
				int personeelsnummer = dbResultSet.getInt("personeelsnummer");
				String email_adres = dbResultSet.getString("email_adres");
				String wachtwoord = dbResultSet.getString("wachtwoord");
				String achternaam = dbResultSet.getString("achternaam");
				String tussenvoegsel = dbResultSet.getString("tussenvoegsel");
				String initialen = dbResultSet.getString("initialen");
				String status = dbResultSet.getString("status");
				String rang = dbResultSet.getString("rang");
				int leeftijd = dbResultSet.getInt("leeftijd");

				results.add(new Bioscoopmedewerker(personeelsnummer, email_adres, wachtwoord, achternaam, tussenvoegsel, initialen, status, rang, leeftijd));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Er zit een error in de Bioscoopmedewerker (selectBioscoopmedewerker)");
		}

		return results;
	}
	
	/*****************************Read methods *****************************/

	public Bioscoopmedewerker findByPersoneelsnummer(int personeelsnummer) {
		return selectKlanten(String.format("SELECT * FROM bioscoopmedewerker WHERE personeelsnummer = '%d'", personeelsnummer)).get(0);
	}
	
	public Bioscoopmedewerker findByEmail_adres(String email_adres) {
		return selectKlanten(String.format("SELECT * FROM bioscoopmedewerker WHERE email_adres = '%s'", email_adres)).get(0);
	}
	
	public List<Bioscoopmedewerker> findAll(){
		return selectKlanten("SELECT * FROM bioscoopmedewerker");
	}
	
	/***************************** Delete methods *****************************/
	
    public boolean deleteBioscoopmedewerker(Bioscoopmedewerker bioscoopmedewerker) {
        boolean result = false;
        boolean bioscoopmedewerkerExist = findByPersoneelsnummer(bioscoopmedewerker.getPersoneelsnummer()) != null;

        if (bioscoopmedewerkerExist) {

            try (Connection con = super.getConnection()) {
                PreparedStatement stmt = con.prepareStatement("DELETE FROM bioscoopmedewerker WHERE personeelsnummer = ?");
                stmt.setInt(1, bioscoopmedewerker.getPersoneelsnummer());

                return stmt.executeUpdate() == 1;
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                System.out.println("Er zit een error in BioscoopmedewerkerDAO (deleteBioscoopmedewerker)");

            }
        }

        return result;
    }
    
    /***************************** Update methods *****************************/
    
    public boolean updateBioscoopmedewerkStatusNAHW(Bioscoopmedewerker bioscoopmedewerker) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE bioscoopmedewerker SET status= 'Niet aan het werk' where personeelsnummer = ?");
            stmt.setInt(1, bioscoopmedewerker.getPersoneelsnummer());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in BioscoopmedewerkerDAO (update bioscoopmedewerkerstatusNAHW)");

        }
		return false;
    }
    
    public boolean updateBioscoopmedewerkStatusAHW(Bioscoopmedewerker bioscoopmedewerker) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE bioscoopmedewerker SET status= 'Aan het werk' where personeelsnummer = ?");
            stmt.setInt(1, bioscoopmedewerker.getPersoneelsnummer());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in BioscoopmedewerkerDAO (update bioscoopmedewerkerstatusAHW)");

        }
		return false;
    }
    
    public boolean updateBioscoopmedewerkStatusZ(Bioscoopmedewerker bioscoopmedewerker) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE bioscoopmedewerker SET status= 'Ziek' where personeelsnummer = ?");
            stmt.setInt(1, bioscoopmedewerker.getPersoneelsnummer());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in BioscoopmedewerkerDAO (update bioscoopmedewerkerstatusZ)");

        }
		return false;
    }
    
    /***************************** Insert methods *****************************/
    
    public boolean insertBioscoopmedewerker(Bioscoopmedewerker bioscoopmedewerker) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO bioscoopmedewerker (Personeelsnummer, Email_adres, Wachtwoord, Achternaam, Tussenvoegsel, Initialen, Status, Rang, Leeftijd) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, bioscoopmedewerker.getPersoneelsnummer());
            stmt.setString(2, bioscoopmedewerker.getEmail_adres());
            stmt.setString(3, bioscoopmedewerker.getWachtwoord());
            stmt.setString(4, bioscoopmedewerker.getAchternaam());
            stmt.setString(5, bioscoopmedewerker.getTussenvoegsel());
            stmt.setString(6, bioscoopmedewerker.getInitialen());
            stmt.setString(7, bioscoopmedewerker.getStatus());
            stmt.setString(8, bioscoopmedewerker.getRang());
            stmt.setInt(9, bioscoopmedewerker.getLeeftijd());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in Bioscoopmedewerker (insert into)");

        }
		return false;
		}
}
