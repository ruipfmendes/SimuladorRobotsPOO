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
public class AgenteProximo extends Agente {
    AgenteProximo(int entID, String entCor, String entForma, coordXY entCoordenadas, int raioVisao,int tempoVida){
        super(entID,entCor,entForma,entCoordenadas,raioVisao,tempoVida);
    }
    public Bloco escolherDestino(Ambiente amb){
        Random rand = new Random();
        ArrayList<Bloco> blocosRaioVisao = new ArrayList<Bloco>();
        int distancia;
        coordXY coordMenorDistancia = null;
        int objectoMenorDistancia = 0;
        for(int i=0;i<amb.getTamanhoMundo();i++){
            for(int j=0;j<amb.getTamanhoMundo();j++){
                distancia=(Math.abs(coordenadas.getXcoord() - i) + Math.abs(coordenadas.getYcoord() - j));
                if(Math.abs(coordenadas.getXcoord() - i)<= raioVisao && Math.abs(coordenadas.getYcoord() - j)<= raioVisao && amb.getBloco(new coordXY(i,j)).getObjectoNoBloco() != null && (new coordXY(i,j)) != this.getCoordenadas()){
                    if(distancia < objectoMenorDistancia){
                        objectoMenorDistancia = distancia;
                        coordMenorDistancia = new coordXY(i,j);
                    }
                }
            }
        }
        if(objectoMenorDistancia != 0){
            return amb.getBloco(coordMenorDistancia);
        }
        int randomX = rand.nextInt((raioVisao - 0) + 0) + 0;
        int randomY = rand.nextInt((raioVisao - 0) + 0) + 0;
        return amb.getBloco(new coordXY(randomX,randomY));
    }
}
