package edu.uoc.mecm.eda.warmup;

import java.util.Arrays;

public class MathUtils {

	/**
	 * Suma los elementos del vector y devuelve el resultado
	 * @param array el vector del que se desean sumar los elements
	 * @return el valor acumulado del vector
	 * @throws Exception si array es null
	 */
	public static double sum( double[] array ) throws Exception{
		if ( array == null ){
			throw new Exception( "El vector debe ser distinto de null" );
		}
		double sum = 0;
		for(int i = 0; i < array.length; i++){
			sum += array[i];
		}
		return sum;
	}
	
	/**
	 * Determina si la suma de los elementos del primer vector es mayor que la suma de los elementos del segundo
	 * @param arrayA el primer vector
	 * @param arrayB el segundo vector
	 * @return true si la suma de los elementos del primer vector es mayor, false en otros casos
	 * @throws Exception si alguno de los vectores es null
	 */
	public static boolean arrayIsGreater( double[] arrayA, double[] arrayB ) throws Exception{
		if( arrayA == null || arrayB == null ){
			throw new Exception( "Los vectores deben ser distintos de null" );
		}
		double sumA = sum(arrayA);
		double sumB = sum(arrayB);

		return sumA > sumB;
	}
	
	/**
	 * Determina si el primer vector domina al segundo vector. Es decir, para cada 
	 * dimension del vector, el valor del vector A es mayor o igual 
	 * que el valor del vector B
	 * @param arrayA
	 * @param arrayB
	 * @return true si el vector A domina al vector B, false en otro caso
	 * @throws Exception si alguno de los vectores es null o si los tamaños de los vectores no coinciden
	 */
	public static boolean dominates( double[] arrayA, double[] arrayB ) throws Exception {
		if( arrayA == null || arrayB == null ){
			throw new Exception( "Los vectores deben ser distintos de null" );
		}
		if( arrayA.length != arrayB.length ){
			throw new Exception( "Ambos vectores deben tener la misma dimensión" );
		}
		/* Tu codigo a partir de aqui */
		for(int i = 0;i < arrayA.length ;i++){
			if(arrayA[i] < arrayB[i]){
				return false;
			}
		}

		return true;
	}
	
	/**
	 * Crea un nuevo vector copia del vector argumento
	 * @param array el vector a copiar
	 * @return la referencia al nuevo objeto creado o null si el argumento es null
	 */
	public static double[] copyArray( double[] array ){
		/* Tu codigo a partir de aqui */
		double [] arrayCopied = null;
		if(array != null){
			arrayCopied = new double[array.length];
			for(int i= 0; i < array.length; i++){
				arrayCopied[i] = array[i];
			}
		}
		return arrayCopied;
	}
	
