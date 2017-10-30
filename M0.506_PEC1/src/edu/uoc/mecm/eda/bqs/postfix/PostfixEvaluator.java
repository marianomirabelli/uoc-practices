package edu.uoc.mecm.eda.bqs.postfix;

import java.util.Scanner;
import java.util.Stack;

/**
 * Clase que implementa métodos para evaluar expresiones en RPN
 * @author Carles Pairot Gavaldà
 *
 */
public class PostfixEvaluator {

	private Stack<Integer> numbers;

	public PostfixEvaluator(){
		this.numbers = new Stack<Integer>();
	}

	/**
	 * Método que evalúa una expresión en notación RPN
	 * @param expr El string a evaluar
	 * @return El resultado numérico
	 */
	public int evaluatePostfixExpression (String expr) throws ExpressionMismatchException {
		Integer valueA;
		Integer valueB;
	    if(expr==null){
			throw  new ExpressionMismatchException("The expression can't be null");
		}
		Scanner scanner = new Scanner(expr);
		while (scanner.hasNext()){
			String currentValue = scanner.next();
			if(isNumeric(currentValue)){
				this.numbers.push(Integer.parseInt(currentValue));
			}else if (isAllowedOperator(currentValue)){
			    if(this.numbers.size()<2){
			        throw new ExpressionMismatchException("The expression hasn't enough operators to make the operation");
                }
			    switch (currentValue){
                    case "+":
                        valueA = this.numbers.pop();
                        valueB = this.numbers.pop();
                        this.numbers.push(valueB + valueA);
                        break;
                    case "-":
                        valueA = this.numbers.pop();
                        valueB = this.numbers.pop();
                        this.numbers.push(valueB - valueA);
                        break;
                    case "/":
                        valueA = this.numbers.pop();
                        valueB = this.numbers.pop();
                        this.numbers.push(valueB / valueA);
                        break;
                    case "*":
                        valueA = this.numbers.pop();
                        valueB = this.numbers.pop();
                        this.numbers.push(valueB * valueA);
                        break;
                }

			}else{
				throw  new ExpressionMismatchException("The expression contains invalid characters");
			}
		}
		if(this.numbers.size()> 1){
		    throw new ExpressionMismatchException("The expression is bad formed, just one result can be reached with this notation");
        }
        return this.numbers.pop();
	}

	private boolean isNumeric(String s) {
		return s != null && s.matches("\\d*?\\d+");
	}

	private boolean isAllowedOperator(String s) {
		return s != null && s.matches("[-+/*]+");
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
		int[] expectedResults = { 18, 25, 6, 82, 3, 11, 340};

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
