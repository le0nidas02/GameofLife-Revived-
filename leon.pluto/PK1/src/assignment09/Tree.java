package assignment09;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse für eine Node im Family Tree
 */
public class Tree {
    private Person data;
    private List<Tree> children;
    private Tree parent;

    /**
     * Initialisiert eine Tree Node 
     * @param data Person die in der Node gespeichert wird
     * @param children Child nodes von der jeweiligen Node
     */
    public Tree(Person data, Tree... children) 
    {
        this.data = data;
        this.children = new ArrayList<>();
        this.parent = null;
        for (Tree child : children) 
        {
            this.addChild(child);
        }
    }

    /**
     * Adde ein Child zu der jeweiligen Node
     * @param child Child node die added wird
     */
    public void addChild(Tree child) 
    {
        child.setParent(this);
        this.children.add(child);
    }

    public Person getData() 
    {
        return data;
    }

    public List<Tree> getChildren() 
    {
        return children;
    }

    public Tree getParent() 
    {
        return parent;
    }

    private void setParent(Tree parent) 
    {
        this.parent = parent;
    }
}
