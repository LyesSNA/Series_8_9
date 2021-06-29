package org.LyesSnaoui.exo18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class io18_Main {


	public static void main(String[] args) {

		List <Person> peopleToWrite = List.of(new Person ("Julien", "Clerc", 70),
				new Person ("Jacques", "Brel", 60),
				new Person ("Edith", "Piaf", 60));

		String file = "./files/PeropleExo18.bin";

		try(PersonOutputStream pos = new PersonOutputStream(new FileOutputStream(file))){

			pos.writePeople(peopleToWrite);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("ecrture OK");

		try(PersonInputStream pis = new PersonInputStream(new FileInputStream(file))){

			System.out.println("liste = " + pis.readPeople());

		} catch (IOException e) {
			e.printStackTrace();
		}

	} 
}
