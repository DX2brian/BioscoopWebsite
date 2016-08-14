package controller;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TextServlet extends HttpServlet{
	private static final long serialVersionUID = -6836537793332383648L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    
		 //Dit is dan mijn coole random text generator

		String button = req.getParameter("Random Text Generator"); 	//Hij krijgt eerst een waarde van de knop mee

		int randomInt = Integer.parseInt(button);	//deze waarde word omgezet in een int (nummer)
		
		   
		    Random randomGenerator = new Random();	//start de random generator!
		      randomInt = randomGenerator.nextInt(62);	//Hij zet de waarde van de knop om in een nieuwe waarde van 1 tussen de 49 
		      //Daarna gaat hij door de gigantische if/else if/else loop om te kijken welk nummer dat is
		      if (randomInt == 1){
		    	  req.setAttribute("hoofdbericht", "Wist je dat dit mijn eerste website ooit is?");
		      } else if (randomInt == 2) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat ik eigenlijk meer van series hou dan van films, maar toch een filmwebsite heb gebouwd?");
		      } else if (randomInt == 3) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat de aarde rond is?");
		      } else if (randomInt == 4) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat deze tekst word gegenereerd door een random generator?");
		      } else if (randomInt == 5) {
		    	  req.setAttribute("hoofdbericht", "Ik heb een gevoel dat België het EK gaat winnen.");
		      } else if (randomInt == 6) {
		    	  req.setAttribute("hoofdbericht", "Ik heb zelf ook geen idee waarom deze tekst hier staat.");
		      } else if (randomInt == 7) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat deze website me ongeveer 2 volle weken heeft gekost om te leren en te maken?");
		      } else if (randomInt == 8) {
		    	  req.setAttribute("hoofdbericht", "Han Solo gaat dood.");
		      } else if (randomInt == 9) {
		    	  req.setAttribute("hoofdbericht", "Welkom op de officele Brioscoop website!");
		      } else if (randomInt == 10) {
		    	  req.setAttribute("hoofdbericht", "Er zijn volgens mij genoeg films die letterlijk nergens over gaan.");
		      } else if (randomInt == 11) {
		    	  req.setAttribute("hoofdbericht", "Hoeveel feiten zullen hier wel niet kunnen verschijnen?");
		      } else if (randomInt == 12) {
		    	  req.setAttribute("hoofdbericht", "Waarom heb ik mijn kostbare tijd verspilt aan het maken van een random servlet?");
		      } else if (randomInt == 13) {
		    	  req.setAttribute("hoofdbericht", "Bananen zijn krom.");
		      } else if (randomInt == 14) {
		    	  req.setAttribute("hoofdbericht", "Nederland zijn klimaat heeft af en toe wel wat.");
		      } else if (randomInt == 15) {
		    	  req.setAttribute("hoofdbericht", "Ik weet niet eens of dit werkt.");
		      } else if (randomInt == 16) {
		    	  req.setAttribute("hoofdbericht", "En het klopt dat je niet in aantallen kan bestellen want ik wist niet zo snel te verzinnen hoe dat moest.");
		      } else if (randomInt == 17) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat het uiteindelijk doel van deze website was om het popcorn verbruik te verminderen.");
		      } else if (randomInt == 18) {
		    	  req.setAttribute("hoofdbericht", "Ik heb honger.");
		      } else if (randomInt == 19) {
		    	  req.setAttribute("hoofdbericht", "Mijn ideeën voor feiten raken langzamerhand op.");
		      } else if (randomInt == 20) {
		    	  req.setAttribute("hoofdbericht", "Wie kan er een goeie grap waarderen?");
		      } else if (randomInt == 21) {
		    	  req.setAttribute("hoofdbericht", "Regen heeft zo ook zijn voordelen.");
		      } else if (randomInt == 22) {
		    	  req.setAttribute("hoofdbericht", "Volgens mij gaan de meeste van deze feitjes niet eens over films.");
		      } else if (randomInt == 23) {
		    	  req.setAttribute("hoofdbericht", "Ik had misschien geen random getallen moeten gebruiken voor de bestellingen/klanten.");
		      } else if (randomInt == 24) {
		    	  req.setAttribute("hoofdbericht", "Moraal van vandaag: programmeer niet te lang aan één stuk door want anders gebeuren er rare dingen (zoals de creatie van een Random Text Generator en genoeg spellingsfouten)");
		      } else if (randomInt == 25) {
		    	  req.setAttribute("hoofdbericht", "Feit nummer 25.");
		      } else if (randomInt == 26) {
		    	  req.setAttribute("hoofdbericht", "Deze website is bijna volledig buitenshuis gemaakt in het zonnetje.");
		      } else if (randomInt == 27) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat als je het goed doet, alle gegevens van deze website kan verwijderen zonder naar de database te gaan.");
		      } else if (randomInt == 28) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat je ook kan inloggen als een medewerker?");
		      } else if (randomInt == 29) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat deze website gehost word door Openshift?");
		      } else if (randomInt == 30) {
		    	  req.setAttribute("hoofdbericht", "Feit nummer 30");
		      } else if (randomInt == 31) {
		    	  req.setAttribute("hoofdbericht", "Gras is voor het grootste geval groen, behalve als het droog is want dan is het hooi.");
		      } else if (randomInt == 32) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat ik nog nooit een ict-project helemaal zelf heb uitgevoerd (ben lui ofzo)?");
		      } else if (randomInt == 33) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat je winkelwagen om de 10 seconden refresht?");
		      } else if (randomInt == 34) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat de geheime alle.jsp pagina om de 10 seconden refresht?");
		      } else if (randomInt == 35) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat de geheime alle.jsp pagina alle database gegevens bevat?");
		      } else if (randomInt == 36) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat deze optie er alleen maar in kwam, omdat ik dit al een keer eerder wilde doen maar ik het toen nog niet kon uitvoeren?");
		      } else if (randomInt == 37) {
		    	  req.setAttribute("hoofdbericht", "404 feit not found.");
		      } else if (randomInt == 38) {
		    	  req.setAttribute("hoofdbericht", "Wist je dat er maar een bepaald aantal feiten beschikbaar zijn?");
		      } else if (randomInt == 39) {
		    	  req.setAttribute("hoofdbericht", "Alleen de Sidebar is niet origineel gecreeërd");
		      } else if (randomInt == 40) {
		    	  req.setAttribute("hoofdbericht", "Er worden bijna alleen maar prepared statements gebruikt voor de database.");
		      } else if (randomInt == 41) {
		    	  req.setAttribute("hoofdbericht", "Ben je bedreven, aardig en goed met computers? Wij zijn op zoek naar medewerkers!");
		      } else if (randomInt == 42) {
		    	  req.setAttribute("hoofdbericht", "Deze website is volledig gemaakt in Java.");
		      } else if (randomInt == 43) {
		    	  req.setAttribute("hoofdbericht", "Ook was deze website gemaakt om me IPASS te fixen.");
		      } else if (randomInt == 44) {
		    	  req.setAttribute("hoofdbericht", "Feit nummer 44.");
		      } else if (randomInt == 45) {
		    	  req.setAttribute("hoofdbericht", "Mensen zeggen soms dat ik lui ben. Ik kan het begrijpen.");
		      } else if (randomInt == 46) {
		    	  req.setAttribute("hoofdbericht", "Om deze feit te krijgen heb je 1.6% kans (ofzo).");
		      } else if (randomInt == 47) {
		    	  req.setAttribute("hoofdbericht", "Waarom klik je door als er toch niks nuttigs uit komt?");
		      } else if (randomInt == 48) {
		    	  req.setAttribute("hoofdbericht", "Er is blijkbaar ook een test user gecreeërd.");
		      } else if (randomInt == 49) {
		    	  req.setAttribute("hoofdbericht", "Voor het grootste geval bestaat 'database' uit de letters 'a'.");
		      } else if (randomInt == 50) {
		    	  req.setAttribute("hoofdbericht", "Marvel heeft meer dan 9000 characters.");
		      } else if (randomInt == 51) {
		    	  req.setAttribute("hoofdbericht", "De eerste film komt uit 1890.");
		      } else if (randomInt == 52) {
		    	  req.setAttribute("hoofdbericht", "Er zit voor meer dan 100 uur aan in website.");
		      } else if (randomInt == 53) {
		    	  req.setAttribute("hoofdbericht", "Nederland heeft 137 reguliere bioscopen (2008).");
		      } else if (randomInt == 54) {
		    	  req.setAttribute("hoofdbericht", "Nederland heeft 1 Virtual Reality bioscoop .");
		      } else if (randomInt == 55) {
		    	  req.setAttribute("hoofdbericht", "De slechtste movie ooit gemaakt is disaster movie volgens de internet movie database (2013).");
		      } else if (randomInt == 56) {
		    	  req.setAttribute("hoofdbericht", "Pirates of the Caribbean: On Stranger Tides is de duurste movie ooit gemaakt en koste $378.500.000.");
		      } else if (randomInt == 57) {
		    	  req.setAttribute("hoofdbericht", "Avatar is de meest succesvolste film en de opbrengst was $ 2.787.965.087.");
		      } else if (randomInt == 58) {
		    	  req.setAttribute("hoofdbericht", "Marvel Cinematic Universe is de succesvolste filmreeks en heeft een wereldwijde opbrengst van $ 10.216.890.699.");
		      } else if (randomInt == 59) {
		    	  req.setAttribute("hoofdbericht", "Turks fruit is de meest succesvolste nederlandse film en had 3.338.000 bezoekers.");
		      } else if (randomInt == 60) {
		    	  req.setAttribute("hoofdbericht", "Cutthroat Island is de grootse flop in de film wereld de het bedrijf maakte  $104.982.678 verlies en daardoor ging het bedrijf failliet.");
		      } else if (randomInt == 61) {
		    	  req.setAttribute("hoofdbericht", "Voor als je het nog niet door had... Alle films, cast en genres zijn gebaseerd op mijn twee voorletters");
		      } else {
		    	  req.setAttribute("hoofdbericht", "Feit nummer 62 en officieel de laatste (totdat je weer op de knop drukt).");
		      }
		      
		      req.getRequestDispatcher("/index.jsp").forward(req, resp); //Stuurt je terug naar de homepagina waar ook de tekst zal verschijnen
		}
	
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/index.jsp").forward(req, resp); //Stuurt je terug naar de homepagina waar ook de tekst zal verschijnen
		}
}
