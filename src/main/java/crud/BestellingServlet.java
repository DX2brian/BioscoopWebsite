package crud;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BestellingV2;
import domain.Klant;
import model.CompanyService;
import model.ServiceProvider;

public class BestellingServlet extends HttpServlet {
	private static final long serialVersionUID = 5057162048049471829L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //is hetzelfde als de methode hieronder maar dan met buttons
		
		//Service erbij halen
		CompanyService service = ServiceProvider.getCompanyService();
		
		//Delete een bestelling
		if (req.getParameter("Delete") != null) {	//Controller of Delete een waarde heeft
			Integer deleteBestelling = Integer.parseInt(req.getParameter("Delete"));	//Zo ja, zet Delete dan om in een int (nummer)
			service.verwijderBestelling(deleteBestelling);	//Verwijder een bestelling met de waarde van Delete
			req.getRequestDispatcher("/webshop/winkelwagen.jsp").forward(req, resp);	//Stuur hem dor naar de winkelwagen
		}
		
		//Update een bestelling
		if (req.getParameter("Update") != null) {	//Controlleer of Update een waarde heeft
			Integer updateBestelling = Integer.parseInt(req.getParameter("Update"));	//Zo ja, zet Update dan om in een int (nummer)
			int klantnummer = ((Klant)req.getSession().getAttribute("loggedKlant")).getKlantnummer();	//verkrijg het klantnummer van de klant door te kijken welk nummer loggedklant heeft en zet dit nummer om in een variabele
			int personeelsnummer = 0000;	//zet het personeelsnummer TERUG op 0 (omdat de bestelling word gereset
			int filmID = ((BestellingV2)req.getSession().getAttribute("actieveBestelling")).getFilm();	//verkrijg de filmcode van de film door te kijken welk nummer actieveBestelling heeft en zet dit nummer om in een variabele
			int prijs = 0;	//Prijs is gewoon 0 omdat ik er gek van werd
			
			
			BestellingV2 b = new BestellingV2(updateBestelling, personeelsnummer, klantnummer, filmID, prijs); //Verkrijg alle variablen die hierboven zijn genoemd
			req.getSession().setAttribute("actieveBestelling", b);	//zet de bestelling om nieuw bestelling session object want daarmee verander je je vorige bestelling
			req.getRequestDispatcher("/webshop/producten.jsp").forward(req, resp); 	//Stuur je door naar de producten pagina
		}
		
		//Voeg een bestelling toe
		if (req.getParameter("voegToe") != null) {	//controlleer of voegtoe een waarde heeft
			Random random = new Random();			//start de random methode
			int bestelcode = random.nextInt(1000000) +1; //Random bestellingsnummer tussen de 1 en de 1000000
			int klantnummer = ((Klant)req.getSession().getAttribute("loggedKlant")).getKlantnummer();	//verkrijg het klantnummer van de klant door te kijken welk nummer loggedklant heeft en zet dit nummer om in een variabele
			Integer filmID = Integer.parseInt(req.getParameter("voegToe"));	//FilmID voor welke film opgehaald door de waarde van voegToe
			int prijs = random.nextInt(50) +1;	//Random prijs tussen de 1 en 50
			
			BestellingV2 b = new BestellingV2(bestelcode, klantnummer, filmID, prijs);	//Gooi alle variabelen in een nieuwe bestelling en zet deze om in b
			req.getSession().setAttribute("actieveBestelling", b);						//zet actieveBestelling om naar de net aangemaakte bestelling b
			
			service.voegFilmToe(b);	//Voeg de bestelling toe aan de databasse
			
			req.getRequestDispatcher("/webshop/producten.jsp").forward(req, resp);		//Stuurt je door naar producten pagina
	}
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //is hetzelfde als de methode hieronder maar dan met links
		
		//Service erbij halen
		CompanyService service = ServiceProvider.getCompanyService();
		
		//Delete een bestelling
		if (req.getParameter("Delete") != null) {	//Controller of Delete een waarde heeft
			Integer deleteBestelling = Integer.parseInt(req.getParameter("Delete"));	//Zo ja, zet Delete dan om in een int (nummer)
			service.verwijderBestelling(deleteBestelling);	//Verwijder een bestelling met de waarde van Delete
			req.getRequestDispatcher("/webshop/winkelwagen.jsp").forward(req, resp);	//Stuur hem dor naar de winkelwagen
		}
		
		//Update een bestelling
		if (req.getParameter("Update") != null) {	//Controlleer of Update een waarde heeft
			Integer updateBestelling = Integer.parseInt(req.getParameter("Update"));	//Zo ja, zet Update dan om in een int (nummer)
			int klantnummer = ((Klant)req.getSession().getAttribute("loggedKlant")).getKlantnummer();	//verkrijg het klantnummer van de klant door te kijken welk nummer loggedklant heeft en zet dit nummer om in een variabele
			int personeelsnummer = 0000;	//zet het personeelsnummer TERUG op 0 (omdat de bestelling word gereset
			int filmID = ((BestellingV2)req.getSession().getAttribute("actieveBestelling")).getFilm();	//verkrijg de filmcode van de film door te kijken welk nummer actieveBestelling heeft en zet dit nummer om in een variabele
			int prijs = 0;	//Prijs is gewoon 0 omdat ik er gek van werd
			
			
			BestellingV2 b = new BestellingV2(updateBestelling, personeelsnummer, klantnummer, filmID, prijs); //Verkrijg alle variablen die hierboven zijn genoemd
			req.getSession().setAttribute("actieveBestelling", b);	//zet de bestelling om nieuw bestelling session object want daarmee verander je je vorige bestelling
			req.getRequestDispatcher("/webshop/producten.jsp").forward(req, resp); 	//Stuur je door naar de producten pagina
		}
		
		//Voeg een bestelling toe
		if (req.getParameter("voegToe") != null) {	//controlleer of voegtoe een waarde heeft
			Random random = new Random();			//start de random methode
			int bestelcode = random.nextInt(1000000) +1; //Random bestellingsnummer tussen de 1 en de 1000000
			int klantnummer = ((Klant)req.getSession().getAttribute("loggedKlant")).getKlantnummer();	//verkrijg het klantnummer van de klant door te kijken welk nummer loggedklant heeft en zet dit nummer om in een variabele
			Integer filmID = Integer.parseInt(req.getParameter("voegToe"));	//FilmID voor welke film opgehaald door de waarde van voegToe
			int prijs = random.nextInt(50) +1;	//Random prijs tussen de 1 en 50
			
			BestellingV2 b = new BestellingV2(bestelcode, klantnummer, filmID, prijs);	//Gooi alle variabelen in een nieuwe bestelling en zet deze om in b
			req.getSession().setAttribute("actieveBestelling", b);						//zet actieveBestelling om naar de net aangemaakte bestelling b
			
			service.voegFilmToe(b);	//Voeg de bestelling toe aan de databasse
			
			req.getRequestDispatcher("/webshop/producten.jsp").forward(req, resp);		//Stuurt je door naar producten pagina
	}
		req.getRequestDispatcher("/webshop/winkelwagen.jsp").forward(req, resp);		//Stuurt je door naar producten pagina
	}
}
