package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.Camisa;
import model.Talle;

public class ManagerCamisa implements IGenericManager<Camisa> {

	public List<Camisa> getAll() {
		List<Camisa> camisas = new ArrayList<Camisa>();

		List<Talle> list = Arrays.asList(Talle.L, Talle.M, Talle.S, Talle.XL, Talle.XXL);

		camisas.add(new Camisa("Naranja", list.stream().distinct().collect(Collectors.toList())));
		camisas.add(new Camisa("Rojo", list.stream().limit(3).collect(Collectors.toList())));
		camisas.add(new Camisa("Amarillo", list.parallelStream().limit(3).collect(Collectors.toList())));
		camisas.add(new Camisa("Negro", list.stream().skip(3).collect(Collectors.toList())));
		camisas.add(new Camisa("Bordo", list.stream().collect(Collectors.toList())));
		return camisas;
	}
}
