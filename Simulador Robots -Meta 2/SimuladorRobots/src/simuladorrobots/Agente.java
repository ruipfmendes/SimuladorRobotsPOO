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

public class Agente extends Entidade {
    protected int raioVisao;
    protected int distPercorrida;
    protected int numObjectos;
    protected int numDifObjectos;
    protected Memoria memoria; 
    protected int tempoVida;
    Agente(int entID, String entCor, String entForma, coordXY entCoordenadas, int raioVisao,int tempoVida){
        super(entID,entCor,entForma,entCoordenadas);
        this.raioVisao= raioVisao;
        this.distPercorrida = 0;
        this.numObjectos = 0;
        this.numDifObjectos = 0;
        this.tempoVida = tempoVida;
    }

    public int getDistPercorrida() {
        return this.distPercorrida;
    }
    public Memoria getMemoria() {
        return this.memoria;
    }
    public int getNumDifObjectos() {
        return this.numDifObjectos;
    }
    public int getNumObjectos() {
        return this.numObjectos;
    }
    public int getRaioVisao() {
        return this.raioVisao;
    }
    public void setDistPercorrida(int distPercorrida) {
        this.distPercorrida = distPercorrida;
    }
    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }
    public void setNumDifObjectos(int numDifObjectos) {
        this.numDifObjectos = numDifObjectos;
    }
    public void setNumObjectos(int numObjectos) {
        this.numObjectos = numObjectos;
    }
    public void setRaioVisao(int raioVisao) {
        this.raioVisao = raioVisao;
    }
    
    @Override
    public String toString() {
        return super.toString()+"Distancia Percorrida: "+distPercorrida+";"+memoria.toString()+"Numero de Objectos em memoria: "+numObjectos+"; Numero de Objectos diferentes em memoria: "+numDifObjectos+";";  //To change body of generated methods, choose Tools | Templates.
    }
           
}
