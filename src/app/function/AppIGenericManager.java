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
		imprimir(managerString);
		
		//Metodo 2
		List<Talle> talles = managerTalles.getAll();
		talles.forEach(System.out::println);
		
		//Metodo 3
		imprimir(() -> Collections.singletonList(new Camisa("Verde", Talle.M)));
	}

	static <T> void imprimir(IGenericManager<T> manager) {
		List<T> list = manager.getAll();
		System.err.println(list.size());
	}
}
