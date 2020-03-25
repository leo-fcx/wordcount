package com.fcx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCounter {
    public static void main(String[] args) {
        count(args[0]);
    }

    public static void count(String path) {
        try {
            Files
                    .lines(Paths.get(path))
                    .map(line -> line.split("[\\s]+"))
                    .flatMap(Arrays::stream)
                    .map(word -> word.replaceAll("[^a-zA-Z0-9]", ""))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .forEach((k, v) -> System.out.println(k + " "+ v));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
