package it.polito.tdp.anagrammi.DAO;

public class TestDB {

	public static void main(String[] args) {
		
		AnagrammiDAO anagrammiDao = new AnagrammiDAO();
		
		System.out.println(anagrammiDao.anagrammi("ciao"));

	}

}
