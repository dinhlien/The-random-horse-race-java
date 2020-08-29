import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Linh
 */
public class RaceOrganizer {

    private int length;
    private int delay;
    private ArrayList<Horse> runners = new ArrayList<>();
    private ActionListener listener;
    private ActionEvent event;
    private final double FORWARD_STRIDE = 0.60;

    public RaceOrganizer(int length, int delay) {
        this.length = length;
        this.delay = delay;
        event = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "stride");
    }

    //setters
    public void setLength(int length) {
        this.length = length;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void addActionListener(ActionListener listener) {
        this.listener = listener;
    }

    //getters
    public int getLength() {
        return length;
    }

    public int getDelay() {
        return delay;
    }

    public ArrayList<Horse> getRunners() {
        return runners;
    }

    public void connect() {
        listener.actionPerformed(event);
    }

    //for arraylist runner
    public void reset() {
        for (Horse horse : runners) {
            horse.setPosition(0);
            horse.setPlacement(0);
            horse.setStrides(0);
            horse.setFinished(false);
        }
    }

    public void onHold(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(RaceOrganizer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void runRace() {
        reset();
        int counter = 0;
        int place = 1;
        int direction = 0;
        int numOfFinished = 0;

        while (numOfFinished < runners.size()) {
            for (Horse runner : runners) {
                if (runner.getPosition() < length) {
                    Random random = new Random();
                    double fitness = random.nextDouble();
                    if (fitness < FORWARD_STRIDE) {
                        direction = 1;
                    } else {
                        direction = -1;
                    }
                    // Update position and runX 
                    // position == 0 AND direction < 0, no update
                    if (runner.getPosition() > 0 || direction > 0) {
                        runner.updatePosition(direction);
                        runner.updateRunX();
                    }
                    runner.setStrides(counter);
                } 
                else if (!runner.getFinished()) {
                    runner.setFinished(true);
                    runner.setPlacement(place);
                    runner.setStrides(counter);
                    numOfFinished++;
                    place++;
                }
            }
            counter++;
            onHold(delay);
            connect();
        }
    }
}
