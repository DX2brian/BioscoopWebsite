package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Klant;
import model.CompanyService;
import model.ServiceProvider;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = -2448391581236943784L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Haalt alles op uit het register.jsp en geeft het allemaal een variable
		String ingevuldAchternaam = req.getParameter("achternaam");
		String ingevuldTussenvoegsel = req.getParameter("tussenvoegsel");
		String ingevuldInitialen = req.getParameter("initialen");
		String ingevuldEmail_adres = req.getParameter("email_adres");
		String ingevuldWachtwoord = req.getParameter("wachtwoord");
		String ingevuldBvwachtwoord = req.getParameter("bvwachtwoord");
		String ingevuldStringleeftijd = req.getParameter("leeftijd");

		
		Random random = new Random();								//haal de random methode op
		int klantnummer = random.nextInt(100000000) + 1;			//verzin een random klant nummer tussen de 1 en de 100000000
		int leeftijd = Integer.parseInt(ingevuldStringleeftijd);	//zet de leeftijd om naar een int (nummer)

		// Import services
		CompanyService service = ServiceProvider.getCompanyService();

		// loginsucces neerzetten
		boolean loginSuccess = false;


		if (ingevuldWachtwoord.equals(ingevuldBvwachtwoord)) {			// komt het wachtwoord overeen?
			Klant k = new Klant(klantnummer, ingevuldAchternaam, ingevuldTussenvoegsel, ingevuldInitialen, ingevuldEmail_adres, ingevuldWachtwoord, leeftijd); //zet alle klantgegevens die je uit de register hebt gehaald om in klantgegevens
			service.insertKlant(k);		//Stuur k door naar de KlantDAO om alles in de database te inserten
			req.setAttribute("hoofdbericht", "Welkom op de officele Brioscoop website"); //zet dit bericht op het hoofdmenu
			loginSuccess = true;		//ticket om door te gaan naar de volgende pagina als je wachtwoorden overeen komen
		} else {	// Zo niet dan krijg je een error en een loginSuccess = false
			req.setAttribute("msgs", "Wachtwoorden komen niet overeen");	//zeg op de registeer pagina dat je wachtwoorden niet overeen komen
		}
		

		// Request dispatcher
		if (loginSuccess == true) {		//als je inglogt bent stuurt hij je door
			req.getRequestDispatcher("/index.jsp").forward(req, resp); 	//en kom je in de index.jsp
		} else {						// anders
			req.getRequestDispatcher("/inlog/register.jsp").forward(req, resp);	//stuurt hij je terug naar de pagina
		}

	}
}
