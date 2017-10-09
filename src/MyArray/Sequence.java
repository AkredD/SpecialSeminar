package MyArray;

import java.io.PrintStream;


public interface Sequence<E> {
    void print(String delimiter, PrintStream ps);
    void print(PrintStream ps);
    int size();
}
