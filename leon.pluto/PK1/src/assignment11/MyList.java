package assignment11;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * implementierung von einer Liste (Linked list)
 * 
 * @param <E>
 */
public class MyList<E> extends LinkedList<E> 
{
    
    /**
     * Gibt die Liste als String dargestellt zurück
     * 
     * @return den String
     */
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder("[");
        for (E element : this) {
            sb.append(element).append(", ");
        }
        if (sb.length() > 1) sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    /**
     * Entfernt das gesuchte Element an der 1. stelle an der es vorkommt
     * 
     * @param element das zu entfernende Element
     * @throws MyNoSuchElementException wenn das Element nicht gefunden wird
     */
    public void removeElement(E element) throws MyNoSuchElementException 
    {
        boolean removed = false;
        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            if (it.next().equals(element)) 
            {
                it.remove();
                removed = true;
                break;
            }
        }
        if (!removed) 
        {
            throw new MyNoSuchElementException("Element " + element + " nicht gefunden");
        }
    }

    /**
     * Gibt den Index des ersten Vorkommens des angegebenen Element zurück
     * 
     * @param element das zu suchende Element
     * @return der Index des ersten Vorkommens des Elements
     * @throws MyNoSuchElementException wenn das Element nicht gefunden wird
     */
    public int getIndex(E element) throws MyNoSuchElementException 
    {
        int index = 0;
        for (E e : this) 
        {
            if (e.equals(element)) 
            {
                return index;
            }
            index++;
        }
        throw new MyNoSuchElementException("Element " + element + " nicht gefunden");
    }

    /**
     * Gibt das Element am angegebenen Index zurück.
     * 
     * @param i der Index vom Element
     * @return das Element am angegebenen Index
     * @throws MyIndexOutOfBoundsException wenn der Index ungültig ist
     */
    public E getElement(int i) throws MyIndexOutOfBoundsException 
    {
        if (i < 0 || i >= this.size()) 
        {
            throw new MyIndexOutOfBoundsException("Index: " + i + ", Größe: " + this.size());
        }
        return this.get(i);
    }
}
