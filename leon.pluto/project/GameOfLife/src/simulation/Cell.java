package simulation;
public class Cell {

    
    public static final int DEAD = 0;       // Möglicher Status einer Zelle, entweder DEAD / ALIVE --> 0 / 1
    public static final int ALIVE = 1;

//-------------------------------------------------------------------------------------Constructor-------------------------------------------------------------------------------------                          
    private int status;                     // Private Status der Zelle

    
    public Cell() {                         // Konstruktor ohne Parameter, der die Zelle auf DEAD setzt
        this.status = DEAD;
    }

    
    public Cell(int status) {               // Konstruktor, der den Status durch Parameter setzt --> default ist also immer auf DEAD, außer extra auf Alive gesetzt
        if (status != DEAD && status != ALIVE) 
        {    // Falls ein falscher Parameter benutzt wird --> Error
            throw new IllegalArgumentException("Invalid status value");
        }
        this.status = status;
    }

//-----------------------------------------------------------------------------------------Methoden-------------------------------------------------------------------------------------
    public void setStatus(int status) 
    {                 // Methode um den Status mauell zu setzen
        if (status != DEAD && status != ALIVE) 
        {        //wieder ein Error check
            throw new IllegalArgumentException("Invalid status value");
        }
        this.status = status;
    }

    
    public int getStatus() 
    {                    // Methode zum Abrufen des aktuellen Status (optional, falls benötigt)
        return status;
    }

    
    @Override
    public String toString() 
    {                  // Methode zum Ausgeben des Status als String
        return (status == ALIVE) ? "#" : ".";   // Das Fragezeichen steht basically für if Else --> If status == alive --> # else .
    }

    // Main-Methode zum Testen der Klasse (optional)
    public static void main(String[] args) 
    {
        Cell cell1 = new Cell();
        Cell cell2 = new Cell(ALIVE);

        System.out.println("cell1: " + cell1); // Sollte "." ausgeben
        System.out.println("cell2: " + cell2); // Sollte "#" ausgeben

        cell1.setStatus(ALIVE);
        System.out.println("cell1 nach Statusänderung: " + cell1); // Sollte "#" ausgeben
        System.out.println("Status der Zelle1: " + cell1.getStatus());
    }
}