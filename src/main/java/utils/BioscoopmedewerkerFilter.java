package utils;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class BioscoopmedewerkerFilter implements Filter {
	public void init(FilterConfig arg0) throws ServletException {
		/* Filter is being placed into service, do nothing. */
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest) req;	//zet een (naar HttpServletRequest omgezette) request naar een HttpServletRequest variabele
		if (hsr.getSession().getAttribute("loggedMedewerker") == null) {	//Hiermee kan je controleren of loggedMedewerker gelijk is aan null 
			req.setAttribute("bericht1", "Om deze pagina te kunnen bereiken zal je eerst moeten als medewerker"); //Zo ja, geef dan een bericht dat je niet ingelogt bent
			hsr.getRequestDispatcher("/inlog/login.jsp").forward(req, resp);	//En stuur je daarna door naar de inlog pagina
		} else {											//Als loggedMedewerker wel een waarde heeft...
			chain.doFilter(req, resp);						//Stuurt hij hem gewoon door
		}
	}

	public void destroy() {
		/* Filter is being taken out of service, do nothing. */
	}
}