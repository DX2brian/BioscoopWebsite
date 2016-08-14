package model;

public class ServiceProvider {
	private static CompanyService companyService = new CompanyService();	//zet comanyservice in een variabele
	
	public static CompanyService getCompanyService() {						//Hiermee kan je hem dus elke keer weer aanroepen
		return companyService;												
	}
	
}