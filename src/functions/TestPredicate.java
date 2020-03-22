package functions;

import java.util.List;
import java.util.function.Predicate;

import controller.CamisaController;
import dao.IGenericManager;
import dao.ManagerCamisa;
import model.Camisa;
import model.Talle;

public class TestPredicate {
	
	public static void main(String[] args) {
		
		IGenericManager<Camisa> dataBase = new ManagerCamisa();
		List<Camisa> camisas = dataBase.getAll();
		
		//Manera 1
		CamisaController camisaController1 = new CamisaController();
		CamisaController camisaControllerIsRojo = new CamisaController();
		List<Camisa> camisas2 = camisaController1.filtrarCamisa(camisas, camisaControllerIsRojo.isRojo());
		camisas2.forEach(System.out::println);
		
		//Manera 2
		Predicate<Camisa> isAmarillo = c -> c.getColor().equalsIgnoreCase("amarillo");
		CamisaController camisaController2 = new CamisaController();
		List<Camisa> camisas3 = camisaController1.filtrarCamisa(camisas, isAmarillo);
		camisas3.forEach(System.err::println);
		
		//Manera 3
		camisas.stream().filter(c -> c.getTalle().equals(Talle.M)).forEach(System.out::println);
		
		//Manera 4 - uso de test()
		for (Camisa camisa : camisas3) 
			if(isAmarillo.test(camisa))
				System.err.println(camisa);
		
	}

}
