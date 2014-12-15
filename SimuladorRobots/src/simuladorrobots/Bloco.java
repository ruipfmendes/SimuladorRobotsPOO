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
    private Objecto objectoNoBloco = null;
    private ArrayList<Agente> agentesNoBloco = new ArrayList<Agente>();    
//    private ArrayList<Entidade> entidadesNoBloco = new ArrayList<Entidade>();
//    private ArrayList<Integer> entNoBlocoID = new ArrayList<Integer>();
    
    public coordXY getCoordenadas() {
        return this.coordenadas;
    }
    public Objecto getObjectoNoBloco() {
        return this.objectoNoBloco;
    }
    public ArrayList<Entidade> getAgNoBloco() {
        return this.agentesNoBloco;
    }
    public void setObjectoNoBloco(Objecto objectoNoBloco) {
        this.objectoNoBloco = objectoNoBloco;
    }
    public void setCoordenadas(coordXY coordenadas) {
        this.coordenadas = coordenadas;
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
         String infBloco = "Bloco "+coordenadas+"\n Entidades a ocupar bloco:"; //To change body of generated methods, choose Tools | Templates.
         for(int i=0;i<entidadesNoBloco.size();i++){
             infBloco += "\n"+entidadesNoBloco.get(i).toString();
         }
         if(entidadesNoBloco.isEmpty()){
             infBloco += "\nNenhuma.";
         }
         return infBloco;
    }

}
