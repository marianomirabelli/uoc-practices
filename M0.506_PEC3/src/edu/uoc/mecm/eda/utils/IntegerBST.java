package edu.uoc.mecm.eda.utils;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Clase que implementa un BST de enteros
 * @author Carles Pairot Gavalda
 *
 */
public class IntegerBST {
    // Nodo raíz del BST
	private Node root;
	private Integer maxValue = Integer.MIN_VALUE;
	
    /**
     * Clase privada que encapsula un nodo del árbol
     * @author Carles Pairot Gavalda
     *
     */
    private class Node {    
    		// El valor del nodo
    		private Integer value;

    		// Subárboles izquierdo y derecho
    		private Node left, right;

    		// Constructor de la clase
    		public Node (Integer value) {
            this.value = value;
        }
    }


    /**
     * Busca en el BST por un valor determinado y devuelve cierto si lo ha encontrado
     * @param value El valor por el que buscat
     * @return Cierto si el valor se encuentra en el BST
     */
    public boolean contains (Integer value) {
        return get (root, value) != null;
    }

    private Integer get (Node x, Integer value) {
        if (x == null) {
        	return null;
        }

        int cmp = value.compareTo (x.value);
        
        if	(cmp < 0) {
        	return get (x.left, value);
        }
        else if (cmp > 0) {
        	return get (x.right, value);
        }
        else {
        	return x.value;
        }
    }

    
    /**
     * Inserta un valor entero en el BST. Si el valor ya existe lo reemplaza
     * @param value Entero a insertar
     */
    public void put (Integer value) {
		if(maxValue.compareTo(value)==-1){
			maxValue = value;
		}
    	root = put (root, value);
    }

    private Node put (Node x, Integer value) {
        if (x == null) {
        	return new Node (value);
        }
        
        int cmp = value.compareTo (x.value);
        
        if (cmp < 0) {
        		x.left  = put (x.left,  value);
        }
        else if (cmp > 0) {
        		x.right = put (x.right, value);
        }
        return x;
    }
    
    /**
     * Método que devuelve el espejo del árbol a partir de la raiz
     */
    public void mirror() {
    		if (root == null) {
    			throw new NoSuchElementException();
    		}
    		
    		mirror (root);
    }
    
    /**
     * Método que devuelve el espejo del árbol a partir del nodo x
     * @param x El nodo a partir del cual se aplica el mirroring
     */
    private void mirror (Node x) {
    	if(!Objects.isNull(x)){
			mirror(x.left);
			mirror(x.right);
    		Node temp = x.left;
			x.left = x.right;
			x.right = temp;
		}

    }

    /**
     * Método que devuelve el valor máximo del árbol a partir del nodo raíz
     * @return El valor máximo del árbol
     */
    public int getMax() {
    	if (root == null) {
    		throw new NoSuchElementException();
    	} else {
    		return getMax (root);
    	}
    }
    
    /**
     * Método que devuelve el valor mínim del árbol CON COSTE CONSTANTE
     * @return El valor mínimo del árbol
     */
    public int getNewMax() {

    	return maxValue;
    }
    
    /**
     * Método que devuelve el valor máximo del subárbol a partir del nodo especificado
     * @param x Nodo a partir del cual se devuelve el máximo
     * @return El valor mínimo del subárbol
     */
    private int getMax (Node x) { 
    		if (x.right == null) {
    			return x.value; 
    		} else {
    			return getMax (x.right); 
    		}
    }
        
    /**
     * Método que devuelve un string representando un recorrido inorden por el árbol
     * @return String con un recorrido inorden por el arbon
     */
    public String inOrder() {
    		return inOrder (root);
    }
    
    private String inOrder (Node node) {
    	StringBuffer sb = new StringBuffer();
        if (node != null) {
            sb.append (inOrder (node.left));
            sb.append (node.value + " ");
            sb.append (inOrder (node.right));
        }
        return sb.toString();
    }

    
    /**
     * Método que implementa unos sencillos tests unitarios para comprobar el correcto funcionamiento de
     * vuestro algoritmo
     * @param args Params
     */
    public static void main (String[] args) {
    		IntegerBST a0 = new IntegerBST();
    		a0.put (4); a0.put(5); a0.put(2); a0.put(1); a0.put(3);

    		IntegerBST a1 = new IntegerBST();
    		a1.put (4); a1.put (10); a1.put (-3); a1.put (0); a1.put (40); a1.put (16); a1.put (1); a1.put (3);

    		IntegerBST a2 = new IntegerBST();
    		a2.put (8); a2.put (25); a2.put (16); a2.put (32); a2.put (95);

    		IntegerBST a3 = new IntegerBST();
    		a3.put (-4); a3.put (-5); a3.put (-16); a3.put (-32); a3.put (-95); a3.put (152);
    		
	    	if (a0.getMax() == a0.getNewMax()) {
	    		System.out.println ("Test Unitario 1 - OK.");
	    	} else {
	    		System.err.println ("Test Unitario 1 - KO - getMax(" + a0.getMax() + ") != getNewMax(" + a0.getNewMax() + ")");
	    	}
    		
    		if (a1.getMax() == a1.getNewMax()) {
	    		System.out.println ("Test Unitario 2 - OK.");
	    	} else {
	    		System.err.println ("Test Unitario 2 - KO - getMax(" + a1.getMax() + ") != getNewMax(" + a1.getNewMax() + ")");
	    	}
	
	    	if (a2.getMax() == a2.getNewMax()) {
	    		System.out.println ("Test Unitario 3 - OK.");
	    	} else {
	    		System.err.println ("Test Unitario 3 - KO - getMax(" + a2.getMax() + ") != getNewMax(" + a2.getNewMax() + ")");
	    	}

	    	if (a3.getMax() == a3.getNewMax()) {
	    		System.out.println ("Test Unitario 4 - OK.");
	    	} else {
	    		System.err.println ("Test Unitario 4 - KO - getMax(" + a3.getMax() + ") != getNewMax(" + a3.getNewMax() + ")");
	    	}
    		
    		a0.mirror();
    		a1.mirror();
    		a2.mirror();
    		a3.mirror();
    		
    		if (a0.inOrder().trim().equals ("5 4 3 2 1")) {
        		System.out.println ("Test Unitario 5 - OK.");
        	} else {
        		System.err.println ("Test Unitario 5 - KO - Returning - " + a0.inOrder());
        	}
    	
    		if (a1.inOrder().trim().equals ("40 16 10 4 3 1 0 -3")) {
        		System.out.println ("Test Unitario 6 - OK.");
        	} else {
        		System.err.println ("Test Unitario 6 - KO - Returning - " + a1.inOrder());
        	}

    		if (a2.inOrder().trim().equals ("95 32 25 16 8")) {
        		System.out.println ("Test Unitario 7 - OK.");
        	} else {
        		System.err.println ("Test Unitario 7 - KO - Returning - " + a2.inOrder());
        	}

    		if (a3.inOrder().trim().equals ("152 -4 -5 -16 -32 -95")) {
        		System.out.println ("Test Unitario 8 - OK.");
        	} else {
        		System.err.println ("Test Unitario 8 - KO - Returning - " + a3.inOrder());
        	}
   }
}