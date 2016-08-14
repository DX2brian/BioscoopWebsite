package toevoegen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BestellingV2;
import model.CompanyService;
import model.ServiceProvider;

public class VoegBestellingToeServlet extends HttpServlet {
	private static final long serialVersionUID = -2448391581236943784L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//doet hetzelfde als de methode hieronder maar dan met buttons

		// Maak van alle form tags, variabelen
		String bestellingnummer = req.getParameter("bestellingnummer");
		String klant = req.getParameter("klant");
		String bioscoopmedewerker = req.getParameter("bioscoopmedewerker");
		String eten = req.getParameter("eten");
		String drinken = req.getParameter("drinken");
		String film = req.getParameter("film");
		String prijs = req.getParameter("prijs");
		String status = req.getParameter("status");

		// Zet ze om in nummers
		if (bestellingnummer != null && klant != null && bioscoopmedewerker != null && film != null && prijs != null) {	//controlleer of ze wel zijn ingevuld want anders krijg je vage errors
		
		int bestellingnummernum = Integer.parseInt(bestellingnummer);
		int klantnum = Integer.parseInt(klant);
		int bioscoopmedewerkernum = Integer.parseInt(bioscoopmedewerker);
		int filmnum = Integer.parseInt(film);
		int prijsnum = Integer.parseInt(prijs);

		// Import services
		CompanyService service = ServiceProvider.getCompanyService();	//Haal service weer eens op

		BestellingV2 b = new BestellingV2(bestellingnummernum, klantnum, bioscoopmedewerkernum, eten, drinken, filmnum, prijsnum, status);	//voeg alle attributen toe
		service.insertBestelling(b);	//voeg de bestlling toe
		
		}
		req.getRequestDispatcher("/alleProducten/alles.jsp").forward(req, resp);	//ga terug naar alles

	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//doet hetzelfde als de methode hierboven maar dan met links

		// Maak van alle form tags, variabelen
		String bestellingnummer = req.getParameter("bestellingnummer");
		String klant = req.getParameter("klant");
		String bioscoopmedewerker = req.getParameter("bioscoopmedewerker");
		String eten = req.getParameter("eten");
		String drinken = req.getParameter("drinken");
		String film = req.getParameter("film");
		String prijs = req.getParameter("prijs");
		String status = req.getParameter("status");

		// Zet ze om in nummers
		if (bestellingnummer != null && klant != null && bioscoopmedewerker != null && film != null && prijs != null) {	//controlleer of ze wel zijn ingevuld want anders krijg je vage errors
		
		int bestellingnummernum = Integer.parseInt(bestellingnummer);
		int klantnum = Integer.parseInt(klant);
		int bioscoopmedewerkernum = Integer.parseInt(bioscoopmedewerker);
		int filmnum = Integer.parseInt(film);
		int prijsnum = Integer.parseInt(prijs);

		// Import services
		CompanyService service = ServiceProvider.getCompanyService();	//Haal service weer eens op

		BestellingV2 b = new BestellingV2(bestellingnummernum, klantnum, bioscoopmedewerkernum, eten, drinken, filmnum, prijsnum, status);	//voeg alle attributen toe
		service.insertBestelling(b);	//voeg de bestlling toe
		
		}
		req.getRequestDispatcher("/alleProducten/alles.jsp").forward(req, resp);	//ga terug naar alles

	}
	
	
}
