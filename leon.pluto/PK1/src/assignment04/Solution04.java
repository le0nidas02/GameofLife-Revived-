package assignment04;
import java.util.*;
public class Solution04
{

    public static void main(String[] args) 
    {

        // Task 1 (0.5 points)                                                  //.
        System.out.println("\n---------Task 1---------");

        System.out.println("Ergebnis = " + square(5));



        // Task 2 (1.5 points)
        System.out.println("\n---------Task 2---------");

        int[] array = {1, 2, 3, 5, 6, 7, 8};
        int value = 4;
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
        value = 49;
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
     * Lineare Suche, in dem festgelegten Array, nach dem in der Main Methode festgelegten Wert: (REKURSIV)
     * 
     * @param array Das gegebene Array
     * @param value Der Wert nach dem die Methode sucht
     * @return true wenn der Wert im array gefunden wurde, sonst false
     */
    public static boolean linearSearch(int[] array, int value) 
    {
        // Wenn nach Überprüfung des gesammten Arrays keine Zahlen zum überprüfen übrig sind d.h. keine Stellen mehr abgeschnitten werden können, so wurde das Element "value" nicht im Array "Array" gefunden
        if (array.length == 0)
        {
            return false;
        }
        if(value == array[array.length -1]) // Überprüft das letzte Element im Array
        {
            return true;
        }

        else {
            // Klont das alte array auf ein neues, welches das schon überprüfte Element aka. das letzte nicht mehr beinhaltet
            int[] newArray = new int[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, array.length - 1); // den arraycopy befehlt musste ich durch googeln rausfinden
            // Ruft die Funktion rekursiv mit dem neuen Array auf
            return linearSearch(newArray, value);
        }
        
    }



    //------------------------------------------Task3------------------------------------------

    /**
     * Fügt ein Element an das Ende des bisherigen Arrays ein.
     * 
     * @param array   Bisheriger Array.
     * @param element Hinzuzufügendes Element.
     * @return Neues Array mit hinzugefügtem Element an letzter Stelle.
     */
    public static int[] appendToArray(int[] array, int element) {
        if (array.length == 0) {            // Falls das Array leer sein sollte wird ein neues erstellt
            int[] newArray = {element};     
            return newArray;                // hierfür wird noch keine Rekursion benötigt
        } else {
            int[] newArray = new int[array.length + 1]; // Falls der Array nicht leer ist: Erstellt einen neuen (1 Stelle größer)
            
            System.arraycopy(array, 0, newArray, 0, array.length); // kopiert den alten auf den neuen Array
            
            newArray[newArray.length - 1] = element;    // setzt an der letzten Stelle (bisher unbeschrieben) das vorgegebene Element ein
            
            return newArray; // Return vom neuen Array
        }
    }


    //------------------------------------------Task4------------------------------------------

    /**
     * Summiert die quadrierten Werte der einzelnen Zahlen
     * 
     * @param wert input Wert (int)
     * @return Die Summe der quadrierten Werte der einzelnen Zahlen
     */
    public static int sumUpValues(int value) {
        
        if (value == 0) {       // Falls der Wert 0 ist, ist die Summe 0
            return 0;
        } else {
            int zahl = value % 10; // Holt den Wert einer Ziffer der Zahl raus
            int summe = square(zahl) + sumUpValues(value / 10); // square() die Zahl und fügt sie zur gesamten Summe hinzu
            return summe;
        }
    }


// Ist noch die alte Version, an der neuen bin ich noch am arbeiten, habe es leider jetzt zeitlich nicht fertig bekommen!
    public static boolean isHappyNumber(int value)
    {
        int[] intArray = {};
        
        while(linearSearch(intArray, value) == false)
        { 
            if(value == 1)
            {
                return true;
            }

            intArray = appendToArray(intArray, value);   
            value = sumUpValues(value); 
        } 
        return false;
    }


}

