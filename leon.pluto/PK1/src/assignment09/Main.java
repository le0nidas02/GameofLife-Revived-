package assignment09;

public class Main 
{


// Test zum ausführen
    public static void main(String[] args) {
        Tree a = new Tree(new Person("a"));
        Tree b = new Tree(new Person("b"));
        Tree c = new Tree(new Person("c"));
        Tree abc = new Tree(new Person("abc"), a, b, c);
        Tree d = new Tree(new Person("d"));
        Tree e = new Tree(new Person("e"));
        Tree de = new Tree(new Person("de"), d, e);
        Tree abcde = new Tree(new Person("abcde"), abc, de);
        Tree f = new Tree(new Person("f"));
        Tree g = new Tree(new Person("g"));
        Tree root = new Tree(new Person("abcdefg"), abcde, f, g);

        FamilyTree tree = new FamilyTree(root);
        System.out.println("\n------------------------------ Gibt Children aus: ------------------------------");
        tree.printChildren("abcde"); // ---> Sollte :" abc, de " ausgeben
        System.out.println("\n------------------------------ Gibt Siblings aus: ------------------------------");
        tree.printSiblings("d"); //  ---> Sollte : "e"  ausgeben 
        System.out.println("\n------------------------------ Gibt alle Nachkommen aus: ------------------------------");
        tree.printAllDescendants("abcde"); // ---> Sollte "alle Nachkommen von abcde" ausgeben
        System.out.println("\n------------------------------ Gibt alle Vorfahren aus: ------------------------------");
        tree.printAncestors("de"); // ---> Sollte: "abcde, abcdefg" ausgeben 
    }
}