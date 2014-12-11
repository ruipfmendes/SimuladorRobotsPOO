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
public class coordXY extends Bloco{
    private int xcoord;
    private int ycoord;
    coordXY(int coordx, int coordy){
        this.xcoord = coordx;
        this.ycoord = coordy;
    }
    coordXY(){
        
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
}
