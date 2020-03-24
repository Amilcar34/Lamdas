package app.function;

import java.util.List;
import java.util.function.Consumer;

import dao.IGenericManager;
import dao.ManagerCamisa;
import model.Camisa;

public class AppConsumer {

	//expresion Lamda
	static Consumer<Camisa> consumerLamda = c -> System.out.println(c);

	//expresion por referencia
	static Consumer<Camisa> consumerReferencia = System.out::println;

	
	public static void main(String[] args) {

		IGenericManager<Camisa> manager = new ManagerCamisa();
		List<Camisa> camisas = manager.getAll();

		// Metodo 1
		camisas.forEach(consumerLamda);

		// Metodo 2 - uso implisito
		camisas.forEach(c -> System.err.println(c));
		
		// Metodo 3 - uso de metodo como parametro
		camisas.forEach(AppConsumer::imprimir);

		// Metodo 4 - uso de accept() y expresion por referencia
		for (Camisa camisa : camisas)
			consumerReferencia.accept(camisa);
	}

	//uso de accept() y expresion lamda
	static void imprimir(Camisa camisa) {
		consumerLamda.accept(camisa);
	}

}
