package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Eten;


public class EtenDAO extends BaseDAO {
	private List<Eten> selectEten(String query) {
		List<Eten> results = new ArrayList<Eten>();

		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);

			while (dbResultSet.next()) {
				String barcode = dbResultSet.getString("barcode");
				String naam = dbResultSet.getString("naam");
				String merk = dbResultSet.getString("merk");
				int prijs = dbResultSet.getInt("prijs");
				String grootte = dbResultSet.getString("grootte");
				int gram = dbResultSet.getInt("gram");

				results.add(new Eten(barcode, naam, merk, prijs, grootte, gram));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Er zit een error in de etenDAO (selectEten)");
		}

		return results;
	}
	
	/***************************** READ methods *****************************/

	public Eten findByNaam(String naam) {
		return selectEten(String.format("SELECT * FROM eten WHERE naam = '%s'", naam)).get(0);
	}
	
	public List<Eten> findAll(){
		return selectEten("SELECT barcode, naam, merk, prijs, grootte, gram FROM eten");
	}
	
	public Eten findByBarcode(String barcode) {
		return selectEten(String.format("SELECT * FROM eten WHERE barcode = '%s'", barcode)).get(0);
	}
	
	/***************************** Delete methods *****************************/
	
	public boolean deleteEten(Eten eten) {
		boolean result = false;
		boolean etenExists = findByBarcode(eten.getBarcode()) != null;
		
		if (etenExists) {
					
			try (Connection con = super.getConnection()) {
				PreparedStatement stmt = con.prepareStatement("DELETE FROM eten WHERE barcode = ?");
				stmt.setString(1, eten.getBarcode());
				
				return stmt.executeUpdate() == 1;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				System.out.println("Er zit een error in etenDAO (deleteEten)");
				
			}
		}
		
		return result;
	}
	
	/***************************** Insert methods *****************************/
	
    public boolean insertEten(Eten eten) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO eten (Barcode, Naam, Merk, Prijs, Grootte, Gram) VALUES ( ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, eten.getBarcode());
            stmt.setString(2, eten.getNaam());
            stmt.setString(3, eten.getMerk());
            stmt.setInt(4, eten.getPrijs());
            stmt.setString(5, eten.getGrootte());
            stmt.setInt(6, eten.getGram());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in EtenDAO (insert into)");

        }
		return false;
		}
}
