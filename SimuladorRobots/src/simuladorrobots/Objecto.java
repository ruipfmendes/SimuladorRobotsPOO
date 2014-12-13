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
public class Objecto extends Entidade {
    private String nomeObj;
    Objecto(int entID, String entCor, String entForma, coordXY entCoordenadas, String nome){
        super(entID,entCor,entForma,entCoordenadas);
        this.nomeObj = nome;
    }
    public String getNomeObj() {
        return this.nomeObj;
    }
    public void setNomeObj(String nomeObj) {
        this.nomeObj = nomeObj;
    }
    @Override
    public String toString() {
        return super.toString()+"Nome do Objecto: "+nomeObj+";"; //To change body of generated methods, choose Tools | Templates.
    }
}
