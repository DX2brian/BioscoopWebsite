package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.Klant;

public class KlantDAO extends BaseDAO {
    private List<Klant> selectKlanten(String query) {
        List<Klant> results = new ArrayList<Klant>();

        try (Connection con = super.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int klantnummer = dbResultSet.getInt("klantnummer");
                String achternaam = dbResultSet.getString("achternaam");
                String tussenvoegsel = dbResultSet.getString("tussenvoegsel");
                String initialen = dbResultSet.getString("initialen");
                String email_adres = dbResultSet.getString("email_adres");
                String wachtwoord = dbResultSet.getString("wachtwoord");
                int leeftijd = dbResultSet.getInt("leeftijd");

                results.add(new Klant(klantnummer, achternaam, tussenvoegsel, initialen, email_adres, wachtwoord, leeftijd));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in de klantDAO (selectKlanten)");
        }

        return results;
    }
    
    /***************************** READ methods *****************************/

    public Klant findByKlantnummer(int klantnummer) {
        return selectKlanten(String.format("SELECT * FROM klant WHERE klantnummer = %d", klantnummer)).get(0);
    }

    public List<Klant> findAll() {
        return selectKlanten("SELECT klantnummer, achternaam, tussenvoegsel, initialen, email_adres, wachtwoord, leeftijd FROM klant");
    }

    public Klant findByEmail(String email_adres) {
        return selectKlanten(String.format("SELECT * FROM klant WHERE email_adres = '%s'", email_adres)).get(0);
    }
    
    /***************************** Delete methods *****************************/

    public boolean deleteKlant(Klant klant) {
        boolean result = false;
        boolean klantExists = findByKlantnummer(klant.getKlantnummer()) != null;

        if (klantExists) {

            try (Connection con = super.getConnection()) {
                PreparedStatement stmt = con.prepareStatement("DELETE FROM klant WHERE klantnummer = ?");
                stmt.setInt(1, klant.getKlantnummer());

                return stmt.executeUpdate() == 1;
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                System.out.println("Er zit een error in klantDAO (deleteKlant)");
            }
        }

        return result;
    }
    
    /***************************** Insert methods *****************************/
    
    public boolean insertKlant(Klant klant) {

            try (Connection con = super.getConnection()) {
                PreparedStatement stmt = con.prepareStatement("INSERT INTO klant VALUES ( ?, ?, ?, ?, ?, ?, ?)");
                stmt.setInt(1, klant.getKlantnummer());
                stmt.setString(2, klant.getAchternaam());
                stmt.setString(3, klant.getTussenvoegsel());
                stmt.setString(4, klant.getInitialen());
                stmt.setString(5, klant.getEmail_adres());
                stmt.setString(6, klant.getWachtwoord());
                stmt.setInt(7, klant.getLeeftijd());
                System.out.print(stmt);

                return stmt.executeUpdate() == 1;
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                System.out.println("Er zit een error in klantDAO (insert into)");

            }
			return false;
    }
    
    /***************************** Update methods *****************************/
    
    public boolean veranderwwKlant(Klant klant) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE klant SET Wachtwoord= ? Where Klantnummer= ?");
            stmt.setString(1, klant.getWachtwoord());
            stmt.setInt(2, klant.getKlantnummer());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in klantDAO (Update ww)");

        }
		return false;
}
}
