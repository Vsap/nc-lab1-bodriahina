package java.sorters;

import java.util.ArrayList;

/**
 * @author Bodriagina
 */
public abstract class BubbleSort extends Sort {
    protected abstract int initializationForI(ArrayList<Integer> arr);
    protected abstract int initializationForJ(ArrayList<Integer> arr);
    protected abstract boolean condition(ArrayList<Integer>arr, int i);
    protected abstract boolean condition(int i, int j);
    protected abstract int increment();
    protected abstract boolean conditionToSwap(ArrayList<Integer> arr, int b);

    public final ArrayList<Integer> sort(ArrayList<Integer> arr) {
        boolean swapped = true;
        for(int i = initializationForI(arr); condition(arr, i) && swapped; i+=increment()) {
            swapped = false;
            for (int j = initializationForJ(arr); condition(i, j); j-=increment()) {
                if (conditionToSwap(arr, j)) {
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }
        }
        return arr;
    }
}
