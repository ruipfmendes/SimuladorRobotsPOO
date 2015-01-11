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
public class Ambiente {
    private int tamanhoMundo;
    private int tipoMundo;
    private String[] nomeObjectos;
    private final String[] nomeObjExploracao = {"Rocha", "Pedaço de Asteróide", "Cratera"};
    private final String[] nomeObjEmergencia = {"Ambulância", "Destroços", "Voluntário"};
    private final String[] nomeObjDomestico = {"Mesa", "Cadeira", "Caixote do lixo", "Televisao", "Prato", "Eletrodoméstico", "Cama"};
    private Bloco[][] mundo;
    private int numAgentes;
    private int numObjectos;
    private int tempoVidaInicial = 1; //Atençao que neste momento cada agente tem o seu tempo de vida; Nao sei se devem todos começar com o mesmo

    public Ambiente() {
    }
    public int getNumAgentes() {
        return this.numAgentes;
    }
    public int getNumObjectos() {
        return this.numObjectos;
    }
    public int getTamanhoMundo() {
        return this.tamanhoMundo;
    }
    public int getTipoMundo() {
        return this.tipoMundo;
    }
    public int getTempoVidaInicial() {
        return this.tempoVidaInicial;
    }
    public String[] getNomeObjectos() {
        return this.nomeObjectos;
    }
    public String getNomeObjecto(int num) {
        return this.nomeObjectos[num];
    }

