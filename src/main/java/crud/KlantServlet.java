package crud;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import model.CompanyService;
import model.ServiceProvider;

public class KlantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CompanyService service = ServiceProvider.getCompanyService();	//haal de service weer eens op
		
		if (req.getParameter("verwijderKlant") != null){	//Controlleer of verwijderKlant een waarde heeft
			Integer klantnummerdeleteV2 = Integer.parseInt(req.getParameter("verwijderKlant"));	//Zo ja, zet de waarde verwijderKlant om in een int (nummer)
			service.deleteKlant(klantnummerdeleteV2);		//vind dit nummer en verwijder de klant die erbij hoort
			req.setAttribute("hoofdbericht", "Je account is bij deze verwijdert");	//zet een bericht op het hoofdmenu
			
			//Verwijder de sessie
			HttpSession session = req.getSession(false);	//vraag sessie op en geef het een waarde
			if(session != null){							//Als hij dus een waarde heeft gooit hij eerst de gebruiker eruit voordat je inlogt
				session.invalidate();						//Hier gooit hij je eruit
			}
			req.getRequestDispatcher("index.jsp").forward(req, resp);	//Stuurt je door naar index.jsp
			
		}
		
		
	}
}
