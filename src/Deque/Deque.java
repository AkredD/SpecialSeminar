package Deque;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Created by user on 19.09.2017.
 */


public interface Deque<E> extends Iterable<E> {
    void addFirst(E elem);
    E first();
    E removeFirst();
    void addLast(E elem);
    E last();
    E removeLast();

}
