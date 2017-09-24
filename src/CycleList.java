import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;


/**
 * Created by user on 19.09.2017.
 */


public class CycleList<E> implements CycList<E> {
    public int size;
    private static class Node<E> {
        E info;
        Node<E> next;
    }
    Node<E> head = null;
    Node<E> end = null;

    public void shift(int delta){
        head = getObj(delta, head);
    }

    public int size(){return size;}
    public CycleList(E a){
        size = 1;
        this.head = new Node();
        head.info = a;
        head.next = head;
    }


    private Node<E> getObj(int i, Node <E> local){
        if (i!=0){
            return getObj(i-1, local.next);
        }else{
            return local;
        }
    }


    public E get(int i){
        return getObj(i, head).info;
    }

    public void add(E a){
        size++;
        Node<E> obj = new Node();
        obj.info = a;
        obj.next = head;
        findEnd(head).next = obj;
    }

    private Node<E> findEnd(Node<E> local){
        if (local.next.equals(head)){
            return local;
        } else{
            return findEnd(local.next);
        }
    }

    public Iterator<E> iterator(){ return new Itr(); }

    private class Itr implements Iterator<E>{
       E info;

       public E next(){
            if (hasNext()){
                info = head.info;
                head = head.next;
                return info;
            }
           return null;
       }
       public boolean hasNext(){
           if (head == null){
               return false;
           }else{
               return true;
           }
       }

   }

}
