package StrategySort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * Created by user on 09.10.2017.
 */


public class SortAlgorithms {
    public <E extends Comparable<E>> E[] concreteSort1(E[] a) {
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 0; j < a.length - i - 1; j++){
                E loc;
                if (a[j].compareTo(a[j+1]) > 0){
                    loc = a[j+1];
                    a[j+1] = a[j];
                    a[j] = loc;
                }
            }
        }
        return a;
    }
    public <E extends Comparable<E>> E[] concreteSort2(E[] a) {
        int minInd;
        E min;
        for (int i = 0; i < a.length - 1; i++){
            min = a[i];
            minInd = i;
            for (int j = i + 1; j < a.length; ++j){
                if (a[j].compareTo(min) > 0){
                    min = a[j];
                    minInd = j;
                }
            }
            a[minInd] = a[i];
            a[i] = min;
        }

        return a;
    }
    public <E extends Comparable<E>> E[] concreteSort3(E[] a) {
        Arrays.sort(a);
        return a;
    }
}
