
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String id;
    private String name;
    private String email;

    /**
     * Constructor for objects of class Person
     */
    public Person(String id, String name, String email)
    {
        // initialise instance variables
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public String getCurrentName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getID()
    {
        return id;
    }
}
