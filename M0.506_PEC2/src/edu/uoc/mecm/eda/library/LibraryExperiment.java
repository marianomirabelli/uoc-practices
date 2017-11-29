package edu.uoc.mecm.eda.library;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import edu.uoc.mecm.eda.library.filters.TitleAndYearFilter;
import edu.uoc.mecm.eda.utils.GenerateRandomData;
import edu.uoc.mecm.eda.utils.MergeSort;
import edu.uoc.mecm.eda.utils.QuickSort;

/**
 * Clase que ejecuta un experimento de rendimiento temporal sobre libros con
 * distintos algoritmos y tipos de orden. Tendras que modificar esta clase para 
 * lograr el resultado que se pide en el enunciado de la actividad
 * 
 * @author Carles Pairot Gavalda
 *
 */
public class LibraryExperiment {

	private static final String pathComparatorExperiment = "result/bookcomparator.tsv";
		
	/**
	 * Ejecuta el benchmark
	 * @throws IOException Si no se puede escribir el fichero con los resultados de salida
	 */
	protected static void runExperimentComparator() throws IOException {
			
		double averageTimeQuickSort = 0;
		double averageTimeMergeSort = 0;
		double averageTimeArraysSort = 0;
		
		BufferedWriter writer = null;

		try {
			// Abrimos el fichero donde se almacenara el resultado del experimento
		    writer = new BufferedWriter (new OutputStreamWriter (new FileOutputStream (pathComparatorExperiment), "utf-8"));

		    // Inicializamos la variable de tiempo inicial
		    long tini = System.currentTimeMillis();
		    
		    int librarySize = 100;
	    	
		    System.out.print ("Generating " + librarySize + " random books...");
    			Book[] originalLibrary = GenerateRandomData.getRandomLibrary (librarySize);
    			System.out.println ("generated!");
		    		
    			// Copiamos el vector generado
    			Book[] aux1 = Arrays.copyOf (originalLibrary, librarySize);

    			// Empezamos a medir el tiempo de ordenacion
    			long t1 = System.currentTimeMillis();
		    		
		    // Ordenamos con mergesort y calculamos tiempo que ha tardado
		    MergeSort.sort (aux1, new TitleAndYearFilter());
		    averageTimeMergeSort += ((double) (System.currentTimeMillis() - t1));
		    		
		    // Hacemos lo mismo con el resto de algoritmos de ordenacion...
		    
  		    // Escribimos el tamaño y los resultados de realizar la ordenacion con MergeSort, QuickSort y Arrays.sort() 
		    writer.write ("SZ: " + librarySize + "\tMS: " + averageTimeMergeSort + "\tQS: " + averageTimeQuickSort + "\tAS: " +  averageTimeArraysSort + "\n" );
			writer.flush();
		    
		    // Finalizamos el experimento
		    long tfin = System.currentTimeMillis() - tini;
			System.out.println ("Total time: " + tfin + " ms");
		    
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}		
	}
	
	/**
	 * Método principal de la clase utilizado para comprobar el correcto funcionamiento
	 * @param args Parámetros de entrada (no utilizados)
	 */
	public static void main (String[] args) {
		
		System.out.println ("Book title and year sort benckmark has started...");
		try {
			runExperimentComparator();
		} catch (IOException e) {
			System.err.println ("The benchmark has failed.");
			e.printStackTrace();
		}
		System.out.println ("Benchmark finished successfully.");
	}
}
