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
    
    private ArrayList <Objecto> memoriaAgente = new ArrayList <Objecto>();
    
    Memoria(){}
    
    public void inserirObjecto(Objecto obj){
        memoriaAgente.add(obj);
    }
    
    public void removerObjecto(Objecto obj){
        memoriaAgente.remove(memoriaAgente.indexOf(obj));
    }
    
    /*public void limpaMemoria(){
        memoriaAgente.clear();
    }*/

    @Override
    public String toString() {
        String infMemoria = "Objectos em Memoria: ";
        while (memoriaAgente.iterator().hasNext()){
            infMemoria += memoriaAgente.iterator().toString();
        }
        return infMemoria; //To change body of generated methods, choose Tools | Templates.
    }
}
