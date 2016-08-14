package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Film;


public class FilmDAO extends BaseDAO {
	private List<Film> selectFilm(String query) {
		List<Film> results = new ArrayList<Film>();

		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);

			while (dbResultSet.next()) {
				int filmcode = dbResultSet.getInt("filmcode");
				String naam = dbResultSet.getString("naam");
				String cast = dbResultSet.getString("cast");
				String beschrijving = dbResultSet.getString("beschrijving");
				String genre = dbResultSet.getString("genre");
				String visie = dbResultSet.getString("visie");
				int zaalnummer = dbResultSet.getInt("zaalnummer");
				String beschikbaarheid = dbResultSet.getString("beschikbaarheid");
				int prijs = dbResultSet.getInt("prijs");
				int IMDB_rating = dbResultSet.getInt("IMDB_rating");

				results.add(new Film(filmcode, naam, cast, beschrijving, genre, visie, zaalnummer, beschikbaarheid, prijs, IMDB_rating));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Er zit een error in de FilmDAO (selectFilm)");
		}

		return results;
	}
	
	/***************************** READ methods *****************************/

	public Film findByNaam(String naam) {
		return selectFilm(String.format("SELECT * FROM film WHERE naam = '%s'", naam)).get(0);
	}
	
	public List<Film> findAll(){
		return selectFilm("SELECT filmcode, naam, cast, beschrijving, genre, visie, zaalnummer, beschikbaarheid, prijs, IMDB_rating FROM film ");
	}
	
    public Film findByFilmcode(int filmcode) {
        return selectFilm(String.format("SELECT * FROM film WHERE filmcode = '%d'", filmcode)).get(0);
    }
	
    /***************************** Delete methods *****************************/
    
	public boolean deleteFilm(Film film) {
		boolean result = false;
		boolean filmExists = findByFilmcode(film.getFilmcode()) != null;
		
		if (filmExists) {
					
			try (Connection con = super.getConnection()) {
				PreparedStatement stmt = con.prepareStatement("DELETE FROM film WHERE filmcode = ?");
				stmt.setInt(1, film.getFilmcode());
				
				return stmt.executeUpdate() == 1;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				System.out.println("Er zit een error in filmDAO (deleteFilm)");
				
			}
		}
		
		return result;
	}
	
	/***************************** Insert methods *****************************/
	
    public boolean insertFilm(Film film) {

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO film (Filmcode, Naam, Cast, Beschrijving, Genre, Visie, Zaalnummer, Beschikbaarheid, Prijs, IMDB_rating) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, film.getFilmcode());
            stmt.setString(2, film.getNaam());
            stmt.setString(3, film.getCast());
            stmt.setString(4, film.getBeschrijving());
            stmt.setString(5, film.getGenre());
            stmt.setString(6, film.getVisie());
            stmt.setInt(7, film.getZaalnummer());
            stmt.setString(8, film.getBeschikbaarheid());
            stmt.setInt(9, film.getPrijs());
            stmt.setInt(10, film.getIMDB_rating());
            System.out.print(stmt);

            return stmt.executeUpdate() == 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Er zit een error in FilmDAO (insert into)");

        }
		return false;
		}
}
