package zadaca1;

class SLLNode {
  protected int id;
  protected int plata;
  public SLLNode succ;

   public SLLNode(int id, int plata, SLLNode succ) {
       this.id = id;
       this.plata = plata;
       this.succ = succ;
   }
}
class SLL {
   private SLLNode first;

   public SLL() {
       // Construct an empty SLL
       this.first = null;
   }

   public void deleteList() {
       first = null;
   }

   public int size() {
       int listSize = 0;
       SLLNode tmp = first;
       while(tmp != null) {
           listSize++;
           tmp = tmp.succ;
       }
       return listSize;
   }

//    @Override
//    public String toString() {
//        String ret = new String();
//        if (first != null) {
//            SLLNode tmp = first;
//            ret += tmp.element;
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += "->" + tmp.element;
//            }
//        } else
//            ret = "Prazna lista!!!";
//        return ret;
//    }

   public void insertFirst(E o) {
       SLLNode ins = new SLLNode(o, null);
       ins.succ = first;
       //SLLNode<E> ins = new SLLNode<E>(o, first);
       first = ins;
   }

   public void insertAfter( o, SLLNode<E> node) {
       if (node != null) {
           SLLNode<E> ins = new SLLNode<E>(o, node.succ);
           node.succ = ins;
       } else {
           System.out.println("Dadenot jazol e null");
       }
   }
   public void insertBefore(E o, SLLNode<E> before) {

       if (first != null) {
           SLLNode<E> tmp = first;
           if(first==before){
               this.insertFirst(o);
               return;
           }
           //ako first!=before
           while (tmp.succ != before && tmp.succ!=null)
               tmp = tmp.succ;
           if (tmp.succ == before) {
               tmp.succ = new SLLNode<E>(o, before);;
           } else {
               System.out.println("Elementot ne postoi vo listata");
           }
       } else {
           System.out.println("Listata e prazna");
       }
   }

   public void insertLast(E o) {
       if (first != null) {
           SLLNode<E> tmp = first;
           while (tmp.succ != null)
               tmp = tmp.succ;
           tmp.succ = new SLLNode<E>(o, null);
       } else {
           insertFirst(o);
       }
   }

   public E deleteFirst() {
       if (first != null) {
           SLLNode<E> tmp = first;
           first = first.succ;
           return tmp.element;
       } else {
           System.out.println("Listata e prazna");
           return null;
       }
   }

   public E delete(SLLNode<E> node) {
       if (first != null) {
           SLLNode<E> tmp = first;
           if(first == node) {
               return this.deleteFirst();
           }
           while (tmp.succ != node && tmp.succ.succ != null)
               tmp = tmp.succ;
           if (tmp.succ == node) {
               tmp.succ = tmp.succ.succ;
               return node.element;
           } else {
               System.out.println("Elementot ne postoi vo listata");
               return null;
           }
       } else {
           System.out.println("Listata e prazna");
           return null;
       }

   }

   public SLLNode getFirst() {
       return first;
   }

   public SLLNode find(E o) {
       if (first != null) {
           SLLNode<E> tmp = first;
           while (!tmp.element.equals(o) && tmp.succ != null)
               tmp = tmp.succ;
           if (tmp.element.equals(o)) {
               return tmp;
           } else {
               System.out.println("Elementot ne postoi vo listata");
           }
       } else {
           System.out.println("Listata e prazna");
       }
       return null;
   }

   public void merge (SLL<E> in){
       if (first != null) {
           SLLNode<E> tmp = first;
           while(tmp.succ != null)
               tmp = tmp.succ;
           tmp.succ = in.getFirst();
       }
       else{
           first = in.getFirst();
       }
   }

   public void mirror() {
       if (first != null) {
           //m=nextsucc, p=tmp,q=next
           SLLNode tmp = first;
           SLLNode newsucc = null;
           SLLNode next;

           while(tmp != null){
               next = tmp.succ;
               tmp.succ = newsucc;
               newsucc = tmp;
               tmp = next;
           }
           first = newsucc;
       }
   }

   public SLL brisi_pomali_od(int iznos) {
       SLLNode current = first;
       SLLNode previous = first;

       while (current != null) {
           if (current.plata < iznos) {
               if (current == first) {
                   first = current.succ;
                   previous = first;
                   current = first;
               }else {
                   previous.succ = current.succ;
                   current = current.succ;
               }
           }
           else {
               previous = current;
               current = current.succ;
           }
       }
       return this;
   }

   public SLL sortiraj_opagacki() {
       SLLNode current = first;
       SLLNode index = null;
       int temp;

       if (first == null) {
           return null;
       }
       else {
           while (current != null) {
               index = current.succ;

               while (index != null) {
                   if (current.plata < index.plata) {
                       temp = current.plata;
                       current.plata = index.plata;
                       index.plata = temp;
                   }
                   index = index.succ;
               }
               current = current.succ;
           }
       }
       return this;
   }

}

public class SLLKompanija {

}
