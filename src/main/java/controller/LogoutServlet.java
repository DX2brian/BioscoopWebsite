package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = -2486842898701305081L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 	//doet hetzelfde als hieronder maar dan met buttons
		
		HttpSession session = req.getSession(false);	//vraag sessie op en geef het een waarde
		if(session != null){							//Als hij dus een waarde heeft gooit hij eerst de gebruiker eruit voordat je inlogt
			session.invalidate();						//Hier gooit hij je eruit
		}
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);	//stuurt je door naar de index als je bent uitgelogd
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//doet hetzelfde als hierboven maar dan met links

		HttpSession session = req.getSession(false);	//vraag sessie op en geef het een waarde
		if(session != null){							//Als hij dus een waarde heeft gooit hij eerst de gebruiker eruit voordat je inlogt
			session.invalidate();						//Hier gooit hij je eruit
		}
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);	//stuurt je door naar de index als je bent uitgelogd
	}
}