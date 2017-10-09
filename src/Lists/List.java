package Lists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Created by user on 18.09.2017.
 */

public class List<E extends Comparable<E>> {
    private int size;
    private static class Node<E> {
        E info;
        Node<E> next;
    }
    Node<E> head = null;

    public List(E a){
        size ++;
        this.head = new Node();
        head.info = a;
        head.next = null;
    }

    public void sort(){
        for (int i = 0; i < size - 1; i++){
            for (int j = 0; j < size - i - 1; j++){
                Node<E> loc;
                if (get(j).compareTo(get(j+1)) > 0){
                    swap(j, j+1);
                }
            }
        }

    }

    public void swap(int i, int j) {
        if (i > j){
            int a = i;
            i = j;
            j = i;
        }

        if (j >= size || i < 0) throw new IndexOutOfBoundsException();
        if (i==j) return;
        Node<E> first = getObj(i, head);
        Node<E> second = getObj(j, head);
        Node<E> afterSecond = getObj(j+1, head);
        if (i > 0){
            setObj(second, getObj(i-1, head), getObj(i+1, head));
        }else{
            second.next = head.next;
            head = second;
        }
        setObj(first, getObj(j-1, head), afterSecond);
    }

    private Node<E> getObj(int i, Node <E> local){
        if (local == null) return null;
        if (i!=0){
            return getObj(i-1, local.next);
        }else{
            return local;
        }
    }

    private void setObj(Node<E> obj,Node<E> left, Node<E> right){
        obj.next = right;
        left.next = obj;
    }

    public E get(int i){
        return getObj(i, head).info;
    }

    public void add(E a){
        Node<E> obj = new Node();
        obj.info = a;
        obj.next = null;
        findEnd(head).next = obj;
        size++;
    }

    private Node<E> findEnd(Node<E> local){
        if (local.next == null){
            return local;
        } else{
            return findEnd(local.next);
        }
    }

}

