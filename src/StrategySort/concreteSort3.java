package StrategySort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;


/**
 * Created by user on 19.09.2017.
 */


public class concreteSort3 implements Strategy {

    public Integer[] sort(Integer[] a) {
        Arrays.sort(a);
        return a;
    }
}
