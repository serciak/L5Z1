package com.company;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compareTo;

        SortEvaluator sortEvaluator = new SortEvaluator(50);
        sortEvaluator.evaluate(comparator);
    }
}
