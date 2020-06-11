package ctr;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.IntStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Application {
	
	public static void tryModifiableList(List<String> list){
		System.out.println(list.toString());
		try {
			list.remove(2);
			System.out.println("Funktioniert...");
		} catch (UnsupportedOperationException e) {
			System.err.println("unmodifiable...");
		}

		try {
			list.add("ToDo");
			System.out.println("Funktioniert...");


		} catch (UnsupportedOperationException e) {
			System.err.println("unmodifiable...");
		}
		ListIterator<String> iterator = list.listIterator();
		
		try {
			iterator.next();
			iterator.remove();
			System.out.println("Funktioniert...");

		} catch (UnsupportedOperationException e) {
			System.err.println("unmodifiable...");
		}
		
		System.out.println(list.toString());

	}
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("a------------------------------------------------------");
		//a-------------------------------------------------------------------------------------
		
		String[] stringArray = { "Explorer", "Chrome", "Spotify", "GitHub", "Bash", "FireFox" };

		List<String> unmodifiableList = Collections.unmodifiableList(Arrays.asList(stringArray));
		List<String> modifiableList = new ArrayList<String>();
		
		for(String s: stringArray) {
			modifiableList.add(s);
		}

		tryModifiableList(unmodifiableList);
		System.out.println("-------------------------------------------------------");
		tryModifiableList(modifiableList);

		
		//unmodifiableList kann nicht verändert werden Ausgabe: unmodifiale...

		System.out.println("b------------------------------------------------------");
		//b-------------------------------------------------------------------------------------
		
		Dog georg = new Dog("Georg", 52);
		Dog fridulin = new Dog("Fridulin", 64);
		
		DogWrapper dogWrapper = new DogWrapper(georg, fridulin);
		georg.setSize(34);
		
		System.out.println(dogWrapper.getSmallDog().toString());
		
		//c-------------------------------------------------------------------------------------

	
		System.out.println(SensorAggregator.getMax("VPdef (mbar)","01.01.2009 00:00:00" , "01.02.2009 23:50:00"));
	
	}
}
