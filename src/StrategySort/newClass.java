package StrategySort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.StringTokenizer;


/**
 * Created by user on 19.09.2017.
 */


public class NewClass {

    public Object[] main(String[] args) {
        Method method = null;

        try {
            switch (args[0]) {
                case "sort1":
                    method = SortAlgorithms.class.getDeclaredMethod("concreteSort1", Comparable[].class);
                    break;
                case "sort2":
                    method = SortAlgorithms.class.getDeclaredMethod("concreteSort2", Comparable[].class);
                    break;
                case "sort3":
                    method = SortAlgorithms.class.getDeclaredMethod("concreteSort3", Comparable[].class);
                    break;
                default:
                    System.out.println("No such sort algorithm, using standard sort");
                    method = SortAlgorithms.class.getDeclaredMethod("concreteSort3", Comparable[].class);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }

        Random rnd = new Random();
        int size = rnd.nextInt(10) + 10;
        Integer[] array = new Integer[size];
        for(int i = 0; i < size; i++){
            array[i] = (Integer) rnd.nextInt(200); //!!!!!11111
        }
        try {
            method.invoke(new SortAlgorithms(), (Object) array);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return array;
    }


}
