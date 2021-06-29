package org.LyesSnaoui.exo16;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.LyesSnaoui.exo18.Person;

public class PersonReader extends Person{

	public static List<Person> read (String filename){

		File people = new File(filename);

		try (Reader read = new FileReader(people);
				BufferedReader br = new BufferedReader(read);){

			List<Person> containsPeople = br.lines().filter(line -> !line.startsWith("#"))
													.map(l -> Person.lineToPerson(l))
													.collect(Collectors.toList());
			
			return containsPeople;
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	} 

}