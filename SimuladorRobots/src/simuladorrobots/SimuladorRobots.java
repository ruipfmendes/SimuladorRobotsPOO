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
public class SimuladorRobots {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ambiente amb = new Ambiente();
        amb.configTipoMundo();
        amb.configTamanhoMundo();
        amb.criarMundo();
        amb.configNumEntidades();
        amb.configNomesObjectos();
        //amb.imprimirObjectosAmb();
        //Agente agentes[] = new Agente[amb.getNumAgentes()];
        Objecto objectos [] = new Objecto[amb.getNumObjectos()];
        amb.criarEntidades(objectos);
        
    }
    
}
