package app.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AppStreamFlatMap {

	public static void main(String[] args) {
       
        String[][][] data = new String[][][]{{{"a", "b"}}, {{"c", "d"}}, {{"e", "f"}}};
        
        Stream<String[][]> temp = Arrays.stream(data);
        Stream<String[]> stringStreamArr = temp.flatMap(x -> Arrays.stream(x));
        Stream<String> stringStream = stringStreamArr.flatMap(x -> Arrays.stream(x));
//        stringStream.filter(x -> "a".equals(x.toString())).forEach(System.out::println);
        
        int[] intArray = {1, 2, 3, 4, 5, 6};
        
        Stream<int[]> streamArray = Stream.of(intArray);
        
        //2. Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));
        intStream.forEach(x -> System.out.println(x));
	}
}
