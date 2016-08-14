package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StemmingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//Doet hetzelfde als de methode hieronder maar dan met buttons
		
		if (req.getParameter("standaard") != null) {	//controlleer of standaard een waarde heeft
			req.getRequestDispatcher("/account/klantAccount.jsp").forward(req, resp);	//stuur je terug naar je account pagina
		}
		
		if (req.getParameter("vreugde") != null) {	//controlleer of vreugde een waarde heeft
			req.getRequestDispatcher("/account/extraAccount/klantAccount2.jsp").forward(req, resp);	//stuur je terug naar je account pagina
		}
		
		if (req.getParameter("verdriet") != null) {	//controlleer of verdriet een waarde heeft
			req.getRequestDispatcher("/account/extraAccount/klantAccount3.jsp").forward(req, resp);	//stuur je terug naar je account pagina
		}
		
		if (req.getParameter("angst") != null) {	//controlleer of angst een waarde heeft
			req.getRequestDispatcher("/account/extraAccount/klantAccount4.jsp").forward(req, resp);	//stuur je terug naar je account pagina
		}
		
		if (req.getParameter("woede") != null) {	//controlleer of woede een waarde heeft
			req.getRequestDispatcher("/account/extraAccount/klantAccount5.jsp").forward(req, resp);	//stuur je terug naar je account pagina
		}
		
		if (req.getParameter("verbazing") != null) {	//controlleer of verbazing een waarde heeft
			req.getRequestDispatcher("/account/extraAccount/klantAccount6.jsp").forward(req, resp);	//stuur je terug naar de je account pagina
		}
		
		if (req.getParameter("afschuw") != null) {	//controlleer of afschuw een waarde heeft
			req.getRequestDispatcher("/account/extraAccount/klantAccount7.jsp").forward(req, resp);	//stuur je terug naar je account pagina
		}
	}
}
