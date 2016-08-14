package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Drinken;

public class DrinkenDAO extends BaseDAO {
	private List<Drinken> selectDrinken(String query) {
		List<Drinken> results = new ArrayList<Drinken>();

		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);

			while (dbResultSet.next()) {
				String barcode = dbResultSet.getString("barcode");
				String naam = dbResultSet.getString("naam");
				String merk = dbResultSet.getString("merk");
				int prijs = dbResultSet.getInt("prijs");
				int liters = dbResultSet.getInt("liters");
				String gekoelt = dbResultSet.getString("gekoelt");

				results.add(new Drinken(barcode, naam, merk, prijs, liters, gekoelt));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Er zit een error in de DrinkenDAO (selectDrinken)");
		}

		return results;
	}
	
	/***************************** Read methods *****************************/

	public Drinken findByNaam(String naam) {
		return selectDrinken(String.format("SELECT * FROM drinken WHERE naam = '%s'", naam)).get(0);
	}
	
	public List<Drinken> findAll(){
		return selectDrinken("SELECT barcode, naam, merk, prijs, liters, gekoelt FROM drinken");
	}
	
	public Drinken findByBarcode(String barcode) {
		return selectDrinken(String.format("SELECT * FROM drinken WHERE barcode = '%s'", barcode)).get(0);
	}
	
	/***************************** Delete methods *****************************/
	
	public boolean deleteDrinken(Drinken drinken) {
		boolean result = false;
		boolean drinkenExists = findByBarcode(drinken.getBarcode()) != null;
		
		if (drinkenExists) {
					
			try (Connection con = super.getConnection()) {
				PreparedStatement stmt = con.prepareStatement("DELETE FROM drinken WHERE barcode = ?");
				stmt.setString(1, drinken.getBarcode());
				
				return stmt.executeUpdate() == 1;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				System.out.println("Er zit een error in drinkenDAO (deleteDrinken)");
				
			}
		}
		
		return result;
	}
	
	/***************************** Insert methods *****************************/
	
    public boolean insertDrinken(Drinken drinken) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO drinken (Barcode, Naam, Merk, Prijs, Liters, Gekoelt) VALUES ( ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, drinken.getBarcode());
            stmt.setString(2, drinken.getNaam());
            stmt.setString(3, drinken.getMerk());
            stmt.setInt(4, drinken.getPrijs());
            stmt.setInt(5, drinken.getLiters());
            stmt.setString(6, drinken.getGekoelt());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in DrinkenDAO (insert into)");

        }
		return false;
		}
}
