package assignment09;

import java.util.ArrayList;
import java.util.List;

/**
 * Erstellung der Klasse (family Tree)
 */
public class FamilyTree {
    private Tree root;

    /**
     * initilalisieren den Familiy Tree mit einer  root node.
     * @param root Die Root node
     */
    public FamilyTree(Tree root) 
    {
        this.root = root;
    }

    /**
     * Überprüft, ob schon eine Person mit dem Namen gespeichert ist
     * @param name Name der Person
     * @return true wenn die Person gefunden wurde, sonst false
     */
    public boolean containsName(String name) 
    {
        return containsName(root, name);
    }

    private boolean containsName(Tree node, String name) 
    {
        if (node.getData().getName().equals(name)) 
        {
            return true;
        }
        for (Tree child : node.getChildren()) 
        {
            if (containsName(child, name)) 
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Printed die Namen von allen personen die schon im Family Tree gespeichert sind
     */
    public void printAllEntries() 
    {
        printAllEntries(root);
    }

    private void printAllEntries(Tree node) 
    {
        System.out.println(node.getData().getName());
        for (Tree child : node.getChildren()) 
        {
            printAllEntries(child);
        }
    }

    /**
     * Gibt die Namen der Kinder einer Person aus
     * @param name Name der Person
     */
    public void printChildren(String name) 
    {
        Tree node = findNode(root, name);
        if (node != null) 
        {
            for (Tree child : node.getChildren()) 
            {
                System.out.println(child.getData().getName());
            }
        }
    }

    /**
     * Gibt die Nachkommen einer Person aus
     * @param name Name der Person
     */
    public void printAllDescendants(String name) 
    {
        Tree node = findNode(root, name);
        if (node != null) 
        {
            printAllEntries(node);
        }
    }

    /**
     * Gibt die Vorfahren einer Person aus
     * @param name Name der Person
     */
    public void printAncestors(String name)
    {
        Tree node = findNode(root, name);
        List<String> ancestors = new ArrayList<>();
        while (node != null && node.getParent() != null) 
        {
            node = node.getParent();
            ancestors.add(node.getData().getName());
        }
        for (String ancestor : ancestors) 
        {
            System.out.println(ancestor);
        }
    }

    /**
     * Gibt die Geschwister der Person aus
     * @param name Name der Person
     */
    public void printSiblings(String name) 
    {
        Tree node = findNode(root, name);
        if (node != null && node.getParent() != null) 
        {
            for (Tree sibling : node.getParent().getChildren()) 
            {
                if (!sibling.getData().getName().equals(name)) 
                {
                    System.out.println(sibling.getData().getName());
                }
            }
        }
    }

    private Tree findNode(Tree node, String name) 
    {
        if (node.getData().getName().equals(name)) 
        {
            return node;
        }
        for (Tree child : node.getChildren()) 
        {
            Tree result = findNode(child, name);
            if (result != null) 
            {
                return result;
            }
        }
        return null;
    }
}
