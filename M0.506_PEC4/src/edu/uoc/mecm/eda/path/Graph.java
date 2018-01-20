package edu.uoc.mecm.eda.path;

import java.util.Stack;
import java.util.Iterator;

/**
 * Clase que encapsula un grafo dirigido
 * @author Carles Pairot Gavaldà
 *
 */
public class Graph {
	
	// Número de vértices
	private int V;
	
	// Lista de adyacencias
	private Stack<Integer>[] adj;
	
	/**
	 * Constructor de la clase
	 * @param V Le pasamos el número de vértices para inicializar la estructura
	 */
	public Graph (int V) {
		this.V = V;
		adj = (Stack<Integer>[]) new Stack[V];
		
		// Inicializamos la lista de adyacencias
		for (int i = 0; i < V; i++) {
			adj[i] = new Stack<Integer>();
		}
	}
	
	/**
	 * Método para añadir una arista
	 * @param u Vértice origen
	 * @param v Vértice destino
	 */
	public void addEdge (int u, int v) {
		adj[u].push (v);
	}

	/**
	 * Método para contar el número de caminos de 's' a 'd'
	 * @param s Vértice origen
	 * @param d Vértice destino
	 * @return El número total de caminos posibles entre 's' y 'd'
	 */
	public int countPaths (int s, int d) {
		// Para poder marcar si el vértice ya ha sido visitado
		boolean[] visited = new boolean[V];

		// Número de caminos desde 's' a 'd' encontrados	
		int pathCount = 0;
		
		// Llamamos a la función auxiliar para que calcule los caminos y devuelva el número de caminos encontrado
		return countPathsUtil (s, d, visited, pathCount);
	}

	
	/**
	 * Una función recursiva para contar todos los caminos desde 'u' hasta 'd'
	 * @param u Vértice origen
	 * @param d Vértice destino
	 * @param visited Mantiene los vértices ya visitados en el camino actual
	 * @param pathCount Número de caminos encontrados hasta ahora
	 * @return Número de caminos encontrados después de aplicar la función
	 */
	private int countPathsUtil (int u, int d, boolean[] visited, int pathCount) {
		// TODO: Implementar este método
		
		// Primero hay que marcar el vértice actual como visitado
		// Si el vértice actual es el mismo que el vértice destino, entonces hemos encontrado un nuevo camino
		// Si el vértice actual no es el mismo que el vértice destino, buscamos por todos los vértices adyacentes al vértice actual que no hayamos visitado aún
		// Llamaremos recursivamente a la misma función (countPathsUtil) para encontrar el camino desde el vértice adyacente
		// Marcamos el vértice actual como no visitado
		// Devolvemos el número de caminos encontrados

		visited[u] = true;
		if(u==d){
			pathCount += 1;
		}else{
			Iterator<Integer> uAdyacentList = this.adj[u].iterator();
			while(uAdyacentList.hasNext()){
				int adjacentVertex = uAdyacentList.next();
				if(!visited[adjacentVertex]){
					pathCount = countPathsUtil(adjacentVertex,d,visited,pathCount);
				}
			}
		}
		visited[u] = false;
		return pathCount;
	}
	
	/**
	 * Método principal que contiene unos tests unitarios para comprobar el correcto funcionamiento de vuestro método
	 * @param args Argumentos de entrada
	 */
	public static void main (String[] args) {
		Graph g = new Graph (4);

		g.addEdge (0, 1);
	    g.addEdge (0, 2);
	    g.addEdge (0, 3);
	    g.addEdge (2, 0);
	    g.addEdge (2, 1);
	    g.addEdge (1, 3);
		
    	int result = g.countPaths (2, 3); 
	    if (result == 3) {
    		System.out.println ("Test Unitario 1 - OK.");
    	} else {
    		System.err.println ("Test Unitario 1 - KO - countPaths() devuelve " + result);
    	}

    	result = g.countPaths (1, 3); 
	    if (result == 1) {
    		System.out.println ("Test Unitario 2 - OK.");
    	} else {
    		System.err.println ("Test Unitario 2 - KO - countPaths() devuelve " + result);
    	}

    	g = new Graph (6);
	    
	    g.addEdge (0, 1);
	    g.addEdge (0, 2);
	    g.addEdge (0, 4);
	    g.addEdge (1, 3);
	    g.addEdge (1, 4);
	    g.addEdge (2, 4);
	    g.addEdge (3, 2);
	    
	    
	    result = g.countPaths (0, 4);
	    if (result == 4) {
    		System.out.println ("Test Unitario 3 - OK.");
    	} else {
    		System.err.println ("Test Unitario 3 - KO - countPaths() devuelve " + result);
    	}
    
	    result = g.countPaths (2, 4);
	    if (result == 1) {
    		System.out.println ("Test Unitario 4 - OK.");
    	} else {
    		System.err.println ("Test Unitario 4 - KO - countPaths() devuelve " + result);
    	}
	
	    result = g.countPaths (1, 4);
	    if (result == 2) {
    		System.out.println ("Test Unitario 5 - OK.");
    	} else {
    		System.err.println ("Test Unitario 5 - KO - countPaths() devuelve " + result);
    	}

	    result = g.countPaths (3, 4);
	    if (result == 1) {
    		System.out.println ("Test Unitario 6 - OK.");
    	} else {
    		System.err.println ("Test Unitario 6 - KO - countPaths() devuelve " + result);
    	}
	    
	    result = g.countPaths (0, 5);
	    if (result == 0) {
    		System.out.println ("Test Unitario 7 - OK.");
    	} else {
    		System.err.println ("Test Unitario 7 - KO - countPaths() devuelve " + result);
    	}
	}
}