package simulation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GameMap            //GameMap Klasse auf der die Map gespeichert wird in einem 2D Array
{
    private Cell[][] cells;
    private int width;
    private int height;

    public GameMap(int width, int height)   // Konstruktor von GameMap mit der gegebenen Breite und Höhe und den gesetzten Zellen
    {
        this.width = width;
        this.height = height;
        this.cells = buildCellArray(width, height);     //Variable die alle Zellen Speichert in einem 2D Array | Variable wird durch die buildCellArray verändert
    }


    /**
     * @param width Breite des zu erstellenden Arrays
     * @param height Höhe --.--
     * @return  einen 2D Array mit den gesetzten Zellen
     */
    private static Cell[][] buildCellArray(int width, int height) 
    {
        Cell[][] array = new Cell[width][height];
        for (int x = 0; x < width; x++)             // geht über das gesammte 2D Array
        {
            for (int y = 0; y < height; y++) 
            {
                array[x][y] = new Cell();           // setzt neue Zellen
            }
        }
        return array;               
    }

    public Cell getCell(int x, int y)       //getter
    {
        return cells[x][y];
    }

    public void spawnCell(int x, int y)     // Methode spawnt lebende Zelle --> setzt Status auf alive
    {
        cells[x][y].setStatus(Cell.ALIVE);
    }

    public void killCell(int x, int y)      // Methode killt eine Zelle --> setzt Status auf dead
    {
        cells[x][y].setStatus(Cell.DEAD);
    }

    public void toggleCell(int x, int y)      // Methode toggelt den Status 
    {
        if (cells[x][y].getStatus() == Cell.ALIVE) 
        {
            cells[x][y].setStatus(Cell.DEAD);
        } 
        else 
        {
            cells[x][y].setStatus(Cell.ALIVE);
        }
    }

    public boolean isCellAlive(int x, int y)        // Die Methode gibt einen Boolean aus, true, wenn die Zelle an der Stelle x,y lebt, sonst false
    {
        if (x >= 0 && x < width && y >= 0 && y < height) 
        {
            return cells[x][y].getStatus() == Cell.ALIVE;
        }
        return false;
    }

    public int getWidth()       //Getter für die Breite der Map
    {
        return width;
    }

    public int getHeight()      //Getter für die Höhe der Map
    {
        return height;
    }

    /**
     * @param path          Path einer png Datei
     * @throws IOException  Falls nicht gefunden wurde: Error
     */
    public void fromFile(String path) throws IOException        //Methode zum einlesen einer Datei und umwandeln in Map mit Zellen
    {
        File imageFile = new File(path);                       
        BufferedImage image = ImageIO.read(imageFile);
        int imgWidth = image.getWidth();
        int imgHeight = image.getHeight();
        this.cells = buildCellArray(imgWidth, imgHeight);       // Baut einen 2D Cell Array mit der größe vom Bild
        this.width = imgWidth;
        this.height = imgHeight;

        for (int x = 0; x < imgWidth; x++)                      // läuft über das Bild
        {
            for (int y = 0; y < imgHeight; y++) 
            {
                if (image.getRGB(x, y) == Color.BLACK.getRGB())         //Bei schwarzen RGB Werten im Bild setzt es eine Lebende Zelle an der Position wie im Bild
                {
                    cells[x][y].setStatus(Cell.ALIVE);
                } 
                else 
                {
                    cells[x][y].setStatus(Cell.DEAD);       // Sonst tot
                }
            }
        }
    }

    /**
     * @param pixelsPerCell Resolution der Zelle
     * @return  das Buffered Image --> von Map (2D Array) zu .png Bild
     */
    public BufferedImage toImage(int pixelsPerCell)         //Buffered Image Methode, wie in der Vorlesung 
    {
        int imgWidth = width * pixelsPerCell;           // ändert die Resolution von einem Bild um ein neues Bild zu erzeugen mit gleichen Zellen aber anderer Resolution --> Zellen am ende z.B. Größer
        int imgHeight = height * pixelsPerCell;
        BufferedImage bi = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) bi.getGraphics();

        for (int x = 0; x < width; x++) 
        {
            for (int y = 0; y < height; y++)    //läuft über Bild
            {
                if (cells[x][y].getStatus() == Cell.ALIVE) 
                {
                    g2d.setColor(Color.BLACK);  //Falls Zelle am Leben, setzt die Farbe im Bild auf schwarz
                } 
                else 
                {
                    g2d.setColor(Color.WHITE);
                }
                g2d.fillRect(x * pixelsPerCell, y * pixelsPerCell, pixelsPerCell, pixelsPerCell);
            }
        }
        return bi;
    }
}
