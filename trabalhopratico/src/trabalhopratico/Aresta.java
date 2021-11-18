package trabalhopratico;



public class Aresta { // Classe aresta
    private No inicio;
    private No fim;
    
    public Aresta(No inicio, No fim){
        this.inicio = inicio; // Set o inicio da aresta
        this.fim = fim; // Set o fim da aresta
    }

    public No getInicio() { // Retorna o inicio
        return inicio;
    }

    public void setInicio(No inicio) { // Set o inicio
        this.inicio = inicio;
    }

    public No getFim() { // Retorna o fim
        return fim;
    }

    public void setFim(No fim) { // Set o fim
        this.fim = fim;
    }
    
    public void imprimeAresta(){ // Imprime as arestas
        if(this.inicio != null && this.fim != null ){
            System.out.println(this.inicio.getNome()+" => "+this.fim.getNome());  
        }
    }
    

}