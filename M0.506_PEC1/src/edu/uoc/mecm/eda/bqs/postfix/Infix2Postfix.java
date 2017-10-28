package edu.uoc.mecm.eda.bqs.postfix;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Clase que implementa un método para transformar una expresión en notación infija a RPN
 * @author Carles Pairot Gavaldà
 *
 */
public class Infix2Postfix {

	/**
	 * Función de utilidad que devuelve la precedencia de un operador sobre otro
	 * @param ch Operador
	 * @return Orden de precedencia (cuanto mayor más precedencia)
	 */
	private int precedence (char ch) {
        	switch (ch) {
        		case '+':
        		case '-':
        					return 1;
      
        		case '*':
        		case '/':
        					return 2;
      
        		case '^':
        					return 3;
        	}
        return -1;
    }

	/**
	 * Función de utilidad que devuelve si un string es numérico o no
	 * @param string String a evaluar
	 * @return True si se trata de un valor numérico
	 */
    private boolean isNumeric (String string) {
        try {
            Long.parseLong (string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    /**
     * Función para transformar una expresión en notación infija a notación RPL
     * @param expr Expresión infija
     * @return Expresión posfija
     * @throws ExpressionMismatchException Si la expresión es inválida
     */
    public String transform (String expr) throws ExpressionMismatchException {
    		// TODO: Implementar este método
    		return "";
    }

    
	/**
	 * Método que testea los métodos
	 * @param args No toma valores de entrada
	 * @throws Exception en el caso de una excepción no controlada
	 */
	public static void main (String[] args) throws Exception {
		Infix2Postfix m = new Infix2Postfix();

		// Declaramos las expresiones que queremos testear y sus resultados esperados
		String[] expressions = { "( 6 * ( 8 / 2 - 1 ) )",
								"( 2 + 3 + ( 4 * 5 ) )",
								"( 5 + ( 2 * 4 ) - 7 )",
								"( ( 8 * 5 ) + ( 7 * ( 4 + 2 ) ) )",
								"( 1 + 2 )",
								"( 1 + ( 2 * 3 ) + 4 )",
								"( ( ( 4 + ( 12 * 28 ) ) ) * ( 7 / 5 ) )",
								};

		String[] expectedResults = {	"6 8 2 / 1 - *",
									"2 3 + 4 5 * +",
									"5 2 4 * + 7 -",
									"8 5 * 7 4 2 + * +",
									"1 2 +",
									"1 2 3 * + 4 +",
									"4 12 28 * + 7 5 / *",
									};

		for (int i = 0; i < expressions.length; i++) {
			String result = m.transform (expressions[i]);
			if (result.equals (expectedResults[i])) {
				System.out.println ("[transform] - [" + result + " == " + expectedResults[i] + "] - Test Unitario " + (i + 1) + " OK.");
			} else {
				System.err.println ("[transform] - [" + result + " == " + expectedResults[i] + "] - Test Unitario " + (i + 1) + " KO.");
			}
		}
	}
}
