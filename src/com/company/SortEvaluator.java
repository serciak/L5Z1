package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class SortEvaluator {

    private int size;
    private BubbleSort bs;
    private OptimizedBubbleSort obs;
    private InsertSort is;
    private SelectSort ss;

    public SortEvaluator(int size) {
        this.size = size;
    }

    private ArrayList<Integer> randomArray() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i<size; i++) {
            arrayList.add(random.nextInt(1,100));
        }
        return arrayList;
    }

    private ArrayList<Integer> almostSortedArrayBS() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        int i;

        for(i = 0; i<size*0.1; i++) {
            arrayList.add(random.nextInt(1, 10));
        }
        for(int j = i; j<size; j++) {
            arrayList.add(j*10);
        }
        //System.out.println(arrayList);
        return arrayList;
    }

    private ArrayList<Integer> invertedAlmostSortedArrayBS() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        int i;

        for(i = size; i>size*0.1; --i) {
            arrayList.add(0, Math.abs(i-size));
        }
        for(int j = i; j>0; --j) {
            arrayList.add(0, random.nextInt(1, 10));
        }
        //System.out.println(arrayList);
        return arrayList;
    }

    private ArrayList<Integer> almostSortedArrayIS() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        int i;
        for(i = 0; i<size*0.9; i++) {
            arrayList.add(i);
        }
        for(int j = i; j<size; j++) {
            if(random.nextDouble(-1, 1) > 0) {
                arrayList.add(random.nextInt(0, i));
            } else {
                arrayList.add(j);
            }
        }
        //System.out.println(arrayList);
        return arrayList;
    }

    private ArrayList<Integer> invertedAlmostSortedArrayIS() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        int i;
        for(i = size; i>size*0.1; --i) {
            arrayList.add(0, Math.abs(i-size));
        }
        for(int j = i; j>0; --j) {
            if(random.nextDouble(-1, 1) > 0) {
                arrayList.add(0, random.nextInt(0, i));
            } else {
                arrayList.add(0, j);
            }
        }
        //System.out.println(arrayList);
        return arrayList;
    }

    private ArrayList<Integer> almostSortedArraySS() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        int i;
        for(i = 0; i<size*0.9; i++) {
            arrayList.add(i);
        }
        for(int j = i; j<size; j++) {
            arrayList.add(random.nextInt(i, i+20));
        }
        //System.out.println(arrayList);
        return arrayList;
    }

    private ArrayList<Integer> invertedAlmostSortedArraySS() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        int i;
        for(i = 0; i<size*0.9; i++) {
            arrayList.add(0, i);
        }
        for(int j = i; j<size; j++) {
            arrayList.add(0, random.nextInt(i, i+20));
        }
        //System.out.println(arrayList);
        return arrayList;
    }

    private void randomOrder() {
        ArrayList<Integer> list = randomArray();

        bs.sort((ArrayList<Integer>) list.clone());
        obs.sort((ArrayList<Integer>) list.clone());
        is.sort((ArrayList<Integer>) list.clone());
        ss.sort((ArrayList<Integer>) list.clone());

        System.out.println("Lista losowej kolejnosci:");
    }

    private void almostSortedOrder() {
        ArrayList<Integer> list = almostSortedArrayBS();

        bs.sort((ArrayList<Integer>) list.clone());
        obs.sort((ArrayList<Integer>) list.clone());
        is.sort(almostSortedArrayIS());
        ss.sort(almostSortedArraySS());

        System.out.println("Lista prawie posortowana:");
    }

    private void invertedAlmostSortedOrder() {
        ArrayList<Integer> list = invertedAlmostSortedArrayBS();

        bs.sort((ArrayList<Integer>) list.clone());
        obs.sort((ArrayList<Integer>) list.clone());
        is.sort(invertedAlmostSortedArrayIS());
        ss.sort(invertedAlmostSortedArraySS());

        System.out.println("Lista odwrotnie prawie posortowana:");
    }

    public void evaluate(Comparator<Integer> comparator) {
        bs = new BubbleSort(comparator);
        obs = new OptimizedBubbleSort(comparator);
        is = new InsertSort(comparator);
        ss = new SelectSort(comparator);

        randomOrder();
        printStats();
        almostSortedOrder();
        printStats();
        invertedAlmostSortedOrder();
        printStats();
    }

    private void printStats() {
        System.out.println("[BubbleSort] " + "Porownania: " + bs.getComparisons() + "\tZamiany: " + bs.getSwaps());
        System.out.println("[OptimizedBubbleSort] " + "Porownania: " + obs.getComparisons() + "\tZamiany: " + obs.getSwaps());
        System.out.println("[InsertSort] " + "Porownania: " + is.getComparisons() + "\tZamiany: " + is.getSwaps());
        System.out.println("[SelectSort] " + "Porownania: " + ss.getComparisons() + "\tZamiany: " + ss.getSwaps());
        System.out.println("\n");
    }
}
