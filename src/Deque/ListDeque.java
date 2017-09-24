package Deque;

import java.util.Iterator;


/**
 * Created by user on 19.09.2017.
 */


public class ListDeque<E> implements Deque<E> {
    private static class Node<E> {
        E info;
        Node<E> past;
        Node<E> next;
    }
    Node<E> begin = null;
    private Node<E> local;
    Node<E> end = null;

    //@SafeVarargs
    public ListDeque(E... elements){
        local = new Node<E>();
        local.info = elements[0];
        begin = local;
        end = local;

        for (int i = 1; i < elements.length; ++ i){
            addLast(elements[i]);
        }
    }

    public void addFirst(E elem){
        local = new Node<E>();
        if (begin.next != null) begin.next.past = local;
        local.info = begin.info;
        local.next = begin.next;
        local.past = begin;
        begin.info = elem;
        begin.next = local;
    }

    public  E first(){
        return begin.info;
    }

    public E removeFirst(){
        E a = first();
        local = new Node<E>();
        local.next = begin.next.next;
        local.info = begin.next.info;
        begin.next.next.past = local;
        begin = local;
        return a;
    }

    public void addLast(E elem){
        local = new Node<E>();
        local.info = end.info;
        local.past = end.past;
        local.next = end;
        if (end.past != null){
            end.past.next = local;
            end.past = local;
        }else{
            begin.next = local;
            end = local;
            end.past = begin;
        }
        end.info = elem;
        end.next = null;
    }

    public E last(){
        return end.info;
    }

    public E removeLast(){
        E a = last();
        end.info = end.past.info;
        if (end.past.past != null) end.past.past.next = end;
        end.past = end.past.past;
        return a;
    }

    public Iterator<E> iterator(){ return new Itr(); }

    private class Itr implements Iterator<E>{
        Node<E> cursor = begin;

        public E next(){
            if (hasNext()) {
                E a = cursor.info;
                cursor = cursor.next;
                return a;
            }
            return null;
        }
        public boolean hasNext(){
            return (cursor != null);
        }

    }

}
