package app.function;

import java.util.List;
import java.util.function.Consumer;

import dao.IGenericManager;
import dao.ManagerCamisa;
import model.Camisa;

public class AppConsumer {

	static Consumer<Camisa> consumer = c -> System.out.println(c);

	public static void main(String[] args) {

		IGenericManager<Camisa> manager = new ManagerCamisa();
		List<Camisa> camisas = manager.getAll();

		// Metodo 1
		camisas.forEach(consumer);

		// Metodo 2 - uso implisito
		camisas.forEach(c -> System.err.println(c));
		
		// Metodo 3 - uso de accept()
		camisas.forEach(AppConsumer::imprimir);

		// Metodo 4 - uso de accept()
		for (Camisa camisa : camisas)
			consumer.accept(camisa);
	}

	static void imprimir(Camisa camisa) {
		consumer.accept(camisa);
	}

}
