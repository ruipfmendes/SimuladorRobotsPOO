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
import java.util.*;

public class Memoria {
    private ArrayList <Objecto> memoriaAgente;
    Memoria(){
        this.memoriaAgente = new ArrayList <Objecto>();
    }
    
    public void inserirObjecto(Objecto obj){
        //System.out.println("Entrou na funçao memoria.inserirObjecto()");
        this.memoriaAgente.add(obj);
    }
    
    public void removerObjecto(Objecto obj){
        this.memoriaAgente.remove(memoriaAgente.indexOf(obj));
    }
    
    /*public void limpaMemoria(){
        memoriaAgente.clear();
    }*/

    @Override
    public String toString() {
        String infMemoria = "Objectos em Memoria:";
        for(int i=0;i<memoriaAgente.size();i++){
            infMemoria = infMemoria +"\n"+i+" - "+memoriaAgente.get(i).toString();
        }
        return infMemoria; //To change body of generated methods, choose Tools | Templates.
    }
}
