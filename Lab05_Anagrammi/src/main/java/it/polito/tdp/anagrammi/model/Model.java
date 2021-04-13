package it.polito.tdp.anagrammi.model;
import java.util.List;
import it.polito.tdp.anagrammi.DAO.AnagrammiDAO;


public class Model {
	
	private AnagrammiDAO anagrammiDao ;
	
	public Model() {
		anagrammiDao= new AnagrammiDAO();
	}
	
	public List<String> anagrammiCorretti(String parola){
		return anagrammiDao.anagrammi(parola).get(0);
	} 
	
	public List<String> anagrammiErrati(String parola){
		return anagrammiDao.anagrammi(parola).get(1);
	} 

}
