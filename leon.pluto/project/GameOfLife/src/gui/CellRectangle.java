package gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import simulation.GameMap;
import simulation.Cell;

 
 /**  Die Klasse baut die Zellen (CellRectangles) auf der JavaFX map auf
 */
public class CellRectangle extends Rectangle 
{
    private int x;          // X Koordinate der Zelle auf der Map
    private int y;          // Y Koordinate der Zelle auf der Map
    private GameMap gameMap;        //Die Map auf der die Zelle placed wurde
//-------------------------------------------------------------------------------Konstruktor----------------------------------------------------------------------------------------------------------
    /**
     * @param x Die x-Koordinate der Zelle.
     * @param y Die y-Koordinate der Zelle.
     * @param size Die Größe des Rechtecks, das die Zelle darstellt.
     * @param gameMap Die Spielkarte, zu der diese Zelle gehört.
     */
    public CellRectangle(int x, int y, int size, GameMap gameMap) 
    {
        super(size, size);
        this.x = x;
        this.y = y;                 
        this.gameMap = gameMap;
        setStroke(Color.GRAY);          // Rand der Zelle
        setFill(Color.WHITE);           // Weiß -> Dead

        setOnMouseClicked(e -> toggleCell());       //placed bei Maus klicken eine lebende Zelle bzw. toggelt den State (Falls schon lebt -> tot)
    }

    /**
     *  setGameMap methode 
     *
     * @param gameMap die neue GameMap
     */
    public void setGameMap(GameMap gameMap) 
    {
        this.gameMap = gameMap;
    }

    /**
     * Updated die Farbe 
     * Schwarz - Alive, Weiß - Dead
     */
    public void updateColor() 
    {
        if (gameMap.getCell(x, y).getStatus() == Cell.ALIVE)        // wenn Cell Alive dann Schwarz sonst Weiß
        {
            setFill(Color.BLACK);
        } 
        else 
        {
            setFill(Color.WHITE);
        }
    }

    /**
     * Toggelt den Status der Zelle --> ALIVE <-> DEAD
     * 
     */
    private void toggleCell()                           
    {
        Cell cell = gameMap.getCell(x, y);
        if (cell.getStatus() == Cell.ALIVE) 
        {
            cell.setStatus(Cell.DEAD);
        } 
        else 
        {
            cell.setStatus(Cell.ALIVE);
        }
        updateColor();
    }
}
