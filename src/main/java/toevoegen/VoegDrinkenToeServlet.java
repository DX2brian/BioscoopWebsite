package toevoegen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Drinken;
import model.CompanyService;
import model.ServiceProvider;

public class VoegDrinkenToeServlet extends HttpServlet {
	private static final long serialVersionUID = -2448391581236943784L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//doet hetzelfde als de methode hieronder maar dan met buttons

		// Maak van alle form tags, variabelen
		String barcode = req.getParameter("barcode");
		String naam = req.getParameter("naam");
		String merk = req.getParameter("merk");
		String prijs = req.getParameter("prijs");
		String liter = req.getParameter("liter");
		String gekoelt = req.getParameter("gekoelt");
		
		// Zet ze om in nummers
		if (prijs != null && liter != null) {	//controlleer of ze wel zijn ingevuld want anders krijg je vage errors
			int prijsnum = Integer.parseInt(prijs);
			int liternum = Integer.parseInt(liter);		

		// Import services
		CompanyService service = ServiceProvider.getCompanyService();	//Haal service weer eens op

		Drinken d = new Drinken(barcode, naam, merk, prijsnum, liternum, gekoelt);	//voeg alle attributen toe
		service.insertDrinken(d);	//voeg de drank toe
		
		}
		
		req.getRequestDispatcher("/alleProducten/alles.jsp").forward(req, resp);	//stuurt je door naar alles
	
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//doet hetzelfde als de methode hierboven maar dan met links

		// Maak van alle form tags, variabelen
		String barcode = req.getParameter("barcode");
		String naam = req.getParameter("naam");
		String merk = req.getParameter("merk");
		String prijs = req.getParameter("prijs");
		String liter = req.getParameter("liter");
		String gekoelt = req.getParameter("gekoelt");
		
		// Zet ze om in nummers
		if (prijs != null && liter != null) {	//controlleer of ze wel zijn ingevuld want anders krijg je vage errors
			int prijsnum = Integer.parseInt(prijs);
			int liternum = Integer.parseInt(liter);		

		// Import services
		CompanyService service = ServiceProvider.getCompanyService();	//Haal service weer eens op

		Drinken d = new Drinken(barcode, naam, merk, prijsnum, liternum, gekoelt);	//voeg alle attributen toe
		service.insertDrinken(d);	//voeg de drank toe
		
		}
		
		req.getRequestDispatcher("/alleProducten/alles.jsp").forward(req, resp);	//stuurt je door naar alles
	
	}
}
