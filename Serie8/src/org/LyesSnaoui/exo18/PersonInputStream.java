package org.LyesSnaoui.exo18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

class PersonInputStream extends FileInputStream {

	private FileInputStream fis;

	public PersonInputStream(FileInputStream f) {
		super(FileDescriptor.in);
		fis = f;
	}

	public List<Person> readFields ()  {

		try (FileInputStream fis = this.fis;
				InputStream bis =new ByteArrayInputStream(fis.readAllBytes());
				DataInputStream dis = new DataInputStream(bis);) {

			int nbrPeople = dis.readInt();

			List<Person> people = new ArrayList<>();
			for (int i = 0 ; i < nbrPeople ; i++) {
				while(dis.available()>0) {
					people.add(new Person(dis.readUTF(), "a", dis.readInt()));
				}
			}
			return people;

		}  catch(EOFException eof) {
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		return null;

	}

	public List<Person> readPeople() {
		
		List <Person> people = new ArrayList<>();

		try (FileInputStream fis = this.fis;
			ObjectInputStream ois = new ObjectInputStream(fis);) {

			int nbrPeople = ois.readInt();
			for (int i=0 ; i<nbrPeople; i++) {
				people.add((Person)ois.readObject());
			}

		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
 
		return null;
	}

}
