import MyArray.*;
import Deque.*;
import StrategySort.*;

import java.lang.reflect.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;


/**
 * Created by user on 18.09.2017.
 */


public class mainTest {

    public static void testStrategy() throws Exception{
        Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new File("output.txt"));
        int n = sc.nextInt(); // кол-во элементов
        int typeSort = sc.nextInt(); // тип сортировки (1, 2, 3)
        Integer[] c = new Integer[n];
        newClass a = new newClass(c);
        for (int i = 0; i < n; i++){
            c[i] =sc.nextInt();  // сами элементы
        }
        // пример входных
        //3 1
        //3 2 1
        switch (typeSort){
            case 1:
                a.setStrategy(new concreteSort1());
                break;
            case 2:
                a.setStrategy(new concreteSort2());
                break;
            case 3:
                a.setStrategy(new concreteSort3());
                break;
        }
        a.sort();
        for (int i = 0; i < n; i++){
            out.print(c[i]);
            out.print(" ");
        }


        out.close();
        sc.close();
    }

    public static void testDeque() throws Exception{
        Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new File("output.txt"));
        String s = sc.next(); // Введите Deque.ArrayDeque или Deque.ListDeque

        Class class_;
        Method method_;
        Deque<Integer> a;

        try{
            class_ = Class.forName(s);
            //a = (Deque) class_.getConstructors()[0].newInstance(new Object[] {100,2,3,4,5});
            //Constructor constr = class_.getConstructor(ctorArgs);
            Constructor t = class_.getConstructors()[0];
            //System.out.println(t.getParameterCount());
            Integer[] data = new Integer[] {100,2,3,4,5};
            a = (Deque<Integer>) t.newInstance((Object) data);
            //a = (Deque<Integer>) t.newInstance(100, new Object[] {1,2});

            /*method_ = class_.getMethod(s, class_);

            if (method_ != null) {
            }*/
            a.addFirst(1);
            a.addLast(1);
            Iterator<Integer> iter = a.iterator();
            int sum = 0;
            while(iter.hasNext()){
                sum += iter.next();
            }
            out.print(sum);
        }catch(Exception e) {
            System.out.println(e.toString());
        }



        out.close();
        sc.close();

    }

    public static void testDecorator() throws Exception{
        Scanner sc = new Scanner(new File("input.txt"));
        //Scanner sc = new Scanner(new File("mainTest.in"));
        PrintWriter out = new PrintWriter(new File("output.txt"));
        MyArray a = new MyArray(1, 2, 3, 4, 5);
        DecoratorMyArray b = new RegularDecorator("[", "]", true, true, a);
        b.print(":", new PrintStream("output.txt"));
        a.print(",,,", new PrintStream("output.txt"));

        out.close();
        sc.close();
    }

    public static void testList() throws Exception{
        Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new File("output.txt"));
        List<Integer> a =  new List(1);
        a.add(2);
        a.add(5);
        a.add(0);
        a.sort();
        for (int i = 0; i < 4; ++i) {
            out.print(a.get(i));
            out.print(" ");
        }

        out.close();
        sc.close();
    }

    public static void testCycList() throws Exception{
        Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new File("output.txt"));
        CycList<Integer> a = new CycleList<>(1);
        a.add(2);
        a.add(3);
        CycList<Integer> b = new CycleList<>(1);
        b.add(2);
        b.add(3);

        if (listsEqual(a, b)){
            out.print("equal");
        }else{
            out.print("not equal");
        }
        out.close();
        sc.close();

    }

    static <E> boolean listsEqual(CycList<E> list1, CycList<E> list2){
        boolean eq = false;
        Iterator<E> iter1 = list1.iterator();
        Iterator<E> iter2 = list2.iterator();
        if (list1.size() == list2.size()){
            for (int i = 0; i < list1.size(); ++i){
                eq = true;
                for (int j = 0; j < list1.size(); ++j){
                    if (iter1.next() != iter2.next()){
                        eq = false;
                        break;
                    }
                }
                if (eq) break;
                list1.shift(1);
            }
        }else eq = false;

        return eq;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("input.txt"));
        //Scanner sc = new Scanner(new File("mainTest.in"));
        PrintWriter out = new PrintWriter(new File("output.txt"));
        //PrintWriter out = new PrintWriter(new File("mainTest.out"));

        //testDeque();
        //testStrategy();
        //testDecorator();
        //testList();
        //testCycList();
        out.close();
        sc.close();
    }



    private static class Scanner {
        private BufferedReader br;
        private StringTokenizer t;

        public Scanner(File file) throws Exception {
            br = new BufferedReader(new FileReader(file));
            t = new StringTokenizer("");
        }

        public boolean hasNext() throws Exception {
            while (!t.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null)
                    return false;
                t = new StringTokenizer(line);
            }
            return true;
        }


        public String next() throws Exception {
            if (hasNext()) {
                return t.nextToken();
            }
            return null;
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }

        public void close() throws Exception {
            br.close();
        }
    }
}
