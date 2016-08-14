package crud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Bioscoopmedewerker;
import model.CompanyService;
import model.ServiceProvider;

public class BioscoopmedewerkerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CompanyService service = ServiceProvider.getCompanyService();
		
		if (req.getParameter("NAHW") != null) {	//controlleer of NAHW een waarde heeft
			Bioscoopmedewerker bioscoopmedewerker = (Bioscoopmedewerker)req.getSession().getAttribute("loggedMedewerker");	//Zo ja, vraag dan het Attribuut loggedMedewerker aan en zet deze om in de variabele bioscoopmedewerker
			service.updateStatusNAHW(bioscoopmedewerker);	//Update de status naar 'niet aan het werk'
		}
		
		if (req.getParameter("AHW") != null) {	//controlleer of AHW een waarde heeft
			Bioscoopmedewerker bioscoopmedewerker = (Bioscoopmedewerker)req.getSession().getAttribute("loggedMedewerker");	//Zo ja, vraag dan het Attribuut loggedMedewerker aan en zet deze om in de variabele bioscoopmedewerker
			service.updateStatusAHW(bioscoopmedewerker);	//Update de status naar 'aan het werk'
		}
		
		if (req.getParameter("Z") != null) {	//controlleer of Z een waarde heeft
			Bioscoopmedewerker bioscoopmedewerker = (Bioscoopmedewerker)req.getSession().getAttribute("loggedMedewerker");	//Zo ja, vraag dan het Attribuut loggedMedewerker aan en zet deze om in de variabele bioscoopmedewerker
			service.updateStatusZ(bioscoopmedewerker);		//Update de status naar 'ziek'
		}
		
		req.getRequestDispatcher("/bioscoopmedewerker/bioscoopmedewerkerAccount.jsp").forward(req, resp);	//Ga terug naar dezelfde pagina
	}
}
