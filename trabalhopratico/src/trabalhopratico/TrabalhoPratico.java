package trabalhopratico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TrabalhoPratico {
    private static List<No> blocos = new ArrayList<No>(); // Cria uma lista de nos, que serao os blocos
    
    public static void main(String args[]) throws IOException {

        Path path = Paths.get("C:/test1.txt"); // Seleciona o caminho ate o arquivo
        List<String> linhasArquivo = Files.readAllLines(path); // Cria uma lista para as linhas do arquivo
        int num = 0;
        No bloco = new No("B"+num++); // Instancia a primeira linha do arquivo que sempre eh lider
        int flag = 0,flag2 = 0, cont = 0;
        do{ // Faz as verificacoes para criar novos blocos
            if(flag2 == 0){
                bloco = new No("B"+num++);
            }

            for(int i = cont; i < linhasArquivo.size(); i++){
                if(linhasArquivo.get(i).substring(0,1).contains("L") && linhasArquivo.get(i).contains("goto")){
                    if(flag2 == 0){
                        bloco.addDados(linhasArquivo.get(i));
                        cont++;   
                    }
                    flag2 = 0;
                    break;
                }else if(linhasArquivo.get(i).substring(0,1).contains("L")){
                    if(flag2 == 0){
                        bloco.addDados(linhasArquivo.get(i));
                        cont++;
                    }
                    flag2 = 0;
                    if(i+1 < linhasArquivo.size()&& (linhasArquivo.get(i+1).substring(0,1).contains("L"))){
                        break;
                    }
                }else if(linhasArquivo.get(i).contains("goto")){
                    bloco.addDados(linhasArquivo.get(i));
                    cont++;
                    flag2 = 0;
                    break;
                }else{
                   bloco.addDados(linhasArquivo.get(i));
                   cont++;
                   flag2 = 1;
                }

            }
            if(cont >= linhasArquivo.size()){
                flag = 1;
            }
            blocos.add(bloco);
        }while(flag == 0);

        Grafo grafo = new Grafo(); // Cria um novo grafo
        for(No bloc : blocos){ // Adiciona os blocos no grafo
            grafo.addNo(bloc);
        }

        for(int i = 0; i < blocos.size()-1; i++){ // Verifica quando se deve adicionar uma aresta a partir das condicoes
            if(!blocos.get(i).getDados().get(blocos.get(i).getDados().size()-1).contains("goto") && !blocos.get(i).getDados().get(blocos.get(i).getDados().size()-1).contains("if")){
                grafo.addAresta(blocos.get(i).getNome(), blocos.get(i+1).getNome());
            }else if(blocos.get(i).getDados().get(blocos.get(i).getDados().size()-1).contains("if")){
                grafo.addAresta(blocos.get(i).getNome(), blocos.get(i+1).getNome());
                String aux;
                aux = blocos.get(i).getDados().get(blocos.get(i).getDados().size()-1).substring(blocos.get(i).getDados().get(blocos.get(i).getDados().size()-1).length()-2,blocos.get(i).getDados().get(blocos.get(i).getDados().size()-1).length());
                for(No bloc : blocos){
                    if(bloc.getDados().get(0).substring(0,2).contains(aux)){
                        grafo.addAresta(blocos.get(i).getNome(), bloc.getNome());
                    }
                }
            }else if(blocos.get(i).getDados().get(blocos.get(i).getDados().size()-1).contains("goto")){
                String aux;
                aux = blocos.get(i).getDados().get(blocos.get(i).getDados().size()-1).substring(blocos.get(i).getDados().get(blocos.get(i).getDados().size()-1).length()-2,blocos.get(i).getDados().get(blocos.get(i).getDados().size()-1).length());
                for(No bloc : blocos){
                    if(bloc.getDados().get(0).substring(0,2).contains(aux)){
                        grafo.addAresta(blocos.get(i).getNome(), bloc.getNome());
                    }
                }
            }
        }

        grafo.imprimeGrafo(); // Imprime o grafo
 
        grafo.imprimeArestas(); // Imprime as arestas
 

    }
}

