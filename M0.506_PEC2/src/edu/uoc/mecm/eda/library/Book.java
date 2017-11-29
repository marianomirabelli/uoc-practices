package edu.uoc.mecm.eda.library;

/**
 * Clase que representa un libro
 * Implementa la interfaz Comparable, la cual sirve para establecer un orden natural entre los distintos libros
 * 
 * @author Carles Pairot Gavaldà
 */
public class Book implements Comparable<Book> {
	
	/**
	 * El titulo del libro
	 */
	private String title = null;
	
	/**
	 * El género del libro
	 */
	protected BookGenre genre = null;
	
	/**
	 * El nombre de la editorial
	 */
	private String publisher = null;
	
	/**
	 * El número de páginas del libro
	 */
	private int pages = -1;
	
	/**
	 * El año de publicación del libro
	 */
	
	private int year = -1;
		
	/**
	 * @return Devuelve el título del libro
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title Establece el título del libro
	 */
	public void setTitle (String title) {
		this.title = title;
	}

	/**
	 * @return Devuelve el género del libro
	 */
	public BookGenre getGenre() {
		return genre;
	}

	/**
	 * @param genre Establece el género del libro
	 */
	public void setGenre (BookGenre genre) {
		this.genre = genre;
	}

	/**
	 * @return Devuelve la editorial del libro
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher Establece la editorial del libro
	 */
	public void setPublisher (String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return Devuelve el número de páginas del libro
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * @param pages Establece el número de páginas del libro
	 */
	public void setPages (int pages) {
		this.pages = pages;
	}

	/**
	 * @return Devuelve el año de publicación del libro
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year Establece el año de publicación del libro
	 */
	public void setYear (int year) {
		this.year = year;
	}

	/**
	 * Sobreescritura del método toString
	 * @return Devuelve una representación en String de este objeto
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append ("{\"title\":\"" + this.title + "\",\"genre\":\"" + this.genre + "\",\"publisher\":\"" + this.publisher + "\",\"pages\":" + this.pages + "\",\"year\":" + this.year + "}" );
		return sb.toString();
	}
	
	/**
	 * Crea un objeto que representa un libro
	 * @param title el titulo del libro
	 * @param genre el genero del libro
	 * @param publisher la editorial del libro
	 * @param pages el número de páginas del libro
	 * @param year el año de publicación
	 */
	public Book (String title, BookGenre genre, String publisher, int pages, int year) {
		this.title = title;
		this.genre = genre;
		this.publisher = publisher;
		this.pages = pages;
		this.year = year;
	}

	/**
	 * Los libros se ordenan lexicográficamente mediante su título.
	 * 
	 * En caso de mismo título se ordenan crecientemente mediante su año de publicación.
	 * En caso de mismo año, se ordenan lexicográficamente por editorial.
	 * En caso de misma editorial, se ordenan lexicográficamente mediante su género.
	 * 
	 * @return Se devuelve número negativo en caso de que este libro vaya ordenada antes que o 
	 * @return Se devuelve número positivo en caso de que este libro vaya ordenada después que o
	 * @return Se devuelve cero cuando ambos libros deberían estar ordenados en la misma posición
	*/
	@Override
	public int compareTo (Book o) {
		int titleComparison = this.title.compareToIgnoreCase(o.title);
		if(titleComparison == 0){
			String thisBookYear = String.valueOf(this.year);
			String oBookYear = String.valueOf(o.year);
			int yearComparison = thisBookYear.compareToIgnoreCase(oBookYear);
			if(yearComparison == 0){
				int publisherComparision = this.publisher.compareToIgnoreCase(o.publisher);
				if(publisherComparision == 0){
					return this.genre.compareTo(o.genre);
				}else{

					return publisherComparision;
				}
			}else {
				return yearComparison;
			}
		}else{
			return titleComparison;
		}
	}

	/**
	 * Método principal de la clase utilizado para comprobar el correcto funcionamiento
	 * @param args Parámetros de entrada (no utilizados)
	 */
	public static void main (String[] args) {
		Book book1 = new Book ("Leonardo da Vinci", BookGenre.BIOGRAPHY, "Simon & Schuster", 624, 2017);
		Book book2 = new Book ("Leonardo da Vinci", BookGenre.BIOGRAPHY, "Walt Schrutte Publishing", 624, 2017);
		Book book3 = new Book ("lEonardo DA vInci", BookGenre.BIOGRAPHY, "Simon & Schuster", 624, 2017);
		Book book4 = new Book ("Lord of the Rings II", BookGenre.ACTION, "Allen & Unwin", 1178, 2017);
		Book book5 = new Book ("Lord of the Rings", BookGenre.ACTION, "Allen & Unwin", 1178, 1954);
		Book book6 = new Book ("lord of the rings", BookGenre.ACTION, "allen & unwin", 1178, 1954);
		
		int res = 0;
		
		/*
		 * Test unitario 1
		 */
		if ((res = book1.compareTo (book1)) != 0) {
			System.err.println ("Test unitario 1 - compareTo de " + book1.toString() + " y " + book1.toString() +  " debe ser 0 y devolvio " + res);
		} else {
			System.out.println ("Test unitario 1 OK");
		}
		
		/*
		 * Test unitario 2
		 */
		if ((res = book1.compareTo (book2)) >= 0) {
			System.err.println ("Test unitario 2 - compareTo de " + book1.toString() + " y " + book2.toString() +  " debe ser negativo y devolvio " + res);
		} else {
			System.out.println ("Test unitario 2 OK");
		}
		
		/*
		 * Test unitario 3
		 */
		if ((res = book2.compareTo (book1)) <= 0) {
			System.err.println ("Test unitario 3 - compareTo de " + book2.toString() + " y " + book1.toString() +  " debe ser positivo y devolvio " + res);
		} else {
			System.out.println ("Test unitario 3 OK" );
		}
		
		/*
		 * Test unitario 4
		 */
		if ((res = book1.compareTo (book3)) == 0) {
			System.out.println ("Test unitario 4 OK");
		} else {
			System.err.println ("Test unitario 4 - compareTo de " + book1.toString() + " y " + book3.toString() +  " debe ser 0 y devolvio " + res);
		}
		
		/*
		 * Test unitario 5
		 */
		if ((res = book5.compareTo (book6)) == 0) {
			System.out.println ("Test unitario 5 OK");
		} else {
			System.err.println ("Test unitario 5 - compareTo de " + book3.toString() + " y " + book1.toString() +  " debe ser 0 y devolvio " + res);
		}
		
		/*
		 * Test unitario 6
		 */
		if ((res = book1.compareTo (book4)) >= 0) {
			System.err.println ("Test unitario 6 - compareTo de " + book1.toString() + " y " + book4.toString() +  " debe ser negativo y devolvio " + res);
		} else {
			System.out.println ("Test unitario 6 OK");
		}
		
		/*
		 * Test unitario 7
		 */
		if ((res = book4.compareTo (book1)) <= 0) {
			System.err.println ("Test unitario 7 - compareTo de " + book4.toString() + " y " + book1.toString() +  " debe ser positivo y devolvio " + res);
		} else {
			System.out.println ("Test unitario 7 OK");
		}
		
		/*
		 * Test unitario 8
		 */
		if ((res = book4.compareTo (book6)) <= 0) {
			System.err.println ("Test unitario 8 - compareTo de " + book1.toString() + " y " + book5.toString() +  " debe ser positivo y devolvio " + res);
		} else {
			System.out.println ("Test unitario 8 OK");
		}
	}
}
