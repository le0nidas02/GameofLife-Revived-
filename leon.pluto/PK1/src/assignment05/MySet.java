package assignment05;

import java.util.Arrays;

public class MySet 
{
    private double[] elements;

    
    public MySet() // Constructor für ein leeres Set
    {
        elements = new double[0];
    }

    
    public MySet(double... initialValues) // Constructor mit enthaltenen Elementen
    {
        
        elements = removeDuplicates(initialValues);  // entfernt duplicates aus den Integern
    }

    
    public boolean addElement(double value) // added ein Element
    {
       
        if (indexOf(value) != -1)  // Check ob das Element schon existiert
        {
            return false; // 
        }

        
        double[] newElements = Arrays.copyOf(elements, elements.length + 1);   // Erstellt ein neues Array
        newElements[elements.length] = value; // Added neue Elemente ans Ende
        elements = newElements; // Updates das Array
        orderSet(); // Sort the set --> Bubble Sort
        return true; // 
    }

    public boolean removeElement(double value)     // Entfernt ein Element vom Set

    {
        int index = indexOf(value);
        if (index == -1) 
        {
            return false; // Falls das Element nicht gefunden wurde return false
        }

        double[] newElements = new double[elements.length - 1];        // erstellt ein neues Array ohne das Element was entfernt werden soll

        for (int i = 0, j = 0; i < elements.length; i++) 
        {
            if (i != index) 
            {
                newElements[j++] = elements[i];
            }
        }
        elements = newElements; // Updates das Array
        return true; // Element wurde erfolgreich entfernt
    }

    public String getStringRepresentation()     // ähnlich aufgebaut wie vorheriges "Append to array"

    {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < elements.length; i++) 
        {
            sb.append(elements[i]);
            if (i < elements.length - 1) 
            {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public int getSetSize()     // returnt die Größe des Elements

    {
        return elements.length;
    }

    public boolean isEmpty()     // check ob das Set leer ist

    {
        return elements.length == 0;
    }

    private int indexOf(double value)     // Findet den Index eines Elements

    {
        for (int i = 0; i < elements.length; i++) 
        {
            if (elements[i] == value) 
            {
                return i;
            }
        }
        return -1; // Element not found
    }

    private double[] removeDuplicates(double[] array)     // Removed Dublicates vom Array

    {
        MySet tempSet = new MySet();
        for (double value : array) 
        {
            tempSet.addElement(value);
        }
        return tempSet.elements;
    }

    
    private void orderSet() // Bubble Sort Algorythmus
    {
        for (int i = 0; i < elements.length - 1; i++) 
        {
            for (int j = 0; j < elements.length - i - 1; j++) 
            {
                if (elements[j] > elements[j + 1]) 
                {
                    
                    double temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }
}
