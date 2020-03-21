package dao;

import java.util.ArrayList;
import java.util.List;

import model.Camisa;
import model.Talle;

public class ManagerCamisa implements IGenericManager<Camisa> {

	public List<Camisa> getAll(){
		List<Camisa> camisas = new ArrayList<Camisa>();
		camisas.add(new Camisa("Naranja", Talle.XXL));
		camisas.add(new Camisa("Rojo", Talle.M));
		camisas.add(new Camisa("Amarillo", Talle.XL));
		camisas.add(new Camisa("Negro", Talle.M));
		camisas.add(new Camisa("Bordo", Talle.S));
		return camisas;
	}
}