    public void setTempoVidaInicial(int tempoVidaInicial) {
        this.tempoVidaInicial = tempoVidaInicial;
    }
    public void setNumAgentes(int numAgentes) {
        this.numAgentes = numAgentes;
    }
    public void setNumObjectos(int numObjectos) {
        this.numObjectos = numObjectos;
    }
    public void setTamanhoMundo(int tamanhoMundo) {
        this.tamanhoMundo = tamanhoMundo;
    }
    public void setTipoMundo(int tipoMundo) {
        this.tipoMundo = tipoMundo;
    }
    public void configTempoVida(){
        Scanner sc = new Scanner(System.in);
        int num = 0;
            do {
                System.out.print("Indique o Tempo de Vida dos Agentes (mínimo 1): ");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número");
                    sc.next();
                    System.out.print("Indique o Tempo de Vida dos Agentes (mínimo 1): ");
                }
                num = sc.nextInt();
            } while (num < 1);
            setTempoVidaInicial(num);
    }
    
    public void configTipoMundo(){
        Scanner sc = new Scanner(System.in);
        int seleccao = 0;
        do {
            System.out.println("Mundos:");
            System.out.println("1: Mundo com ambiente de exploração");
            System.out.println("2: Mundo com ambiente de emergência");
            System.out.println("3: Mundo com ambiente doméstico");
            System.out.print("Seleccione o tipo de mundo que deseja simular: ");
            while (!sc.hasNextInt()) {
                System.out.println("Não inseriu um número");
                sc.next();
                System.out.println("Mundos:");
                System.out.println("1: Mundo com ambiente de exploração");
                System.out.println("2: Mundo com ambiente de emergência");
                System.out.println("3: Mundo com ambiente doméstico");
                System.out.print("Seleccione o tipo de mundo que deseja simular: ");
            }
            seleccao = sc.nextInt();
        } while(seleccao != 1 && seleccao != 2 && seleccao != 3);
        setTipoMundo(seleccao);
    }
    
    public void configTamanhoMundo(){
        int tamMundo = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Indique o tamanho do mundo (mínimo 2): ");
            while (!sc.hasNextInt()) {
                System.out.println("Não inseriu um número");
                sc.next();
                System.out.print("Indique o tamanho do mundo (mínimo 2): ");
            }
            tamMundo = sc.nextInt();
        } while (tamMundo < 2);
        setTamanhoMundo(tamMundo);
    }
    
    public void configNumEntidades(){
        Scanner sc = new Scanner(System.in);
        int numAg = 0;
        int numObj = 0;
        do {
            System.out.print("Indique o numero de Agentes (mínimo 1): ");
            while (!sc.hasNextInt()) {
                System.out.println("Não inseriu um número");
                sc.next();
                System.out.print("Indique o numero de Agentes (mínimo 1): ");
            }
            numAg = sc.nextInt();
        } while (numAg < 1);
        do {
            System.out.print("Indique o numero de Objectos (mínimo 1; máximo "+(int)Math.pow(tamanhoMundo,2)+"): ");
            while (!sc.hasNextInt()) {
                System.out.println("Não inseriu um número");
                sc.next();
                System.out.print("Indique o numero de Objectos (mínimo 1; máximo "+(int)Math.pow(tamanhoMundo,2)+"): ");
            }
            numObj = sc.nextInt();
        } while (numObj < 1 || numObj > Math.pow(tamanhoMundo,2));
        setNumAgentes(numAg);
        setNumObjectos(numObj);
    }
    
    public void configNomesObjectos(){
        Scanner sc = new Scanner(System.in);
        int seleccao = 0;
        if(tipoMundo == 1){
            nomeObjectos = nomeObjExploracao;
        }
        else if(tipoMundo == 2){
            nomeObjectos = nomeObjEmergencia;
        }
        else if(tipoMundo == 3){
            nomeObjectos = nomeObjDomestico;
        }
        do {
            System.out.println();
            imprimirObjectosAmb();
            System.out.println("Deseja usar os objectos padrão ou criar novos?");
            System.out.println("1-Objectos Padrão");
            System.out.println("2-Criar novos objectos");
            while (!sc.hasNextInt()) {
                System.out.println("Não inseriu um número");
                sc.next();
                imprimirObjectosAmb();
                System.out.println("\nDeseja usar os objectos padrão ou criar novos?");
                System.out.println("1-Objectos Padrão");
                System.out.println("2-Criar novos objectos");
            }
            seleccao = sc.nextInt();
        } while (seleccao != 1 && seleccao != 2);
        if(seleccao == 2){
            int numObj=0;
            do {
                System.out.print("Indique o numero de nomes de objectos que deseja inserir (mínimo 1): ");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número");
                    sc.next();
                    System.out.print("Indique o numero de nomes de objectos que deseja inserir (mínimo 1): ");
                }
                numObj = sc.nextInt();
            } while (numObj <= 1);
            String[] strAux = new String[numObj];
            String linha;
            for(int i=0;i<strAux.length;i++){
                System.out.print("Insira um nome para objectos: ");
                linha = sc.nextLine();
                while(linha.isEmpty()){
                    linha = sc.nextLine();
                }
                strAux[i] = linha;
                //System.out.println("Inseriu o nome: "+strAux[i]);
            }
            nomeObjectos = strAux;
        }
    }
    
    public void imprimirObjectosAmb(){
        System.out.print("Nomes de objectos do ambiente:\n");
        for(int i=0;i<nomeObjectos.length;i++){
            System.out.print((i+1)+" - "+nomeObjectos[i]+"; ");
        }
        System.out.println();
        /*if(tipoMundo == 1){
            System.out.println(" de exploração:");
            for(int i=0;i<nomeObjExploracao.length;i++){
                System.out.print((i+1)+" - "+nomeObjExploracao[i]+"; ");
            }
        }
        else if(tipoMundo == 2){
            System.out.println(" de emergência:");
            for(int i=0;i<nomeObjEmergencia.length;i++){
                System.out.print((i+1)+" - "+nomeObjEmergencia[i]+"; ");
            }
        }
        else if(tipoMundo == 3){
            System.out.println(" doméstico:");
            for(int i=0;i<nomeObjDomestico.length;i++){
                System.out.print((i+1)+" - "+nomeObjDomestico[i]+"; ");
            }
        }*/
    }
    public Bloco getBloco(coordXY coordenadas){
        //System.out.println("Bloco = X:"+coordenadas.getXcoord()+"; Y:"+coordenadas.getYcoord());
        for(int i=0;i<tamanhoMundo;i++){
            for(int j=0;j<tamanhoMundo;j++){
                //System.out.println("X:"+mundo[i][j].getCoordenadas().getXcoord()+"; Y:"+mundo[i][j].getCoordenadas().getYcoord());
                if(coordenadas.getXcoord() == mundo[i][j].getCoordenadas().getXcoord() && coordenadas.getYcoord() == mundo[i][j].getCoordenadas().getYcoord()){
                    return mundo[i][j];
                }
            }
        }
        //System.out.println("Nao encontrou o bloco");
        return null;
    }
    
    public void criarMundo(){
        mundo = new Bloco[tamanhoMundo][tamanhoMundo];
        for(int i=0;i<tamanhoMundo;i++){
            for(int j=0;j<tamanhoMundo;j++){
                mundo[i][j] = new Bloco(i,j);
                //System.out.println(mundo[i][j].getCoordenadas().getXcoord());
            }
        }
        //System.out.println("Mundo criado");
    }
}
