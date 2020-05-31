package app.function;

import java.util.Arrays;
import java.util.function.Supplier;

import model.Camisa;
import model.Talle;

public class AppSupplier {

	//expresion Lamda
	static Supplier<Camisa> supplierLamda = () -> new Camisa("Negro", Arrays.asList(Talle.XXL));
	
	//expresion Metodo por referencia
	static Supplier<Camisa> supplierReferencia = Camisa::new;
	
	public static void main(String[] args) {
		
		//Metodo 1
		Camisa factory = factory(supplierReferencia);
		System.err.println(factory);
		
		//Metodo 2 - uso de get()
		Camisa camisa = supplierLamda.get();
		System.out.println(camisa);
	}

	private static Camisa factory(Supplier<Camisa> supplier) {
		Camisa camisa = supplier.get();
		if(camisa.getTalles() == null)
			return new Camisa("Negro", Arrays.asList(Talle.S));
		return supplier.get();
	}

}
