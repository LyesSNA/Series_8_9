package org.LyesSnaoui.exo17;

import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class PersonOutputStream extends FileOutputStream{
	
	private FileOutputStream f;
	
	public PersonOutputStream(FileOutputStream f) {
		super(FileDescriptor.in);
		this.f = f;
	}
	
	public void writeFields (List<Person> people)  {
		
			try (FileOutputStream fos = this.f;
				 DataOutputStream bos = new DataOutputStream(fos);) {
				bos.writeInt(people.size());

					for (Person p : people) {
						bos.write(p.personToArray(p));
					}
					
				} catch (IOException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				} 
		
	}

}
