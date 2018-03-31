package java.tests;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.sorters.Sort;
import java.util.ArrayList;

public class SortTest extends TestCase {

    public void testSort() {
    }
    @Test()
    public void testSwap() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        Sort.swap(arr, 1, 2);
        Assert.assertEquals(expected,);

    }
}