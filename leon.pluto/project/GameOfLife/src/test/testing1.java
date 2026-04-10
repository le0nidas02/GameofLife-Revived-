package test;

public class testing1{
    public static void main(String[] args){
//------------------------------------------------------------------------------------------------------------- Map Gebaut -----------------------------------------------------------------------------------------------------

        // 2D Array Erstellt mit variabler größe (denke ich mal sollte besser sein)
        int size = 5;
            boolean[][] map = new boolean[size][size];

        // Manuell ein Paar Zellen auf lebendig (true gesetzt)
        map[1][2] = true;  // Zelle (2,1) lebt       
        map[2][3] = true;  // Zelle (3,2) lebt
        map[3][3] = true;  // Zelle (3,3) lebt
        map[3][2] = true;  // Zelle (2,3) lebt
        map[3][1] = true;  // Zelle (1,3) lebt

        // Map[y][x]

//------------------------------------------------------------------------------------------------------------- Map Printed -----------------------------------------------------------------------------------------------------

        // Print Map:
        System.out.println("Old Map:\n");
        printMap(map);
        System.out.println("New Map:\n");
//---------------------------------------------------------------------------------------------------------Regeln auf alle Zellen -----------------------------------------------------------------------------------------------------
        boolean[][] mapNew = new boolean[size][size];
    for (int posY = 0; posY < map.length; posY++){                                                 
        for (int posX = 0; posX <map[posY].length; posX++){                    
            mapNew[posY][posX] = applyRule(posX,posY, map);
        }
    }
    printMap(mapNew);
//-------------------------------------------------------------------------------------------------------------  -----------------------------------------------------------------------------------------------------

    }

//----------------------------------------------------------------------------------printMap------------------------------------------------------------------------------------------

    /**
     * @param map Input: erzeugte Map, Output: Printed die Map in die Konsole mit (# = Alive), (. = Dead)
     */
    public static void printMap(boolean[][] map){
        for (int i = 0; i < map.length; i++){           // iteriert durch die ganze Map 
            for (int j = 0; j < map[i].length; j++){    //                                 
                if(map[i][j]){                          //Wenn die Zelle lebendig ist Print: #
                    System.out.print("#");            
                }
                    else {
                        System.out.print("O");        //Wenn die Zelle tot ist Print: .
                    }
            }
            System.out.println();
        }

    } 

//---------------------------------------------------------------------------------countLiveNeighbors-------------------------------------------------------------------------------------

    /**
     * @param posX Position auf der X Achse auf der Map, der zu überprüfenden Zelle
     * @param posY Position auf der Y Achse auf der Map, der zu überprüfenden Zelle
     * @param map  Boolean (Array Array --> double Array?) aka. unsere 2D Map bestehend aus Positionen mit Boolean Werten, (true = alive), (false = tot).
     * @return Anzahl der lebenden Nachbarn (?/8)
     */
    public static int countLiveNeighbors(int posX, int posY, boolean[][] map){
        int liveNeighborsCount = 0;
        int numRows = map.length;
        int numCols = map[0].length;

        //Iteriert durch die Map
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Überspringt die Zelle selbst
                if (i == 0 && j == 0) {
                    continue;
                }
    
                int newY = posY + i;
                int newX = posX + j;
    
                // Überprüft, ob die neue Position innerhalb der Array-Grenzen liegt
                if (newY >= 0 && newY < numRows && newX >= 0 && newX < numCols) {
                    // Zählt nur lebende Nachbarn
                    if (map[newY][newX]) {
                        liveNeighborsCount += 1;
                    }
                }
            }
        }
        return liveNeighborsCount;
    }

//-----------------------------------------------------------------------------------------applyRule---------------------------------------------------------------------------------

    public static boolean applyRule(int posX, int posY, boolean[][] map){
        boolean cellAlive = map[posY][posX];
        int liveNeighbors = countLiveNeighbors(posX, posY, map);
        
    
        // Wenn Zelle lebt:
        if (cellAlive)
        {
            if (liveNeighbors < 2 || liveNeighbors > 3) {
                return false;
            }
            else {
                return true;
            }
        }

        // Wenn Zelle nicht lebt:
        else{
            if (liveNeighbors == 3){
                return true;
            }
            else {
                return false;
            }
        }
    }
}
