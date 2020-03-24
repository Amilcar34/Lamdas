package app.function;

import java.util.function.Supplier;

import model.Camisa;
import model.Talle;

public class AppSupplier {

	//expresion Lamda
	static Supplier<Camisa> supplierLamda = () -> new Camisa("Negro", Talle.XXL);
	
	//expresion Metodo por referencia
	static Supplier<Camisa> supplierReferencia = Camisa::new;
	
	public static void main(String[] args) {
		
		//Metodo 1
		Camisa factory = factory(supplierReferencia);
		System.out.println(factory);
		
		//Metodo 2 - uso de get()
		Camisa camisa = supplierLamda.get();
		System.out.println(camisa);
	}

	private static Camisa factory(Supplier<Camisa> supplier) {
		Camisa camisa = supplier.get();
		if(camisa.getTalle() == null)
			return new Camisa("Negro", Talle.S);
		return supplier.get();
	}

}
