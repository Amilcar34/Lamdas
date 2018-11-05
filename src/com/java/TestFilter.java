package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
public class TestFilter {

	public static void main(String[] args) {
		//findfirst devuelve el primero en su reccorrido
		System.out.println(IntStream.range(0, 100).parallel().findFirst());
		//findany devuelve el primero que encuentre
		System.out.println(IntStream.range(0, 100).parallel().findAny());

		
		Search search = new Search(Type.AMAZON);
		ArrayList<Search> list = new ArrayList<>();
		list.addAll(Arrays.asList(search, new Search(Type.EBAY), new Search(Type.VISION), new Search(Type.AMAZON)));
		
		System.err.println("Toda la lista");
		list.stream().forEach(t -> System.out.println(t.getType()));

		System.err.println("El primero que de la lista");
		Optional<Search> optional = list.stream().findFirst();
		System.out.println(optional.get().getType().getValue());
		
		System.err.println("El primero que encuentre");
		Optional<Search> optional2 = list.stream().findAny();
		System.out.println(optional2.get().getType().getValue());
		
		//Evitamos instanciar algo que sea null si incluimos orElse(null)
		Search le = list.stream().filter(t -> t.getType() == Type.AMAZON).findAny().orElse(null);

		System.err.println("solo type amazon y google");
		list.stream().filter(t -> t.getType() == Type.AMAZON || t.getType() == Type.GOOGLE).forEach(t-> System.out.println(t.getType()));
		
	}
}
class Search{
	private Type type;

	public Search(Type type) { this.type = type; }

	public Type getType() {	return type; }
}
enum Type{
	GOOGLE("google"), EBAY("ebay"), AMAZON("amazon"), VISION("vision");

	private String searcher;
	
	private Type(String string) { this.searcher = string; }
	
	public String getValue() {return this.searcher; }
}