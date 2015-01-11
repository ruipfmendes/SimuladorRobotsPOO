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
        amb.configTempoVida();
        //amb.imprimirObjectosAmb();
        Agente agentes[] = new Agente[amb.getNumAgentes()];
        Objecto objectos[] = new Objecto[amb.getNumObjectos()];
        criarEntidades(agentes,objectos,amb);
        simularMovimento(agentes,amb);
    }
    
    public static void simularMovimento(Agente[] agentes, Ambiente amb){
        for(int j=0;j<amb.getTempoVidaInicial();j++){
            for(int i=0;i<amb.getNumAgentes();i++){
                if(agentes[i].getTempoVida()>0){
                    if(agentes[i] instanceof AgenteAleatorio){
                        agentes[i].agenteParaBloco(amb,agentes[i].escolherDestinoAgenteA(amb));
                        //blocoDestino = agentes[i].escolherDestinoAgenteA(amb);
                        //agentes[i].agenteParaBloco(amb,blocoDestino);
                    }
                    agentes[i].setTempoVida(agentes[i].getTempoVida()-1);
                }
            }
        }
    }

    public static void criarEntidades(Agente[] ags, Objecto[] objs, Ambiente amb){
        Scanner sc = new Scanner(System.in);
        String cores[] = new String[5];
        String formas[] = new String[3];
        
        int id=1;
        cores[0] = "Verde";
        cores[1] = "Azul";
        cores[2] = "Vermelho";
        cores[3] = "Amarelo";
        cores[4] = "Preto";
        formas[0] = "Triangular";
        formas[1] = "Quadrangular";
        formas[2] = "Pentagonal";
        
        // Criar e configurar os Agentes
        for(int i=1;i<=amb.getNumAgentes();i++){
            int selCor;
            int selForma;
            coordXY selCoord;
            int coordX = 0;
            int coordY = 0;
            int selEstrategia=0;
            int raioVisao;
            int tempoVida;
            System.out.println("\nConfiguração do Agente "+i+" - Entidade "+id);
            do {
                System.out.println("Escolha a estratégia do Agente "+i+":\n1 - Aleatório; 2 - Máxima Diferença de Hamming; 3 - Proximidade;");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número");
                    sc.next();
                    System.out.println("Escolha a estratégia do Agente "+i+":\n1 - Aleatório; 2 - Máxima Diferença de Hamming; 3 - Proximidade;");
                }
                selEstrategia = sc.nextInt();
            } while(selEstrategia != 1 && selEstrategia != 2 && selEstrategia != 3);
            do {
                System.out.println("Escolha a cor do Agente "+i+":\n1 - "+cores[0]+"; 2 - "+cores[1]+"; 3 - "+cores[2]+"; 4 - "+cores[3]+"; 5 - "+cores[4]+";");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número");
                    sc.next();
                    System.out.println("Escolha a cor do Agente "+i+":\n1 - "+cores[0]+"; 2 - "+cores[1]+"; 3 - "+cores[2]+"; 4 - "+cores[3]+"; 5 - "+cores[4]+";");
                }
                selCor = sc.nextInt();
            } while(selCor < 1 || selCor > cores.length);
            do {
                System.out.println("Escolha a forma do Agente "+i+":\n1 - "+formas[0]+"; 2 - "+formas[1]+"; 3 - "+formas[2]+";");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número");
                    sc.next();
                    System.out.println("Escolha a forma do Agente "+i+":\n1 - "+formas[0]+"; 2 - "+formas[1]+"; 3 - "+formas[2]+";");
                }
                selForma = sc.nextInt();
            } while(selForma < 1 || selForma > formas.length);
            do {
                System.out.print("Escolha o raio de visão do Agente "+i+" (mínimo 1): ");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número");
                    sc.next();
                    System.out.print("Escolha o raio de visão do Agente "+i+" (mínimo 1): ");
                }
                raioVisao = sc.nextInt();
            } while(raioVisao < 1);
            /*do {
                System.out.print("Escolha o tempo de vida do Agente "+i+" (mínimo 1): ");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número");
                    sc.next();
                    System.out.print("Escolha o tempo de vida do Agente "+i+" (mínimo 1): ");
                }
                tempoVida = sc.nextInt();
            } while(tempoVida < 1);*/
            do {
                    System.out.print("Escolha as coordenadas iniciais do Agente "+i+" (mínimo 1 e máximo "+amb.getTamanhoMundo()+")\nIndique a coordenada X: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Não inseriu um número");
                        sc.next();
                        System.out.print("Escolha as coordenadas iniciais do Agente "+i+" (mínimo 1 e máximo "+amb.getTamanhoMundo()+")\nIndique a coordenada X: ");
                    }
                    coordX = sc.nextInt();
                } while(coordX < 1 || coordX > amb.getTamanhoMundo());
            do {
                System.out.print("Escolha as coordenadas iniciais do Agente "+i+" (mínimo 1 e máximo "+amb.getTamanhoMundo()+")\nIndique a coordenada Y: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número");
                    sc.next();
                    System.out.print("Escolha as coordenadas iniciais do Agente "+i+" (mínimo 1 e máximo "+amb.getTamanhoMundo()+")\nIndique a coordenada Y: ");
                }
                coordY = sc.nextInt();
            } while(coordY < 1 || coordY > amb.getTamanhoMundo());
            selCoord = new coordXY(coordX-1,coordY-1);
            if(selEstrategia == 1){
                ags[i-1] = new AgenteAleatorio(id,cores[selCor-1],formas[selForma-1],selCoord,raioVisao,amb.getTempoVidaInicial());
            }
            /*else if(selEstrategia == 2){
                ags[i-1] = new AgenteMaxDif(id,cores[selCor-1],formas[selForma-1],selCoord,raioVisao);
            }
            else if(selEstrategia == 3){
                ags[i-1] = new AgenteProximo(id,cores[selCor-1],formas[selForma-1],selCoord,raioVisao);
            }*/
            amb.getBloco(selCoord).inserirAgente((Agente)ags[i-1]);
            id++;
        }
        for(int j=1;j<=amb.getNumObjectos();j++){
            int selCor = 0;
            int selForma = 0;
            coordXY selCoord;
            int coordX = 0;
            int coordY = 0;
            int selNome = 0;

            System.out.println("\nConfiguração do Objecto "+j+" - Entidade "+id);
            do {
                amb.imprimirObjectosAmb();
                System.out.print("Escolha o nome do Objecto "+j+": ");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número\n");
                    sc.next();
                    amb.imprimirObjectosAmb();
                    System.out.print("Escolha o nome do Objecto "+j+": ");
                }
                selNome = sc.nextInt();
            } while(selNome < 1 || selNome > amb.getNomeObjectos().length);
            do {
                System.out.print("Cores:\n1 - "+cores[0]+"; 2 - "+cores[1]+"; 3 - "+cores[2]+"; 4 - "+cores[3]+"; 5 - "+cores[4]+";\nEscolha a cor do Objecto "+j+": ");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número");
                    sc.next();
                    System.out.print("Cores:\n1 - "+cores[0]+"; 2 - "+cores[1]+"; 3 - "+cores[2]+"; 4 - "+cores[3]+"; 5 - "+cores[4]+";\nEscolha a cor do Objecto "+j+": ");
                }
                selCor = sc.nextInt();
            } while(selCor < 1 || selCor > cores.length);
            do {
                System.out.print("Formas:\n1 - "+formas[0]+"; 2 - "+formas[1]+"; 3 - "+formas[2]+";\nEscolha a forma do Objecto "+j+": ");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número");
                    sc.next();
                    System.out.print("Formas:\n1 - "+formas[0]+"; 2 - "+formas[1]+"; 3 - "+formas[2]+";\nEscolha a forma do Objecto "+j+": ");
                }
                selForma = sc.nextInt();
            } while(selForma < 1 || selForma > formas.length);
            do {
                do {
                    System.out.print("Escolha as coordenadas iniciais do Objecto "+j+" (mínimo 1 e máximo "+amb.getTamanhoMundo()+")\nIndique a coordenada X: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Não inseriu um número");
                        sc.next();
                        System.out.print("Escolha as coordenadas iniciais do Objecto "+j+" (mínimo 1 e máximo "+amb.getTamanhoMundo()+")\nIndique a coordenada X: ");
                    }
                    coordX = sc.nextInt();
                } while(coordX < 1 || coordX > amb.getTamanhoMundo());
                do {
                    System.out.print("Escolha as coordenadas iniciais do Objecto "+j+" (mínimo 1 e máximo "+amb.getTamanhoMundo()+")\nIndique a coordenada Y: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Não inseriu um número");
                        sc.next();
                        System.out.print("Escolha as coordenadas iniciais do Objecto "+j+" (mínimo 1 e máximo "+amb.getTamanhoMundo()+")\nIndique a coordenada Y: ");
                    }
                    coordY = sc.nextInt();
                } while(coordY < 1 || coordY > amb.getTamanhoMundo());
                if(coordY >= 1 || coordY <= amb.getTamanhoMundo() || coordX >= 1 || coordX <= amb.getTamanhoMundo()){
                    if(amb.getBloco(new coordXY(coordX-1,coordY-1)).getObjectoNoBloco() != null){
                        System.out.println("Ja existe um objecto no bloco ("+coordX+","+coordY+")\n");
                    }
                }
            } while(amb.getBloco(new coordXY(coordX-1,coordY-1)).getObjectoNoBloco() != null);
            selCoord = new coordXY(coordX-1,coordY-1);
            objs[j-1] = new Objecto(id,cores[selCor-1],formas[selForma-1],selCoord,amb.getNomeObjecto(selNome-1));
            amb.getBloco(new coordXY(coordX-1,coordY-1)).setObjectoNoBloco(objs[j-1]);
            id++;
        }
    }
}
