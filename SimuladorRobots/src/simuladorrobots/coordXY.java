/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorrobots;

/**
 *
 * @author Rui Mendes
 */
public class coordXY {
    private int xcoord;
    private int ycoord;
    coordXY(int coordx, int coordy){
        this.xcoord = coordx;
        this.ycoord = coordy;
    }
    public int getXcoord() {
        return this.xcoord;
    }
    public int getYcoord() {
        return this.ycoord;
    }
    public void setXcoord(int xcoord) {
        this.xcoord = xcoord;
    }
    public void setYcoord(int ycoord) {
        this.ycoord = ycoord;
    }
    public String toString() {
        return "("+(xcoord+1)+","+(ycoord+1)+")"; //To change body of generated methods, choose Tools | Templates.
    }
}
