import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * --> Main CLass
 * Plaziert Dynamische Punkte auf der Area
 * Zeichnet "Regressionslinien"
 */
public class Solution10 extends Application {

    private List<Double> xCoords = new ArrayList<>();
    private List<Double> yCoords = new ArrayList<>();
    private Canvas canvas;

    /**
     * startet die App
     *
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Setup der JavaFX PrimaryStage
     *
     * @param primaryStage die primäre Bühne für diese Anwendung
     */
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        canvas = new Canvas(800, 600);
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 800, 600);
        scene.setOnMouseClicked(this::handleMouseClick);

        primaryStage.setTitle("Regression Line App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Setzt Punkte durch mausklicks
     * Berechnet und zeichnet die Regressionslinie (aber nur wenn mehr als 1 Punkt gesetzt wurde)
     *
     * @param event --> Maus Klick
     */
    private void handleMouseClick(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        xCoords.add(x);
        yCoords.add(y);

        drawCircle(x, y);
        if (xCoords.size() > 1) {
            drawRegressionLine();
        }
    }

    /**
     * Zeichnet den Kreis an den Koordinaten vom Klick
     *
     * @param x die x-Koordinate des Kreises
     * @param y die y-Koordinate des Kreises
     */
    private void drawCircle(double x, double y) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillOval(x - 2.5, y - 2.5, 5, 5);
    }

    /**
     * Zeichnet die Regressionslinie basierend auf den aktuellen gesetzten Punkten
     */
    private void drawRegressionLine() {
        double b = calculateSlope();
        double a = calculateIntercept(b);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);

        double startX = 0;
        double startY = a + b * startX;
        double endX = canvas.getWidth();
        double endY = a + b * endX;

        gc.strokeLine(startX, startY, endX, endY);
    }

    /**
     * Berechnet die Steigung (b) der Regressionslinie mit der gegebenen Formel
     *
     * @return die Steigung der Regressionslinie
     */
    private double calculateSlope() {
        double xMean = xCoords.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        double yMean = yCoords.stream().mapToDouble(Double::doubleValue).average().orElse(0);

        double numerator = 0;
        double denominator = 0;

        for (int i = 0; i < xCoords.size(); i++) {
            double xDiff = xCoords.get(i) - xMean;
            double yDiff = yCoords.get(i) - yMean;
            numerator += xDiff * yDiff;
            denominator += xDiff * xDiff;
        }

        return numerator / denominator;
    }

    /**
     * Berechnet den y-Achsenabschnitt (a) der Regressionslinie durch die angegebene Formel
     *
     * @param slope die Steigung der Regressionslinie
     * @return der berechnete y-Achsenabschnitt der Regressionslinie
     */
    private double calculateIntercept(double slope) {
        double xMean = xCoords.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        double yMean = yCoords.stream().mapToDouble(Double::doubleValue).average().orElse(0);

        return yMean - slope * xMean;
    }
}
