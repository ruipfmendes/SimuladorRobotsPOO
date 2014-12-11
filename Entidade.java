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
public abstract class Entidade extends Bloco {
    private int ID;
    private String cor;
    private String forma;
    private coordXY coordenadas;

    public int getID() {
        return ID;
    }
    public String getCor() {
        return cor;
    }
    public String getForma() {
        return forma;
    }
    @Override
    public coordXY getCoordenadas() {
        return super.getCoordenadas(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public void setForma(String forma) {
        this.forma = forma;
    }
    public void setCoordenadas(coordXY coordenadas) {
        this.coordenadas = coordenadas;
    }
}
