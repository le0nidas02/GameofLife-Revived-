package simulation;

public class ConwayRules {

    //-------------------------------------------------------------------------------------Methoden-------------------------------------------------------------------------------------                          


    public GameMap applyRule(GameMap map)               //Methode um die Regeln auf alle Zellen anzuwenden (Bekommt die Map mit geliefert)
    {
        int width = map.getWidth();             //Map sizes
        int height = map.getHeight();
        GameMap newMap = new GameMap(width, height);    //Erstellt eine neue Map mit der gleichen Größe

        for (int x = 0; x < width; x++) 
        {
            for (int y = 0; y < height; y++)        //läuft über die ganze Map rüber
            {
                int liveNeighbors = countLiveNeighbors(map, x, y);  //count Neighbors Methode wird benutzt
                if (map.getCell(x, y).getStatus() == Cell.ALIVE)    // wendet alle Regeln an, abhängig von lebenden Nachbar-Zellen
                {
                    if (liveNeighbors < 2 || liveNeighbors > 3)     // Zelle stirbt, wenn mehr als 3 oder weniger als 2 nachbarn leben
                    {
                        newMap.getCell(x, y).setStatus(Cell.DEAD);    // status wird auf der neuen Map changed damit auf der alten noch nichts verändert wird --> sonst wären die Count Neighbors falsch
                    } 
                    else 
                    {
                        newMap.getCell(x, y).setStatus(Cell.ALIVE); // else = 2 oder 3 Nachbarn = Zelle bleibt am leben
                    }
                } 
                else    //else = wenn die Zelle tot war
                {
                    if (liveNeighbors == 3)     // wird wiederbelebt bei genau 3 lebenden nachbarn
                    {
                        newMap.getCell(x, y).setStatus(Cell.ALIVE);    // wieder nur auf newMap geändert 
                    }
                }
            }
        }

        
        for (int x = 0; x < width; x++)                 
        {
            for (int y = 0; y < height; y++)        // läuft über die neue Map
            {
                map.getCell(x, y).setStatus(newMap.getCell(x, y).getStatus());      // Setzt den Status auf der Neuen Map
            }
        }

        return map;
    }



    /**
     * @param map       Aktuelle Map
     * @return          die resetted Map
     */
    public GameMap resetMap(GameMap map)        //reset Map methode
    {
        int width = map.getWidth();
        int height = map.getHeight();
        GameMap newMap = new GameMap(width, height);

        for (int x = 0; x < width; x++) 
        {
            for (int y = 0; y < height; y++) 
            {
                newMap.getCell(x, y).setStatus(Cell.DEAD);          //setzt den Status von jeder Zelle auf DEAD
            }
        }
        
        for (int x = 0; x < width; x++) 
        {
            for (int y = 0; y < height; y++) 
            {
                map.getCell(x, y).setStatus(newMap.getCell(x, y).getStatus());  // kopiert wieder die alte auf die Neue Map
            }
        }

        return map;     //returnt die Map
    }



    
    /**
     * @param map       Aktuelle Map
     * @param cellX     X Position der Zelle
     * @param cellY     Y Position der Zelle
     * @return          Anzahl der lebenden Nachbarn (Cells)
     */
    private int countLiveNeighbors(GameMap map, int cellX, int cellY) 
    {
        int count = 0;
        for (int x = cellX - 1; x <= cellX + 1; x++) 
        {
            for (int y = cellY - 1; y <= cellY + 1; y++) 
            {
                if (x == cellX && y == cellY) 
                {
                    continue;
                }
                if (x >= 0 && x < map.getWidth() && y >= 0 && y < map.getHeight() && map.getCell(x, y).getStatus() == Cell.ALIVE) 
                {
                    count++;
                }
            }
        }
        return count;
    }
}
