package org.LyesSnaoui.exo16;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

import org.LyesSnaoui.exo18.Person;

public class ioMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List personnes = PersonReader.read("files/person.txt");
		
		System.out.println(personnes);
		
		
		Person p1 = new Person ("Claire", "xxx", 26);
		Person p2 = new Person ("Hassan", "Diop", 28);
		Person p3 = new Person ("Arsen", "Lupin",27);
		
		List people = List.of(p1,p2,p3);
		
		PersonWriter.writing(people, "files/nouveau.txt");
		
	}

}
