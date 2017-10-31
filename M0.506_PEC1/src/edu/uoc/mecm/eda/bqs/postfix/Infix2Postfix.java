package edu.uoc.mecm.eda.bqs.postfix;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Clase que implementa un método para transformar una expresión en notación infija a RPN
 * @author Carles Pairot Gavaldà
 *
 */
public class Infix2Postfix {

	private Stack<String>  stack;
	private Queue<String> queue;

	public Infix2Postfix(){

		this.queue = new LinkedList<String>();
		this.stack = new Stack<String>();
	}
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

	private boolean isOperator (String expr) {
		return  (expr.equalsIgnoreCase("+") || expr.equalsIgnoreCase("-")
				 || expr.equalsIgnoreCase("*") || expr.equalsIgnoreCase("/")
				 || expr.equalsIgnoreCase("^"));
	}

	private boolean precedenseAIsGraterThanB(String a, String b){
    	char charA = a.charAt(0);
    	char charB = b.charAt(0);

    	return precedence(charA) > precedence(charB);

	}
    
    /**
     * Función para transformar una expresión en notación infija a notación RPL
     * @param expr Expresión infija
     * @return Expresión posfija
     * @throws ExpressionMismatchException Si la expresión es inválida
     */
    public String transform (String expr) throws ExpressionMismatchException {
    		if(expr == null){
    			throw  new ExpressionMismatchException("The input expression can't be null");
			}
    		Scanner scanner = new Scanner(expr);
    		while(scanner.hasNext()){
				String currentValue = scanner.next();
				if(isNumeric(currentValue)){
					queue.offer(currentValue);
				}else if (isOperator(currentValue)){
					if(stack.isEmpty() || precedenseAIsGraterThanB(currentValue,stack.peek())){
						stack.push(currentValue);
					}else{
						while(!stack.isEmpty() && !precedenseAIsGraterThanB(currentValue,stack.peek()) ){
							String operator =stack.pop();
							if(isOperator(operator)){
								queue.offer(operator);
							}
						}
						stack.push(currentValue);

					}
				}else if(currentValue.equalsIgnoreCase("(")){
					stack.push(currentValue);
				}else if(currentValue.equalsIgnoreCase(")")){
					boolean foundOpenBracket = false;
					while(!stack.isEmpty() && !foundOpenBracket){
						String stackElement =stack.pop();
						if(stackElement.equalsIgnoreCase("(")){
							foundOpenBracket = true;
						}else{
							queue.offer(stackElement);
						}
					}
					if(!foundOpenBracket){
						throw new ExpressionMismatchException("The brackets are not balanced");
					}
				}else {
					throw new ExpressionMismatchException("The input string is not invalid");
				}
			}
			while(!stack.isEmpty()){
    			String element = stack.pop();
    			if(element.equalsIgnoreCase("(")){
					throw new ExpressionMismatchException("The brackets are not balanced");
				}
    			queue.offer(element);
			}

			StringJoiner joiner = new StringJoiner(" ");
			while(!queue.isEmpty()){
				joiner.add(queue.poll());
			}

			return joiner.toString();
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
								"( ( ( 4 + ( 12 * 28 ) ) ) * ( 7 / 5 ) )"


								};

		String[] expectedResults = {	"6 8 2 / 1 - *",
									"2 3 + 4 5 * +",
									"5 2 4 * + 7 -",
									"8 5 * 7 4 2 + * +",
									"1 2 +",
									"1 2 3 * + 4 +",
									"4 12 28 * + 7 5 / *"

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
