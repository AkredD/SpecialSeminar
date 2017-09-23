package StrategySort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Created by user on 19.09.2017.
 */


public class newClass {
    private Integer[] a;
    private Strategy b;
    public newClass(Integer[] a){
        this.a = a;
    }

    public void setStrategy(Strategy b){
        this.b = b;
    }

    public Integer[] sort(){
        return b.sort(a);
    }
}
