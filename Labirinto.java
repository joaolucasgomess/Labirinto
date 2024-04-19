import java.nio.file.*;
import java.util.List;

public class Labirinto {

   public char[][] labirinto;
   public Pilha pilhaDeCaminhos;   
   public Lista listaDeCaminhosErrados;
   public boolean[][] caminhosVisitados;
   
   public Labirinto(int tamanhoDoLabirinto){
      this.labirinto = new char[tamanhoDoLabirinto][tamanhoDoLabirinto];
      this.caminhosVisitados = new boolean[tamanhoDoLabirinto][tamanhoDoLabirinto]; 
      gerarLabirinto();
      this.pilhaDeCaminhos = new Pilha(tamanhoDoLabirinto * tamanhoDoLabirinto);
      this.listaDeCaminhosErrados = new Lista();
      
   }
   
   public void gerarLabirinto(){
      try{
         Path arquivo = Paths.get("C:/Users/Usuario/Desktop/TUDO/trab/LABIRINTO.txt");
         List<String>  linhas = Files.readAllLines(arquivo);
         int countLinha = 0;
         
         for(String linha : linhas){
            int countColuna = 0;
            for(char c : linha.toCharArray()){
               this.labirinto[countLinha][countColuna] = c;
               this.caminhosVisitados[countLinha][countColuna] = false;
               countColuna++;
            }
            countLinha++;  
         }      
      }catch(Exception e){
         System.out.println("Deu errado");
      }
   }
   
   public void imprmirCaminho(){
      System.out.println("Achou o caminho!");
      pilhaDeCaminhos.imprimirPilha();
   }
   
   public int[] buscaInicio(){
      int[] indice = new int[2];
   
      for(int i = 1; i < (this.labirinto.length - 1); i++){
         for(int j = 1; j < (this.labirinto[i].length - 1); j++){
            if(this.labirinto[i][j] == 'S'){
               indice[0] = i;
               indice[1] = j;
               pilhaDeCaminhos.empilhar(indice);
               return indice;
            }
         }
      }
      return indice;
   }
   
   
   
   public void iniciaJornada(){
      int[] indiceInicio = buscaInicio();
      
      buscaSaida(indiceInicio[0], indiceInicio[1]);
               
   }
   
   public Pilha buscaSaida(int linha, int coluna){
   
      if(this.labirinto[linha][coluna] == 'D'){
         return pilhaDeCaminhos;
      }else{
         int[] indice = buscaVizinhoLivre(linha, coluna);
         return buscaSaida(indice[0], indice[1]);
      }
   }
   
  public int[] buscaVizinhoLivre(int linha, int coluna) {
      
      if(this.labirinto[linha][coluna - 1] != '1' && this.caminhosVisitados[linha][coluna - 1] == false){
         int[] proximoPasso = new int[2];
         proximoPasso[0] = linha;
         proximoPasso[1] = coluna - 1;
         this.caminhosVisitados[proximoPasso[0]][proximoPasso[1]] = true;
         pilhaDeCaminhos.empilhar(proximoPasso);
         return proximoPasso;
      }else if(this.labirinto[linha - 1][coluna] != '1'  && this.caminhosVisitados[linha - 1][coluna] == false){
         int[] proximoPasso = new int[2];
         proximoPasso[0] = linha - 1;
         proximoPasso[1] = coluna;
         this.caminhosVisitados[proximoPasso[0]][proximoPasso[1]] = true;
         pilhaDeCaminhos.empilhar(proximoPasso);
         return proximoPasso;          
      }else if(this.labirinto[linha][coluna + 1] != '1'  && this.caminhosVisitados[linha][coluna + 1] == false){
         int[] proximoPasso = new int[2];
         proximoPasso[0] = linha;
         proximoPasso[1] = coluna + 1;
         this.caminhosVisitados[proximoPasso[0]][proximoPasso[1]] = true;
         pilhaDeCaminhos.empilhar(proximoPasso);
         return proximoPasso;         
      }else if(this.labirinto[linha + 1][coluna] != '1'  && this.caminhosVisitados[linha + 1][coluna] == false){
         int[] proximoPasso = new int[2];
         proximoPasso[0] = linha + 1;
         proximoPasso[1] = coluna;
         this.caminhosVisitados[proximoPasso[0]][proximoPasso[1]] = true;
         pilhaDeCaminhos.empilhar(proximoPasso);
         return proximoPasso;         
      }else{
         listaDeCaminhosErrados.insertInStart(pilhaDeCaminhos.espiar());
         pilhaDeCaminhos.desempilhar();
         int[] t = pilhaDeCaminhos.espiar();
         this.caminhosVisitados[t[0]][t[1]] = false;
         return pilhaDeCaminhos.espiar();
      }
  }   
}