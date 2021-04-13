package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnagrammiDAO {

	public boolean isCorrect(String anagramma) {
		final String sql = "SELECT * FROM parola";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				String parola = rs.getString("nome");
				if(parola.equals(anagramma)) {
					conn.close();
					return true;
				}
				
			}
			
			conn.close();
	      	return false;
		
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}

	}

	public List<List<String>> anagrammi(String parola) {

		List<String> risultato = new ArrayList<String>();
		List<String> errate = new ArrayList<String>();
		
		permuta("", parola, 0, risultato, errate); // LANCIA la ricorsione

		List<List<String>> anagrammi = new ArrayList<List<String>>();
		anagrammi.add(risultato);
		anagrammi.add(errate);
		
		return anagrammi;

	}



	private void permuta(String parziale, String lettere, int livello, List<String> risultato, List<String> errate) {
       
		boolean flagCorrette = false;
        boolean flagErrate = false;
        
		if (lettere.length() == 0) { // caso terminale
			if(isCorrect(parziale) == true) {
				
				for(int i = 0 ; i<risultato.size() ; i ++) {
					if(risultato.get(i).equals(parziale)) 
						flagCorrette = true;	
				}
				if(flagCorrette == false)
			       risultato.add(parziale);
			}
			
			else {
				for(int i = 0 ; i<errate.size() ; i ++) {
					if(errate.get(i).equals(parziale)) 
						flagErrate = true;	
				}
				if(flagErrate == false)
				errate.add(parziale);
			}
			
		} else {
			// fai ricorsione
			
			for (int pos = 0; pos < lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos);

				String nuovaParziale = parziale + tentativo;
				String nuovaLettere = lettere.substring(0, pos) + lettere.substring(pos + 1); 
																							

				
				permuta(nuovaParziale, nuovaLettere, livello + 1, risultato, errate);

				
			}
		}

	}

}
