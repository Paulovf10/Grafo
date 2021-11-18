package trabalhopratico;

import java.util.ArrayList;


public class No { // Classe no
    private String nome; // Set o nome 
    private ArrayList<String> dados; // Set os dados do bloco
    private ArrayList<Aresta> arestasDeEntrada; // Set as arestas de entrada
    private ArrayList<Aresta> arestasDeSaida;// Set as arestas de saida
    
    public No(String nome){ // Cria um novo no
        this.nome = nome;
        this.dados = new ArrayList<>();
        this.arestasDeEntrada = new ArrayList<>();
        this.arestasDeSaida  = new ArrayList<>();
    }

    public String getNome() { // Retorna o nome
        return nome;
    }
    
    public ArrayList<String> getDados() { // Retorna os blocos
        return this.dados;
    }

    public void addDados(String dados) { // Adiciona os dados
        this.dados.add(dados);
    }
    
    public void addArestaDeEntrada(Aresta aresta){ // Adiciona as arestas de entrada
        this.arestasDeEntrada.add(aresta); 
    }
    
    public void addArestaDeSaida(Aresta saida){ // Adiciona as arestas de saida
        this.arestasDeSaida.add(saida);    
    }
    
    public ArrayList<Aresta> getArestasEntrada() { // Retorna as arestas de entrada
        return this.arestasDeEntrada;
    }

    public ArrayList<Aresta> getArestasSaida() { // Retorna as arestas de saida
        return this.arestasDeSaida;
    }
}