package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class SelectSort {

    private Comparator comparator;
    private int swaps;
    private int comparisons;

    public SelectSort(Comparator comparator) {
        this.comparator = comparator;
    }

    public ArrayList<Integer> sort(ArrayList<Integer> list) {
        swaps = 0;
        comparisons = 0;
        int size = list.size();

        for(int i = 0; i < size-1; i++) {
            int min = i;
            for(int j = i+1; j < size; j++) {
                comparisons++;
                if(comparator.compare(list.get(j), list.get(min)) < 0) {
                    min = j;
                }
            }

            swaps++;
            int temp = list.get(min);
            list.set(min, list.get(i));
            list.set(i, temp);
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
