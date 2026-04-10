package run;

//import simulation.GameMap;
//import simulation.ConwayRules;
//import javax.imageio.ImageIO;
import gui.GameFX_GUI;
import javafx.application.Application;
//import simulation.ConwayRules;
//import simulation.GameMap;
//import java.io.File;
//import java.io.IOException;
//import java.awt.image.BufferedImage;

public class GameOfLife         // einfache Klasse bzw. Methode die, die javafx Application launcht, bzw. die GameFX_GUI klasse launcht --> Ganze GUI
{
    public static void main(String[] args) 
    {
        Application.launch(GameFX_GUI.class, args);
    }
}



































//------------------------------------------------------------------------------------------ RANDOM alter test Code, als der Output noch auf der Konsole war ---------------------------------------------------------------------------


   /*   public static void glider(int width, int height, int simulationTimes){                                          --> Alter Test (manuell in der Konsole von Milestone 3)
        GameMap map = new GameMap(width, height);                          
        
        map.spawnCell(1, 0);
        map.spawnCell(2, 1);
        map.spawnCell(0, 2);
        map.spawnCell(1, 2);
        map.spawnCell(2, 2);

        ConwayRules rules = new ConwayRules();


        for (int step = 0; step < simulationTimes; step++) {                            
            System.out.println("Gen " + step + ":\n" + map);
            map = rules.applyRule(map);
        }

    }

    public static void kreis(int width, int height, int simulationTimes){
        GameMap map = new GameMap(width, height);                          
        
        map.spawnCell(8, 10);
        map.spawnCell(9, 10);
        map.spawnCell(10, 10);
        map.spawnCell(9, 11);

        ConwayRules rules = new ConwayRules();

        for (int step = 0; step < simulationTimes; step++) {                            
            System.out.println("Gen " + step + ":\n" + map);
            map = rules.applyRule(map);
        }

    }
}*/
