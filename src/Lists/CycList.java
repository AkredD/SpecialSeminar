package Lists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Created by user on 19.09.2017.
 */


public interface CycList<E> extends Iterable<E>{
    void shift(int delta);
    void add(E a);
    E get(int i);
    int size();
}
