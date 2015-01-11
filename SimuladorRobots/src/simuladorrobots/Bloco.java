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
public class Bloco {
    private coordXY coordenadas;
    //private int objectoNoBlocoID = 0;
    private Objecto objectoNoBloco;
    private ArrayList<Agente> agentesNoBloco = new ArrayList<Agente>();    
//    private ArrayList<Entidade> entidadesNoBloco = new ArrayList<Entidade>();
//    private ArrayList<Integer> entNoBlocoID = new ArrayList<Integer>();
    Bloco(int coordX, int coordY){
        this.coordenadas = new coordXY(coordX,coordY);
        this.objectoNoBloco = null;
    }
    
    public coordXY getCoordenadas() {
        return this.coordenadas;
    }

    public Objecto getObjectoNoBloco() {
        return this.objectoNoBloco;
    }
    
    //public int getObjectoNoBlocoID() {
    //    return this.objectoNoBlocoID;
    //}
    public ArrayList<Agente> getAgNoBloco() {
        return this.agentesNoBloco;
    }
    //public void setObjectoNoBlocoID(int objectoNoBlocoID) {
    //    this.objectoNoBlocoID = objectoNoBlocoID;
    //}
    public void setCoordenadas(coordXY coordenadas) {
        this.coordenadas = coordenadas;
    }
    public void setObjectoNoBloco(Objecto objectoNoBloco) {
        this.objectoNoBloco = objectoNoBloco;
    }
    public void inserirAgente(Agente ag){
        agentesNoBloco.add(ag);
    }
    public void removerAgente(Agente ag){
        agentesNoBloco.remove(agentesNoBloco.indexOf(ag));
    }
//    public ArrayList<Integer> getEntNoBlocoID() {
//        return entNoBlocoID;
//    }
//    public void inserirID(int ID){
//        entNoBlocoID.add(ID);
//    }
//    public void removerID(int ID){
//        entNoBlocoID.remove(entNoBlocoID.indexOf(ID));
//    }
    
    @Override
    public String toString() {
         String infBloco = "Bloco "+coordenadas+"\nEntidades a ocupar bloco:"; //To change body of generated methods, choose Tools | Templates.
         for(int i=0;i<agentesNoBloco.size();i++){
             infBloco += "\n"+agentesNoBloco.get(i).toString();
         }
         if(agentesNoBloco.isEmpty()){
             infBloco += "\nNenhuma.";
         }
         return infBloco;
    }

}
