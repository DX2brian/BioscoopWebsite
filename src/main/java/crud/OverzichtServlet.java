package crud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Bioscoopmedewerker;
import model.CompanyService;
import model.ServiceProvider;

public class OverzichtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//Doet hetzelfde als de methode hieronder maar dan met buttons
		
		CompanyService service = ServiceProvider.getCompanyService();	//vraag de companyservice weer eens aan
		
		//Delete de bestelling
		if (req.getParameter("Delete") != null) {	//controlleer of Delete een waarde heeft
			Integer deleteBestelling = Integer.parseInt(req.getParameter("Delete"));	//zo ja, zet de waarde van Delete om in een int (nummer)
			service.verwijderBestelling(deleteBestelling);	//verwijder de bestelling met de waarde van deleteBestelling
		}
		
		//Acepteer de bestelling
		if (req.getParameter("Accepteer") != null) {	//controlleer of Accepteer een waarde heeft
			Integer accepteerBestelling = Integer.parseInt(req.getParameter("Accepteer"));	//zo ja, zet de waarde van Accepteer om in een int (nummer)
			int personeelsnummer = ((Bioscoopmedewerker)req.getSession().getAttribute("loggedMedewerker")).getPersoneelsnummer();	//verkrijg het personeelsnummer van de medewekrer door te kijken welk nummer loggedMedewerker heeft en zet dit nummer om in een variabele
			service.updateBioscoopmedewerkerBestelling(accepteerBestelling, personeelsnummer);	//update de bestelling met de waarde van AccepteerBestelling en het personeelsnummer
		}
		
		//Zet de bestelling op bezig
		if (req.getParameter("Bezig") != null) {	//controlleer of Bezig een waarde heeft
			Integer statusUpdate = Integer.parseInt(req.getParameter("Bezig"));	//zo ja, zet de waarde van Bezig om in een int (nummer)
			service.updateStatusBestellingBezig(statusUpdate);	//update de status van de bestelling naar bezig
		}
		
		//Zet de bestelling op klaar
		if (req.getParameter("Klaar") != null) {	//controlleer of Klaar een waarde heeft
			Integer statusUpdate = Integer.parseInt(req.getParameter("Klaar"));	//zo ja, zet de waarde van Klaar om in een int (nummer)
			service.updateStatusBestellingKlaar(statusUpdate);	//update de status van de bestelling naar klaar
		}
		
		req.getRequestDispatcher("/bioscoopmedewerker/statusOverzicht.jsp").forward(req, resp);	//stuur je terug naar de overizcht pagina
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//Doet hetzelfde als de methode hierboven maar dan met links
		
		CompanyService service = ServiceProvider.getCompanyService();	//vraag de companyservice weer eens aan
		
		//Delete de bestelling
		if (req.getParameter("Delete") != null) {	//controlleer of Delete een waarde heeft
			Integer deleteBestelling = Integer.parseInt(req.getParameter("Delete"));	//zo ja, zet de waarde van Delete om in een int (nummer)
			service.verwijderBestelling(deleteBestelling);	//verwijder de bestelling met de waarde van deleteBestelling
		}
		
		//Acepteer de bestelling
		if (req.getParameter("Accepteer") != null) {	//controlleer of Accepteer een waarde heeft
			Integer accepteerBestelling = Integer.parseInt(req.getParameter("Accepteer"));	//zo ja, zet de waarde van Accepteer om in een int (nummer)
			int personeelsnummer = ((Bioscoopmedewerker)req.getSession().getAttribute("loggedMedewerker")).getPersoneelsnummer();	//verkrijg het personeelsnummer van de medewekrer door te kijken welk nummer loggedMedewerker heeft en zet dit nummer om in een variabele
			service.updateBioscoopmedewerkerBestelling(accepteerBestelling, personeelsnummer);	//update de bestelling met de waarde van AccepteerBestelling en het personeelsnummer
		}
		
		//Zet de bestelling op bezig
		if (req.getParameter("Bezig") != null) {	//controlleer of Bezig een waarde heeft
			Integer statusUpdate = Integer.parseInt(req.getParameter("Bezig"));	//zo ja, zet de waarde van Bezig om in een int (nummer)
			service.updateStatusBestellingBezig(statusUpdate);	//update de status van de bestelling naar bezig
		}
		
		//Zet de bestelling op klaar
		if (req.getParameter("Klaar") != null) {	//controlleer of Klaar een waarde heeft
			Integer statusUpdate = Integer.parseInt(req.getParameter("Klaar"));	//zo ja, zet de waarde van Klaar om in een int (nummer)
			service.updateStatusBestellingKlaar(statusUpdate);	//update de status van de bestelling naar klaar
		}
		
		req.getRequestDispatcher("/bioscoopmedewerker/statusOverzicht.jsp").forward(req, resp);	//stuur je terug naar de overizcht pagina
	}
}
