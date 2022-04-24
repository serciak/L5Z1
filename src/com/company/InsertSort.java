package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class InsertSort {
    private Comparator comparator;
    private int swaps;
    private int comparisons;
    public InsertSort(Comparator comparator) {
        this.comparator = comparator;
    }
    public ArrayList<Integer> sort(ArrayList<Integer> list) {
        swaps = 0;
        comparisons = 0;
        for (int i = 1; i < list.size(); ++i) {
            int value = list.get(i), temp;
            int j;
            for (j = i; j > 0 && comparator.compare(value, temp=list.get(j - 1)) < 0; --j) {
                list.set(j, temp);
                comparisons++;
            }
            list.set(j, value);
            swaps++;
        }
        return list;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getComparisons() {
        return comparisons;
    }
}
