package edu.uoc.mecm.eda.bqs.postfix;

import java.util.Scanner;
import java.util.Stack;

/**
 * Clase que implementa métodos para evaluar expresiones en RPN
 * @author Carles Pairot Gavaldà
 *
 */
public class PostfixEvaluator {

	/**
	 * Método que evalúa una expresión en notación RPN
	 * @param expr El string a evaluar
	 * @return El resultado numérico
	 */
	public int evaluatePostfixExpression (String expr) throws ExpressionMismatchException {
		// TODO: Implementar este método
		return 0;
	}

	
	/**
	 * Método que testea el método evaluatePostfixExpression()
	 * @param args No toma valores de entrada
	 * @throws Exception en el caso de una excepción no controlada
	 */
	public static void main (String[] args) throws Exception {
		PostfixEvaluator m = new PostfixEvaluator();
		
		// Declaramos las expresiones que queremos testear y sus resultados esperados
		String[] expressions = {	"6 8 2 / 1 - *",
								"2 3 + 4 5 * +",
								"5 2 4 * + 7 -",
								"8 5 * 7 4 2 + * +",
								"1 2 +",
								"1 2 3 * + 4 +",
								"4 12 28 * + 7 5 / *"
								};
		int[] expectedResults = { 18, 25, 6, 82, 3, 11, 340 };

		for (int i = 0; i < expressions.length; i++) {
			int result = m.evaluatePostfixExpression (expressions[i]);
			if (result == expectedResults[i]) {
				System.out.println ("[evaluatePostfixExpression] - [" + result + " == " + expectedResults[i] + "] - Test Unitario " + (i + 1) + " OK.");
			} else {
				System.err.println ("[evaluatePostfixExpression] - [" + result + " == " + expectedResults[i] + "] - Test Unitario " + (i + 1) + " KO.");
			}
		}
	}
}
