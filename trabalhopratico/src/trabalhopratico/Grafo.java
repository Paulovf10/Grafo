package trabalhopratico;

import java.util.ArrayList;


public class Grafo { // Classe grafo
    private ArrayList<No> nos; 
    private ArrayList<Aresta> arestas; 
    
    public Grafo(){ // Cria um novo grafo
        this.nos = new ArrayList<>(); // Set dos nos
        this.arestas = new ArrayList<>(); // Set das arestas
        
    }
    public void addNo(No no){ // Adiciona um no no grafo
        this.nos.add(no);
    }
    
    public void addAresta(String dadoinicio, String dadofim){ // Adiciona aresta ao grafo
        No inicio = this.getNo(dadoinicio); // Set o no que vai ser o inicio da aresta
        No fim = this.getNo(dadofim); // Set o no que vai ser o final da aresta
        Aresta aresta = new Aresta(inicio, fim);
        inicio.addArestaDeSaida(aresta); // Adiciona a aresta de saida
        fim.addArestaDeEntrada(aresta); // Adiciona a aresta de entrada
        this.arestas.add(aresta);
    }
    
    public No getNo(String dado){ // Retorna o no
        No no = null;
        for(int i = 0; i < this.nos.size(); i++){
            if(this.nos.get(i).getNome().equals(dado)){
                no = this.nos.get(i);
                break;
            }
        }
        return no;
    }
    public void imprimeGrafo(){ // Imprime o grafo
        ArrayList<No> percoridos = new ArrayList<>(); // Cria uma lista dos nos ja percorridos
        ArrayList<No> lista = new ArrayList<>(); // Cria uma lista dos nos 
        No atual = this.nos.get(0);
        percoridos.add(atual);
        System.out.println(atual.getNome());
        System.out.println(atual.getDados());
        lista.add(atual);
        while(lista.size() > 0){ // Percorre a lista dos nos
            No visitado = lista.get(0);
            for(int i=0; i < visitado.getArestasSaida().size(); i++){
                No proximo = visitado.getArestasSaida().get(i).getFim();
                if (!percoridos.contains(proximo)){ //Verifica se o vértice ainda não foi marcado
                    percoridos.add(proximo);
                    System.out.println(proximo.getNome());
                    System.out.println(proximo.getDados());
                    lista.add(proximo);
                }
            }
            lista.remove(0);
        }
    }
    public void imprimeArestas(){ // Imprime as arestas
        for(Aresta aresta: arestas){
            aresta.imprimeAresta();
        }
    }
}