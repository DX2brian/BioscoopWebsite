package crud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BestellingV2;
import model.CompanyService;
import model.ServiceProvider;

public class EtenDrinkenServlet extends HttpServlet {
	private static final long serialVersionUID = 5057162048049471829L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CompanyService service = ServiceProvider.getCompanyService();	//Roep service weer eens aan
		
		if (req.getParameter("voegEtenToe") != null) {	//controlleer of voegEtenToe een waarde heeft
			String voegEtenToe = req.getParameter("voegEtenToe");	//Zo ja zet voegEtenToe om in een variabele string
			int bestelnummer = ((BestellingV2)req.getSession().getAttribute("actieveBestelling")).getBestellingnummer();	//verkrijg het bestellingnummer van de bestelling door te kijken welk nummer actieveBestelling heeft en zet dit nummer om in een variabele
			service.updateEtenInBestelling(voegEtenToe, bestelnummer);	//update het eten in de bestelling met behulp van de barcode (voegEtenToe), en de bestllingnummer (bestelnummer)
		}
		
		if (req.getParameter("voegDrinkenToe") != null) {	//controlleer of voegDrinkenToe een waarde heeft
			String voegDrinkenToe = req.getParameter("voegDrinkenToe");	//Zo ja zet voegDrinkenToe om in een variabele string
			int bestelnummer = ((BestellingV2)req.getSession().getAttribute("actieveBestelling")).getBestellingnummer();	//verkrijg het bestellingnummer van de bestelling door te kijken welk nummer actieveBestelling heeft en zet dit nummer om in een variabele
			service.updateDrinkenInBestelling(voegDrinkenToe, bestelnummer);	//update het drinken in de bestelling met behulp van de barcode (voegDrinkenToe), en de bestllingnummer (bestelnummer)
		}		
				
		req.getRequestDispatcher("/webshop/producten.jsp").forward(req, resp);	//stuur je door naar dezelfde pagina
	}
}
