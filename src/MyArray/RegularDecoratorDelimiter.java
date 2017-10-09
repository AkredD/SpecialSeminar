package MyArray;

import java.io.*;
import java.util.StringTokenizer;


/**
 * Created by user on 09.10.2017.
 */


public class RegularDecoratorDelimiter extends DecoratorMyArray {
    private boolean comments;

    public RegularDecoratorDelimiter(boolean comments, MyArray array){
        super(array, array.array);
        this.comments = comments;
    }

    public void print(String delimiter, PrintStream ps){
            doPrint(delimiter, ps);
        if (comments){
            ps.print(" всего " + array.length + " элементов");
        }
    }
    public void print(PrintStream ps){
        print(",", ps);
    }

    private void doPrint(String delimiter, PrintStream ps){
        for (int i = 0; i <  array.length - 1; i++){
            ps.print(array[i]);
            ps.print(delimiter + " ");
        }
        ps.print(array[array.length - 1]);
    }
}
