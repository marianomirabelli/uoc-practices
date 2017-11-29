package edu.uoc.mecm.eda.library.filters;

import java.util.Comparator;

import edu.uoc.mecm.eda.library.Book;
import edu.uoc.mecm.eda.library.BookGenre;

/**
 * Clase comparadora que ordena los libros de acuerdo con su título y año de realización 
 * @author Carles Pairot Gavalda
 *
 */
public class TitleAndYearFilter implements Comparator<Book> {

	/**
	 * Compara dos libros para determinar su orden.
	 * El primer criterio para ordenar será emplear el orden lexicografico con el título del libro
	 * En caso de empate, se empleará el año de publicación
	 */
	@Override
	public int compare (Book o1, Book o2) {
		// TODO: Tu codigo a partir de aquí

		return 0;
	}
	
	/**
	 * Método principal de la clase utilizado para comprobar el correcto funcionamiento
	 * @param args Parámetros de entrada (no utilizados)
	 */
	public static void main (String[] args) {

		Book book1 = new Book ("The Da Vinci Code", BookGenre.ACTION, "Doubleday", 454, 2003);
		Book book2 = new Book ("Cold Skin", BookGenre.DRAMA, "Allen & Unwin", 240, 2006);
		Book book3 = new Book ("Lord of the Rings", BookGenre.ACTION, "Allen & Unwin", 1178, 2016);
		Book book4 = new Book ("Lord of the rings", BookGenre.ACTION, "Allen & Unwin", 1178, 2015);
		TitleAndYearFilter a = new TitleAndYearFilter();
		
		int res = 0;
		
		/* Test unitario 1 */
		if ((res = a.compare (book1, book1)) != 0) {
			System.err.println ("Test unitario 1 - La comparacion entre " + book1 + " y " + book1 + " debe ser cero y devolvio " + res);
		} else {
			System.out.println ("Test unitario 1 OK");
		}
		
		/* Test unitario 2 */
		if ((res = a.compare (book1, book2)) <= 0) {
			System.err.println ("Test unitario 2 - La comparacion entre " + book1 + " y " + book2 + " debe ser positiva y devolvio " + res);
		} else {
			System.out.println( "Test unitario 2 OK" );
		}
		
		/* Test unitario 3 */
		if ((res = a.compare (book2, book1)) >= 0) {
			System.err.println ("Test unitario 3 - La comparacion entre " + book2 + " y " + book1 + " debe ser negativa y devolvio " + res);
		} else {
			System.out.println ("Test unitario 3 OK");
		}
		
		/* Test unitario 4 */
		if( (res = a.compare (book1, book3)) <= 0) {
			System.err.println ("Test unitario 4 - La comparacion entre " + book1 + " y " + book3 + " debe ser positiva y devolvio " + res);
		} else {
			System.out.println ("Test unitario 4 OK");
		}
		
		/* Test unitario 5 */
		if( (res = a.compare (book3, book1)) >= 0) {
			System.err.println ("Test unitario 5 - La comparacion entre " + book3 + " y " + book1 + " debe ser negativa y devolvio " + res);
		} else {
			System.out.println ("Test unitario 5 OK");
		}
		
		/* Test unitario 6 */
		if( (res = a.compare (book3, book4)) <= 0) {
			System.err.println ("La comparacion entre " + book3 + " y " + book4 + " debe ser positiva y devolvio " + res);
		} else {
			System.out.println ("Test unitario 6 OK");
		}

		/* Test unitario 7 */
		if( (res = a.compare (book4, book3)) >= 0) {
			System.err.println ("La comparacion entre " + book4 + " y " + book3 + " debe ser positiva y devolvio " + res);
		} else {
			System.out.println ("Test unitario 7 OK");
		}
	}
}
