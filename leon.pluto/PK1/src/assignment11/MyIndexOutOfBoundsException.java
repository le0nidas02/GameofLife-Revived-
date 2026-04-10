package assignment11;


/**
 * Ausnahmefall, der eine Error Message erzegt, wenn der Index ungültig ist
 */
public class MyIndexOutOfBoundsException extends RuntimeException 
{
    
    /**
     * 
     * 
     * @param message die Fehlermeldung
     */
    public MyIndexOutOfBoundsException(String message) 
    {
        super(message);
    }
}
