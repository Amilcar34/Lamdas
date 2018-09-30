package com.java1_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
						System.out.println("---- run -------");
		
		System.err.println("Java 1.2");
		//java 1.2
		List list12 = new ArrayList();
		list12.add(6);
		list12.add("Juan");
		list12.add(2.5);
		
		for(int i = 0; i < list12.size(); i++) 
			System.out.println(list12.get(i));
		
		System.err.println("Java 1.5");		
		//java 1.5 
		//incluye operador diamante que destringe la entrada de Objetos
		List<String> list15 = new ArrayList<String>();
		list15.add("choclo");
		list15.add("papa");
		
		for(String string: list15) //for each comun, solo sirve para acciones de lectura
			System.out.println(list15);  //no se puede modificar la lista cuando es recorrida por un for each
		
		System.err.println("Java 1.7");		
		//java 1.7
		//no hace falta declarar la restriccion de ojbetos en la instancia
		List<String> list17 = new ArrayList<>();
		list17.add("tertulia");
		list17.add("desden");
		list17.add("aspero");
		
		Iterator<String> it = list17.iterator(); //Iterator aciones CRUD
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.err.println("java 1.8");
		//java 1.8
		List<String> list18 = Stream.of("pepo", "retutu", "polaco").collect(Collectors.toList());
		
		list18.forEach(System.out::println);
		
		System.err.println("modificamos la lista");
		//creo un stream (lista hecha para ser recorrida una unica vez)
		//le agrego filter (condicion para filtrar resultados) retorna los resultados
		//voy capturando cada true del filter con collect
		//al terminar los imprimo con forEach
		list18.stream().filter(x -> !"pepo".equals(x) ).collect(Collectors.toList()).forEach(System.out::println);;
		
	}

}
