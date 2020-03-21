package controller;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Camisa;

public class CamisaController {

	public List<Camisa> filtrarCamisa(List<Camisa> camisas, Predicate<Camisa> predicate){
		return camisas.stream().filter(predicate).collect(Collectors.toList());
	}
	
	  public Predicate<Camisa> isRojo() {
	        return c -> c.getColor().equalsIgnoreCase("rojo");
	  }
}
