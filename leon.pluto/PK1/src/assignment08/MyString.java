package assignment08;
import java.util.Comparator;

/**
 * The MyString class represents a string and provides various methods to analyze it.
 */
public class MyString {
    private String str;

    /**
     * Konstruktor
     * @param str  -- der jeweilige String
     */
    public MyString(String str) {
        this.str = str;
    }

    /**
     * Zählt die vowels in dem String
     * @return nummer der vowels
     */
    public int countVowels() {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * Zählt die Konsonanten in dem String
     * @return nummer der Konsonanten
     */
    public int countConsonants() {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isConsonant(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * Gibt die Länge des Strings aus
     * @return die Länge des Strings als integer
     */
    public int getLength() {
        return str.length();
    }

    /**
     * Überprüft ob der String ein Palindrom ist
     * @return true, wenn es ein Palindrom ist -- sonst false
     */
    public boolean isPalindrome() {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            char leftChar = Character.toLowerCase(str.charAt(left));
            char rightChar = Character.toLowerCase(str.charAt(right));
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 
     * @return ausgabe der Inforationen des Strings + meta infos
     */
    public String toString() {
        return "String beinhaltet: \"" + str + "\" | Länge: " + getLength() + " | Vokale (Vowels): " + countVowels() + " | Consonants: " + countConsonants(); // "Content of the String with some meta information"
    }

    /**
     * Überprüft, ob der zu vergleichende Character ein Vokal ist
     * @param a der zu überprüfende char (Buchstabe)
     * @return true wenn der Buchstabe ein Vokal ist
     */
    private boolean isVowel(char a) {
        char lowerA = Character.toLowerCase(a);
        return lowerA == 'a' || lowerA == 'e' || lowerA == 'i' || lowerA == 'o' || lowerA == 'u';
    }

    /**
     * Überprüft ob der Char ein Konsonant ist
     * @param a zu überprüfende Buchstabe
     * @return true wenn der Buchstabe ein Konsonant ist, sonst false
     */
    private boolean isConsonant(char a) {
        char lowerA = Character.toLowerCase(a);
        return (lowerA >= 'a' && lowerA <= 'z') && !isVowel(lowerA);
    }

    /**
     * Berechnet die Summe of the der Dezimal Werte von allen Charactern im String.
     * @return die Summe aller Chars
     */
    public int sumOfCharacterValues() {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i);
        }
        return sum;
    }

    /**
     * sammelt alle bisherigen Informationen in den neuen String um ihn auszugeben
     * @return den String inhalt
     */
    public String getStr() {
        return str;
    }
}

/**
 *
 */
class MyStringComparator implements Comparator<MyString> {
    /**
     * vergleicht die MyString instanzen um sie zu sortieren
     * @param s1 1. MyString instanz
     * @param s2 2. MyString instanz
     * @return den neuen String sortiert, zuerst nach der Länge, (falls gleiche Länge, nach ANzahl der Vokale, falls auch gleich, nach dem Dezimal Wert des Strings)
     */
    public int compare(MyString s1, MyString s2) {
        int lengthComparison = Integer.compare(s1.getLength(), s2.getLength());
        if (lengthComparison != 0) {
            return lengthComparison;
        }

        int vowelComparison = Integer.compare(s1.countVowels(), s2.countVowels());
        if (vowelComparison != 0) {
            return vowelComparison;
        }

        return Integer.compare(s1.sumOfCharacterValues(), s2.sumOfCharacterValues());
    }
}
