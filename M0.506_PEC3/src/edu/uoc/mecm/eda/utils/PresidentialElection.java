package edu.uoc.mecm.eda.utils;

import java.io.File;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase que calcula los resultados de unas elecciones presidenciales
 * @author Carles Pairot Gavalda
 *
 */
public class PresidentialElection {
	
	/**
	 * Método que cuenta los votos hallados en un array de strings
	 * @param votes String con una ocurrencia de cada voto para cada candidato
	 * @return Devuelve un string indicando el ganador y los votos obtenidos
	 */
	private String countVotes (String[] votes) {
		// TODO: Implementar este método

		String winner = "";
		int maxValue = 0;
		Map<String,Integer> candidates = new TreeMap<String,Integer>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		for(String vote :votes){
			Integer cant = candidates.get(vote);
			if(Objects.isNull(cant)){
				candidates.put(vote,1);
			}else{
				candidates.put(vote,cant+1);
			}
		}
		for(String key : candidates.keySet()){
			int recountedVotes = candidates.get(key);
			String candidateName = key;
			if(recountedVotes>maxValue){
				maxValue = recountedVotes;
				winner = candidateName;
			}
		}
        return "El candidato ganador es: " + winner + " con " + maxValue + " votos.";
	}
	
	/**
	 * Método principal
	 * @param args
	 * @throws Exception
	 */
	public static void main (String[] args) throws Exception {
		// Leer los nombres de los candidatos de un fichero y cargarlos en memoria
		Scanner scanner = new Scanner (new File ("./resources/names.txt"));
		scanner.useDelimiter(",");
		
		LinkedList<String> candidates = new LinkedList<String>();
		
		while (scanner.hasNext()) {
			candidates.add (scanner.next().trim());
		}
		
		scanner.close();
		
		// Creamos la lista que contendrá los votos
		LinkedList<String> votes = new LinkedList<String>();
		
		int maxVotes = 0;
		String theoreticWinner = "";
		
		// Generamos aleatoriamente los votos
		for (int i = 0; i < candidates.size(); i++) {
			int votesNum = ThreadLocalRandom.current().nextInt (0, 10000 + 1);
			System.out.print ("Generando votos para " + candidates.get(i) + "...");
			for (int j = 0; j < votesNum; j++) {
				votes.add (candidates.get(i));
			}
			System.out.println ("generados! (" + votesNum + ")");
			
			if (votesNum > maxVotes) {
				maxVotes = votesNum;
				if (candidates.get(i).compareTo (theoreticWinner) > 0) {
					theoreticWinner = candidates.get(i);
				}
			}
		}
		
		// Mezclamos la lista ya que sinó aparecería todo demasiado ordenado
		Collections.shuffle (votes);
		
		System.out.println ("Iniciando el recuento de votos...");

		PresidentialElection pres = new PresidentialElection();	
		String[] votesArr = votes.toArray (new String[votes.size()]);
		String winnerString = pres.countVotes(votesArr);

		if (winnerString.contains (theoreticWinner) && winnerString.contains (String.valueOf (maxVotes))) {
			System.out.println ("Test Unitario OK: " + winnerString);
		} else {
			System.err.println ("Test Unitario KO: " + winnerString + " ////// Aunque en realidad se trata de: " + theoreticWinner + " con " + maxVotes + " votos!!!!");
		}
	}
}
