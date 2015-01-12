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
public class AgenteMaxDif extends Agente{
    AgenteMaxDif(int entID, String entCor, String entForma, coordXY entCoordenadas, int raioVisao,int tempoVida){
        super(entID,entCor,entForma,entCoordenadas,raioVisao,tempoVida);
    }
    public Bloco escolherDestino(Ambiente amb){
        Random rand = new Random();
        int maiorNumDiferencas=0;
        coordXY coordMaiorNumDif = null;
        int agenteNumDiferencas;
        for(int i=0;i<amb.getTamanhoMundo();i++){
            for(int j=0;j<amb.getTamanhoMundo();j++){
                agenteNumDiferencas=0;
                if(Math.abs(coordenadas.getXcoord() - i)<= raioVisao && Math.abs(coordenadas.getYcoord() - j)<= raioVisao && amb.getBloco(new coordXY(i,j)).getObjectoNoBloco() != null && (new coordXY(i,j)) != this.getCoordenadas()){
                    for(int k=0;k<this.getMemoria().getMemoriaAgente().size();k++){
                        if(this.getMemoria().getMemoriaAgente().get(k).getCor() != amb.getBloco(new coordXY(i,j)).getObjectoNoBloco().getCor()){
                            agenteNumDiferencas++;
                        }
                        if(this.getMemoria().getMemoriaAgente().get(k).getForma() != amb.getBloco(new coordXY(i,j)).getObjectoNoBloco().getForma()){
                            agenteNumDiferencas++;
                        }
                    }
                    if(agenteNumDiferencas > maiorNumDiferencas){
                            coordMaiorNumDif = new coordXY(i,j);
                            maiorNumDiferencas = agenteNumDiferencas;
                    }
                }
            }
        }
        if(maiorNumDiferencas > 0){
            return amb.getBloco(coordMaiorNumDif);
        }
        int randomX = rand.nextInt((raioVisao - 0) + 0) + 0;
        int randomY = rand.nextInt((raioVisao - 0) + 0) + 0;
        return amb.getBloco(new coordXY(randomX,randomY));
    }
}
