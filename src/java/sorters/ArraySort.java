package java.sorters;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Bodriagina
 */
public class ArraySort extends Sort {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> arr) {
        Collections.sort(arr);
        return arr;
    }
}
