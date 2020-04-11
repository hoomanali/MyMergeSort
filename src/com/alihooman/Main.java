package com.alihooman;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ParseArgs.isArgsValid(args);
        List<Double> numberList = ParseArgs.getNumberList(args);
    }
}
