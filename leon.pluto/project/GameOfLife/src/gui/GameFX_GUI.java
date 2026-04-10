package gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import simulation.Cell;
import simulation.ConwayRules;
import simulation.GameMap;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameFX_GUI extends Application 
{

    // die Ganzen lokalen Variablen (Lokal weil sie außerhalb der GUI Class nicht verändert werden sollen)
    private GameMap gameMap;
    private Canvas canvas;
    private GraphicsContext graficsContext;
    private Timeline timeline;
    private boolean isRunning = false;
    
    //Variablen für die letzte Kartengröße --> Brauch ich um die resetted Map wieder auf die gleiche größe zu Setzen, sonst hatte ich oft den Fehler dass beim Reset die Map auf die Standart Anfangsgröße gesetzt wurde
    private int lastMapWidth = gridSize;
    private int lastMapHeight = gridSize;

    // Standardgröße der Map und Zell Size
    private static final int gridSize = 50;
    private static final int cellSize = 10;

    /**
     * start der Stage
     * initialisiert die ganze GUI
     */
    public void start(Stage primaryStage) 
    {
        BorderPane root = new BorderPane();         
        Scene scene = new Scene(root, 800, 600);        // GUI größe

        // Füge die Überschrift oben im Fenster hinzu
        Text headline = new Text("Game of Life" + " Size: " +gridSize+" x "+gridSize);       // Titel, außerdem hab ich noch die aktuelle Größe mit rein geschrieben damit man direkt sehen kann was für eine Size die Map hat (Hat mir das testen einfacher gemacht)
        BorderPane.setMargin(headline, new Insets(20));
        root.setTop(headline);

        
        GridPane controls = new GridPane();     //Erstellt das Grid für die Buttons
        controls.setPadding(new Insets(10));
        controls.setHgap(10);
        controls.setVgap(10);

//-----------------------------------------------------------------------------------------Buttons-------------------------------------------------------------------------------------

        Button stepButton = new Button("Step");         //Benutze Buttons 
        Button resetButton = new Button("Reset");
        Button loadButton = new Button("Load Last Saved");
        Button loadTestBuildButton = new Button("Load Test File");
        Button saveButton = new Button("Save");
        Button runButton = new Button("Run");

        
        stepButton.setOnAction(e -> step());            //Activated durch jeweilige Aktion
        resetButton.setOnAction(e -> reset());
        loadButton.setOnAction(e -> load());
        loadTestBuildButton.setOnAction(e -> loadTestBuild());
        saveButton.setOnAction(e -> saveCurrentState(false));
        runButton.setOnAction(e -> run());

        controls.add(stepButton, 0, 0);                 // Anordnung von den Buttons unten auf dem Button Grid
        controls.add(resetButton, 1, 0);
        controls.add(loadButton, 2, 0);
        controls.add(loadTestBuildButton, 3, 0);
        controls.add(saveButton, 4, 0);
        controls.add(runButton, 5, 0);

        root.setBottom(controls);                   // damit die unten am Bildschirm Rand locked sind, sonst müsste man immer ganz runter scrollen

//-----------------------------------------------------------------------------------------Canvas Initialisierung bzw. Start von der App-------------------------------------------------------------------------------------

        // Initialisiert den canvas
        canvas = new Canvas(800, 600);          // Setzt die Größe für den Canvas
        graficsContext = canvas.getGraphicsContext2D();
        Pane canvasPane = new Pane(canvas);
        ScrollPane scrollPane = new ScrollPane(canvasPane);
        root.setCenter(scrollPane);             // Scroll Pannel habe ich in google gefunden was es extrem viel einfacher gemacht hat durch die Map zu gehen(sonst konnte ich nur kleinere Grids testen)

        
        initializeGameMap();                // nachdem die GUI gebaut wurde wird die GameMap initialized und (die Default Map geladen --> sollte 1000x1000 blank sein)
        loadDefaultMap();

        primaryStage.setTitle("Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();

        
        timeline = new Timeline(new KeyFrame(Duration.millis(300), e -> step()));       // Initialisiert die Timeline für die Run Methode alle 0.3 sekunden, müsste auch bei größeren Maps gehen (0.5 Sekunden bei 1000x1000 getestet)
        timeline.setCycleCount(Timeline.INDEFINITE);

        
        canvas.setOnMouseClicked(e -> handleMouseClick(e));         // Mouse klick gesetzt, damit ich Zellen durch den Maus Klick erstellen kann
        canvas.setOnMouseDragEntered(e -> handleMouseDrag(e));
    }





    //-----------------------------------------------------------------------------------------Methoden-------------------------------------------------------------------------------------


    
    
    /**
     * Die Methode initialisiert die Map mit der letzten geladenen Größe.
     */
    private void initializeGameMap() 
    {
        gameMap = new GameMap(lastMapWidth, lastMapHeight);
    }

    /**
     * Updated den Canvas basierend auf dem aktuellen Zustand der Spielkarte.
     */
    private void updateCanvas() 
    {
        int width = gameMap.getWidth();
        int height = gameMap.getHeight();

        
        canvas.setWidth(width * cellSize);      // Größe vom Canvas wird abhängig von der cellSize die man auswählen kann verändert
        canvas.setHeight(height * cellSize);

       
        graficsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());       // löscht den vorherigen inhalt der Zelle bzw. dem Rectangle
        
        for (int x = 0; x < width; x++)     // läuft über die ganze Map und zeichnet die Cells,
        {
            for (int y = 0; y < height; y++) 
            {
                if (gameMap.getCell(x, y).getStatus() == Cell.ALIVE)    // wenn die Zelle Alive ist, wird das Rectangle auf schwarz umgefärbt
                {
                    graficsContext.setFill(Color.BLACK);
                } 
                else 
                {
                    graficsContext.setFill(Color.WHITE);        // Sonst auf weiß
                }
                graficsContext.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);        // nur die größe der einzelnen Zelle wird umgefärbt
            }
        }

        
        graficsContext.setStroke(Color.GRAY);       // Das graue Raster wird hier gebaut, abhängig wie die Resolution der Map ist
        graficsContext.setLineWidth(0.5);
        for (int x = 0; x <= width; x++)        // auf der x Achse
        {
            graficsContext.strokeLine(x * cellSize, 0, x * cellSize, height * cellSize);
        }
        for (int y = 0; y <= height; y++)       // auf der y Achse
        {
            graficsContext.strokeLine(0, y * cellSize, width * cellSize, y * cellSize);
        }
    }

    /**
     *  Die Funktion vom "Step" Button: führt ein mal die ConwayRules aus, läuft innerhalb von den Regeln über alles drüber und speichert den neuen Status der Zellen
     */
    private void step() 
    {
        if (gameMap != null) 
        {
            ConwayRules rules = new ConwayRules();  //Objekt von den Regeln wird erstellt damit ich es hier benutzen kann
            gameMap = rules.applyRule(gameMap);     //regeln auf die Aktuelle GameMap ausführen
            updateCanvas();                         //Nachdem alle Regeln auf alle Zellen angewendet wurde wird der Canvas also die Map einmal updated --> hier ziemlich stolz drauf weil ich hier versucht hab so gut es geht zu optimieren: bei der letzten Version von meiner GameOfLife App war hier das größte Problem weil die funktion nicht gut optimiert war (200x200 Maps sind sogar crashed)
        } 
    }

    /**
     * Funktion "Reset" Button: Setzt basically alle Zellen der jetztigen Map auf DEAD
     */
    private void reset() 
    {
        System.out.println("Spiel wird zurückgesetzt..."); // Hab ich fürs trouble shooten gebraucht weil ich teilweise die Map nicht zurück setzen konnte, und wollte schauen ob die Methode überhaupt aufgerufen wird
        initializeGameMap();  // benutzt die oben festgelegte Methode (Baut die Map neu auf mit der GESPEICHERTEN größe ------>>>>>>> da hab ich wieso auch immer über eine halbe stunde dran gesessen, rauszufinden wieso die resetted map nicht so groß war wie davor)
        updateCanvas();       // Updated den Canvas damit wir in der App sehen, dass es resetted wurde
        if (isRunning) 
        {
            timeline.stop();    //resetted die Timeline
            isRunning = false;  // stoppt auch automatisch "running" damit "run" nicht weiter ausgeführt wird nach einem Map reset
        }
    }

    /**
     * Load Methode lädt einen Speicherstand (den durch "save" Button erzeugten saved_state)
     */
    private void load() 
    {
        String savedStatePath = "saved_state.png"; // Pfad zur gespeicherten PNG-Datei innerhalb von meinem src folder (nicht in Maps-zumKopieren)
        File savedFile = new File(savedStatePath);
        if (savedFile.exists())        // wenn die zu ladende saved_state Datei nicht da ist 
        {// try und catch wird ja automatisch erzeugt
            try         
            {
                gameMap.fromFile(savedStatePath);
                lastMapWidth = gameMap.getWidth();
                lastMapHeight = gameMap.getHeight();
                updateCanvas();
            } 
            catch (IOException e) 
            {
                System.out.println("saved_state.png Datei wurde noch nicht erstellt oder kann nicht gefunden werden");
            }
        } 
    }

    /**
     * Die Methode lädt die testBuild.png auf den Map, damit ihr die App einfacher testen könnt (in der LESEMICH datei hab ich auch geschrieben, dass ihr eure Dateien einfach testBuild.png benennen sollt und die jetzige ersetzen sollt)
     */
    private void loadTestBuild() 
    {
        String savedStatePath = "testBuild.png"; // Pfad zur Test-PNG-Datei --> im src ordner
        File testFile = new File(savedStatePath);
        if (testFile.exists()) 
        {
            try 
            {
                gameMap.fromFile(savedStatePath);
                lastMapWidth = gameMap.getWidth();
                lastMapHeight = gameMap.getHeight();
                updateCanvas();
            } 
            catch (IOException e) 
            {
                // Error könnte sein, dass die Datei nicht gefunden wurde,
            }
        } 
    }

    /**
     * Saved den jetzigen Map-Status, also alle Cells auf der Map
     * 
     * @param saveLarge Die Zellen können auch größer gespeichert werden, wenn saveLarge true ist, falls man die Resolution ändern will, habe ich aber noch nicht in einen Button implementiert, GameOfLife funktioniert trotzdem
     */
    private void saveCurrentState(boolean saveLarge) 
    {
        int pixelsPerCell = saveLarge ? 10 : 1;     // die resolution
        try 
        {
            BufferedImage image = gameMap.toImage(pixelsPerCell);
            ImageIO.write(image, "png", new File("saved_state.png"));       //Datei wird gespeichert in einer neuen .png datei "saved_state"
        }                                                                                       // Falls die Datei schon vorhanden ist wird sie überschrieben, damit man keine 100 save files erstellt die das Programm füllen
        catch (IOException e) 
        {
            // wusste nicht was für eine Error message ich rein schreiben soll
        }
    }

    /**
     * Startet oder stoppt die Simulation.
     */
    private void run()      // toggelt die run-Simulation, der Knopf kann also zum an oder aus-schalten benutzt werden
    {
        if (isRunning) 
        {
            timeline.stop();    //falls sie schon läuft stoppt
            isRunning = false;
        } 
        else 
        {
            timeline.play();        // lässt die Simulation laufen mit der Geschwindigkeit mit der das Timeline Objekt erzeugt wurde (gerade 300ms)
            isRunning = true;
        }
    }

    /**
     * loaded die default Map (wird benutzt wenn das Programm gestartet wird)
     */
    private void loadDefaultMap() 
    {
        String defaultMapPath = "default_map.png";      //default Datei wird mit gegeben, kann man aber auch beliebig ändern, jenachdem welche Map man default_Map.png nennt
        File defaultMapFile = new File(defaultMapPath);
        if (defaultMapFile.exists()) 
        {
            try 
            {
                gameMap.fromFile(defaultMapPath);           //lädt die map aus der File raus --> in String converted
                lastMapWidth = gameMap.getWidth();      
                lastMapHeight = gameMap.getHeight();
                updateCanvas();
            } 
            catch (IOException e) 
            {
                System.out.println("Fehler: Konnte die Standardkarte nicht laden von " + defaultMapPath); // Error, falls man keine default_Map im src folder Hat
            }
        } 
    }

    /**
     * 
     * Die Methode sagt, was bei einem MausKlick zu tun ist
     * @param event Das Mausereignis.
     */
    private void handleMouseClick(MouseEvent event) 
    {

        double x = event.getX();            // Holt die x,y Position der Maus
        double y = event.getY();
        
        int cellX = (int) (x / cellSize);     // außerdem die x,y Position von jeder Zelle
        int cellY = (int) (y / cellSize);

        if (cellX >= 0 && cellX < gameMap.getWidth() && cellY >= 0 && cellY < gameMap.getHeight())  //wenn jeweilige Zelle angeklickt wird werden die x,y position von Maus und Zelle verglichen, damit nur die jeweilige Zelle affected ist
        {
            if (event.getButton() == MouseButton.PRIMARY) //Primary ist bei der javafx.sceneInput libary mit drin --> linksklick
            {
                gameMap.spawnCell(cellX, cellY);
            } 
            else if (event.getButton() == MouseButton.SECONDARY)    //rechtsklick sollte eigentlich die Zelle killen, aber ich habe ein kleineres Problem, weil auch bei Linksklick die Zelle stirbt
            {                                                       // gerade den Fehler gefunden, in CellRectangle wird bei Mausklick einfach die Zelle toggled also von lebendig auf tod und umgekehrt (ein bischen zu spät gefunden)
                gameMap.killCell(cellX, cellY);
            }
            updateCanvas();     // updated den Canvas nach dem MousClick damit die Zelle verändert angezeigt wird
        }
    }
    private void handleMouseDrag(MouseEvent event) 
    {
        System.out.println("LOLLOLOLOLOL");
        double x = event.getX();            // Holt die x,y Position der Maus
        double y = event.getY();
        
        int cellX = (int) (x / cellSize);     // außerdem die x,y Position von jeder Zelle
        int cellY = (int) (y / cellSize);

        if (cellX >= 0 && cellX < gameMap.getWidth() && cellY >= 0 && cellY < gameMap.getHeight())  //wenn jeweilige Zelle angeklickt wird werden die x,y position von Maus und Zelle verglichen, damit nur die jeweilige Zelle affected ist
        {
            if (event.getButton() == MouseButton.PRIMARY) //Primary ist bei der javafx.sceneInput libary mit drin --> linksklick
            {
                gameMap.spawnCell(cellX, cellY);
            } 
            else if (event.getButton() == MouseButton.SECONDARY)    //rechtsklick sollte eigentlich die Zelle killen, aber ich habe ein kleineres Problem, weil auch bei Linksklick die Zelle stirbt
            {                                                       // gerade den Fehler gefunden, in CellRectangle wird bei Mausklick einfach die Zelle toggled also von lebendig auf tod und umgekehrt (ein bischen zu spät gefunden)
                gameMap.killCell(cellX, cellY);
            }
            updateCanvas();     // updated den Canvas nach dem MousClick damit die Zelle verändert angezeigt wird
        }
    }
}
