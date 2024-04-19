public class Lista {

   public No head;
   public No tail;
   public int size;
   
   public Lista(){
      this.head = new No();
      this.tail = new No();
      this.head.next = tail;
      this.size = 0;
   }
   
   public void insertInStart(int[] data){
      No newData = new No(data);
      
      newData.next = this.head.next;
      this.head.next = newData;
      size++;
   }
   
   public void printList(){
      No current = this.head.next;
      
      while(current != tail){
         System.out.print(current.data + "->");
         current = current.next;
      }
      System.out.println("NULL");
   }
   
   /*public String findElement(int[] data){
      No current = this.head.next;
      
      while(current.data != data && current.data != null){
         current = current.next;
      }
      if(current.data == null){
         return "Sem elementos correspondentes";
      }else{
         return current.data;
      }
   }*/
   
   public void removeElement(int findIndex){
      int index = 0;
      No current = this.head.next;
      No before = this.head;
      
      if(findIndex > this.size){
         System.out.println("Index procurado maior que o tamanho da lista");
      }else{
         while(findIndex != index){
            before = current;
            current = current.next;
            index++;
         }
         System.out.println(current.data);
         before.next = current.next;
         this.size--;          
      }      
   }
   
   /*public void convertListForArray(Lista list){
      String[] array = new String[list.size];
      No current = list.head.next;
      int index = 0;
      
      while(current != list.tail){
         array[index] = current.data;
         current = current.next;
         index++;
      }
   }*/
   
   public void removeTail(){
      No current = this.head.next;
      No before = this.head;
      
      while(current.next != tail){
         before = current;
         current = current.next;
      }
      System.out.println(current.data);
      before.next = current.next;
      this.size--;       
   }
}