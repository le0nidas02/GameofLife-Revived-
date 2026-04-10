package assignment09;

/**
 * Personen Klasse
 */
public class Person 
{
    private final String name;

    /**
     * Initialisieren mit einem Namen für die Person                    
     * @param name Name der person
     */
    public Person(String name) 
    {
        this.name = name;
    }


    
    /**
     * Abfrage vom Namen                                  --> Getter
     * @return Name der Person
     */
    public String getName() 
    {
        return name;
    }
}
