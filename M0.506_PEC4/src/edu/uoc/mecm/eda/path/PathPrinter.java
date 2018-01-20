package edu.uoc.mecm.eda.path;

/**
 * Clase que aplica el algoritmo de Dijkstra a una matriz de adyacencia y muestra el camino
 * @author Carles Pairot Gavaldà
 *
 */
public class PathPrinter {

	// Para simplificar, consideramos que el máximo número de vértices será 9
	private static final int V = 9;
	
	// Vector de distancias
	private int dist[];
	
	// Vector de padres
	private int parent[];
	
	// Nodo origen
	private int src;
	
	/**
	 * Función que calcula la distancia mínima devolviendo el vértice con menor distancia 
	 * @param sptSet sptSet
	 * @return El vértice con menor distancia
	 */
	private int minDistance (boolean sptSet[]) {
		// Inicializamos el valor mínimo
		int min = Integer.MAX_VALUE, min_index=-1;

		for (int v = 0; v < V; v++) {
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		}

		return min_index;
	}

	/**
	 * Muestra las distancias desde el vértice origen hasta los otros
	 * @return String representando las distancias
	 */
	public String printSolution() {
		StringBuffer sb = new StringBuffer();
		sb.append ("Vertex   Distance from Source\n");
		
		for (int i = 0; i < V; i++) {
			sb.append (i + "\t\t" + dist[i] + "\n");
		}
		
		return sb.toString();
	}
			
	/**
	 * Función que muestra el camino más corto desde el origen hasta j utilizando la tabla de padres
	 * @param j destino
	 */
	private String printPath (int j) {
		StringBuffer sb = new StringBuffer();
	
	    // Caso particular, si j es el origen
	    if (parent[j]==-1) {
	        return "";
	    }
	 
	    sb.append (printPath (parent[j]));
	 
	    sb.append (j + " ");
	    return sb.toString();
	}

	/**
	 * Función que muestra la solución con el camino completo
	 * @return String que contiene el camino completo
	 */
	public String printSolutionWithPath() {
	    StringBuffer sb = new StringBuffer();
	    sb.append ("Vertex\t\tDistance\tPath\n");

	    // TODO: Implementar este método
	    // El string devuelto tiene que tener el formato que tenéis a continuación (los valores de distancia y camino son solamente ilustrativos)
	    
	    //	    Vertex		Distance	Path
	    //
	    //	    0 -> 1		 8		0 1 
	    //	    0 -> 2		 15		0 2 3 
	    //	    0 -> 3		 19		0 2 3 4 
	    //	    0 -> 4		 22		0 2 6 1 3 
	    //	    0 -> 5		 13		0 2 6 1 
	    //	    0 -> 6		 11		0 2 3 
	    //	    0 -> 7		 7		0 2 
	    //	    0 -> 8		 9		0 1 2 7 
	    
	    // Para imprimir el camino podéis ayudaros del método printPath() que ya está implementado
	    
	    return sb.toString();
	}


	/**
	 * Función que implementa el algoritmo de Dijkstra para un grafo representado por una matriz de adyacencias
	 * @param graph La matriz de adyacencias
	 * @param src El vértice origen
	 */
	public void dijkstra (int graph[][], int src) {
		// TODO: Implementar este método
		
		// Almacenamos el nodo origen en la variable privada src de la clase
		this.src = src;
		
		// El array de salida: dist[i] contendrá la distancia menor desde src hasta i
		dist = new int[V];

		// Declaramos el array sptSet[]. sptSet[i] será cierto si el vértice i está incluído en el shortest path tree o si la distancia más corta desde
		// src a i ha finalizado

		// Inicializamos el array de padres para almacenar el shortest path tree
		
		// Inicializamos todas las distancias como INFINITO y sptSet[] a falso

		// La distancia del vértice origen hasta sí mismo siempre será 0

		// Iniciamos el bucle para encontrar el camino mínimo para todos los vértices
			// Encontrar el vértice a mínima distancia del conjunto de vértices aún no procesados. u siempre es igual a
			// src en la primera iteración. Podéis utilizar la función proporcionada minDistance()

			// Marcamos el vértice tratado como procesado

			// Actualizamos el valor de dist para todos los vértices adyacentes al vértice escogido
				// Actualizar dist[v] sólo si no está dentro de sptSet, existe una arista desde u a v y el peso total
				// del camino desde src hasta v a través de u es más pequeño que el valor actual de dist[v]
				// También marcaremos que el padre de v es u 
	}


