package app.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import model.Camisa;
import model.Talle;

public class AppStream {

	public static void main(String[] args) {

		List<Talle> talles = Arrays.asList(Talle.S, Talle.M);

		Camisa camisa1 = new Camisa("Azul", talles);
		Camisa camisa2 = new Camisa("Negro", Arrays.asList(Talle.XL, Talle.M));
		Camisa camisa3 = new Camisa("Negro", Arrays.asList(Talle.XL, Talle.M));
		List<Camisa> camisas = new ArrayList<Camisa>();
		camisas.add(camisa1);
		camisas.add(camisa2);
		camisas.add(camisa3);

		camisas.stream().distinct().forEach(System.err::println);
		camisas.stream().map(c -> c.getTalles()).flatMap(t -> t.stream()).forEach(System.out::println);
		camisas.stream().forEach(c -> c.getTalles().stream().forEach(System.err::println));

		Map<List<Talle>, List<Camisa>> map = camisas.stream().collect(Collectors.groupingBy(Camisa::getTalles));
		map.forEach((k, v) -> System.out.println(k + " " + v));

		Map<List<Talle>, Long> map2 = camisas.stream().map(c -> c.getTalles())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map2.forEach((k, v) -> System.err.println(k + " " + v));

		Map<List<Talle>, List<List<Talle>>> map3 = camisas.stream().map(c -> c.getTalles())
				.collect(Collectors.groupingBy(Function.identity()));
		map3.forEach((k, v) -> System.out.println(k + " " + v));

	}

}
