package assignment05;

public class Solution05 {
    public static void main(String[] args) {
        // Initialize 3 sets
        MySet set1 = new MySet(1, 2, 3, 2.3, 2.05 - 0.05); // using double values
        MySet set2 = new MySet(new double[]{1, 2, 3, 4}); // using an array
        MySet set3 = new MySet(); // empty

        // Check whether sets are empty
        System.out.println("Set1 is empty: " + set1.isEmpty());
        System.out.println("Set2 is empty: " + set2.isEmpty());
        System.out.println("Set3 is empty: " + set3.isEmpty());

        // Add elements to set3
        set3.addElement(30.3);
        set3.addElement(30.1);
        set3.addElement(30);

        // Remove elements from sets
        set1.removeElement(100);
        set1.removeElement(1000);
        set3.removeElement(30);

        // Print the size of the sets
        System.out.println("Set1 size: " + set1.getSetSize());
        System.out.println("Set2 size: " + set2.getSetSize());
        System.out.println("Set3 size: " + set3.getSetSize());
        System.out.print("Set1: ");
        System.out.println(set1.getStringRepresentation());
        System.out.print("Set2: ");
        System.out.println(set2.getStringRepresentation());
        System.out.print("Set3: ");
        System.out.println(set3.getStringRepresentation());
    }
}
