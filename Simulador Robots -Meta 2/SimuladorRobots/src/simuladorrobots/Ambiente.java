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
    private String[] nomeObjExploracao;
    private String[] nomeObjEmergencia;
    private String[] nomeObjDomestico;
    private Bloco[][] mundo;
    private int numAgentes;
    private int numObjectos;

    public Ambiente() {
        this.nomeObjExploracao = new String[]{"Rocha", "Pedaço de Asteróide", "Cratera"};
        this.nomeObjEmergencia = new String[]{"Ambulância", "Destroços", "Voluntário"};
        this.nomeObjDomestico = new String[]{"Mesa", "Cadeira", "Caixote do lixo", "Televisao", "Prato", "Eletrodoméstico", "Cama"};
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
    
    public void criarEntidades(Agente[] ags, Objecto[] objs){
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
        for(int i=1;i<=numAgentes;i++){
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
            do {
                System.out.print("Escolha o tempo de vida do Agente "+i+" (mínimo 1): ");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número");
                    sc.next();
                    System.out.print("Escolha o tempo de vida do Agente "+i+" (mínimo 1): ");
                }
                tempoVida = sc.nextInt();
            } while(tempoVida < 1);
            do {
                    System.out.print("Escolha as coordenadas iniciais do Agente "+i+" (mínimo 1 e máximo "+tamanhoMundo+")\nIndique a coordenada X: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Não inseriu um número");
                        sc.next();
                        System.out.print("Escolha as coordenadas iniciais do Agente "+i+" (mínimo 1 e máximo "+tamanhoMundo+")\nIndique a coordenada X: ");
                    }
                    coordX = sc.nextInt();
                } while(coordX < 1 || coordX > tamanhoMundo);
            do {
                System.out.print("Escolha as coordenadas iniciais do Agente "+i+" (mínimo 1 e máximo "+tamanhoMundo+")\nIndique a coordenada Y: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número");
                    sc.next();
                    System.out.print("Escolha as coordenadas iniciais do Agente "+i+" (mínimo 1 e máximo "+tamanhoMundo+")\nIndique a coordenada Y: ");
                }
                coordY = sc.nextInt();
            } while(coordY < 1 || coordY > tamanhoMundo);
            
            selCoord = new coordXY(coordX,coordY);
            if(selEstrategia == 1){
                ags[i-1] = new AgenteAleatorio(id,cores[selCor-1],formas[selForma-1],selCoord,raioVisao,tempoVida);
            }
            /*else if(selEstrategia == 2){
                ags[i-1] = new AgenteMaxDif(id,cores[selCor-1],formas[selForma-1],selCoord,raioVisao);
            }
            else if(selEstrategia == 3){
                ags[i-1] = new AgenteProximo(id,cores[selCor-1],formas[selForma-1],selCoord,raioVisao);
            }*/
            procurarBloco(selCoord).inserirAgente(ags[i-1]);
            id++;
        }
        for(int j=1;j<=numObjectos;j++){
            int selCor = 0;
            int selForma = 0;
            coordXY selCoord;
            int coordX = 0;
            int coordY = 0;
            int selNome = 0;

            System.out.println("\nConfiguração do Objecto "+j+" - Entidade "+id);
            do {
                imprimirObjectosAmb();
                System.out.print("Escolha o nome do Objecto "+j+": ");
                while (!sc.hasNextInt()) {
                    System.out.println("Não inseriu um número\n");
                    sc.next();
                    imprimirObjectosAmb();
                    System.out.print("Escolha o nome do Objecto "+j+": ");
                }
                selNome = sc.nextInt();
            } while(selNome < 1 || selNome > nomeObjectos.length);
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
                    System.out.print("Escolha as coordenadas iniciais do Objecto "+j+" (mínimo 1 e máximo "+tamanhoMundo+")\nIndique a coordenada X: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Não inseriu um número");
                        sc.next();
                        System.out.print("Escolha as coordenadas iniciais do Objecto "+j+" (mínimo 1 e máximo "+tamanhoMundo+")\nIndique a coordenada X: ");
                    }
                    coordX = sc.nextInt();
                } while(coordX < 1 || coordX > tamanhoMundo);
                do {
                    System.out.print("Escolha as coordenadas iniciais do Objecto "+j+" (mínimo 1 e máximo "+tamanhoMundo+")\nIndique a coordenada Y: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Não inseriu um número");
                        sc.next();
                        System.out.print("Escolha as coordenadas iniciais do Objecto "+j+" (mínimo 1 e máximo "+tamanhoMundo+")\nIndique a coordenada Y: ");
                    }
                    coordY = sc.nextInt();
                } while(coordY < 1 || coordY > tamanhoMundo);
                if(coordY >= 1 || coordY <= tamanhoMundo || coordX >= 1 || coordX <= tamanhoMundo){
                    if(mundo[coordX-1][coordY-1].getObjectoNoBloco() != null){
                        System.out.println("Ja existe um objecto no bloco ("+coordX+","+coordY+")\n");
                    }
                }
            } while(mundo[coordX-1][coordY-1].getObjectoNoBloco() != null);
            selCoord = new coordXY(coordX-1,coordY-1);
            objs[j-1] = new Objecto(id,cores[selCor-1],formas[selForma-1],selCoord,nomeObjectos[selNome]);
            mundo[coordX-1][coordY-1].setObjectoNoBloco(objs[j-1]);
            id++;
        }
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
    public void simularMovimento(Agente[] agentes){
        for(int i=0;i<agentes.length;i++){
            if(agentes[i].tempoVida>0){
                for(int j=0;j<agentes.length;j++){
                    agenteParaBloco(agentes[i],escolherDestinoAgenteA(agentes[i]));
                    agentes[j].tempoVida--;
                }
            }
        }
    }
    
    public Bloco escolherDestinoAgenteA(Agente ag){
        Random rand = new Random();
        ArrayList<Bloco> blocosRaioVisao = new ArrayList<Bloco>();   
        for(int i=0;i<tamanhoMundo;i++){
            for(int j=0;j<tamanhoMundo;j++){
                if(Math.abs(ag.getCoordenadas().getXcoord() - mundo[i][j].getCoordenadas().getXcoord())<= ag.raioVisao){
                    blocosRaioVisao.add(mundo[i][j]);
                }
            }
        }
        if(blocosRaioVisao.size()>0){
            int randomNum = rand.nextInt((blocosRaioVisao.size() - 0) + 1) + 0;
            System.out.println(randomNum);
            return blocosRaioVisao.get(randomNum);
        }
        else{
            int randomX = rand.nextInt((ag.raioVisao - 0) + 1) + 0;
            int randomY = rand.nextInt((ag.raioVisao - 0) + 1) + 0;
            coordXY coordenadas = new coordXY(randomX,randomY);
            return procurarBloco(coordenadas);
        }
    }
    
    public Bloco procurarBloco(coordXY coordenadas){
        for(int i=0;i<tamanhoMundo;i++){
            for(int j=0;j<tamanhoMundo;j++){
                if(coordenadas == mundo[i][j].getCoordenadas()){
                    return mundo[i][j];
                }
            }
        }
        return null;
    }
    
    public void agenteParaBloco(Agente ag, Bloco blocoDestino){
        int distancia=0;
        procurarBloco(ag.getCoordenadas()).removerAgente(ag);
        distancia = Math.abs(ag.getCoordenadas().getXcoord() - blocoDestino.getCoordenadas().getXcoord()) + Math.abs(ag.getCoordenadas().getYcoord() - blocoDestino.getCoordenadas().getYcoord());
        blocoDestino.inserirAgente(ag);
        ag.setCoordenadas(blocoDestino.getCoordenadas());
        ag.setDistPercorrida(ag.getDistPercorrida()+distancia);
        System.out.println("O Agente"+ag.getID()+" moveu-se para "+blocoDestino.getCoordenadas().toString()+".\n+"+ag.toString());
        if(blocoDestino.getObjectoNoBloco() != null){
            ag.memoria.inserirObjecto(blocoDestino.getObjectoNoBloco());
            System.out.println("O Agente"+ag.getID()+" conheceu e colocou em memoria o seguinte objecto:\n"+blocoDestino.getObjectoNoBloco());
            ag.setNumObjectos(numObjectos+1);
        }
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
