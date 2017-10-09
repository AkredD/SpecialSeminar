package MyArray;

import java.io.*;
import java.util.StringTokenizer;


/**
 * Created by user on 09.10.2017.
 */


public class RegularDecoratorBrackets extends DecoratorMyArray {
    private String leftPart;
    private String rightPart;
    private boolean comments;

    public RegularDecoratorBrackets(String leftPart, String rightPart, boolean comments, MyArray array){
        super(array, array.array);
        this.leftPart = leftPart;
        this.comments = comments;
        this.rightPart = rightPart;
    }

    public void print(String delimiter, PrintStream ps){
        ps.print(leftPart);
        doPrint(" ", ps);
        ps.print(rightPart);
        if (comments){
            ps.print(" всего " + array.length + " элементов");
        }
    }
    public void print(PrintStream ps){
        print(" ", ps);
    }

    private void doPrint(String delimiter, PrintStream ps){
        for (int i = 0; i <  array.length - 1; i++){
            ps.print(array[i]);
            ps.print(delimiter);
        }
        ps.print(array[array.length - 1]);
    }
}
