
public class Person implements Comparable<Person> {

	private int age;
	
	public Person(int age)
	{
		this.age = age;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public int compareTo(Person obj)
	{
		return age - obj.getAge();
	}
	
	public String toString()
	{
		return age + " years";
	}
}
