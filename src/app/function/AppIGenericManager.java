package app.function;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import dao.IGenericManager;
import model.Camisa;
import model.Talle;

public class AppIGenericManager {

	static IGenericManager<Talle> managerTalles = () -> Arrays.asList(Talle.L, Talle.XL, Talle.XXL );
	
	public static void main(String[] args) {

		//Metodo 1
		IGenericManager<String> managerString = () -> Arrays.asList("Jorge", "Alan", "Leo", "Pablo");
		imprimirData(managerString);
		
		//Metodo 2
		List<Talle> talles = managerTalles.getAll();
		talles.forEach(System.out::println);
		
		//Metodo 3
		imprimirData(() -> Collections.singletonList(new Camisa("Verde", Collections.singletonList(Talle.M))));
	}

	static <T> void imprimirData(IGenericManager<T> manager) {
		List<T> list = manager.getAll();
		System.err.println(list.size());
		System.err.println(list.isEmpty());
		System.err.println(list.toString());
	}
}
