/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorrobots;

import java.util.ArrayList;
import java.util.Random;

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
        this.memoria = new Memoria();
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
    public int getTempoVida() {
        return this.tempoVida;
    }

    public void setTempoVida(int tempoVida) {
        this.tempoVida = tempoVida;
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
    
    public void agenteParaBloco(Ambiente amb, Bloco blocoDestino){
        int distancia=0;
        amb.getBloco(coordenadas).removerAgente(this);
        distancia = Math.abs(coordenadas.getXcoord() - blocoDestino.getCoordenadas().getXcoord()) + Math.abs(coordenadas.getYcoord() - blocoDestino.getCoordenadas().getYcoord());
        blocoDestino.inserirAgente(this);
        distPercorrida = distPercorrida+distancia;
        System.out.println("\nO Agente "+ID+" moveu-se de "+coordenadas.toString()+" para "+blocoDestino.getCoordenadas().toString()+".");
        System.out.println("Agente "+ID+": "+this.toString());
        this.setCoordenadas(blocoDestino.getCoordenadas());
        if(blocoDestino.getObjectoNoBloco() != null){
            //System.out.println("Bloco "+blocoDestino.getCoordenadas().toString()+" tem um objecto.");
            memoria.inserirObjecto(blocoDestino.getObjectoNoBloco());
            System.out.println("O Agente "+ID+" conheceu e colocou em memoria o seguinte objecto: "+blocoDestino.getObjectoNoBloco().toString());
            numObjectos = this.getNumObjectos()+1;
        }
    }
    public Bloco escolherDestinoAgenteA(Ambiente amb){
        Random rand = new Random();
        ArrayList<Bloco> blocosRaioVisao = new ArrayList<Bloco>();   
        for(int i=0;i<amb.getTamanhoMundo();i++){
            for(int j=0;j<amb.getTamanhoMundo();j++){
                if(Math.abs(coordenadas.getXcoord() - amb.getBloco(new coordXY(i,j)).getCoordenadas().getXcoord())<= raioVisao && Math.abs(coordenadas.getYcoord() - amb.getBloco(new coordXY(i,j)).getCoordenadas().getYcoord())<= raioVisao && amb.getBloco(new coordXY(i,j)).getObjectoNoBloco() != null){
                    blocosRaioVisao.add(amb.getBloco(new coordXY(i,j)));
                    
                }
            }
        }
        if(blocosRaioVisao.size()>0){
            int randomNum = rand.nextInt((blocosRaioVisao.size() - 0) + 0) + 0;
            //System.out.println("Numero random = "+randomNum);
            return blocosRaioVisao.get(randomNum);
        }
        else{
            int randomX = rand.nextInt((raioVisao - 0) + 0) + 0;
            int randomY = rand.nextInt((raioVisao - 0) + 0) + 0;
            coordXY coordenadas = new coordXY(randomX,randomY);
            return amb.getBloco(coordenadas);
        }
    }
    @Override
    public String toString() {
        return super.toString()+"Distancia Percorrida: "+distPercorrida+"; Numero de Objectos em memoria: "+numObjectos+"; Numero de Objectos diferentes em memoria: "+numDifObjectos+";";  //To change body of generated methods, choose Tools | Templates.
    }
           
}
