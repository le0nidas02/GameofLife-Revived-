package test;
public class decideTheCellFate{
    public static void main(String[] args){
        decideCellFate(false, 3);
    }

    public static boolean decideCellFate(boolean cellAlive, int liveNeighbors)
    {
        // Wenn Zelle lebt:
        if (cellAlive)
        {
            if (liveNeighbors < 2 || liveNeighbors > 3) {
                System.out.println("Zelle tot");
                return false;
            }
            else {
                System.out.println("Zelle lebt");
                return true;
            }
        }

        // Wenn Zelle nicht lebt:
        else{
            if (liveNeighbors == 3){
                System.out.println("Zelle lebt");
                return true;
            }
            else {
                System.out.println("Zelle tot");
                return false;
            }
        }
    }
}