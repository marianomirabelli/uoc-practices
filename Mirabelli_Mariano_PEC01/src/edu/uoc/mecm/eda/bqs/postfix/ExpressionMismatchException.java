package edu.uoc.mecm.eda.bqs.postfix;

/**
 * Clase que modela una excepción general de evaluación de expresión matemática
 * @author Carles Pairot Gavaldà
 *
 */
public class ExpressionMismatchException extends Exception {

	private static final long serialVersionUID = -2912102877561613126L;
	
	public ExpressionMismatchException (String msg) {
		super (msg);
	}

}
