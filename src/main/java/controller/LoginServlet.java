package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Bioscoopmedewerker;
import domain.Klant;
import model.CompanyService;
import model.ServiceProvider;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1467841676;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Declare all the form tags
        String ingevuldEmail_adres = req.getParameter("email_adres");
        String ingevuldWachtwoord = req.getParameter("wachtwoord");

        //Declare some booleans
        boolean loginSuccess = false;

        //Service erbij halen
        CompanyService service = ServiceProvider.getCompanyService();

        //Ga hier eerst kijken of hij een klant kan vinden met ingevulde email adres
        try {
        if (service.findKlantByEmail(ingevuldEmail_adres) != null) {
		        Klant k = service.findKlantByEmail(ingevuldEmail_adres);	//vind de klant via zijn email en stop hem in k
		    	String email_adres = k.getEmail_adres();	//Email-adres van de klant word nu email_adres
		    	String wachtwoord = k.getWachtwoord();		//Wachtwoord van de klant word nu wachtwoord
			    	if (ingevuldEmail_adres.equals(email_adres) && ingevuldWachtwoord.equals(wachtwoord)){ 	//Ga kijken of het ingevulde email/wachtwoord gelijk is aan dat van de klant
			            
			    		//loguit als er nog iemand anders eerst op de sessie zit
			    		HttpSession session = req.getSession(false);	//vraag sessie op en geef het een waarde
			    		if(session != null){							//Als hij dus een waarde heeft gooit hij eerst de gebruiker eruit voordat je inlogt
			    			session.invalidate();						//Hier gooit hij je eruit
			    		}
			    		
			    		req.getSession().setAttribute("loggedKlant", k);	//maak van loggedKlant een klant attribuut die alle waardes heeft van de klant waarmee je hebt ingelogt
			            loginSuccess = true;								//Hier is je ticket om door te gaan naar de volgende pagina
			    	} else {
			    		req.setAttribute("bericht1", "Emailadres en/of wachtwoord ongeldig");	//Als je ingevulde email/wachtwoord niet gelijk zijn aan die van klant geef dan deze melding
			    	}
			    }
        	} catch (IndexOutOfBoundsException exc) {	//Als er geen Klant bestaat met dat emailadres geeft hij een fout. Deze fout word hier opgevangen en geeft dan ook aan dat er iets fout is
			        req.setAttribute("bericht1", "Emailadres en/of wachtwoord ongeldig");	//Als je ingevulde email/wachtwoord niet gelijk zijn aan die van klant geef dan deze melding
			}


      //Ga hier kijken of hij een medewerker kan vinden met ingevulde email adres
		try{    	
        if (service.findBioscoopmedewerkerByEmail(ingevuldEmail_adres) != null){
		        Bioscoopmedewerker b = service.findBioscoopmedewerkerByEmail(ingevuldEmail_adres);	//vind de medewerker via zijn email en stop hem in b
		    	String email_adres = b.getEmail_adres();	//Email-adres van de klant word nu email_adres
		    	String wachtwoord = b.getWachtwoord();		//Wachtwoord van de klant word nu wachtwoord
			    	if (ingevuldEmail_adres.equals(email_adres) && ingevuldWachtwoord.equals(wachtwoord)){	//Ga kijken of het ingevulde email/wachtwoord gelijk is aan dat van de medewerker
			    		
			    		//loguit als er nog iemand anders eerst op de sessie zit
			    		HttpSession session = req.getSession(false);	//vraag sessie op en geef het een waarde
			    		if(session != null){							//Als hij dus een waarde heeft gooit hij eerst de gebruiker eruit voordat je inlogt
			    			session.invalidate();						//Hier gooit hij je eruit
			    		}
			  
			            req.getSession().setAttribute("loggedMedewerker", b);	//maak van loggedMedewerker een medewerker attribuut die alle waardes heeft van de medewerker waarmee je hebt ingelogt
			            loginSuccess = true;									//Hier is je ticket om door te gaan naar de volgende pagina
			    	} else {
			    		req.setAttribute("bericht1", "Emailadres en/of wachtwoord ongeldig");	//Als je ingevulde email/wachtwoord niet gelijk zijn aan die van medewerker geef dan deze melding
			    	}
        		}
        	} catch (IndexOutOfBoundsException exc) {									//Als er geen Medewerker bestaat met dat emailadres geeft hij een fout. Deze fout word hier opgevangen en geeft dan ook aan dat er iets fout is
        		req.setAttribute("bericht1", "Emailadres en/of wachtwoord ongeldig");	//Als je ingevulde email/wachtwoord niet gelijk zijn aan die van medewerker geef dan deze melding
        	}

        //Request dispatcher
        if (loginSuccess == true) {													//Hier is dan die loginsucces die je alleen doorlaat als je ingelogt bent
        	if (req.getSession().getAttribute("loggedMedewerker") == null) {		//als je niet bent ingelogd als medewerker krijg je deze if-loop
	            
        		//RELEASE THE COOKIES
	            Cookie cookie = new Cookie("koek", ingevuldEmail_adres);			//Maak een koekie aan van email_adres
	            cookie.setMaxAge(60*30);											//zet de tijd van een koekie op een half uur
	            resp.addCookie(cookie);												//voeg hem toe aan cookie
	
	            req.getRequestDispatcher("/account/klantAccount.jsp").forward(req, resp);	//stuur je door naar de klantaccount
	            
        	} else {
        		req.getRequestDispatcher("/bioscoopmedewerker/bioscoopmedewerkerAccount.jsp").forward(req, resp);	 //hier word je heen gestuurd als je wel bent inglogt als medewerker
        	}
	            
	     } else {
	    	 req.getRequestDispatcher("/inlog/login.jsp").forward(req, resp);		//Hier word je heen gestuurd als je niet ingelogt bent
	        }
        
    }
}
