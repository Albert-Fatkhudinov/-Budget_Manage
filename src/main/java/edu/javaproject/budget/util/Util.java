package edu.javaproject.budget.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Util {


    private static final BufferedReader reader
            = new BufferedReader(new InputStreamReader(System.in));

    public static int readInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static void indent() {
        System.out.println();
    }

}
