package toevoegen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Bioscoopmedewerker;
import model.CompanyService;
import model.ServiceProvider;

public class VoegBioscoopmedewerkerToeServlet extends HttpServlet {
	private static final long serialVersionUID = -2448391581236943784L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//doet hetzelfde als de methode hieronder maar dan met buttons

		// Maak van alle form tags, variabelen
		String personeelsnummer = req.getParameter("personeelsnummer");
		String email_adres = req.getParameter("email_adres");
		String wachtwoord = req.getParameter("wachtwoord");
		String achternaam = req.getParameter("achternaam");
		String tussenvoegsel = req.getParameter("tussenvoegsel");
		String initialen = req.getParameter("initialen");
		String status = req.getParameter("status");
		String rang = req.getParameter("rang");
		String leeftijd = req.getParameter("leeftijd");

		// Zet ze om in nummers
		if (personeelsnummer != null && leeftijd != null) {	//controlleer of ze wel zijn ingevuld want anders krijg je vage errors
		int personeelsnummernum = Integer.parseInt(personeelsnummer);
		int leeftijdnum = Integer.parseInt(leeftijd);

		// Import services
		CompanyService service = ServiceProvider.getCompanyService();	//Haal service weer eens op

		Bioscoopmedewerker b = new Bioscoopmedewerker(personeelsnummernum, email_adres, wachtwoord, achternaam, tussenvoegsel, initialen, status, rang, leeftijdnum);	//voeg alle attributen toe
		service.insertBioscoopmedewerker(b);	//voeg de bioscoopmedewerker toe
		}
		
		req.getRequestDispatcher("/alleProducten/alles.jsp").forward(req, resp);	//ga terug naar alles
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//doet hetzelfde als de methode hierboven maar dan met links

		// Maak van alle form tags, variabelen
		String personeelsnummer = req.getParameter("personeelsnummer");
		String email_adres = req.getParameter("email_adres");
		String wachtwoord = req.getParameter("wachtwoord");
		String achternaam = req.getParameter("achternaam");
		String tussenvoegsel = req.getParameter("tussenvoegsel");
		String initialen = req.getParameter("initialen");
		String status = req.getParameter("status");
		String rang = req.getParameter("rang");
		String leeftijd = req.getParameter("leeftijd");

		// Zet ze om in nummers
		if (personeelsnummer != null && leeftijd != null) {	//controlleer of ze wel zijn ingevuld want anders krijg je vage errors
		int personeelsnummernum = Integer.parseInt(personeelsnummer);
		int leeftijdnum = Integer.parseInt(leeftijd);

		// Import services
		CompanyService service = ServiceProvider.getCompanyService();	//Haal service weer eens op

		Bioscoopmedewerker b = new Bioscoopmedewerker(personeelsnummernum, email_adres, wachtwoord, achternaam, tussenvoegsel, initialen, status, rang, leeftijdnum);	//voeg alle attributen toe
		service.insertBioscoopmedewerker(b);	//voeg de bioscoopmedewerker toe
		}
		
		req.getRequestDispatcher("/alleProducten/alles.jsp").forward(req, resp);	//ga terug naar alles
	}
}
