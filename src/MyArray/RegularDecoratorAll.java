package MyArray;

import java.io.*;
import java.util.StringTokenizer;


/**
 * Created by user on 19.09.2017.
 */


public class RegularDecoratorAll extends DecoratorMyArray {
    private String leftPart;
    private String rightPart;
    private boolean brackets;
    private boolean comments;

    public RegularDecoratorAll(String leftPart, String rightPart, boolean brackets,
                               boolean comments, MyArray array){
        super(array, array.array);
        this.leftPart = leftPart;
        this.rightPart = rightPart;
        this.brackets = brackets;
        this.comments = comments;
    }

    public void print(String delimiter, PrintStream ps){
        if (brackets){
            ps.print(leftPart);
            doPrint(delimiter, ps);
            ps.print(rightPart);
        }else{
            doPrint(delimiter, ps);
        }
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
