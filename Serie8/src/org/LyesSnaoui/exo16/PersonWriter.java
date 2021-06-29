package org.LyesSnaoui.exo16;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.LyesSnaoui.exo18.Person;

public class PersonWriter {
	
	public static void writing(List<Person> people, String fileName){
		
		
		File myPeople = new File (fileName);
		
		try(Writer writer = new FileWriter (myPeople);) {
			
			writer.write("# LastName, firstName, age \n");
			
			for (Person p : people) {
				writer.write(Person.personToLine(p));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
