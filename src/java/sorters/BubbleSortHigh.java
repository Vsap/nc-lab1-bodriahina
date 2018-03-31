package java.sorters;

import java.util.ArrayList;

/**
 * @author Bodriagina
 */
public class BubbleSortHigh extends BubbleSort {
    @Override
    protected int initializationForI(ArrayList<Integer> arr) {
        return 0;
    }
    @Override
    protected int initializationForJ(ArrayList<Integer> arr) {
        return arr.size()-2;
    }
    @Override
    protected boolean condition(ArrayList<Integer> arr, int i) {
        return i<arr.size()-2;
    }
    @Override
    protected int increment(){
        return 1;
    };
    @Override
    protected boolean conditionToSwap(ArrayList<Integer> arr, int j) {
        return arr.get(j)>arr.get(j+1);
    }
    @Override
    protected boolean condition(int i, int j) {
        return j>i;
    }
}
