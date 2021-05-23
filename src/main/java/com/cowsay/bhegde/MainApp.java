package com.cowsay.bhegde;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        Gson gson = new Gson();
        // create a reader
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(args[0]), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Type kaggaType = new TypeToken<ArrayList<Kagga>>() {}.getType();

        assert reader != null;
        ArrayList<Kagga> allKaggas = gson.fromJson(reader, kaggaType);

        String randomKaggaInKn = allKaggas.get(getRandomNumBetween(1, 945)).getKagga_kn();

        System.out.println(randomKaggaInKn);

        PrintWriter consoleOut = null;
        try {
            consoleOut = new PrintWriter(new OutputStreamWriter(System.out, "Cp850"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("---------------");
        consoleOut.println(randomKaggaInKn);

        PrintStream out = null;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("---------------");
        out.println(randomKaggaInKn);
        System.out.println("---------------");
    }

    private static int getRandomNumBetween(int start, int end){
        return ((int) (Math.random() * (end - start))) + start;
    }
}
