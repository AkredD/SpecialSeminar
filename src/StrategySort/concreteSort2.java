package StrategySort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Created by user on 19.09.2017.
 */


public class concreteSort2 implements Strategy {

    public Integer[] sort(Integer[] a) {
        int minInd;
        int min;
        for (int i = 0; i < a.length - 1; i++){
            min = a[i];
            minInd = i;
            for (int j = i + 1; j < a.length; ++j){
                if (a[j] < min){
                    min = a[j];
                    minInd = j;
                }
            }
            a[minInd] = a[i];
            a[i] = min;
        }

        return a;
    }

}
