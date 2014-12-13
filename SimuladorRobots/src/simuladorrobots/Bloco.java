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
    private ArrayList<Entidade> entidadesNoBloco = new ArrayList<Entidade>();
//    private ArrayList<Integer> entNoBlocoID = new ArrayList<Integer>();
    
    public coordXY getCoordenadas() {
        return this.coordenadas;
    }
    public ArrayList<Entidade> getEntNoBlocoID() {
        return entidadesNoBloco;
    }
    public void inserirEntidade(Entidade ent){
        entidadesNoBloco.add(ent);
    }
    public void removerEntidade(Entidade ent){
        entidadesNoBloco.remove(entidadesNoBloco.indexOf(ent));
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
