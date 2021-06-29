package org.LyesSnaoui.exo17;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.function.Function;

public class Person {

	
	private int age; 
	private String name; 
	private String fName;
	
	public Person (String n, String fn,int a) {
		this.age = a; 
		this.name = n; 
		this.fName = fn;
	}

	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", fName=" + fName + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public Person() {
	}	
	
	static Function <String, Person> extractPerson = 
			line -> {String[] mots = line.split(", ");
			String lastName = mots[0];String firstName = mots[1]; int age = Integer.parseInt(mots[2]);
			 return new Person(firstName, lastName, age);
		    };
	
    public static Person lineToPerson (String line) {
    	return extractPerson.apply(line);
    }
    
    
    static Function<Person, String> personToString =
 		   person -> person.getName() + ", " +person.getfName() + ", " + Integer.toString(person.getAge()) + "\r\n";

 		   
	public static String personToLine (Person p) {
			return personToString.apply(p);
	}
	
	public byte[] personToArray (Person p) {
		
		try(ByteArrayOutputStream bytePeople = new ByteArrayOutputStream();
		DataOutputStream dataPeople = new DataOutputStream(bytePeople);){
			
			dataPeople.writeUTF(this.getName());
			dataPeople.writeUTF(this.getfName());
			dataPeople.write(this.getAge());
			
			return bytePeople.toByteArray();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}