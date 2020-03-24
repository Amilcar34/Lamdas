package app.function;

import java.util.function.BinaryOperator;

public class AppBinaryOperator {

	final static int DIEZ = 10, CINCO = 5;

	public static void main(String[] args) {

		// metodo 1 - Unsigned
		int divideUnsigned = Integer.divideUnsigned(DIEZ, CINCO);
		System.out.println(divideUnsigned);
		
		// metodo 2 - expresion: metodo por referencia
		BinaryOperator<Integer> divideReferencia = Integer::divideUnsigned;
		System.err.println(divideReferencia.apply(DIEZ, CINCO));

		// metodo 3 - expresion: Lamda
		BinaryOperator<Integer> divideLamda = (a,b) ->  Integer.divideUnsigned(a, b);
		System.err.println(divideLamda.apply(DIEZ, CINCO));

	}

}
