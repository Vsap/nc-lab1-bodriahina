package java.sorters;

import java.util.ArrayList;

public class MinimumSort extends Sort {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> arr) {
        for (int i = 0; i< arr.size(); i++){
            swap(arr, i, minIndex(arr,i));
        }
        return arr;
    }
    private int minIndex(ArrayList<Integer> arr, int index){
        int min = index;
        for(int i = index; i< arr.size(); i++){
            if(min>arr.get(i)) min=index;
        }
        return index;
    }
}
