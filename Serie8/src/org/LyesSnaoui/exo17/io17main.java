package org.LyesSnaoui.exo17;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class io17main {

	public static void main(String[] args) {

		
		List <Person> peopleToWrite = List.of(new Person ("Julien", "Clerc", 70),
										new Person ("Jacques", "Brel", 60),
										new Person ("Edith", "Piaf", 60));
	
	
		String file = "files/peopleExo17.bin";
		
		try(PersonOutputStream pos = new PersonOutputStream(new FileOutputStream(file));){
			
			pos.writeFields(peopleToWrite);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		List<Person> readPeople = new ArrayList<>();
		
		try(PersonInputStream pis = new PersonInputStream(new FileInputStream(file));){
			
			readPeople = pis.readFields();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println(readPeople);
		
	}

}
