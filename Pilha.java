public class Pilha {
   
   public int[][] pilha;
   public int topo;
   
   public Pilha(int tamanho){
      this.pilha = new int[tamanho][2];
      this.topo = -1;
   }
   
   public void empilhar(int[] valor){
      if(topo == this.pilha.length){
         System.out.println("Pilha cheia");
      }else{
         topo++;
         pilha[topo] = valor;
      }           
   }
   
   public void desempilhar(){
      if(topo == -1){
         System.out.println("Lista Vazia");      
      }else{
         pilha[topo][0] = -1;
         pilha[topo][1] = -1;
         topo--;
      }
   }
   
   public int[] espiar(){
      return pilha[topo];      
   }
}