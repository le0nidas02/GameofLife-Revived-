package assignment11;

public class Solution11 
{


    //Test vom programm.
    public static void main(String[] args) 
    {
        MyList<String> list = new MyList<>();
        list.add("Klaus");
        list.add("Petra");
        list.add("Noah");
        System.out.println(list); // [Klaus, Petra, Noah]

        try 
        {
            list.removeElement("Clara");
        } catch (MyNoSuchElementException e) 
        {
            e.printStackTrace();
        }

        try {
            System.out.println(list.getElement(5));
        } catch (MyIndexOutOfBoundsException e) 
        {
            e.printStackTrace();
        }
    }
}
