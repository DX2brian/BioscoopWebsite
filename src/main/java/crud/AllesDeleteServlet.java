package crud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CompanyService;
import model.ServiceProvider;

public class AllesDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//doet hetzelfde als hieronder maar dan met buttons
		CompanyService service = ServiceProvider.getCompanyService();
		
		if (req.getParameter("DeleteBestelling") != null) {	//controller of DeleteBestelling een waarde heeft
			Integer deleteBestelling = Integer.parseInt(req.getParameter("DeleteBestelling")); //zo ja, haal de waarde op en zet hem om in een int (nummer)
			service.verwijderBestelling(deleteBestelling);	//verwijder een bestelling met de waarde van DeleteBestelling
		}
		
		if (req.getParameter("DeleteBioscoopmedewerker") != null) {	//controller of DeleteBioscoopmedewereker een waarde heeft
			Integer personeelsnummer = Integer.parseInt(req.getParameter("DeleteBioscoopmedewerker"));	//zo ja, haal de waarde op en zet hem om in een int (nummer)
			service.deleteBioscoopmedewerker(personeelsnummer);		//verwijder een medewerker met de waarde van DeleteBioscoopmedewereker
		}
		
		if (req.getParameter("DeleteDrinken") != null) {	//controller of DeleteDrinken een waarde heeft
			String barcode = req.getParameter("DeleteDrinken");	//zo ja, haal de waarde op en zet hem om in een int (nummer)
			service.deleteDrinken(barcode);					//verwijder een drank met de waarde van DeleteDrinken
		}
		
		if (req.getParameter("DeleteEten") != null) {	//controller of DeleteEten een waarde heeft
			String barcode = req.getParameter("DeleteEten");	//zo ja, haal de waarde op en zet hem om in een int (nummer)
			service.deleteEten(barcode);					//verwijder een voedsel met de waarde van DeleteEten
		}

		if (req.getParameter("DeleteFilm") != null) {	//controller of DeleteFilm een waarde heeft
			Integer filmcode = Integer.parseInt(req.getParameter("DeleteFilm"));	//zo ja, haal de waarde op en zet hem om in een int (nummer)
			service.deleteFilm(filmcode);				//verwijder een film met de waarde van DeleteFilm
		}
		
		if (req.getParameter("DeleteKlant") != null) {	//controller of DeleteKlant een waarde heeft
			Integer klantnummer = Integer.parseInt(req.getParameter("DeleteKlant"));	//zo ja, haal de waarde op en zet hem om in een int (nummer)
			service.deleteKlant(klantnummer);			//verwijder een klant met de waarde van DeleteKlant
		}
		
		req.getRequestDispatcher("/alleProducten/alles.jsp").forward(req, resp);	//stuur hem door naar dezelfde pagina
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//Doet hetzelfde als hierboven maar dan met links
		CompanyService service = ServiceProvider.getCompanyService();
		
		if (req.getParameter("DeleteBestelling") != null) {	//controller of DeleteBestelling een waarde heeft
			Integer deleteBestelling = Integer.parseInt(req.getParameter("DeleteBestelling")); //zo ja, haal de waarde op en zet hem om in een int (nummer)
			service.verwijderBestelling(deleteBestelling);	//verwijder een bestelling met de waarde van DeleteBestelling
		}
		
		if (req.getParameter("DeleteBiosoopmedewerker") != null) {	//controller of DeleteBioscoopmedewerker een waarde heeft
			Integer personeelsnummer = Integer.parseInt(req.getParameter("DeleteBiosoopmedewerker"));	//zo ja, haal de waarde op en zet hem om in een int (nummer)
			service.deleteBioscoopmedewerker(personeelsnummer);		//verwijder een medewerker met de waarde van DeleteBioscoopmedewerker
		}
		
		if (req.getParameter("DeleteDrinken") != null) {	//controller of DeleteDrinken een waarde heeft
			String barcode = req.getParameter("DeleteDrinken");	//zo ja, haal de waarde op en zet hem om in een int (nummer)
			service.deleteDrinken(barcode);					//verwijder een drank met de waarde van DeleteDrinken
		}
		
		if (req.getParameter("DeleteEten") != null) {	//controller of DeleteEten een waarde heeft
			String barcode = req.getParameter("DeleteEten");	//zo ja, haal de waarde op en zet hem om in een int (nummer)
			service.deleteEten(barcode);					//verwijder een voedsel met de waarde van DeleteEten
		}

		if (req.getParameter("DeleteFilm") != null) {	//controller of DeleteFilm een waarde heeft
			Integer filmcode = Integer.parseInt(req.getParameter("DeleteFilm"));	//zo ja, haal de waarde op en zet hem om in een int (nummer)
			service.deleteFilm(filmcode);				//verwijder een film met de waarde van DeleteFilm
		}
		
		if (req.getParameter("DeleteKlant") != null) {	//controller of DeleteKlant een waarde heeft
			Integer klantnummer = Integer.parseInt(req.getParameter("DeleteKlant"));	//zo ja, haal de waarde op en zet hem om in een int (nummer)
			service.deleteKlant(klantnummer);			//verwijder een klant met de waarde van DeleteKlant
		}
		
		req.getRequestDispatcher("/alleProducten/alles.jsp").forward(req, resp);	//stuur hem door naar dezelfde pagina
	}
}
