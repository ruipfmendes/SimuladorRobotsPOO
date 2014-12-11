/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorrobots;
import java.util.*;

/**
 *
 * @author Rui Mendes
 */
public class Ambiente {
    private int tamanhoMundo;
    private Bloco[][] mundo;
    private int numAgentes;
    private int numObjectos;
    private int tempoVidaAgentes;
    private String[] nomeObjectos;
    Ambiente(int tamMundo, int numAg, int numObj, int tempoVidaAg){
        this.tamanhoMundo = tamMundo;
        this.numAgentes = numAg;
        this.numObjectos = numObj;
        this.tempoVidaAgentes = tempoVidaAg;
    }

    public int getNumAgentes() {
        return this.numAgentes;
    }
    public int getNumObjectos() {
        return this.numObjectos;
    }
    public int getTamanhoMundo() {
        return this.tamanhoMundo;
    }
    public int getTempoVidaAgentes() {
        return this.tempoVidaAgentes;
    }
    public void setNumAgentes(int numAgentes) {
        this.numAgentes = numAgentes;
    }
    public void setNumObjectos(int numObjectos) {
        this.numObjectos = numObjectos;
    }
    public void setTamanhoMundo(int tamanhoMundo) {
        this.tamanhoMundo = tamanhoMundo;
    }
    public void setTempoVidaAgentes(int tempoVidaAgentes) {
        this.tempoVidaAgentes = tempoVidaAgentes;
    }
    public void configTamanhoMundo(){
        Scanner sc = new Scanner(System.in);
        while(sc.nextInt() < 1){
            System.out.println("Indique o tamanho do mundo: ");
            setTamanhoMundo(sc.nextInt());
            break;
        }
    }
    public void configNumEntidades(){
        Scanner sc = new Scanner(System.in);
        int numAg = 0;
        int numObj = 0;
        while(numAg < 1){
            System.out.println("Indique o numero de Agentes: ");
            numAg = sc.nextInt();
            setNumAgentes(numAg);
        }
        while(numObj < 1){
            System.out.println("Indique o numero de Objectos: ");
            numObj = sc.nextInt();
            setNumObjectos(numObj);
        }
    }
    public void criarEntidades(int numAgentes, int numObjectos){
        
    }
    public void criarMundo(){
        mundo = new Bloco[tamanhoMundo][tamanhoMundo];
    }
}
