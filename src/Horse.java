/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Linh
 */
public class Horse {

    private String name;
    private int position = 0;
    private int placement;
    private boolean finished = false;
    private int strides;
    private String runX;

    //constructor
    public Horse(String name) {
        this.name = name;
    }

    //setters
    public void setPosition(int pos) {
        this.position = pos;
    }

    public void setPlacement(int p) {
        this.placement = p;
    }

    public void setStrides(int s) {
        this.strides = s;
    }
    
    public void setRunX(String r) {
        this.runX = r;
    }

    public void setFinished(boolean f) {
        this.finished = f;
    }

    //getters
    public int getPosition() {
        return position;
    }

    public int getPlacement() {
        return placement;
    }

    public int getStrides() {
        return strides;
    }

    public String getName() {
        return name;
    }

    public String getRunX() {
        return runX;
    }

    public boolean getFinished() {
        return finished;
    }

    public void updatePosition(int num) {
        position += num;
    }

    public void updateRunX() {
        runX = "";
        for (int i = 0; i < position; i++) {
            runX += "X";
        }
    }

}
