package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Klant;
import model.CompanyService;
import model.ServiceProvider;

public class VeranderwwServlet extends HttpServlet{
	private static final long serialVersionUID = -6836537793332383648L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// alle form tags worden hier verwerkt in variabelen
		String controleww1 = req.getParameter("controleww1");
		String controleww2 = req.getParameter("controleww2");
		String controleww3 = req.getParameter("controleww3");

		// Import services
		CompanyService service = ServiceProvider.getCompanyService();

		// Zet de wachtwoordSucces variable alvast op false
		boolean wachtwoordSuccess = false;

		// komt het wachtwoord overeen?
		//vraag eerst aan de eerste variable of hij overeenkomt met de sessie. Als tweede haal je het atribuut loggedKlant op en uit loggedKlant haal je dan weer het wachtwoord (is dus het wachtwoord van de ingelogde klant) en die vergelijk je met elkaar
		//en controlleer daarna of de twee nieuwe wachtwoorden hetzelfde zijn
		if (controleww1.equals(((Klant)req.getSession().getAttribute("loggedKlant")).getWachtwoord()) && controleww2.equals(controleww3)) { 
			
			
			int klantnummer = ((Klant)req.getSession().getAttribute("loggedKlant")).getKlantnummer(); //Klantnummer erbij omdat hij dan kan zien wie het wachtwoord wil aanpassen
			Klant k = new Klant(klantnummer, controleww3);	//zet de k attribuut
			service.updateww(k);		//Stuur hem naar de KlantDAO om alles in de database te updaten
	
			wachtwoordSuccess = true;	//zet je wachtwoordsucces op true
			req.setAttribute("msgs3", "Wachtwoord verandert");	//zet het bericht dat ze overeen komen
			// Zo niet dan krijg je een error en een loginSuccess = false
		} else {
			req.setAttribute("msgs3", "Wachtwoorden komen niet overeen");	//zet het bericht dat ze niet overeen komen
		}
		

		// Request dispatcher
		if (wachtwoordSuccess == true) {	//als alles klopt
			req.getRequestDispatcher("/account/klantAccount.jsp").forward(req, resp);	//stuur hem door naar dezelfde pagina
		} else {
			req.getRequestDispatcher("/account/klantAccount.jsp").forward(req, resp);	//stuur hem door naar dezelfde pagina
		}
	}
}
