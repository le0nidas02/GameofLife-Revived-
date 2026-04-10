package assignment11;


/**
 * Error, Ausnahmefall, wenn das Element nicht gefunden werden kann
 */
public class MyNoSuchElementException extends Exception 
{
    
    /**
     * 
     * 
     * @param message die Fehlermeldung
     */
    public MyNoSuchElementException(String message) 
    {
        super(message);
    }
}

