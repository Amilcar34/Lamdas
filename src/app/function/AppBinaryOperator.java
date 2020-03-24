package app.function;

import java.util.function.BinaryOperator;

public class AppBinaryOperator {

	final static int DIEZ = 10, CINCO = 5;
	
	public static void main(String[] args) {

		//metodo 1 - básico
		System.err.println(DIEZ / CINCO);
		
		//metodo 2 - Unsigned
		System.out.println(Integer.divideUnsigned(DIEZ, CINCO));
		
		//metodo 3 - Lamda
		BinaryOperator<Integer> divide = Integer::divideUnsigned;
		System.err.println(divide.apply(DIEZ, CINCO));
	}

}