	/**
	 * Método para probar el correcto funcionamiento de vuestro algoritmo
	 * @param args Argumentos de entrada
	 */
	public static void main (String[] args) {
     
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                               {4, 0, 8, 0, 0, 0, 0, 11, 0},
                               {0, 8, 0, 7, 0, 4, 0, 0, 2},
                               {0, 0, 7, 0, 9, 14, 0, 0, 0},
                               {0, 0, 0, 9, 0, 10, 0, 0, 0},
                               {0, 0, 4, 14, 10, 0, 2, 0, 0},
                               {0, 0, 0, 0, 0, 2, 0, 1, 6},
                               {8, 11, 0, 0, 0, 0, 1, 0, 7},
                               {0, 0, 2, 0, 0, 0, 6, 7, 0}
                              };

        PathPrinter t = new PathPrinter();
        t.dijkstra (graph, 0);

        if (t.printSolution().contains ("3		19")) { 
    		System.out.println ("Test Unitario 1 - OK.");
    	} else {
    		System.err.println ("Test Unitario 1 - KO - el método no devuelve bien la solución: " + t.printSolution());
    	}
        
        if (t.printSolution().contains ("1		4")) { 
    		System.out.println ("Test Unitario 2 - OK.");
    	} else {
    		System.err.println ("Test Unitario 2 - KO - el método no devuelve bien la solución: " + t.printSolution());
    	}

        if (t.printSolution().contains ("5		11")) { 
    		System.out.println ("Test Unitario 3 - OK.");
    	} else {
    		System.err.println ("Test Unitario 3 - KO - el método no devuelve bien la solución: " + t.printSolution());
    	}

        if (t.printSolution().contains ("8		14")) { 
    		System.out.println ("Test Unitario 4 - OK.");
    	} else {
    		System.err.println ("Test Unitario 4 - KO - el método no devuelve bien la solución: " + t.printSolution());
    	}

        if (t.printSolutionWithPath().contains ("0 -> 4		 21		0 7 6 5 4")) { 
    		System.out.println ("Test Unitario 5 - OK.");
    	} else {
    		System.err.println ("Test Unitario 5 - KO - el método no devuelve bien la solución: " + t.printSolutionWithPath());
    	}

        if (t.printSolutionWithPath().contains ("0 -> 6		 9		0 7 6")) { 
    		System.out.println ("Test Unitario 6 - OK.");
    	} else {
    		System.err.println ("Test Unitario 6 - KO - el método no devuelve bien la solución: " + t.printSolutionWithPath());
    	}
        
        if (t.printSolutionWithPath().contains ("0 -> 8		 14		0 1 2 8")) { 
    		System.out.println ("Test Unitario 7 - OK.");
    	} else {
    		System.err.println ("Test Unitario 7 - KO - el método no devuelve bien la solución: " + t.printSolutionWithPath());
    	}
        
        if (t.printSolutionWithPath().contains ("0 -> 3		 19		0 1 2 3")) { 
    		System.out.println ("Test Unitario 8 - OK.");
    	} else {
    		System.err.println ("Test Unitario 8 - KO - el método no devuelve bien la solución: " + t.printSolutionWithPath());
    	}
        
        
        System.out.println (t.printSolution());
        System.out.println (t.printSolutionWithPath());
	}
}