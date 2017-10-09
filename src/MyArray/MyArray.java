package MyArray;

import java.io.PrintStream;

public class MyArray implements Sequence<Integer> {
    public Integer[] array;

    public MyArray(Integer... elements) {
        array = new Integer[elements.length];
        for (int i = 0; i < elements.length; i++){
            array[i] = elements[i];
        }
    }
    public int size() { return array.length; }
    public void print(String delimiter, PrintStream ps) {
        for (int i = 0; i <  array.length - 1; i++){
            ps.print(array[i]);
            ps.print(delimiter);
        }
        ps.print(array[array.length - 1]);
    }
    public void print(PrintStream ps){
        print(",", ps);
    }
}
