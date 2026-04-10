package assignment12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


/**
 * Die Klasse ließt Textdateien ein und zählt wie oft ein "Name" vorkommen
 * "Name: Wort mit großem Anfangsbuchstaben, und länger als ein Char"
 */
public class Solution12{

    /**
     * 
     * Liest die Datei, geht jede Zeile durch und gibt die gezählten Namen aus
     * 
     * @param args
     */
    public static void main(String[] args) 
    {
        String filePath = "C:\\Users\\leonp\\OneDrive\\Uni-Studium-Informatik-Bachelor-of-Science\\Programmierkurs 1 (Imperative Sprache)\\Praxis - Visual Studio Code\\Pc-VSC\\Programmierkurs\\private\\leon.pluto\\PK1\\src\\assignment12\\bible";
        //String filePath = "PublicRepo\\bible.txt (wird bei mir nicht angezeigt)";
        Map<String, Integer> nameCounts = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                processLine(line, nameCounts);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        nameCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
    }

    /**
     * Arbeitet durch jede Zeile in der Datei und holt + zählt alle gefundenen Namen
     * Eigenname / Name: Wort das mit einem Großbuchstaben beginnt.
     * 
     * @param line Die zu verarbeitende Zeile
     * @param nameCounts Eine Map, die gefundenen Eigennamen speichert
     */
    private static void processLine(String line, Map<String, Integer> nameCounts) 
    {
        String[] words = line.split("\\s+");
        for (String word : words) 
        {
            word = word.replaceAll("\\p{Punct}", "");
            if (word.length() > 1 && Character.isUpperCase(word.charAt(0))) 
            {
                nameCounts.put(word, nameCounts.getOrDefault(word, 0) + 1);
            }
        }
    }
}