package threads;

import javafx.application.Platform;
import model.TrainStation;

import java.awt.*;

/**
 * This class counts how long the game lasts
 */
public class Chronometer extends Thread{

    private int seconds;
    private int stop;
    private Graphics graphics;

    public Chronometer(int stop, Graphics graphics) {
        this.stop = stop;
        this.graphics = graphics;
    }

    @Override
    public void run() {
        while(seconds < stop){
            try{
                seconds++;
                Thread.sleep(1000);
            } catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
        //Platform.runLater(() -> TrainStation.getInstance().generateSavedGraph(graphics));
        TrainStation.getInstance().generateSavedGraph(graphics);
    }

    public int getSeconds() {
        return seconds;
    }
}