	/**
	 * Crea un nuevo vector que es la suma de ambos vectores argumento
	 * @param arrayA el primer vector
	 * @param arrayB el segundo vector
	 * @return un nuevo vector que es suma de ambos vectores
	 * @throws Exception si los tamaños de ambos vectores no son iguales o si alguno de los argumentos es null
	 */
	public static double[] sumArrays( double[] arrayA, double[] arrayB ) throws Exception{
		/* Tu codigo a partir de aqui
		 * NOTA: En este ejercicio tu debes decidir donde lanzar excepciones
		 */
		if(arrayA==null || arrayB ==null){
			throw new Exception("Las matrices no pueden ser null");
		}
		if(arrayA.length!= arrayB.length){
			throw new Exception("No se pueden sumar arrays de longitudes distintas");
		}
		double [] sumArray = new double[arrayA.length];
		for (int i = 0 ;i< arrayA.length;i++){
			sumArray[i] = arrayA[i] + arrayB[i];
		}
		return sumArray;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double a[] = { 1, 2, 3, 4, 5, 6};
		double b[] = { 10, 3, 8, 4, 5, 8};
		double c[] = { 3, 5, 7, 9 };
		
		/* Test unitario 1 */
		try {
			double res = 0;
			if( (res = sum( a )) == 21 ){
				System.out.println( "Test unitario 1 (sum) OK" );
			} else {
				System.err.println( "sum(" + Arrays.toString( a ) + ") debió sumar 21 y sumo " + res );
			}
		} catch (Exception e) {
			System.err.println( "Se lanzó excepción en Test unitario 1 (sum) " + e.getMessage() );
		}
		
		/* Test unitario 2 */
		try{
			if( !arrayIsGreater( a ,  b ) ){
				System.out.println( "Test unitario 2 (arrayIsGreater) OK" );
			} else {
				System.err.println( "arrayIsGreater(" + Arrays.toString( a ) + 
						"," + Arrays.toString( b ) + ") debió devolver false" );
			}
		} catch( Exception e ){
			System.err.println( "Se lanzó una excepción en Test unitario 2 (arrayIsGreater) " + e.getMessage() ); 
		}
		
		/* Test unitario 3 */
		try{
			if( !arrayIsGreater( a ,  a ) ){
				System.out.println( "Test unitario 3 (arrayIsGreater) OK" );
			} else {
				System.err.println( "arrayIsGreater(" + Arrays.toString( a ) + 
						"," + Arrays.toString( a ) + ") debió devolver false" );
			}
		} catch( Exception e ){
			System.err.println( "Se lanzó una excepción en Test unitario 3 (arrayIsGreater) " + e.getMessage() ); 
		}
		
		/* Test unitario 4 */
		try{
			if( arrayIsGreater( b , a ) ){
				System.out.println( "Test unitario 4 (arrayIsGreater) OK" );
			} else {
				System.err.println( "arrayIsGreater(" + Arrays.toString( b ) + 
						"," + Arrays.toString( a ) + ") debió devolver true" );
			}
		} catch( Exception e ){
			System.err.println( "Se lanzó una excepción en Test unitario 4 (arrayIsGreater) " + e.getMessage() ); 
		}
		
		/* Test unitario 5 */
		try{
			if( dominates( b , a ) ){
				System.out.println( "Test unitario 5 (dominates) OK" );
			} else {
				System.err.println( "dominates(" + Arrays.toString( b ) + 
						"," + Arrays.toString( a ) + ") debió devolver true" );
			}
		} catch( Exception e ){
			System.err.println( "Se lanzó una excepción en Test unitario 5 (dominates) " + e.getMessage() ); 
		}
		
		/* Test unitario 6 */
		try{
			if( !dominates( a , b ) ){
				System.out.println( "Test unitario 6 (dominates) OK" );
			} else {
				System.err.println( "dominates(" + Arrays.toString( a ) + 
						"," + Arrays.toString( b ) + ") debió devolver false" );
			}
		} catch( Exception e ){
			System.err.println( "Se lanzó una excepción en Test unitario 6 (dominates) " + e.getMessage() ); 
		}
		
		/* Test unitario 7 */
		try{
			if( copyArray( null ) == null ){
				System.out.println( "Test unitario 7 (copyArray) OK" );
			} else {
				System.err.println( "copyArray(null) debió devolver null" );
			}
		} catch( Exception e ){
			System.err.println( "Se lanzó una excepción en Test unitario 7 (copyArray) " + e.getMessage() ); 
		}
		
		/* Test unitario 8 */
		try{
			double[] copied = copyArray( a );
			if( copied == a ){
				System.err.println( "copyArray no debe devolver la misma referencia de objeto" );
			} else if( Arrays.equals( copied , a ) ){
				System.out.println( "Test unitario 8 (copyArray) OK" );
			} else {
				System.err.println( "copyArray(" + Arrays.toString( a ) +") devolvió "+ Arrays.toString( copied ) + 
						" en vez de una copia" );
			}
		} catch( Exception e ){
			System.err.println( "Se lanzó una excepción en Test unitario 8 (copyArray) " + e.getMessage() ); 
		}
		
		/* Test unitario 9 */
		try{
			sumArrays( null, b );
			System.err.println( "sumArrays(null," + Arrays.toString( b ) + ") debió lanzar excepción" );
		} catch( Exception e ){
			System.out.println( "Test unitario 9 (sumArrays) OK" );
		}
		
		/* Test unitario 10 */
		try{
			sumArrays( b, null );
			System.err.println( "sumArrays(" + Arrays.toString( b ) + ",null) debió lanzar excepción" );
		} catch( Exception e ){
			System.out.println( "Test unitario 10 (sumArrays) OK" );
		}
		
		/* Test unitario 11 */
		try{
			sumArrays( b, c );
			System.err.println( "sumArrays(" + Arrays.toString( b ) + "," + Arrays.toString( c ) +
					") debió lanzar excepción" );
		} catch( Exception e ){
			System.out.println( "Test unitario 11 (sumArrays) OK" );
		}
		
		/* Test unitario 12 */
		try{
			double[] summed = sumArrays( a, b );
			double[] expected = { 11.0, 5.0, 11.0, 8.0, 10.0, 14.0 };
			if( Arrays.equals( summed , expected ) ){
				System.out.println( "Test unitario 12 (sumArrays) OK" );
			} else {
				System.err.println( "sumArrays(" + Arrays.toString( a ) + "," + Arrays.toString( b ) 
						+ ") sumo " + Arrays.toString( summed ) + " y esperaba " +
						Arrays.toString( expected ) );
			}
		} catch( Exception e ){
			System.err.println( "Se lanzó una excepción en Test unitario 12 (copyArray) " + e.getMessage() ); 
		}
		
		
	}

}
