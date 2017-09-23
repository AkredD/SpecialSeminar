package MyArray;

import java.io.*;
import java.util.StringTokenizer;


/**
 * Created by user on 19.09.2017.
 */


public abstract class DecoratorMyArray implements Sequence<Integer> {
    protected Sequence thisArray;
    protected Integer[] array;

    public DecoratorMyArray(Sequence thisArray, Integer... elements){
        this.thisArray = thisArray;
        this.array = new Integer[elements.length];
        for (int i = 0; i < elements.length; i++){
            this.array[i] = elements[i];
        }
    }
    public int size() { return array.length; }

    public abstract void print(String delimiter, PrintStream ps);
}
