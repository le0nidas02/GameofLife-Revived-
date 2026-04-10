package assignment08;

import java.util.Arrays;


public class Solution08 {
    public static void main(String[] args) {
        // Initialisiert den Array mit den 7 MyString instanzen (welche Zusammengefügt werden)
        MyString[] strings = {
            new MyString("Test1"),
            new MyString("TeST1"),
            new MyString("Test2"),
            new MyString("abc"),
            new MyString("cde"),
            new MyString("irgendwas"),
            new MyString("NochmalWas12#")
        };

        // Gibt den unsortierten Array mit allen neuen Meta daten aus
        System.out.println("Unsortierter array:");
        for (MyString s : strings) {
            System.out.println(s + " | Summe der Charaktere: " + s.sumOfCharacterValues());
        }

        // Sortiert den Array
        Arrays.sort(strings, new MyStringComparator());

        // Gibt den Array sortiert aus
        System.out.println("\nSortierter array:");
        for (MyString s : strings) {
            System.out.println(s + " | Summe der Charaktere: " + s.sumOfCharacterValues());
        }
    }
}