package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class BubbleSort {

    private Comparator<Integer> comparator;
    private int swaps;
    private int comparisons;

    public BubbleSort(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    public ArrayList<Integer> sort(ArrayList<Integer> list) {
        int temp;
        swaps = 0;
        comparisons = 0;

        for(int i = 0; i<list.size(); i++) {
            for(int j = 1; j<list.size(); j++) {
                comparisons++;
                if(list.get(j-1) > list.get(j)) {
                    swaps++;
                    temp = list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j, temp);
                }
            }
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
