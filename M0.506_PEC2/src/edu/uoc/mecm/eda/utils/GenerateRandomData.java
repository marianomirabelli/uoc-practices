package edu.uoc.mecm.eda.utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import edu.uoc.mecm.eda.library.Book;
import edu.uoc.mecm.eda.library.BookGenre;

/**
 * Clase auxiliar que genera una biblioteca de peliculas
 * @author Carles Pairot Gavalda
 *
 */
public class GenerateRandomData {

	/**
	 * Objeto auxiliar usado para generar numeros aleatorios
	 */
	private static Random rnd = null;
	
	/**
	 * El numero total de elementos aleatorios generados desde la ultima inicializacion del objeto random
	 */
	private static int totalRandomGenerated = 0;
	
	/**
	 * Maximo numero de elementos a generar antes de inicializar de nuevo el objeto aleatorio
	 */
	private static final int MAX_RANDOM_GENERATED = 10000;
	
	/**
	 * Tamaño minimo de palabra
	 */
	private static final int MIN_WORD_SIZE = 2;
	
	/**
	 * Tamaño maximo de palabra
	 */
	private static final int MAX_WORD_SIZE = 14;
	
	/**
	 * Longitud minima en palabras para el titulo de un libro
	 */
	private static final int MIN_BOOK_TITLE_LENGTH = 1;
	
	/**
	 * Longitud maxima en palabras para el titulo de un libro
	 */
	private static final int MAX_BOOK_TITLE_LENGTH = 8;
	
	/**
	 * Longitud minima en palabras para la editorial
	 */
	private static final int MIN_PUBLISHER_NAME_LENGTH = 1;
	
	/**
	 * Longitud maxima en palabras para la editorial
	 */
	private static final int MAX_PUBLISHER_NAME_LENGTH = 5;
	
	/**
	 * Año minimo
	 */
	private static final int MIN_YEAR = 1920;
	
	/**
	 * Año maximo
	 */
	private static final int MAX_YEAR = 2015;
	
	/**
	 * Mínimas páginas
	 */
	private static final int MIN_PAGES = 5;
	
	/**
	 * Máximas páginas
	 */
	private static final int MAX_PAGES = 1024;
	
	/**
	 * Los distintos generos de libros
	 */
	private static BookGenre[] genres = BookGenre.values();
	
	
	/**
	 * Genera un numero aleatorio en el rango especificado
	 * @param min el valor minimo
	 * @param max el valor maximo
	 * @return un entero uniformemente distribuido entre los valores especificados
	 */
	private static int getRandomInt (int min, int max) {
		if (rnd == null) {
			rnd = new Random (System.currentTimeMillis());
		} else if (totalRandomGenerated >= MAX_RANDOM_GENERATED) {
			rnd = new Random (System.currentTimeMillis());
			totalRandomGenerated = 0;
		}
		totalRandomGenerated++;
		return rnd.nextInt (max - min + 1 ) + min;
		
	}
	
	/**
	 * Genera una palabra aleatoria
	 * @return String con la palabra aleatoria
	 */
	private static String getRandomWord(){
		int wordSize = getRandomInt( MIN_WORD_SIZE , MAX_WORD_SIZE );
		return RandomStringUtils.randomAlphabetic( wordSize );
	}
	
	/**
	 * Genera una secuencia aleatoria de palabras
	 * @param min el minimo numero de palabras
	 * @param max el maximo numero de palabras
	 * @return String con la secuencia de palabras
	 */
	private static String generateRandomWordSequence (int min, int max) {
		int numberWord = getRandomInt (min , max);
		StringBuilder sb = new StringBuilder (getRandomWord());
		
		for (int i = 1; i < numberWord; i++) {
			sb.append ( " " + getRandomWord());
		}
		return sb.toString();
	}
	
	/**
	 * Metodo que genera un nombre aleatorio para la editorial
	 * @return String con el nombre aleatorio de la editorial
	 */
	private static String generateRandomPublisher() {
		return generateRandomWordSequence (MIN_PUBLISHER_NAME_LENGTH , MAX_PUBLISHER_NAME_LENGTH);
	}
	
	/**
	 * Metodo que genera un titulo aleatorio para un libro
	 * @return String con el titulo del libro
	 */
	private static String generateRandomBookName(){
		return generateRandomWordSequence (MIN_BOOK_TITLE_LENGTH , MAX_BOOK_TITLE_LENGTH);
	}
	
	/**
	 * Devuelve un género de libro aleatorio
	 * @return género de libro aleatorio
	 */
	public static BookGenre getRandomBookGenre() {
		return genres [getRandomInt (0, genres.length - 1)];
	}

	/**
	 * Genera aleatoriamente la biblioteca de libros de un usuario
	 * @param size el tamaño de la biblioteca del usuario
	 * @return un array con la biblioteca del usuario
	 */
	public static Book[] getRandomLibrary (int size) {
		Book[] library = new Book[size];
		
		for (int i = 0; i < size; i++) {
			// Genera libros aleatoriamente
			library[i] = new Book (generateRandomBookName(), getRandomBookGenre(), generateRandomPublisher(), getRandomInt (MIN_PAGES, MAX_PAGES), getRandomInt (MIN_YEAR, MAX_YEAR));
		}
		
		return library;
	}
}
