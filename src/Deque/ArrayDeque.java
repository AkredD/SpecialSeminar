package Deque;

import java.util.Iterator;


/**
 * Created by user on 19.09.2017.
 */


public class ArrayDeque<E> implements Deque<E> {
    private int length;
    private int begin;
    private int end;
    private E[] array;

    @SafeVarargs     //On your honor
    public ArrayDeque(E... elements){
        int size = (Integer) elements[0];
        this.length = elements.length-1;
        array = (E[]) (new Object[size]);
        for (int i = 1; i < elements.length; ++i){
            array[i-1] = elements[i];
        }
        begin = 0;
        end = elements.length-1;
        makeBalance();
    }

    public int size(){
        return (end - begin);
    }

    private void makeBalance(){
        E[] local = (E[]) (new Object[array.length]);
        for(int i = begin; i < end; ++i){
            local[array.length/2 - length/2 + i] = array[i];
        }
        array = local;
        begin = array.length/2 - length/2;
        end =  array.length/2 - length/2 + length - 1;
    }

    public void addFirst(E elem){
        if (begin == 0) makeBalance();
        array[--begin] = elem;
    }

    public E first(){
        return array[begin];
    }

    public E removeFirst(){
        return array[begin++];
    }

    public void addLast(E elem){
        if (end == array.length) makeBalance();
        array[++end] = elem;
    }

    public E last(){
        return array[end];
    }

    public E removeLast(){
        return array[end--];
    }

    public Iterator<E> iterator(){ return new Itr(); }

    private class Itr implements Iterator<E>{
        int cursor = begin;

        public E next(){
            if (hasNext()) return array[cursor++];
            return null;
        }
        public boolean hasNext(){
            return (cursor <= end);
        }

    }
}
