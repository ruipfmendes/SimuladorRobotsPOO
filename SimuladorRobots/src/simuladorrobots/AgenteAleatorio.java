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
public class AgenteAleatorio extends Agente {
    AgenteAleatorio(int entID, String entCor, String entForma, coordXY entCoordenadas, int raioVisao,int tempoVida){
        super(entID,entCor,entForma,entCoordenadas,raioVisao,tempoVida);
    }
    public Bloco escolherDestino(Ambiente amb){
        Random rand = new Random();
        ArrayList<Bloco> blocosRaioVisao = new ArrayList<Bloco>();   
        for(int i=0;i<amb.getTamanhoMundo();i++){
            for(int j=0;j<amb.getTamanhoMundo();j++){
                if(Math.abs(coordenadas.getXcoord() - i)<= raioVisao && Math.abs(coordenadas.getYcoord() - j)<= raioVisao && amb.getBloco(new coordXY(i,j)).getObjectoNoBloco() != null && (new coordXY(i,j)) != this.getCoordenadas()){
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
}
