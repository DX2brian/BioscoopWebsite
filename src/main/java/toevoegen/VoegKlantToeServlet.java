package toevoegen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Klant;
import model.CompanyService;
import model.ServiceProvider;

public class VoegKlantToeServlet extends HttpServlet {
	private static final long serialVersionUID = -2448391581236943784L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 	//doet hetzelfde als de methode hieronder maar dan met buttons

		// Maak van alle form tags, variabelen
		String klantnummer = req.getParameter("klantnummer");
		String achternaam = req.getParameter("achternaam");
		String tussenvoegsel = req.getParameter("tussenvoegsel");
		String initialen = req.getParameter("initialen");
		String email_adres = req.getParameter("email_adres");
		String wachtwoord = req.getParameter("wachtwoord");
		String leeftijd = req.getParameter("leeftijd");
		
		// Zet ze om in nummers
		if(klantnummer != null && leeftijd != null) {	//controlleer of ze wel zijn ingevuld want anders krijg je vage errors
		int klantnummernum = Integer.parseInt(klantnummer);
		int leeftijdnum = Integer.parseInt(leeftijd);

		// Import services
		CompanyService service = ServiceProvider.getCompanyService();	//Haal service weer eens op

		Klant k = new Klant(klantnummernum, achternaam, tussenvoegsel, initialen, email_adres, wachtwoord, leeftijdnum);	//voeg alle attributen toe
		service.insertKlant(k);	//voeg de klant toe
		
		}
		
		req.getRequestDispatcher("/alleProducten/alles.jsp").forward(req, resp); //ga terug naar alles
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//doet hetzelfde als de methode hierboven maar dan met links

		// Maak van alle form tags, variabelen
		String klantnummer = req.getParameter("klantnummer");
		String achternaam = req.getParameter("achternaam");
		String tussenvoegsel = req.getParameter("tussenvoegsel");
		String initialen = req.getParameter("initialen");
		String email_adres = req.getParameter("email_adres");
		String wachtwoord = req.getParameter("wachtwoord");
		String leeftijd = req.getParameter("leeftijd");
		
		// Zet ze om in nummers
		if(klantnummer != null && leeftijd != null) {
		int klantnummernum = Integer.parseInt(klantnummer);
		int leeftijdnum = Integer.parseInt(leeftijd);

		// Import services
		CompanyService service = ServiceProvider.getCompanyService();

		Klant k = new Klant(klantnummernum, achternaam, tussenvoegsel, initialen, email_adres, wachtwoord, leeftijdnum);	//voeg alle attributen toe
		service.insertKlant(k);	//voeg de klant toe
		
		}
		
		req.getRequestDispatcher("/alleProducten/alles.jsp").forward(req, resp); //ga terug naar alles
	}
}
