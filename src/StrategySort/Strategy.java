package StrategySort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Created by user on 19.09.2017.
 */


public interface Strategy {
    public Integer[] sort(Integer[] a);
}
