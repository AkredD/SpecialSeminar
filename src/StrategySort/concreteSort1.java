package StrategySort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Created by user on 19.09.2017.
 */


public class concreteSort1 implements Strategy {
    public Integer[] sort(Integer[] a) {
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 0; j < a.length - i - 1; j++){
                int loc;
                if (a[j] > a[j+1]){
                    loc = a[j+1];
                    a[j+1] = a[j];
                    a[j] = loc;
                }
            }
        }
        return a;
    }
}
