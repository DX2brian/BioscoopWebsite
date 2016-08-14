package toevoegen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Film;
import model.CompanyService;
import model.ServiceProvider;

public class VoegFilmToeServlet extends HttpServlet {
	private static final long serialVersionUID = -2448391581236943784L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//doet hetzelfde als de methode hieronder maar dan met buttons

		// Maak van alle form tags, variabelen
		String filmcode = req.getParameter("filmcode");
		String naam = req.getParameter("naam");
		String cast = req.getParameter("cast");
		String beschrijving = req.getParameter("beschrijving");
		String genre = req.getParameter("genre");
		String visie = req.getParameter("visie");
		String zaalnummer = req.getParameter("zaalnummer");
		String beschikbaarheid = req.getParameter("beschikbaarheid");
		String prijs = req.getParameter("prijs");
		String imdbrating = req.getParameter("imdb_rating");
		
		// Zet ze om in nummers
		if (filmcode != null && zaalnummer != null && prijs != null && imdbrating != null){	//controlleer of ze wel zijn ingevuld want anders krijg je vage errors
		int filmcodenum = Integer.parseInt(filmcode);
		int zaalnummernum = Integer.parseInt(zaalnummer);
		int prijsnum = Integer.parseInt(prijs);
		int imdbratingnum = Integer.parseInt(imdbrating);

		// Import services
		CompanyService service = ServiceProvider.getCompanyService();	//Haal service weer eens op

		Film f = new Film(filmcodenum, naam, cast, beschrijving, genre, visie, zaalnummernum, beschikbaarheid, prijsnum, imdbratingnum);	//voeg alle attributen toe
		service.insertFilm(f);	//voeg de film toe

		}
		
		req.getRequestDispatcher("/alleProducten/alles.jsp").forward(req, resp);	//ga terug naar alles

	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//doet hetzelfde als de methode hierboven maar dan met links

		// Declare all the form tags
		String filmcode = req.getParameter("filmcode");
		String naam = req.getParameter("naam");
		String cast = req.getParameter("cast");
		String beschrijving = req.getParameter("beschrijving");
		String genre = req.getParameter("genre");
		String visie = req.getParameter("visie");
		String zaalnummer = req.getParameter("zaalnummer");
		String beschikbaarheid = req.getParameter("beschikbaarheid");
		String prijs = req.getParameter("prijs");
		String imdbrating = req.getParameter("imdb_rating");
		
		// Set them to integers
		if (filmcode != null && zaalnummer != null && prijs != null && imdbrating != null){
		int filmcodenum = Integer.parseInt(filmcode);
		int zaalnummernum = Integer.parseInt(zaalnummer);
		int prijsnum = Integer.parseInt(prijs);
		int imdbratingnum = Integer.parseInt(imdbrating);

		// Import services
		CompanyService service = ServiceProvider.getCompanyService();

		Film f = new Film(filmcodenum, naam, cast, beschrijving, genre, visie, zaalnummernum, beschikbaarheid, prijsnum, imdbratingnum);
		service.insertFilm(f);
		
		req.setAttribute("alleBericht", "Film is toegevoegd");
		
		}
		
		req.getRequestDispatcher("/alleProducten/alles.jsp").forward(req, resp);

	}
}
