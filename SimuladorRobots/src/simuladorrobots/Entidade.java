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
public abstract class Entidade {
    protected int ID;
    protected String cor;
    protected String forma;
    public coordXY coordenadas;
    Entidade(int entID, String entCor, String entForma, coordXY entCoordenadas){
        this.ID = entID;
        this.cor = entCor;
        this.forma = entForma;
        this.coordenadas = entCoordenadas;
    }
    public int getID() {
        return ID;
    }
    public String getCor() {
        return cor;
    }
    public String getForma() {
        return forma;
    }
    public coordXY getCoordenadas() {
        return coordenadas;
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
    @Override
    public String toString() {
        return "Entidade "+ID+"; Cor: "+cor+"; Forma: "+forma+"; Coordenadas: "+coordenadas.toString()+"; "; //To change body of generated methods, choose Tools | Templates.
    }
}
