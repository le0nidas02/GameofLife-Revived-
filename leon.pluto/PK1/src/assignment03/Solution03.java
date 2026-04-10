package assignment03;
import java.util.*;
public class Solution03 
{

    public static void main(String[] args) 
    {

        // Task 1 (0.5 points)                                                  //.
        System.out.println("\n---------Task 1---------");

        System.out.println("Ergebnis = " + square(5));



        // Task 2 (1.5 points)
        System.out.println("\n---------Task 2---------");

        int[] array = {1, 2, 3, 5, 6, 7, 8};
        int value = 5;
        System.out.println("Gesuchter Wert: " + value);
        if(linearSearch(array,value)){
            System.out.println("Wert ist im Array");
        }
        else{
            System.out.println("Wert ist nicht im Array");
        }



        // Task 3 (2 points)
        System.out.println("\n---------Task 3---------");

        int[] originalerArray = {1, 2, 3, 4, 5};
        int hinzuzufügendesElement = 10123;
        int[] neuerArray = appendToArray(originalerArray, hinzuzufügendesElement);
        System.out.println("Hinzuzufügendes Element: " + hinzuzufügendesElement);
        System.out.println(Arrays.toString(neuerArray));        // google hat geholfen wie man Arrays im Sysout ausgibt ohne dass da nur irgend etwas mit dem Hashwert ausgegeben wird --> importiert automatisch eine libary


        // Task 4 (2.5 points)
        System.out.println("\n---------Task 4---------");

        int wert = 123;
        System.out.println("Eingabe: " + wert);
        int result = sumUpValues(wert);

        System.out.println("Ergebnis der quadrierten Werte jeder Zahl " + wert + " = " + result);
        

        // Task 5 (1.5 points)
        System.out.println("\n---------Task 5---------");
        value = 42;
       if(isHappyNumber(value)){
        System.out.println("Die Zahl " + value + " ist eine Happy Number");
       }
       else{
        System.out.println("Die Zahl " + value + " ist keine Happy Number");
       }


    }



    // Ich hab eine allgemeine Frage zu meinem Stil: "Korrektes einrücken bei Blöcken" wird ja gefordert, ist es so wie ich es bisher gemacht habe korrekt? (ich setze z.B. die erste geschweifte Klammer nicht direkt in der Zeile der Methode an, sondern direkt darunter was es für mich ein Stück leichter macht den Überblick zu behalten, auf welcher Höhe zwei zusammen gehörende Klammern sind anstatt die erste oben neben der Methode und die anderen unten nach der Methode richtig eingerückt)


    //------------------------------------------Task1------------------------------------------

    /**
     * Quadriert den eingegebenen Wert
     * 
     * @param value - Der integer Wert der quadriert werden soll
     * @return - Der Quadrierte Wert
     */
    public static int square(int value)                                             //<--
    {                                                                               //<-- hier z.B. zur Frage "Korrektes einrücken bei Blöcken, da sie ja normalerweise in der Zeile drüber sein sollte"
        //System.out.println("Wert der Quadriert werden soll: " + value);
        return value * value;       // Rechnung value²
    }



    
    
    //------------------------------------------Task2------------------------------------------

    /**
     * Lineare Suche, in dem festgelegten Array, nach dem in der Main Methode festgelegten Wert:
     * 
     * @param array Das gegebene Array
     * @param value Der Wert nach dem die Methode sucht
     * @return true wenn der Wert im array gefunden wurde, sonst false
     */
    public static boolean linearSearch(int[] array, int value) 
    {
        
        for (int i = 0; i < array.length; i++) // Iteriert durch den Array in 1er schritten
        {
            if (array[i] == value) 
            {
                return true; // Wenn der gesuchte Wert gefunden wurde: true
            }
        }
        return false; // Wenn der gesuchte Wert nicht gefunden wurde: false
    }



    //------------------------------------------Task3------------------------------------------

    /**
     * Fügt ein Element an das Ende des bisherigen Arrays ein.
     * 
     * @param array   Bisheriger Array.
     * @param element Hinzuzufügendes Element.
     * @return Neues Array mit hinzugefügtem Element an letzter Stelle.
     */
   public static int[] appendToArray(int[] array, int element)
 
    {
        
        int[] neuerArray = new int[array.length + 1]; // Step 1: Initialisiert ein neues Array, was 1 länger ist als der originale
        
        
        for (int i = 0; i < array.length; i++)  // Kopiert alle bisherigen Elemente in den neuen Array schritt für Schritt
        {
            neuerArray[i] = array[i];
        }
        
       
        neuerArray[neuerArray.length - 1] = element; // Fügt das neue Element an die letzte Stelle im neuen Array hinzu
        
        return neuerArray; // Gibt den neuen (längeren) array aus
    }


    //------------------------------------------Task4------------------------------------------

    /**
     * Summiert die quadrierten Werte der einzelnen Zahlen
     * 
     * @param wert input Wert (int)
     * @return Die Summe der quadrierten Werte der einzelnen Zahlen
     */
    public static int sumUpValues(int value) 
    {      
        int summe = 0;

        
        while (value != 0)              // Step 3: Wiederholen bis es keine Ziffern mehr gibt
        {
            int zahl = value % 10;      // Step 1: Holt den Wert einer Ziffer der Zahl raus
            summe += square(zahl);      // Step 2: square() die Zahl und fügt sie zur gesammt Summe hinzu
            value /= 10;                // Entfernt die letzte Ziffer der Nummer
        }

        
        return summe;                  // Gibt das Ergebnis aus
    }



    public static boolean isHappyNumber(int value)
    {
        int[] intArray = {};
        
        while(linearSearch(intArray, value) == false)
        { 
            if(value == 1)
            {
                return true;
            }

            intArray = appendToArray(intArray, value);   // dieses "intArray =" hat mich circa 3 stunden gekostet einfach weil ich vergessen habe es hinzuschreiben und ich somit eine endlosschleife erzeugt habe :) (egal problem solved)
            value = sumUpValues(value); 
        } 
        return false;
    }





}

