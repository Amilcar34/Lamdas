package app.function;

import java.util.function.Supplier;

import model.Camisa;
import model.Talle;

public class AppSupplier {

	static Supplier<Camisa> supplier = () -> new Camisa("Negro", Talle.XXL);
	
	public static void main(String[] args) {
		
		//Metodo 1
		Camisa factory = factory(Camisa::new);
		System.out.println(factory);
		
		//Metodo 2 - uso de get()
		Camisa camisa = supplier.get();
		System.out.println(camisa);
	}

	private static Camisa factory(Supplier<Camisa> supplier) {
		Camisa camisa = supplier.get();
		if(camisa.getTalle() == null)
			return new Camisa("Negro", Talle.S);
		return supplier.get();
	}

}
