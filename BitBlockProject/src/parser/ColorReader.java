package parser;

import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.image.WritableImage;

/**
 * CURRENTLY UNUSED
 * @author Josh Thorsson
 *
 */
public class ColorReader {

    private double xCoord = 0.0;
    private double yCoord = 0.0;
    public Color readColor(Canvas canvas) {

        Color cClickedColor = null;

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
           xCoord = me.getX();
           yCoord = me.getY();
        }
        });

        int iWidth = (int) canvas.getWidth();
        int iHeight = (int) canvas.getHeight();

        //GraphicsContext gc = canvas.getGraphicsContext2D();
        WritableImage image = new WritableImage(iWidth, iHeight);

        image = canvas.snapshot(new SnapshotParameters(),null);


        cClickedColor = image.getPixelReader().getColor((int)xCoord,(int)yCoord);


        return cClickedColor;
    }
}
