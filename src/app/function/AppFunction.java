package app.function;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dao.IGenericManager;
import dao.ManagerCamisa;
import model.Camisa;
import model.Talle;

public class AppFunction {
	
	static Function<Camisa, Talle> getTalle = c -> c.getTalle();

	public static void main(String[] args) {
		Function<Long, String> toString = s -> s.toString();
		
		//Metodo 1 - uso de apply()
		String apply = toString.apply(2l);
		System.out.println(apply);
		
		IGenericManager<Camisa> manager = new ManagerCamisa();
		List<Camisa> camisas = manager.getAll();
		
		//Metodo 2 
		Stream<Camisa> stream1 = camisas.stream();
		stream1.map(getTalle).forEachOrdered(System.err::println);
		
		//Metodo 3 - uso de implícito
		Stream<Camisa> stream2 = camisas.stream();
		stream2.map(c -> c.getColor()).forEachOrdered(System.out::println);
	}
}
