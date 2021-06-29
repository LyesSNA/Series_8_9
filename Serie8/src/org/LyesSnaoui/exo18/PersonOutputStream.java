package org.LyesSnaoui.exo18;

import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

	public void writePeople (List<Person> peopleToWrite) {

		try (FileOutputStream fos = this.f;
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeInt(peopleToWrite.size());

			for (Person p : peopleToWrite) {
				oos.writeObject(p);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 

	}

}
